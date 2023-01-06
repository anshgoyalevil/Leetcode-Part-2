class Solution {
    public int trailingZeroes(int n) {
        int zero = 0;
        int x = 5;
        while(x<=n){
            zero+=n/x;
            x*=5;
        }
        return zero;
    }
}