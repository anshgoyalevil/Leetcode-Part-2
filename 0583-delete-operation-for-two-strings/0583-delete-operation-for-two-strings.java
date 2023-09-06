class Solution {

    public int f(String w1, String w2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(w1.charAt(i) == w2.charAt(j)){
            return 1 + f(w1, w2, i-1, j-1, dp);
        }
        
        return dp[i][j] = Math.max(f(w1, w2, i-1, j, dp), f(w1, w2, i, j-1, dp));
        
    }

    public int minDistance(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        int [][] dp = new int [l1][l2];
        
        for(int [] e: dp){
            Arrays.fill(e, -1);
        }
        
        return word1.length() + word2.length() - (2*f(word1, word2, l1-1, l2-1, dp));
        
    }
}
