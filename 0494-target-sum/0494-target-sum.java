class Solution {
    
    public int f(int [] nums, int t, int ind, int [][] dp){
        
        if(ind == 0){
            if(t == 0 && nums[0] == 0){
                return 2;
            }
            if(t == 0 || nums[0] == t){
                return 1;
            }
            return 0;
        }
        
        if(dp[ind][t]!=-1){
            return dp[ind][t];
        }
        
        int notPick = f(nums, t, ind-1, dp);
        int pick = 0;
        if(nums[ind] <= t){
            pick = f(nums, t-nums[ind], ind-1, dp);
        }
        
        return dp[ind][t] = pick + notPick;
        
    }
    
    public int findTargetSumWays(int[] nums, int t) {
        
        int s = 0;
        
        for(int i = 0; i<nums.length; i++){
            s+=nums[i];
        }
        
        if((s+t)%2==1 || s-t < 0){
            return 0;
        }
        
        int [][] dp = new int [nums.length][s-t+1];
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<=s-t; j++){
                dp[i][j] = -1;
            }
        }
    
        
        return f(nums, (s-t)/2, nums.length-1, dp);
        
    }
}