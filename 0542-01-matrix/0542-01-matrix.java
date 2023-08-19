class Trio{
    int a;
    int b;
    int c;
    Trio(int x, int y, int z){
        a = x;
        b = y;
        c = z;
    }
}

class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int [][] vis = new int[m][n];
        
        int [][] ans = new int[m][n];
        
        Queue<Trio> q = new LinkedList<Trio>();
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Trio(i, j, 0));
                }
            }
        }
        
        int [] dirx = {-1, 1, 0, 0};
        int [] diry = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            Trio tmp = q.peek();
            int a = tmp.a;
            int b = tmp.b;
            int c = tmp.c;
            ans[a][b] = c;
            q.remove();
            for(int i = 0; i<4; i++){
                int fx = a + dirx[i];
                int fy = b + diry[i];
                if(fx <= m-1 && fy <= n-1 && fx >=0 && fy >= 0 && vis[fx][fy] == 0){
                    vis[fx][fy] = 1;
                    q.add(new Trio(fx, fy, c+1));
                }
            }
        }
        
        return ans;
        
    }
}