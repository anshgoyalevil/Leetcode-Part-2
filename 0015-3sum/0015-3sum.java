class Solution {

    public int bin(int[] nums, int l, int r, int t) {
        if (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] < t) {
                return bin(nums, mid + 1, r, t);
            } else if (nums[mid] > t) {
                return bin(nums, l, mid - 1, t);
            }
            return mid;
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int start = 0;

        int end = nums.length - 1;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target2 = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int target1 = target2 - nums[j];
                int b = bin(nums, j + 1, nums.length-1, target1);
                //System.out.println(b + " " + target2 + " " + target1);
                if (b != -1) {
                    List<Integer> m = new ArrayList<>();
                    m.add(nums[i]);
                    m.add(nums[j]);
                    m.add(nums[b]);
                    Collections.sort(m);
                    hs.add(m);
                }
            }
        }
        return new ArrayList<>(hs);
    }
}
