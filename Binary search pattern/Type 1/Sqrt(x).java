class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0) return x;
        int l = 0;
        int r = x;
        //while l<=r
        while(r-l>1){
            //mid = l+(r-l)/2
            int mid = l+((r-l)/2);
            //if(mid*mid==target)
            if(((long)mid*mid)==x)   
                //return mid
                return mid;
            //else if(mid*mid<target)
            else if(((long)mid*mid)<x)
                //low=mid
                l = mid;
            //else if(mid*mid>target)
            else if(((long)mid*mid)>x)
                //high=mid
                r=mid;
        }
        //return l
        return l;
    }
}
