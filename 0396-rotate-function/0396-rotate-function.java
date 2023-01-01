class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        
        int f0 = 0;
        int s = 0;
        
        for(int i = 0; i<nums.length; i++){
            f0+=i*nums[i];
            s+=nums[i];
        }
        
        int it = n-1;

        int max = f0;
        
        for(int i = 0; i<n-1; i++){
            int r = f0+s-((n)*nums[it]);
            max = Math.max(max, r);
            it--;
            f0 = r;
        }
        return max;
    }
}