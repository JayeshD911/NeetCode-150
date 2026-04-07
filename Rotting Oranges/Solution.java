class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        int ripes= 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
                if(grid[i][j] == 1) ripes++;
            }
        }

        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int qLength = queue.size();
            boolean rotted = false;

            while (qLength > 0){
                int [] x = queue.poll();
                int r = x[0];
                int c = x[1];
                for (int[] d : directions){
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if(newR < 0 || newC < 0 || newR >= n || newC >= m || grid[newR][newC] == 0 || grid[newR][newC] == 2 ) continue;

                    else{                   //if grid[newR][newC] = 1
                        rotted = true;
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR,newC});
                        ripes--;
                    }
                }
                qLength--;
            }
            if (rotted) time++;

        }

        return ripes > 0 ? -1: time;

    }
}






// Easy to understand. Separate final ripe counting logic
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        // Find the rotten oranges
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }

        // BFS
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int qLength = queue.size();
            boolean rotted = false;

            while (qLength > 0){
                int [] x = queue.poll();
                int r = x[0];
                int c = x[1];
                for (int[] d : directions){
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if(newR < 0 || newC < 0 || newR >= n || newC >= m || grid[newR][newC] == 0 || grid[newR][newC] == 2 ) continue;

                    else{
                        rotted = true;
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR,newC});
                    }
                }
                qLength--;
            }
            if (rotted) time++;

        }

        // Find if any still fresh
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return time;

    }
}
