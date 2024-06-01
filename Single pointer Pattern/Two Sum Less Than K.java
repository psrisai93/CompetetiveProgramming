class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]<k){
                max = Math.max(max,nums[left]+nums[right]);
                left++;
            }else{
                right--;
            }
        }
        return (max==Integer.MIN_VALUE)?-1:max;
    }
}
