class Solution {
    public String longestPrefix(String s) {
        
        int [] dp = new int [s.length()];
        
        int j = 0;
        
        for(int i = 1; i<s.length(); i++){
            while(s.charAt(i) != s.charAt(j) && j>0){
                j = dp[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
                dp[i] = j;
            }
        }
        
        return s.substring(0, dp[s.length()-1]);
        
    }
}