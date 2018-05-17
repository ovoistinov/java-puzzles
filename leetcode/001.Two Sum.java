class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> used = new HashMap<>();
        int[] indices = new int[2];
        
        for (int i=0; i < nums.length; i++) {
            if (used.containsKey(target-nums[i])) {
                return new int[] {used.get(target-nums[i]), i};
            } else {
                used.put(nums[i], i);
            }
        }
        
        return indices;
    }
}