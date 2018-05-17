class Solution {
    public String reverseString(String s) {
        char[] ch = s.toCharArray();
        
        for (int i=0; i < ch.length / 2; i++) {
            swap(ch, i, ch.length - 1 - i);
        }
        
        return new String(ch);
    }
    
    private void swap(char[] ch, int left, int right) {
        char tmp = ch[left];
        ch[left] = ch[right];
        ch[right] = tmp;
    }
    
    public String reverseStringWithAnotherArray(String s) {
        char[] ch = s.toCharArray();
        char[] reversed = new char[ch.length];
        
        for (int i=0; i < ch.length; i++) {
            reversed[ch.length-1-i] = ch[i];
        }
        
        return new String(reversed);
    }
}