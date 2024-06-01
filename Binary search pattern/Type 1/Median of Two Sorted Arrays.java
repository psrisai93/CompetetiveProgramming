class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length>nums1.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int total = nums1.length+nums2.length;
        int leftParitionCount = (int)Math.floor((float)(nums1.length+nums2.length)/2);
        int l = 0;
        int r = nums2.length-1;
        while(true){
            int mid2 = (int)Math.floor(l+((float)(r-l)/2));
            int mid1 = leftParitionCount-(mid2+1)-1;
            int mid2_left = (mid2<0)?Integer.MIN_VALUE:nums2[mid2];
            int mid2_right = (mid2+1>=nums2.length)?Integer.MAX_VALUE:nums2[mid2+1];
            int mid1_left = (mid1<0)?Integer.MIN_VALUE:nums1[mid1];
            int mid1_right = (mid1+1>=nums1.length)?Integer.MAX_VALUE:nums1[mid1+1];
            if(mid2_left<=mid1_right && mid1_left<=mid2_right){
                if(total%2==0){
                    return (float)(Math.max(mid2_left,mid1_left)+Math.min(mid2_right,mid1_right))/2;
                }else{
                    return (Math.min(mid2_right,mid1_right));
                }
            }else if(mid2_left>mid1_right){
                r = mid2-1;
            }else if(mid1_left>mid2_right){
                l = mid2+1;
            }
        }
    }
}
