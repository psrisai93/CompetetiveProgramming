class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //startRow
        int startRow = 0;
        //endRow
        int endRow = matrix.length-1;
        int midRow = -1;
        //while(startRow<=endRow)
        while(startRow<=endRow){
            //midLogic
            midRow = startRow+(endRow-startRow)/2;
            if(target>=matrix[midRow][0] && target<=matrix[midRow][matrix[midRow].length-1]){
                break;
            }
            else if(target<matrix[midRow][0]){
                endRow = midRow-1;
            }
            else if(target>matrix[midRow][matrix[midRow].length-1]){
                startRow = midRow+1;
            }
        }
        //if startRow>endRow
        if(startRow>endRow)
            //return false
            return false;
        //startCol = 0
        int startCol = 0;
        //endCol = matrix[0].length-1
        int endCol = matrix[0].length-1;
        //while(startCol<=endCol)
        while(startCol<=endCol){
            //midLogic
            int midCol = startCol + (endCol-startCol)/2;
            if(matrix[midRow][midCol]==target)
                break;
            else if(matrix[midRow][midCol]<target)
                startCol = midCol+1;
            else if(matrix[midRow][midCol]>target)
                endCol = midCol-1;
        }
        //if(startCol>endCol)
        if(startCol>endCol)
            //return false
            return false;
        //return true
        return true;
    }
}
