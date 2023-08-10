class Solution {
    
    public int f(String s1, String s2, int i, int j, int [][] dp ){
        
        if(i<0||j<0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + f(s1, s2, i-1, j-1, dp);
        }
        
        return dp[i][j] = Math.max(f(s1, s2, i-1, j, dp), f(s1, s2, i, j-1, dp));
        
    }
    
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        int [][] dp = new int [n][n];
            
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        StringBuilder st = new StringBuilder(s);
        
        return f(s, st.reverse().toString(), n-1, n-1, dp);
        
    }
}