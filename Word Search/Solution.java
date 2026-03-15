class Solution {

    public boolean dfs(char[][] board, String word, int row, int col, int wordIdx){
        if(wordIdx == word.length()) return true;

        if( row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(wordIdx)
        ) return false;

        char temp = board[row][col];  //store value in temp so that we can later revert and backtrack
        board[row][col] = '*';        // mark visited so that it dosen't access again in the next dfs call
        if (dfs(board, word, row + 1, col, wordIdx + 1) || // move right
                dfs(board, word, row, col + 1, wordIdx + 1) || // move down
                dfs(board, word, row - 1, col, wordIdx + 1) || // move left
                dfs(board, word, row, col - 1, wordIdx + 1)    // move up
        ) return true;

        //backtrack / rollback
        board[row][col] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i< board.length ; i++){
            for(int j = 0 ; j< board[0].length ; j++){
                if(dfs(board, word, i, j, 0)) return true;    //keep looping if false
            }
        }
        return false;
    }
}