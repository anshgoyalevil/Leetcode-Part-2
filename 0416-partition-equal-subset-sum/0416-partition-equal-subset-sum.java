class Solution {
    
    public boolean f(int [] nums, int [][] dp, int n, int ind, int t){
        
        if(t == 0){
            return true;
        }
        if(ind == 0){
            return t == nums[ind];
        }
        
        if(dp[ind][t] != -1){
            return dp[ind][t] == 1 ? true : false;
        }
        
        boolean donttake = f(nums, dp, n, ind-1, t);
        boolean take = false;
        if(t >= nums[ind]){
            take = f(nums, dp, n, ind-1, t-nums[ind]);
        }
        
        dp[ind][t] = (donttake | take) == true ? 1 : 0;
        
        return (donttake | take);
        
    }
    
    public boolean canPartition(int[] nums) {
        
        
        int s = 0;
        
        for(int e: nums){
            s+=e;
        }
        
        if(s%2==1){
            return false;
        }
        
        int n = nums.length;
        
        int [][] dp = new int [n+1][(s/2)+1];
        
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<(s/2)+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return f(nums, dp, n, n-1, s/2);
        
    }
}