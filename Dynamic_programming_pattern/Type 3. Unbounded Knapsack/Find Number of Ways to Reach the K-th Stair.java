class Solution {
    public int waysToReachStair(int k) {
        return dfs(1,0,false,new HashMap<Integer,Integer>(), k);
    }

    public int dfs(int cur, int jump, boolean used, HashMap<Integer,Integer> map, int k){
        if(cur<0){
            return 0;
        }
        if(cur-k>1){
            return 0;
        }
        if(map.get(cur)!=null){
            return map.get(cur);
        }
        if(cur==k){
            int count = 1;
            if(used){
                count+=feedback;
            }else{
            }
            map.put(cur,count);
            return count;
        }
        
        int count = 0;
        if(used){
            count+=feedback;
        }else{
        }
        map.put(cur,count);
        return count;
    }
}
