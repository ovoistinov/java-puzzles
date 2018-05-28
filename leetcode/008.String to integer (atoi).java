class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }

        if (start == str.length()) {
            return 0;
        }
        
        int sign = 1;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        
        double result = 0;
        
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            
            result = result * 10 + (str.charAt(i) - '0');
            
            if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        
        result *= sign;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}