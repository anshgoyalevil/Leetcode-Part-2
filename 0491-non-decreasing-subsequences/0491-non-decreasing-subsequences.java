class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();

    public void f(int id, int[] nums, int pm, ArrayList<Integer> m) {
        if (m.size() >= 2) {
            List<Integer> md = new ArrayList<>(m);
            hs.add(md);
        }
        if (id == nums.length) {
            return;
        }
        if (pm <= nums[id]) {
            m.add(nums[id]);
            f(id + 1, nums, nums[id], m);
            m.remove(m.size() - 1);
        }
        f(id + 1, nums, pm, m);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        f(0, nums, Integer.MIN_VALUE, new ArrayList<>());
        return new ArrayList<>(hs);
    }
}
