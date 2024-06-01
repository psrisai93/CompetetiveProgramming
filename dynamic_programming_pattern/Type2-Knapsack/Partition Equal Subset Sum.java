class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for(int num:nums) targetSum+=num;
        if(targetSum%2==1) return false;
        //create dp with [nums.length][2]
        int[][] dp = new int[nums.length][(int)Math.ceil(targetSum/2)+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //dfs
        dfs(targetSum/2,0, dp, nums);
        return dp[0][targetSum/2]==1;
    }

    public boolean dfs(int takenRemain, int cur, int[][] dp, int[] nums){
        if(cur==nums.length){
            if(takenRemain==0)
                return true;
            return false;
        }
        if(takenRemain<0)
            return false;
        if(dp[cur][takenRemain]!=-1)
            return (dp[cur][takenRemain]==1)?true:false;
        boolean canPartition = dfs(takenRemain-nums[cur],cur+1,dp,nums) || dfs(takenRemain,cur+1,dp,nums);
        if(canPartition){
            dp[cur][takenRemain] = 1;
            return true;
        }else{
            dp[cur][takenRemain] = 0;
            return false;
        }
    }
}
