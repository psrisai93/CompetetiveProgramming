class Solution {
    public int findMin(int[] nums) {
        //min = Integer.MAX
        int min = Integer.MAX_VALUE;
        //isLeft = false
        boolean isLeft = false;
        int start = 0;
        int end = nums.length-1;
        //while start<=end
        while(start<=end){
            //calc. mid
            int mid = start +((end-start)/2);
            //if start<mid
            if(nums[start]<=nums[mid]){
                //min = min(min,start)
                min = Math.min(min,nums[start]);
                //isLeft = false
                isLeft = false;
            }
            //else if mid>end
            else if(nums[mid]<nums[end]){
                //min = min(min,mid)
                min = Math.min(min,nums[mid]);
                //isLeft = true
                isLeft = true;
            }
            //if(isLeft)
            if(isLeft)
                //end = mid-1
                end = mid-1;
            //else
            else
                //start = mid+1
                start = mid+1;
        }
        //return min
        return min;
    }
}
