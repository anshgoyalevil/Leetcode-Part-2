class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        
        int it = 0;

        int r = 0;
        
        
        while(it!=nums.length){
            ans.add(new ArrayList<>());
            for(Map.Entry<Integer, Integer> e: hm.entrySet()){
                //System.out.println(hm);
                if(e.getValue() > 0){
                    hm.put(e.getKey(), e.getValue()-1);
                    it++;
                    ans.get(r).add(e.getKey());
                }
            }
            r++;
            if(it == nums.length){
                break;
            }
        }
        
        return ans;
        
    }
}