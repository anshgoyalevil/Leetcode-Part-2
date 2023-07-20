class Solution {
    
    public int f(int [] coins, int t, int ind, int [][] dp){
        
        if(ind == 0){
            if(t%coins[0] == 0){
                return t/coins[0];
            }
            return 1000000000;
        }
        
        if(dp[ind][t] != -1){
            return dp[ind][t];
        }
        
        int pick = 1000000000;
        if(coins[ind] <= t){
            pick = 1 + f(coins, t-coins[ind], ind, dp);
        }
        int notPick = f(coins, t, ind-1, dp);
        
        return dp[ind][t] = Math.min(pick, notPick);
        
    }
    
    public int coinChange(int[] coins, int amount) {
        
        int [][] dp = new int [coins.length][amount+1];
        
        for(int i = 0; i<coins.length; i++){
            for(int j = 0; j<amount+1; j++){
                dp[i][j] = -1;
            }
        }
        
        int ans = f(coins, amount, coins.length-1, dp);
        
        if(ans >= 1000000000){
            return -1; 
        }
        
        return ans;
        
    }
}