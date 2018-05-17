class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    public void rotateByRightShift(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        for (int i=0; i < k; i++) {
            shiftRight(nums);
        }
    }
    
    private void shiftRight(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i=nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }
}