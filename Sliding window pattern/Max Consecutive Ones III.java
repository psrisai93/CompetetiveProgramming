class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) k--;
            while(left<nums.length && k<0){
                if(nums[left]==0) k++;
                left++;
            }
            if(k>=0){
                max = Math.max(max,right-left+1);
            }
        }
        return max;
    }
}
