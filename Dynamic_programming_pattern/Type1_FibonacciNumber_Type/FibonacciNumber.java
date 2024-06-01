class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int a = 0;
        int b = 1;
        int count =n-2;
        while(count-->=0){
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
}
