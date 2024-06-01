class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length==1 && grid[0].length==1) return 0;
        int[][] kMaxMatrix = new int[grid.length][grid[0].length];
        for(int i = 0;i<kMaxMatrix.length;i++){
            Arrays.fill(kMaxMatrix[i],-1);
        }
        //return BFS(0,0,grid,k)
        return BFS(0,0,grid,k, kMaxMatrix);
    }

    class Triplet<M,N,O>{
        M row;
        N col;
        O k;
        Triplet(M row, N col, O k){
            this.row = row;
            this.col = col;
            this.k = k;
        }
    }
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int BFS(int row, int col, int[][] grid, int k, int[][] kMaxMatrix){
        //distance=0
        int distance=0;
        //create queue
        Deque<Triplet<Integer,Integer,Integer>> queue = new ArrayDeque();
        //queue.add(new Pair(row,col))
        queue.add(new Triplet(row, col,k));
        //add row,col to kMaxMatrix
        kMaxMatrix[row][col] = k;
        //while(queue is not empty)
            //size = queue.size()
            int size = queue.size();
            //distance++
            distance++;
            //while(size-->0)
            while(size-->0){
                Triplet t = queue.pop();
                row = (Integer)t.row;
                col = (Integer)t.col;
                k = (Integer)t.k;
                //loop directions
                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    //if valid direction   
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length){
                        //if cell is m-1, n-1 
                        if(newRow==grid.length-1 && newCol==grid[0].length-1)
                            //return distance
                            return distance;
                        //if cell is obstacle && if current cell k-1 > kMaxMatrix[newRow][newCol]
                        if(grid[newRow][newCol]==1 && (k-1)>kMaxMatrix[newRow][newCol]){
                            //queue.add(newRow,newCol,k-1)
                            queue.add(new Triplet(newRow,newCol,k-1));
                            //kMaxMatrix[newRow][newCol]=k-1
                            kMaxMatrix[newRow][newCol] = k-1;
                        }
                        //if cell is free space && current cell k > kMatMatrix[newRow][newCol]
                        if(grid[newRow][newCol]==0 && k>kMaxMatrix[newRow][newCol]){
                            //queue.add(newRow,newCol,k)
                            queue.add(new Triplet(newRow,newCol,k));
                            //kMaxMatrix[newRow][newCol] = k
                            kMaxMatrix[newRow][newCol] = k;
                        }
                    }

                }

            }

        }
        //return -1
        return -1;
    }
}
