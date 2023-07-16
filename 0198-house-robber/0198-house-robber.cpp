class Solution {
public:
    
    int f(vector<int>& nums, int ind, vector<int>& dp){
        
        if(ind == 0){
            return nums[0];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int a = nums[ind] + f(nums, ind - 2, dp);
        int b = f(nums, ind - 1, dp);
        
        return dp[ind] = max(a, b);
        
    }
    
    int rob(vector<int>& nums) {
        
        vector<int> dp(nums.size(), -1);
        
        return f(nums, nums.size()-1, dp);
        
    }
};