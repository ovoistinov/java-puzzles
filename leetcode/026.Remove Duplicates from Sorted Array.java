class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int curElement = nums[0];
        int curIndex = 0;
        
        for (int i=0; i < nums.length; i++) {
            if (curElement != nums[i]) {
                curElement = nums[i];
                curIndex++;
                
                swap(nums, curIndex, i);
            }
        }
        
        return curIndex + 1;
    }
    
    private void swap(int[] nums, int fromi, int toi) {
        int temp = nums[fromi];
        nums[fromi] = nums[toi];
        nums[toi] = temp;
    }
}