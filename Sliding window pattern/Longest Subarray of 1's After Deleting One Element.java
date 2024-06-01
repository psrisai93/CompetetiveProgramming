class Solution {

    public int longestSubarray(int[] nums){
        int k=1;
        int right = 0;
        int max = Integer.MIN_VALUE;
        for(int left=0;left<nums.length;left++){
            while(right<nums.length && (k>0 || nums[right]==1)){
                if(nums[right]==0)
                    k--;
                max = Math.max(max,right-left+1);
                right++;
            }
            if(k>=0){
                max = Math.max(max,right-left);
            }
            if(nums[left]==0)
                k++;
        }
        return (max==Integer.MIN_VALUE)?0:max-1;
    }
}
class Solution {

    public int longestSubarray(int[] nums){
        int k=1;
        int right = 0;
        int max = Integer.MIN_VALUE;
        for(int left=0;left<nums.length;left++){
            while(right<nums.length && (k>0 || nums[right]==1)){
                if(nums[right]==0)
                    k--;
                max = Math.max(max,right-left+1);
                right++;
            }
            if(k>=0){
                max = Math.max(max,right-left);
            }
            if(nums[left]==0)
                k++;
        }
        return (max==Integer.MIN_VALUE)?0:max-1;
    }
}
