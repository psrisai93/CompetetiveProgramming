class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] reverseString = s.toCharArray();
        for(int i=0;i<s.length();i++){
            reverseString[s.length()-1-i] = s.charAt(i);
        }
        String reverse = String.valueOf(reverseString);
        System.out.println(reverse);
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=reverse.length()-1;j>=0;j--){
                if(s.charAt(i)==reverse.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
