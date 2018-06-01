class Solution {
    public String countAndSay(int n) {
        int it = 1;
        String result = "1";
        
        while (it < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == result.charAt(i-1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(i-1));
                    count = 1;
                }
            }
            
            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            result = sb.toString();
            it++;
        }
        
        return result;
    }
}