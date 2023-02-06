class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String str = "";
        
        int mxLen = Integer.MAX_VALUE;
        
        for(int i = 0; i<strs.length; i++){
            
            mxLen = Math.min(mxLen, strs[i].length());
            
        }
        
        int c = 0;
        
        for(int i = 0; i<mxLen; i++){
            
            char init = strs[0].charAt(i);
            
            for(int j = 0; j<strs.length; j++){
                
                if(strs[j].charAt(i) == init){
                    c++;
                }
                
            }
            
            if(c == strs.length){
                str = str + init;
                c = 0;
            }
            else{
                break;
            }
            
        }
        
        return str;
        
    }
}