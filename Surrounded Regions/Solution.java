class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'S';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}



// EASY TO UNDERSTAND

class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0 ; i< n ;i++){
            if(board[i][0] == 'O') dfs(i, 0,visited,board);
            if(board[i][m-1] == 'O') dfs(i,m-1,visited,board);
        }
        for (int j = 0 ; j< m ;j++){
            if(board[0][j] == 'O') dfs(0,j,visited,board);
            if(board[n-1][j] == 'O') dfs(n-1,j,visited,board);
        }

        for (int i = 0 ; i< n ; i++){
            for (int j = 0 ; j< m ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for (int i = 0 ; i< n ;i++){
            for (int j = 0 ; j< m ; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void dfs(int i , int j , boolean[][] visited , char[][] board){
        if (visited[i][j]) return;
        visited[i][j] = true;
        board[i][j] = '#';

        for (int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X') continue;
            dfs( x , y ,visited , board);
        }
    }
}
