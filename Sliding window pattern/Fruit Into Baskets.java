class Solution {
    public int totalFruit(int[] fruits) {
        int right = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap();
        for(int left=0;left<fruits.length;left++){
            while(right<fruits.length && (map.size()<2 || (map.size()==2 && map.containsKey(fruits[right])))){
                map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
                max = Math.max(max,right-left+1);
                right++;
            }
            if(map.size()<=2){
                max =  Math.max(max,right-left);
            }
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0) map.remove(fruits[left]);
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}
