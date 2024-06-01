class Solution {
    public boolean predictTheWinner(int[] nums) {
        Map<Integer,Map<Integer,Integer>> map =new HashMap<>();
        int diff = solver1(0,nums.length-1,nums,map);
        return diff >= 0;
    }

    public int solver1(int i, int j, int[] stoneValue, Map<Integer,Map<Integer,Integer>> map) {
        if(i>j){
            return 0;
        }
        if(map.get(i)!=null && map.get(i).get(j)!=null){
            return map.get(i).get(j);
        }
        int res = Integer.MIN_VALUE;
        res = Math.max(res,stoneValue[i]-solver1(i+1,j,stoneValue,map));
        res = Math.max(res,stoneValue[j]-solver1(i,j-1,stoneValue,map));
        if(map.get(i)!=null){
            map.get(i).put(j,res);
        }else{
            Map<Integer,Integer> innerMap = new HashMap<>();
            innerMap.put(j,res);
            map.put(i,innerMap);
        }
        return map.get(i).get(j);
    }
}
