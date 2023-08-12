class Solution {
    
    public int f(String a, String b, int i, int j, int [][] dp){
        
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(a.charAt(i) == b.charAt(j)){
            return f(a, b, i-1, j-1, dp);
        }
        
        return dp[i][j] = 1 + Math.min(f(a, b, i-1, j, dp), Math.min(f(a, b, i, j-1, dp), f(a, b, i-1, j-1, dp)));
        
    }
    
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int [][] dp = new int [n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        
        return f(word1, word2, n-1, m-1, dp);
        
    }
}