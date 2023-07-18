class Solution {
    
    public int f(int i, int j1, int j2, int r, int c, int [][] grid, int [][][] dp){
        
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c){
            return -1000000000;
        }
        
        if(i == r-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        
        int mx = Integer.MIN_VALUE;
        
        for(int a = -1; a<=1; a++){
            for(int b = -1; b<=1; b++){
                int value = 0;
                if(j1 != j2){
                    value+=grid[i][j1] + grid[i][j2] + f(i+1, j1+a, j2+b, r, c, grid, dp);
                }
                else{
                    value+=grid[i][j1] + f(i+1, j1+a, j2+b, r, c, grid, dp);
                }
                mx = Math.max(mx, value);
            }
        }
        
        return dp[i][j1][j2] = mx;
        
    }
    
    public int cherryPickup(int[][] grid) {
        
        int [][][] dp = new int [grid.length][grid[0].length][grid[0].length];
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                for(int k = 0; k<c; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return f(0, 0, c-1, r, c, grid, dp);
        
    }
}