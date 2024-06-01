class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        //while start<end
        while(start<end){
            //calc. mid
            int mid = start+((end-start)/2);
            //if nums[mid]>nums[mid+1]
            if(nums[mid]>nums[mid+1])
                //r = mid
                end=mid;
            //else
            else
                //l = mid+1
                start = mid+1;
        }
        //return start
        return start;
    }
}
