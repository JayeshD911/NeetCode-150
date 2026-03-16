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
                        boolean[] column,
                        boolean[] diagonal,
                        boolean[] antiDiagonal,
                        List<List<String>> ans,
                        int row){
        if(row == n){
            //convert [][] to List<List<String>>
            ans.add(convert(board));
            return;
        }
        for (int col = 0 ; col < n ; col++){
            if (column[col] == true || diagonal[row - col + n] == true || antiDiagonal[row + col] == true ){ // row - col + n to eliminate -ve index
                continue;
            }
            // mark queen
            board[row][col] = 'Q';
            column[col] = true;
            diagonal[row - col + n] = true;
            antiDiagonal[row + col] = true;
            solve( n, board, column, diagonal, antiDiagonal, ans, row + 1);

            //backtrack
            board[row][col] = '.';
            column[col] = false;
            diagonal[row - col + n] = false;
            antiDiagonal[row + col] = false;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();

        // if queen already exist in the same column or difference diagonal (r-c values)(diagonal) or sum diagonal (r + c values)(anti diagonal)

        //This optimised approach uses boolean [] instead of hashset
        boolean[] column = new boolean[n];
        boolean[] diagonal = new boolean[n * 2];
        boolean[] antiDiagonal = new boolean[n * 2];


        char[][] board = new char[n][n];

        for(int i = 0 ; i< n ; i++){
            Arrays.fill(board[i], '.');
        }

        solve(n, board, column, diagonal, antiDiagonal , ans, 0);     // no need to have n because board.length = n

        return ans;

    }
}