class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            
        }
        
        int insPos = 0;
        
        for (int n : nums) {
            if (n != 0) {
                nums[insPos] = n;
                insPos++;
            }
        }
        
        while(insPos < nums.length) {
            nums[insPos] = 0;
            insPos++;
        }
    }
}