class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(-1);
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while(stack.peekLast()!=-1 && heights[stack.peekLast()]>heights[i]){
                int curHeight = heights[stack.pollLast()];
                int curWidth = i-stack.peekLast()-1;
                maxArea = Math.max(maxArea,curWidth*curHeight);
            }
            stack.addLast(i);
        }
        while(stack.peekLast()!=-1){
            int curHeight = heights[stack.pollLast()];
            int curWidth = heights.length-stack.peekLast()-1;
            maxArea = Math.max(maxArea,curHeight*curWidth);
        }
        return maxArea;
    }
}
