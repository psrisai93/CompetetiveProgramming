class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int a = 1;
        int b = 2;
        n=n-2;
        while(n-->0){
            int temp = b;
            b = a+b;
            a = temp;
        }
        return b;
    }
}
