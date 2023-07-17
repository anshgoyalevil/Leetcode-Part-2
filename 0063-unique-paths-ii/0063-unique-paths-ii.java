class Solution {
    
    public int f(int [][] dp, int i, int j, int [][] og){
        
        if(i>=og.length || j>=og[0].length || og[i][j] == 1){
            return 0;
        }
        if(i == og.length-1 && j == og[0].length-1){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int a = f(dp, i+1, j, og);
        int b = f(dp, i, j+1, og);
        
        return dp[i][j] = a+b;
        
    }
    
    public int uniquePathsWithObstacles(int[][] og) {
        
        int [][] dp = new int [og.length][og[0].length];
        
        for(int i = 0; i<og.length; i++){
            for(int j = 0; j<og[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return f(dp, 0, 0, og);
        
    }
}