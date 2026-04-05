class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for ( int i = 0 ; i < n ; i++){
            for ( int j = 0 ; j < m ; j++){
                if (grid[i][j] == 1){
                    ans = Math.max(ans , dfs(i , j , grid));
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j , int[][] grid){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] == 0 ) return 0;

        grid[i][j] = 0;

        return 1
                + dfs(i+1 , j , grid)
                + dfs(i , j+1 , grid)
                + dfs(i-1 , j , grid)
                + dfs(i , j-1 , grid);
    }
}