class Solution {

    public boolean detectCapitalUse(String w) {
        int c = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) - 'a' < 0) {
                c++;
            }
        }
        if(w.charAt(0)-'a'<0){
            if(c == 1){
                return true;
            }
            if(c == w.length()){
                return true;
            }
        }
        
        if(c > 0){
            return false;
        }
        return true;
    }
}
