class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: initialize
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty() && fresh > 0){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : directions){

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1){
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    fresh--;
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}