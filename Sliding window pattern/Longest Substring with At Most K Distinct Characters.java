class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        
        int maxSubString = Integer.MIN_VALUE;
        int uniques = set.size();
        for(int unique=1;unique<=Math.min(uniques,k);unique++){
            int left = 0;
            int count = 0;
            int[] countArr = new int[256];
            for(int right=0;right<s.length();right++){
                if(countArr[s.charAt(right)]==0) count++;
                countArr[s.charAt(right)]++;
                while(left<s.length() && count>unique){
                    countArr[s.charAt(left)]--;
                    if(countArr[s.charAt(left)]==0) count--;
                    left++;
                }
                if(count==unique){
                    maxSubString = Math.max(right-left+1,maxSubString);
                }
            }

        }
        return (maxSubString==Integer.MIN_VALUE)?0:maxSubString;
    }
}
