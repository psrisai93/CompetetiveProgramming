class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        int globalMax = 0;
        for(int i=nums.length-1;i>=0;i--){
            int max = 1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j])
                    max = Math.max(max,1+dp[j]);
            }
            dp[i] = max;
            globalMax = Math.max(globalMax,max);
        }
        return globalMax;
    }
    
}
