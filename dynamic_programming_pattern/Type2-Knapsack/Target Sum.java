class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        //create dp[nums.length][target+1]
        int[][] dp = new int[nums.length][sum+1+sum];
        //initialize dp with -1
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //dfs
        dfs(0,0,target,nums, dp);
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        //return dp[0][target]
        return dp[0][sum];
    }

    public int dfs(int sum, int cur, int target, int[] nums, int[][] dp){
        //if(cur==nums.length)
        if(cur==nums.length){
            //target==0
            if(sum==target)
                //return true
                return 1;
            //return false
            return 0;
        }
        // System.out.println(sum);
        // System.out.println(target);
        //if(dp[cur][target]!=-1)
        if(dp[cur][(dp[0].length/2)+sum]!=-1)
            //return dp[cur][target]
            return dp[cur][(dp[0].length/2)+sum];

        //int count = dfs(target-nums[cur], cur+1, dp, nums) || dfs(target+nums[cur], cur+1, dp, nums)
        dp[cur][(dp[0].length/2)+sum] = 
            dfs(sum-nums[cur], cur+1, target, nums, dp) + dfs(sum+nums[cur], cur+1, target, nums, dp);
        //return dp[cur][target]
        return dp[cur][(dp[0].length/2)+sum];
    }
}
