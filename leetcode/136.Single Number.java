class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int n : nums) {
            res ^= n;
        }
        
        return res;
    }
    
    public int singleNumberWithSet(int[] nums) {
        Set<Integer> s = new HashSet<>();
        
        for (int n : nums) {
            if (s.contains(n)) {
                s.remove(n);
            } else {
                s.add(n);
            }
        }
        
        Iterator it = s.iterator();
        
        return ((Integer) it.next()).intValue();
    }
}