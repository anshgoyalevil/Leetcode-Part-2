class Solution {
    
    public int f(int i, int j, String a, String b, int [][] dp){
        
        if(i<0||j<0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(a.charAt(i) == b.charAt(j)){
            return 1 + f(i-1, j-1, a, b, dp);
        }
        
        return dp[i][j] = Math.max(f(i, j-1, a, b, dp), f(i-1, j, a, b, dp));
        
    }
    
    public int minInsertions(String s) {
        
        int n = s.length();
        
        int [][] dp = new int [n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        StringBuilder st = new StringBuilder(s);
        
        return n - f(n-1, n-1, s, st.reverse().toString(), dp);
        
    }
}