class Solution {
    
    public int f(int tn, int i, int [][] dp, int [] prices, int n, int k){
        
        if(i == n || tn == 2*k){
            return 0;
        }
        
        if(dp[i][tn] != -1){
            return dp[i][tn];
        }
        
        if(tn%2==0){
            int profit = Math.max(-prices[i] + f(tn+1, i+1, dp, prices, n, k), f(tn, i+1, dp, prices, n, k));
            return dp[i][tn] = profit;
        }
        else{
            int profit = Math.max(prices[i] + f(tn+1, i+1, dp, prices, n, k), f(tn, i+1, dp, prices, n, k));
            return dp[i][tn] = profit;
        }
                
    }
    
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        
        int [][] dp = new int [n][2*k];
        
        for(int [] e: dp){
            Arrays.fill(e, -1);
        }
        
        return f(0, 0, dp, prices, n, k);
        
    }
}