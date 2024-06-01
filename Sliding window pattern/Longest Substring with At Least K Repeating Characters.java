class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int max = Integer.MIN_VALUE;
        int atleast = 0;
        for(int unique=1;unique<=map.size();unique++){
            int right = 0;
            HashMap<Character,Integer> newMap = new HashMap<>();
            for(int left=0;left<s.length();left++){
                while(right<s.length() && newMap.size()<=unique){
                    newMap.put(s.charAt(right),newMap.getOrDefault(s.charAt(right),0)+1);
                    if(newMap.get(s.charAt(right))==k) atleast++;
                    if(atleast==unique && newMap.size()==unique){
                        max = Math.max(max,right-left+1);
                    }
                    right++;
                }
                if(atleast==unique && newMap.size()==unique){
                    max = Math.max(max,right-left);
                }
                if(newMap.get(s.charAt(left))==k) atleast--;
                newMap.put(s.charAt(left),newMap.get(s.charAt(left))-1);
                if(newMap.get(s.charAt(left))==0) newMap.remove(s.charAt(left));
            }
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}
