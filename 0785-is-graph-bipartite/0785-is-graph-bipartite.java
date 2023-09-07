class Solution {

    public boolean dfs(int[][] graph, int col, int[] colr, int s) {
        colr[s] = col;

        for (int e : graph[s]) {
            if (colr[e] == 0) {
                if (dfs(graph, col == 1 ? 2 : 1, colr, e) == false) {
                    return false;
                }
            } else {
                if (colr[e] == col) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colr = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (colr[i] == 0) {
                if (dfs(graph, 1, colr, i) == false) {
                    //System.out.println(Arrays.toString(colr));
                    return false;
                }
            }
        }

        return true;
    }
}
