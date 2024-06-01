class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        int maxCoin = 0;
        for(int i=0;i<coins.length;i++){
            maxCoin = Math.max(maxCoin, coins[i]);
        }
        int[][] dp = new int[amount+1][maxCoin+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dfs(amount, 0, coins, dp);
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return (dp[amount][coins[0]]==Integer.MAX_VALUE)?1:dp[amount][coins[0]];
    }

    public int dfs(int remain, int cur, int[] coins, int[][] dp){
        if(cur==coins.length){
            if(remain==0){
                return 1;
            }
            return 0;
        }
        if(remain==0){
            return 1;
        }
        if(remain<0){
            return 0;
        }
        if(dp[remain][coins[cur]]!=Integer.MAX_VALUE){
            return dp[remain][coins[cur]];
        }
        dp[remain][coins[cur]] = dfs(remain-coins[cur], cur, coins, dp) + dfs(remain, cur+1, coins, dp);
        return dp[remain][coins[cur]];
    }
}
