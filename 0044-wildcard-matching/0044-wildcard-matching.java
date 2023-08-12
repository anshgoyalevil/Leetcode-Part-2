class Solution {
    
    public boolean f(String s, String p, int i, int j, Boolean [][] dp){
        
        if(i<0 && j<0){
            return true;
        }
        if(i<0 && j>=0){
            for(int ii = 0; ii<=j; ii++){
                if(p.charAt(ii)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(j<0 && i>=0){
            return false;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = f(s, p, i-1, j-1, dp);
        }
        
        if(p.charAt(j) == '*'){
            return dp[i][j] = f(s, p, i, j-1, dp) || f(s, p, i-1, j, dp);
        }
        
        return false;
        
    }
    
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();
        
        Boolean [][] dp = new Boolean [n][m];
        
        return f(s, p, n-1, m-1, dp);
        
    }
}