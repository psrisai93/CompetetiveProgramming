class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            count+= countMap.getOrDefault(sum-k,0);
            countMap.put(sum,countMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
