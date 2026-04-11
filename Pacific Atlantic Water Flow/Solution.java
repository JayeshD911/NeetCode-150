class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificVisited = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];

        for(int j = 0; j < m ; j++) dfs(0, j, heights, pacificVisited);
        for(int i = 0; i < n ; i++) dfs(i, 0, heights, pacificVisited);
        for(int j = 0; j < m ; j++) dfs(n-1, j, heights, atlanticVisited);
        for(int i = 0; i < n ; i++) dfs(i, m-1, heights, atlanticVisited);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    public void dfs(int i , int j , int[][] heights, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;
        for (int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x >= heights.length ||
                    y < 0 || y >= heights[0].length ||
                    visited[x][y] ||
                    heights[x][y] < heights[i][j]) continue;
            dfs(x, y, heights, visited);
        }
    }
}