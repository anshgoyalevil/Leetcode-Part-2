class Solution {

    static int sss(int arr[], int n, int K) {
        
        if(K == 0){
            return 0;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        int currPrefixSum = 0;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            currPrefixSum += arr[i];

            if (currPrefixSum == K) {
                int currLen = i + 1;
                result = Math.min(result, currLen);
            }

            int requirePrefixSum = currPrefixSum - K;

            if (mp.containsKey(requirePrefixSum)) {
                int foundIdx = mp.get(requirePrefixSum);
                int currIdx = i;

                result = Math.min(result, currIdx - foundIdx);
            }

            mp.put(currPrefixSum, i);
        }

        if (result >= Integer.MAX_VALUE) return -1;

        return result;
    }

    public int minSizeSubarray(int[] nums, int target) {
        
        int sum = 0;
        
        for(int e: nums){
            sum+=e;
        }
        
        int [] arr = new int [nums.length*2];
        for(int i = 0; i<nums.length; i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
        }
        
        if(target > sum){
            long res = target%sum;
            // System.out.println(res);
            int ans = sss(arr, nums.length*2, (int)res);
            // System.out.println(ans);
            if(ans == -1){
                return -1;
            }
            return ans + (nums.length)*(target/sum);
        }
        else{
            int ans = sss(arr, nums.length*2, (int)target);
            
            return ans;
        }
        
    }
}
