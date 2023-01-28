class Solution {
    int ans = 0;
    int mx = 0;

    public void f(int[] nums, int xr, int i) {
        //System.out.println(xr);

        if (i == nums.length) {
            if (xr == mx) {
                ans++;
            }
            return;
        }

        f(nums, xr | nums[i], i + 1);
        f(nums, xr, i + 1);
    }

    public int countMaxOrSubsets(int[] nums) {
        int m = 0;

        for (int i = 0; i < nums.length; i++) {
            m = m | nums[i];
        }

        mx = m;

        f(nums, 0, 0);

        //System.out.println(mx);

        return ans;
    }
}
