class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int window = p.length();
        HashMap<Character,Integer> map_p = new HashMap();
        for(int i=0;i<p.length();i++){
            map_p.put(p.charAt(i),map_p.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0;
        HashMap<Character,Integer> map = new HashMap();
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(left<s.length() && right-left+1>window){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
            }
            if(right-left+1==window && map_p.equals(map)){
                result.add(left);
            }
        }
        return result;
    }
}
