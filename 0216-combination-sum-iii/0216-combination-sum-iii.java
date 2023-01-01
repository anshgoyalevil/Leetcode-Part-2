class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void f(ArrayList<Integer> m, int t, int k, int id, int [] ct){
        
        if(m.size() == k){
            if(t == 0){
                ans.add(new ArrayList<>(m));
            }
            return;
        }
        
        if(id==9){
            return;
        }
        
        if(ct[id] <= t){
            //System.out.println(id);
            m.add(ct[id]);
            f(m, t-ct[id], k, id+1, ct);
            m.remove(m.size()-1);
        }
        f(m, t, k, id+1, ct);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {

        int [] ct = {1,2,3,4,5,6,7,8,9};
        
        f(new ArrayList<>(), n, k, 0, ct);
        return ans;
        
    }
}