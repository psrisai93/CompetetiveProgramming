class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxCost = Integer.MIN_VALUE;
        for(int i=0;i<costs.length;i++){
            maxCost = Math.max(maxCost,costs[i]);
        }
        int maxDays = Integer.MIN_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int day : days) {
            maxDays = Math.max(maxDays, day);
            ts.add(day);
        }
        int[] dp = new int[maxDays+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        map.put(0,1);
        map.put(1,7);
        map.put(2,30);
        dfs(ts.higher(0),0,costs, dp,ts);
        System.out.println(Arrays.toString(dp));
        return dp[ts.higher(0)];
    }

    Map<Integer,Integer> map = new HashMap<>();


    public int dfs(Integer days, int cur, int[] costs, int[] dp,TreeSet<Integer> ts){
        if(cur==costs.length){
            if(days==null){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(days==null){
            return 0;
        }
        if(dp[days]!=Integer.MAX_VALUE){
            return dp[days];
        }
        int curTotal = 0;
        int min = Math.min(costs[cur]+dfs(ts.higher(days+map.get(cur)-1), cur, costs, dp,ts),
                        dfs(days, cur+1,costs, dp,ts));
        dp[days] = Math.min(min,dp[days]);
        return dp[days];
    }
}
