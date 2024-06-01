class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];//0 is even //1 is odd
        //initialize to -1
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        dfs(0, 0, dp, nums);
        return dp[0][0];
    }

    public long dfs(int cur, int isEven, long[][] dp , int[] nums){
        //if cur is >= length
        if(cur==nums.length)
            //return 0
            return 0;
        //if dp[cur][isEven]!=-1
        if(dp[cur][isEven]!=-1)
            //return dp[cur][isEven]
            return dp[cur][isEven];
        //total = total+(isEven)?nums[cur]:-1*nums[cur];
        int total = (isEven==0)?nums[cur]:-1*nums[cur];
        dp[cur][isEven] = Math.max(total+dfs(cur+1, (isEven==0)?1:0, dp, nums), dfs(cur+1, isEven, dp, nums));
        return dp[cur][isEven];
    }
}
