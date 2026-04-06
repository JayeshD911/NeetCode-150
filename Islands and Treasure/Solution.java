class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }
        //BFS
        int[][] directions = {{1,0} , {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            int r = x[0];
            int c = x[1];

            for(int[] direction : directions){
                int new_r = r + direction[0];
                int new_c = c + direction[1];

                if(new_r < 0 || new_c < 0 || new_r >= n || new_c >= m || grid[new_r][new_c] != 2147483647 ) continue;

                grid[new_r][new_c] = grid[r][c] + 1;
                queue.offer(new int[]{new_r,new_c} );
            }
        }
    }
}
