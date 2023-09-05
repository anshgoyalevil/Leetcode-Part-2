class Solution {
    public int[] findOrder(int n, int[][] pr) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<pr.length; i++){
            adj.get(pr[i][0]).add(pr[i][1]);
        }
        
        int [] ans = new int [n];
        
        int [] in = new int [n];
        
        for(int i = 0; i<adj.size(); i++){
            for(int j = 0; j<adj.get(i).size(); j++){
                in[adj.get(i).get(j)]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int ct = 0;
        
        for(int i = 0; i<n; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        
        int it = n-1;
        
        while(!q.isEmpty()){
            int t = q.poll();
            
            ans[it] = t;
            ct++;
            it--;
            
            for(int e: adj.get(t)){
                in[e]--;
                if(in[e] == 0){
                    q.add(e);
                }
            }
            
        }
        
        int [] ep = {};
        
        if(ct == n){
            return ans;
        }
        return ep;
        
    }
}