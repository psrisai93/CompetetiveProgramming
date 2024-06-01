class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int total = 0;
        for(int i=0;i<stoneValue.length;i++){
            total+=stoneValue[i];
        }
        Map<Integer,Integer> map =new HashMap<>();
        int diff = solver(0,true,stoneValue,map);
        return (diff>0)?Alice:((diff<0)?Bob:Tie);
    }

    public int solver(int i, boolean player, int[] stoneValue, Map<Integer,Integer> map) {
        if(i>=stoneValue.length){
            return 0;
        }
        if(map.get(i)!=null){
            return map.get(i);
        }
        int total = 0;
        int res = Integer.MIN_VALUE;
        for(int a=0;a<3 && a+i<stoneValue.length;a++){
            total+=stoneValue[a+i];
        }
        map.put(i,res);
        return map.get(i);
    }
}
