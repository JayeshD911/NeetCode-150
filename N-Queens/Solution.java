class Solution {

    public List<String> convert(char[][] board){
        List<String> result = new ArrayList<>();

        for(int i= 0 ; i< board.length ; i++){
            result.add(new String(board[i]));
        }
        return result;


    }
    public void solve(  int n,
                        char[][] board,
                        HashSet<Integer> column,
                        HashSet<Integer> diagonal,
                        HashSet<Integer> antiDiagonal,
                        List<List<String>> ans,
                        int row){
        if(row == n){
            //convert [][] to List<List<String>>
            ans.add(convert(board));
            return;
        }
        for (int col = 0 ; col < n ; col++){
            if (column.contains(col) || diagonal.contains(row - col) || antiDiagonal.contains(row + col)){
                continue;
            }
            // mark queen
            board[row][col] = 'Q';
            column.add(col);
            diagonal.add(row - col);
            antiDiagonal.add(row + col);
            solve( n, board, column, diagonal, antiDiagonal, ans, row + 1);

            //backtrack
            board[row][col] = '.';
            column.remove(col);
            diagonal.remove(row - col);
            antiDiagonal.remove(row + col);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();

        // if queen already exist in the same column or difference diagonal (r-c values)(diagonal) or sum diagonal (r + c values)(anti diagonal)

        HashSet<Integer> column = new HashSet<Integer>();
        HashSet<Integer> diagonal = new HashSet<Integer>();
        HashSet<Integer> antiDiagonal = new HashSet<Integer>();


        char[][] board = new char[n][n];

        for(int i = 0 ; i< n ; i++){
            Arrays.fill(board[i], '.');
        }

        solve(n, board, column, diagonal, antiDiagonal , ans, 0);     // no need to have n because board.length = n

        return ans;

    }
}