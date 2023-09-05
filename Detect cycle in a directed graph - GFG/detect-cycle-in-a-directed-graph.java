//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, int node, int [] vis, int [] pathVis){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int e: adj.get(node)){
            if(vis[e] == 0){
                if(dfs(V, adj, e, vis, pathVis) == true){
                    return true;
                }
            }
            else if(pathVis[e] == 1){
                return true;
            }
        }
        
        pathVis[node] = 0;
        return false;
        
    }
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int [] vis = new int [V+1];
        int [] pathVis = new int [V+1];
        
        for(int i = 0; i<V; i++){
            if(dfs(V, adj, i, vis, pathVis) == true){
                return true;
            }
        }
        
        return false;
    }
}