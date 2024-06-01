class Solution {
    public int maxSubArray(int[] nums) {
        int globalSum = nums[0];
        int curSum = 0;
        for(int i=0;i<nums.length;i++){
            curSum = Math.max(nums[i],nums[i]+curSum);
            globalSum = Math.max(globalSum,curSum);
        }
        return globalSum;
    }
}
