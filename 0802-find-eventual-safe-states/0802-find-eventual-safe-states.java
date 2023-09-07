class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adjrev = new ArrayList<>();
        
        for(int i = 0; i<graph.length; i++){
            adjrev.add(new ArrayList<>());
        }
        
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[i].length; j++){
                adjrev.get(graph[i][j]).add(i);
            }
        }
        
        int [] in = new int [graph.length];
        
        for(int i = 0; i<adjrev.size(); i++){
            for(int j = 0; j<adjrev.get(i).size(); j++){
                in[adjrev.get(i).get(j)]++;
            }
        }
        
        //boolean [] vis = new boolean [in.length];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<in.length; i++){
            if(in[i] == 0){
                //vis[i] = true;
                q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            
            int top = q.poll();
            ans.add(top);
            
            for(int e: adjrev.get(top)){
                in[e]--;
                if(in[e] == 0){
                    q.add(e);
                }
            }
            
            
        }
        Collections.sort(ans);
        return ans;
        
    }
}