class Solution {

    public int f(int t, int e, int[] nums, int id) {
        
        if (id == nums.length) {
            if (e == t) {
                return 1;
            }
            return 0;
        }
        
        int a = f(t, e + nums[id], nums, id + 1);
        int b = f(t, e - nums[id], nums, id + 1);
        
        return a+b;
    }

    public int findTargetSumWays(int[] nums, int target) {
        
        
        return f(target, 0, nums, 0);
        
        
    }
}
