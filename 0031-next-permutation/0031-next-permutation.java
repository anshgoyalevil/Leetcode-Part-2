class Solution {

    public void rev(int[] a, int i, int j) {
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return;
        }

        int ind = -1;
        int ind2 = -1;
        int mn = Integer.MAX_VALUE;

        for (int i = len - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            rev(nums, ind + 1, len - 1);
            return;
        }

        for (int i = len - 1; i > ind; i--) {
            if (mn > nums[i] && nums[i] > nums[ind]) {
                ind2 = i;
                mn = nums[i];
                break;
            }
        }

        int temp = nums[ind];
        nums[ind] = nums[ind2];
        nums[ind2] = temp;

        int l = len - 1;

        rev(nums, ind + 1, len - 1);
    }
}
