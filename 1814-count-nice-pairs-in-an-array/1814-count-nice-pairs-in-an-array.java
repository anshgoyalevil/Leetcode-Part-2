class Solution {

    public int countNicePairs(int[] nums) {
        int[] reva = new int[nums.length];
        
        int mod = 1000_000_007;

        for (int i = 0; i < nums.length; i++) {
            int op = nums[i];
            int rev = 0;
            int rem;
            while (op > 0) {
                rem = op % 10;
                rev = (rev * 10) + rem;
                op = op / 10;
            }
            reva[i] = nums[i]-rev;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int ans = 0;
        
        for(int i = 0; i<reva.length; i++){
            if(hm.containsKey(reva[i])){
                ans=(ans+hm.get(reva[i]))%mod;
                hm.put(reva[i], hm.getOrDefault(reva[i], 0)+1);
            }
            else{
                hm.put(reva[i], hm.getOrDefault(reva[i], 0)+1);
            }
        }
        return ans;
    }
}
