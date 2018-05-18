class Solution {
    public int firstUniqChar(String s) {
        int res = s.length();
        
        for (char c = 'a'; c <= 'z'; c++) {
            int pos = s.indexOf(c);
            
            if (s.lastIndexOf(c) == -1) continue;
            if (pos == s.lastIndexOf(c)) {
                res = Math.min(pos, res);
            }
        }
        
        return res == s.length() ? -1 : res;
    }
}