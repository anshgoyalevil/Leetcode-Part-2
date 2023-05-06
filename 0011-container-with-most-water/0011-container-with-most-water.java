class Solution {
    public int maxArea(int[] h) {
        
        int l = 0;
        int r = h.length-1;
        
        int ans = 0;
        
        while(l<r){
            
            int lh = h[l];
            int rh = h[r];
            
            int minh = Math.min(lh, rh);
            
            int len = r-l;
            
            ans = Math.max(ans, len*minh);
            
            if(lh<rh){
                l++;
            }
            else{
                r--;
            }
            
        }
        
        return ans;
        
    }
}