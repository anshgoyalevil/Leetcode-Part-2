class Solution {

    public int f(List<List<Integer>> t, int i, int j, int[][] dp) {
        if (i == t.size() - 1) {
            return t.get(i).get(j);
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int a = t.get(i).get(j) + f(t, i + 1, j, dp);
        int b = t.get(i).get(j) + f(t, i+1, j + 1, dp);
        
        return dp[i][j] = Math.min(a, b);
        
    }

    public int minimumTotal(List<List<Integer>> t) {
        
        int [][] dp = new int [t.size()][t.size()];
        
        for(int i = 0; i<t.size(); i++){
            for(int j = 0; j<t.size(); j++){
                dp[i][j] = -1;
            }
        }
        
        for(int i = 0; i<t.size(); i++){
            dp[dp.length-1][i] = t.get(dp.length-1).get(i);
        }
        
        for(int i = t.size() - 2; i>-1; i--){
            
            for(int j = 0; j<t.get(i).size(); j++){
                int a = dp[i+1][j] + t.get(i).get(j);
                int b = dp[i+1][j+1] + t.get(i).get(j);
                dp[i][j] = Math.min(a, b);
            }
            
        }
        
        return dp[0][0];
        
        //return f(t, 0, 0, dp);
        
    }
}
