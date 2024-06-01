class Solution {
    public int countSubstrings(String s) {
        String maxString = ;
        int maxLen = 0;
        int i=0;
        int count = 0;
        while(i<s.length()){
            int left = i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(maxLen<right-left+1){
                    maxString = s.substring(left,right+1);
                    maxLen = right-left+1;
                }
                count++;
                left--;
                right++;
                
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(maxLen<right-left+1){
                    maxString = s.substring(left,right+1);
                    maxLen = right-left+1;
                }
                count++;
                left--;
                right++;
                
            }
            i++;
        }
        return count;
    }
}
