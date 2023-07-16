class Solution {
public:
    
    int f(vector<int>& nums, vector<int>& dp, int ind){
        if(ind == 0){
            return nums[0];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int a = nums[ind] + f(nums, dp, ind -2);
        int b = f(nums, dp, ind -1);
        return dp[ind] = max(a, b);
    }
    
    int rob(vector<int>& nums) {
        if(nums.size() == 1){
            return nums[0];
        }
        vector<int> dp1(nums.size(), -1);
        vector<int> dp2(nums.size(), -1);
        vector<int> t1, t2;
        for(int i = 0; i<nums.size(); i++){
            if(i != 0){
                t1.push_back(nums[i]);
            }
            if(i != nums.size() -1){
                t2.push_back(nums[i]);
            }
        }
        return max(f(t1, dp1, t1.size()-1), f(t2, dp2, t2.size() -1));
    }
};