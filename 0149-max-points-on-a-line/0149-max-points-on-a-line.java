class Solution {
    public int maxPoints(int[][] points) {
        
        if(points.length == 1){
            return 1;
        }
        
        HashMap<Double, Integer> hm = new HashMap<>();
                
        int mx = -1;
        for(int i = 0; i<points.length; i++){
            
            for(int j = 0; j<points.length; j++){
                if(i==j){
                    continue;
                }
                double s = ((double)(points[i][1]-points[j][1]))/((double)(points[i][0]-points[j][0]));
                
                hm.put(s, hm.getOrDefault(s, 0)+1);
                
            }
            for(Map.Entry<Double, Integer> e: hm.entrySet()){
                mx = Math.max(mx, e.getValue());
            }
            hm.clear();
            
        }
        
        return mx+1;
    }
}