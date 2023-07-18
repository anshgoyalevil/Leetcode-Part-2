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
        
        return f(t, 0, 0, dp);
        
    }
}
