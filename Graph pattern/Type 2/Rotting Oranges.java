class Solution {
    //Pair class
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    //dirs
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        
        int freshOranges = 0;
        //distance = 0
        int distance = 0;
        //create queue
        Deque<Pair> queue = new ArrayDeque();
        //add all rotten oranges to queue
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        //bfs start
        //while(queue is not empty)
            //size = queue.size()
            int size = queue.size();
            //distance++
            distance++;
            //while(size-->0)
            while(size-->0){
                //p = queue.pop()
                Pair p = queue.pop();
                int row = p.row;
                int col = p.col;
                //loop dirs
                for(int[] dir : dirs){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];
                    //valid dir && ==1
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length 
                    && grid[newRow][newCol]==1){
                        //==2
                        grid[newRow][newCol]=2;
                        freshOranges--;
                        //add to queue
                        queue.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
        //return distance
        return (freshOranges==0)?distance-1:-1;
    }
}
