class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        char cLeft;
        char cRight;
        
        while(left <= right) {
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } else if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    public boolean isPalindromeWithStringBuilder(String s) {
        s = s.toLowerCase();
        
        if (s == null) {
            return false;
        }
        
        StringBuilder norm = new StringBuilder();
        
        for (int i=0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                norm.append(s.charAt(i));
            }
        }
        
        StringBuilder reversed = new StringBuilder(norm);
        reversed.reverse();
        
        return norm.toString().equals(reversed.toString());
    }
}