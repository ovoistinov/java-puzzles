class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 1;

        for (int i=digits.length - 1; i >=0 ; i--) {
            digits[i] += remainder;
            
            if (digits[i] == 10) {
                remainder = 1;
                digits[i] = 0;
            } else {
                remainder = 0;
            }
        }
        
        int[] result;
        
        if (remainder > 0) {
            int[] temp = digits.clone();
            result = new int[temp.length + 1];
            System.arraycopy(temp, 0, result, 1, temp.length);
            result[0] = 1;
            return result;
        } else {
            return digits.clone();
        }
    }
}