class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long max = Integer.MIN_VALUE;
        int right = 0;
        for(int left=0;left<nums.length;left++){
                sum+=(long)nums[right];
                set.add(nums[right]);
                right++;
            }
            if(set.size()==k){
                max = Math.max(max,sum);
            }
            set.remove(nums[left]);
            sum-=(long)nums[left];
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long max = Integer.MIN_VALUE;
        int right = 0;
        for(int left=0;left<nums.length;left++){
                sum+=(long)nums[right];
                set.add(nums[right]);
                right++;
            }
            if(set.size()==k){
                max = Math.max(max,sum);
            }
            set.remove(nums[left]);
            sum-=(long)nums[left];
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}
