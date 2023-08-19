class Solution {
    
    public void f(int[][] b, int [][] vis, int i, int j, int m, int n){
        
        if(i<0 || j<0 || i>m-1 || j>n-1 || vis[i][j] == 1 || b[i][j] == 0){
            return;
        }
        
        if(b[i][j] == 1){
            vis[i][j] = 1;
        }
        
        f(b, vis, i+1, j, m, n);
        f(b, vis, i-1, j, m, n);
        f(b, vis, i, j+1, m, n);
        f(b, vis, i, j-1, m, n);
        
    }
    
    public int numEnclaves(int[][] b) {
        
        int m = b.length;
        int n = b[0].length;
        
        int [][] vis = new int [m][n];
        
        for(int i = 0; i<n; i++){
            if(b[0][i] == 1){
                f(b, vis, 0, i, m, n);
            }
        }
        for(int i = 0; i<m; i++){
            if(b[i][0] == 1){
                f(b, vis, i, 0, m, n);
            }
        }
        for(int i = 0; i<n; i++){
            if(b[m-1][i] == 1){
                f(b, vis, m-1, i, m, n);
            }
        }
        for(int i = 0; i<m; i++){
            if(b[i][n-1] == 1){
                f(b, vis, i, n-1, m, n);
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j] != 1 && b[i][j] == 1){
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}