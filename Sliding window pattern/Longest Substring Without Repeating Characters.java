class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap();
        HashSet<Character> set = new HashSet<>();
        int maxRepeatingCharacterCount = 0;
        int max = Integer.MIN_VALUE;
        int right = 0;
        for(int left=0;left<s.length();left++){
            while(right<s.length() && (right-left-maxRepeatingCharacterCount<k || (right-left-maxRepeatingCharacterCount==k && (set.isEmpty() || set.contains(s.charAt(right)))))){
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
                maxRepeatingCharacterCount = 0;
                set = new HashSet<>();
                for(Map.Entry<Character,Integer> entry : map.entrySet()){
                    if(maxRepeatingCharacterCount<entry.getValue()){
                        maxRepeatingCharacterCount = entry.getValue();
                        set = new HashSet<>();
                        set.add(entry.getKey());

                    }else if(maxRepeatingCharacterCount==entry.getValue()){
                        set.add(entry.getKey());
                    }
                }
                max = Math.max(max,right-left+1);
                right++;
            }
            if(map.size()-maxRepeatingCharacterCount<=k){
                max = Math.max(max,right-left);
            }
            map.put(s.charAt(left),map.get(s.charAt(left))-1);
            if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));

            maxRepeatingCharacterCount = 0;
            set = new HashSet<>();
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(maxRepeatingCharacterCount<entry.getValue()){
                    maxRepeatingCharacterCount = entry.getValue();
                    set = new HashSet<>();
                    set.add(entry.getKey());

                }else if(maxRepeatingCharacterCount==entry.getValue()){
                    set.add(entry.getKey());
                }
            }
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}
