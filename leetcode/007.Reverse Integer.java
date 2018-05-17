class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        
        int n = Math.abs(x);
        long result = 0;
        
        while(n > 0) {
            result = result*10 + n%10;
            
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            
            n /= 10;
        }
        
        return (int) result*sign;
    }
}