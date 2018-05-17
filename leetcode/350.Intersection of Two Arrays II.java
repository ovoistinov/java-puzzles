class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> intersection = new ArrayList<>();
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        int[] result = new int[intersection.size()];
        
        int i = 0;
        for (int n : intersection) {
            result[i] = n;
            i++;
        }
        
        return result;
    }
    
    public int[] intersectWithHashMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n1 : nums1) {
            if (map.containsKey(n1)) {
                map.put(n1, map.get(n1) + 1);
            } else {
                map.put(n1, 1);
            }
        }
        
        List<Integer> intersection = new ArrayList<>();
        
        for (int n2 : nums2) {
            if (map.containsKey(n2)) {
                int count = map.get(n2);
                
                if (count > 1) {
                    map.put(n2, map.get(n2) - 1);
                } else {
                    map.remove(n2);
                }
                
                intersection.add(n2);
            }
        }
        
        int[] result = new int[intersection.size()];
        
        int i = 0;
        for (int is : intersection) {
            result[i++] = is;
        }
        
        return result;
    }
}