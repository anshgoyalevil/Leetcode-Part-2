class Solution {
    
    public void addEdge(List<List<Integer>> g, int a, int b){
        g.get(a).add(b);
    }
    
    public boolean dfs(List<List<Integer>> g, int s, HashSet<Integer> vis){
        
        if(vis.contains(s)){
            return false;
        }
        
        if(g.get(s).size() == 0){
            return true;
        }
        
        vis.add(s);
        
        for(int e: g.get(s)){
            if(!vis.contains(e)){
                dfs(g, e, vis);
            }
            else{
                return false;
            }
        }
        vis.remove(s);
        g.get(s).clear();
        
        return true;
        
    }
    
    public boolean canFinish(int nc, int[][] p) {
        
        List<List<Integer>> g = new ArrayList<>();
        
        for(int i = 0; i<nc; i++){
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i<p.length; i++){
            addEdge(g, p[i][0], p[i][1]);
        }
        
        HashSet<Integer> vis = new HashSet<>();
        
        for(int i = 0; i<nc; i++){
            if(dfs(g, i, vis) == false){
                return false;
            }
        }
        return true;
    }
}