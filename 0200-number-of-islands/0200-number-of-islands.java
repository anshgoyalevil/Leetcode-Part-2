class Solution {
    int c = 0;
    public void f(char[][] grid, int m, int n, char [][] it){
        if(m<0 || n<0 || m>=grid.length || n>=grid[0].length || it[m][n] == '0'){
            return;
        }
        if(grid[m][n] == '1'){
            grid[m][n] = '0';
            //return;
        }
        else{
            return;
        }
        f(grid, m+1, n, it);
        f(grid, m, n+1, it);
        f(grid, m-1, n, it);
        f(grid, m, n-1, it);
    }

    public int numIslands(char[][] grid) {
        char [][] it = new char [grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                it[i][j] = grid[i][j];
            }
        }
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    c++;
                    f(grid, i, j, it);
                }
            }
        }
        // for(int i = 0; i<grid.length; i++){
        //     for(int j = 0; j<grid[0].length; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return c;
    }
}