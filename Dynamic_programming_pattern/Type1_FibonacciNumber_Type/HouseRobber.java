class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(dfs(0,nums,dp),dfs(1,nums,dp));
    }

    public int dfs(int cur, int[] nums, int[] dp){
        //if more than length 
        if(cur>=nums.length)
            //return 0
            return 0;
        //if dp[i] exists
        if(dp[cur]!=-1)
            //return dp[i]
            return dp[cur];
        dp[cur] = Math.max(nums[cur]+dfs(cur+2,nums,dp),dfs(cur+1,nums,dp));
        //return nums[i]+max
        return dp[cur];
    }
}
