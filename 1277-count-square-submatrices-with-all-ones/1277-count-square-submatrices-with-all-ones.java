class Solution {
    public int countSquares(int[][] mt) {
        
        int n = mt.length;
        int m = mt[0].length;
        int ans = 0;
        
        int [][] dp = new int [n][m];
        
        for(int i = 0; i<n; i++){
            dp[i][0] = mt[i][0];
        }
        
        for(int i = 0; i<m; i++){
            dp[0][i] = mt[0][i];
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(mt[i][j] == 0){
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans+=dp[i][j];
            }
        }
        
        return ans;
        
    }
}