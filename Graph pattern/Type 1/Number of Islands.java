class Solution {
    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        //count = 0
        int count =0;
        //loop of matrix
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //if not visited
                if(grid[i][j]=='1'){
                    //DFS(i,j,grid)
                    DFS(i,j,grid);
                    //count++
                    count++;
                }
            }
        }
        //return count
        return count;
    }

    public void DFS(int i, int j, char[][] grid){
        //if visited[i][j]
        if(grid[i][j]=='2')
            //return true
            return;
        //visited[i][j] = true
        grid[i][j] = '2';
        //loop all directions
        for(int[] dir : directions){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            //DFS(newRow,newCol,grid,visited)
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]=='1')
                DFS(newRow, newCol, grid);
        }
    }
}
