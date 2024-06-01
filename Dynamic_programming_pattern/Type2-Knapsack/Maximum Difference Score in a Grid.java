class Solution {
    public int maxScore(List<List<Integer>> grid) {
        long[][] dp = new long[grid.size()][grid.get(0).size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],2*Integer.MIN_VALUE);
        }
        long max = Integer.MIN_VALUE;
        for(int i=grid.size()-1;i>=0;i--){
            for(int j=grid.get(0).size()-1;j>=0;j--){
                max = Math.max(max,dfs(i,j,grid,dp));
            }
        }
        return (int)max;
    }

    public long dfs(int r, int c, List<List<Integer>> grid, long[][] dp){
        if(r>=grid.size() && c>=grid.get(0).size()){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c]!=2*Integer.MIN_VALUE){
            return dp[r][c];
        }
        long max = Integer.MIN_VALUE;
        for(int i=r+1;i<grid.size();i++){
            max = Math.max(max,(long)(grid.get(i).get(c)-grid.get(r).get(c))+(long)Math.max(dfs(i,c,grid,dp),0));
        }
        for(int i=c+1;i<grid.get(0).size();i++){
            max = Math.max(max,(long)(grid.get(r).get(i)-grid.get(r).get(c))+(long)Math.max(dfs(r,i,grid,dp),0));
        }
        dp[r][c] = max;
        return max;
    }
}
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        long[][] dp = new long[grid.size()][grid.get(0).size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],2*Integer.MIN_VALUE);
        }
        long max = Integer.MIN_VALUE;
        for(int i=grid.size()-1;i>=0;i--){
            for(int j=grid.get(0).size()-1;j>=0;j--){
                max = Math.max(max,dfs(i,j,grid,dp));
            }
        }
        return (int)max;
    }

    public long dfs(int r, int c, List<List<Integer>> grid, long[][] dp){
        if(r>=grid.size() && c>=grid.get(0).size()){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c]!=2*Integer.MIN_VALUE){
            return dp[r][c];
        }
        long max = Integer.MIN_VALUE;
        for(int i=r+1;i<grid.size();i++){
            max = Math.max(max,(long)(grid.get(i).get(c)-grid.get(r).get(c))+(long)Math.max(dfs(i,c,grid,dp),0));
        }
        for(int i=c+1;i<grid.get(0).size();i++){
            max = Math.max(max,(long)(grid.get(r).get(i)-grid.get(r).get(c))+(long)Math.max(dfs(r,i,grid,dp),0));
        }
        dp[r][c] = max;
        return max;
    }
}
