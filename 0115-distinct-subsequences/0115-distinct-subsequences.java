class Solution {
    
    public int fr(String s, String t, int i, int j, int [][] dp){
        
        if(j<0){
            return 1;
        }
        
        if(i<0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = fr(s, t, i-1, j-1, dp) + fr(s, t, i-1, j, dp);
        }
        
        return dp[i][j] = fr(s, t, i-1, j, dp);
        
    }
    
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        int [][] dp = new int [n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        
        return fr(s, t, n-1, m-1, dp);
        
    }
}