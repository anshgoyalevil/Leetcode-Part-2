class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] l = new int[nums.length];
        int[] prev = new int[nums.length];

        Arrays.sort(nums);

        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            l[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && l[j] + 1 > l[i]) {
                    l[i] = l[j] + 1;
                    prev[i] = j;
                }
            }
            if (l[i] > max) {
                max = l[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }
}
