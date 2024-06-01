class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        //while start<end
        while(start<end){
            //calc. mid
            int mid = start + ((end-start)/2);
            //if nums[mid]==target
            if(nums[mid]==target)
                //return mid
                return mid;
            //if nums[mid+1]<=nums[end] - shows right ordered subarray
            if(nums[mid+1]<=nums[end]){
                //nums[mid+1]<=target && nums[end]>=target
                if(nums[mid+1]<=target && nums[end]>=target)
                    //start = mid+1
                    start = mid+1;
                //else
                else
                    //end = mid-1
                    end = mid-1;
            }
            //else if nums[start]<=nums[mid] - shows left ordered subarray
            else if(nums[start]<=nums[mid]){
                //nums[start]<=target && nums[mid]>=target
                if(nums[start]<=target && nums[mid]>=target)
                    //end=mid-1
                    end = mid-1;
                //else
                else
                    //start = mid+1
                    start = mid+1;
            }
        }
        //return (nums[start] == target)?start:-1;
        return nums[start]==target?start:-1;
    }
}
