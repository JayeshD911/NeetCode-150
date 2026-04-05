class Solution {
    int rows=0;
    int cols=0;
    public int numIslands(char[][] grid) {
        int count=0;
        rows=grid.length;
        cols=grid[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'){dfs(r,c,grid);count++;}
            }
        }
        return count;
    }

    void dfs(int r,int c,char[][] grid){
        if(r<0||c<0||r>rows-1||c>cols-1||grid[r][c]=='0')return;
        if(grid[r][c]=='1'){grid[r][c]='0';}
        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }

}