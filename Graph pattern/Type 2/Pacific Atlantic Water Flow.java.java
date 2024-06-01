class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //create result
        List<List<Integer>> result = new ArrayList();
        //visitedMatrix (nothing is 0, pacafic make it 1, atlantic make it 2)
        int[][] visitedMatrix = new int[heights.length][heights[0].length];
        //create pacaficQueue
        Deque<Pair> pacaficQueue = new ArrayDeque();
        //create atlanticQueue
        Deque<Pair> atlanticQueue = new ArrayDeque();
        //loop
        for(int j=0;j<heights[0].length;j++){
            //add to pacafic queue
            pacaficQueue.add(new Pair(0,j));
            visitedMatrix[0][j]=1;
        }
        //loop
        for(int i=0;i<heights.length;i++){
            //add to atlantic queue
            pacaficQueue.add(new Pair(i,0));
            visitedMatrix[i][0]=1;
        }
        for(int j=0;j<heights[0].length;j++){
            //add to pacafic queue
            atlanticQueue.add(new Pair(heights.length-1,j));
            if(visitedMatrix[heights.length-1][j]==1){
                ArrayList<Integer> arr = new ArrayList();
                arr.add(heights.length-1);
                arr.add(j);
                result.add(arr);
                visitedMatrix[heights.length-1][j]=2;
            }else if(visitedMatrix[heights.length-1][j]==0){
                visitedMatrix[heights.length-1][j]=3;
            }
            
            
        }
        //loop
        for(int i=0;i<heights.length;i++){
            //add to atlantic queue
            atlanticQueue.add(new Pair(i,heights[0].length-1));
            if(visitedMatrix[i][heights[0].length-1]==1){
                ArrayList<Integer> arr = new ArrayList();
                arr.add(i);
                arr.add(heights[0].length-1);
                result.add(arr);
                visitedMatrix[i][heights[0].length-1]=2;
            }else if(visitedMatrix[i][heights[0].length-1]==0){
                visitedMatrix[i][heights[0].length-1]=3;
            }
            
        }
        //while(pacaficQueue is not empty)
            //size = queue.size
            int size = pacaficQueue.size();
            //while(size-->0)
            while(size-->0){
                //pop()
                Pair p = pacaficQueue.pop();
                int row = p.row;
                int col = p.col;
                //loop dirs
                for(int[] dir : dirs){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];
                    //if dir is valid && [newRow][newCol]==0
                    if(newRow>=0 && newRow<heights.length && newCol>=0 && newCol<heights[0].length
                    && heights[newRow][newCol]>=heights[row][col]){
                        if(visitedMatrix[newRow][newCol]==0){
                            //[newRow][neCol] = 1
                            visitedMatrix[newRow][newCol] =1;
                            //pacaficQueue.add(newRow,newCol)
                            pacaficQueue.add(new Pair(newRow,newCol));
                        }else if(visitedMatrix[newRow][newCol]==3){
                            //[newRow[newCol]]==2
                            visitedMatrix[newRow][newCol]=2;
                            //atlanticQueue.add(newRow,newCol)
                            pacaficQueue.add(new Pair(newRow,newCol));
                            //add to result
                            ArrayList<Integer> arr = new ArrayList();
                            arr.add(newRow);
                            arr.add(newCol);
                            result.add(arr);
                        }
                        
                    }
                }

            }

        }
        //while(atlanticQueue is not empty)
            //size = queue.size
            int size = atlanticQueue.size();
            //while(size-->=)
            while(size-->0){
                //pop()
                Pair p = atlanticQueue.pop();
                int row = p.row;
                int col = p.col;
                //loop dirs
                for(int[] dir : dirs){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];
                    //if dir is valid 
                    if(newRow>=0 && newRow<heights.length && newCol>=0 && newCol<heights[0].length
                    && heights[newRow][newCol]>=heights[row][col]){
                        //if [newRow][newCol]==0
                        if(visitedMatrix[newRow][newCol]==0){
                            //[newRow][newCol] = 1
                            visitedMatrix[newRow][newCol]=3;
                            //atlanticQueue.add(newRow,newCol)
                            atlanticQueue.add(new Pair(newRow,newCol));
                        }
                        //else if [newRow][newCol]==1
                        else if(visitedMatrix[newRow][newCol]==1){
                            //[newRow[newCol]]==2
                            visitedMatrix[newRow][newCol]=2;
                            //atlanticQueue.add(newRow,newCol)
                            atlanticQueue.add(new Pair(newRow,newCol));
                            //add to result
                            ArrayList<Integer> arr = new ArrayList();
                            arr.add(newRow);
                            arr.add(newCol);
                            result.add(arr);
                        }
                    }
                }
            }
        }
        //return result
        return result; 
    }
}
