//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int [] par;
    static int [] size;
    
    static int findPar(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = findPar(par[x]);
    }
    
    static void union(int u, int v){
        if(size[u] >= size[v]){
            par[v] = u;
            size[u] += size[v];
        }
        else{
            par[u] = v;
            size[v] += size[u];
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    
	    int n = V;
	    
	    par = new int [n];
	    size = new int [n];
	    
	    for(int i = 0; i<n; i++){
	        par[i] = i;
	        size[i] = 1;
	    }
	    
	    int ans = 0;
	    
	    Arrays.sort(edges, (a, b) -> {
	        return a[2] - b[2];
	    });
	    
	    for(int i = 0; i<edges.length; i++){
	        int u = findPar(edges[i][0]);
	        int v = findPar(edges[i][1]);
	        if(u!=v){
	            union(u, v);
	            ans+=edges[i][2];
	        }
	    }
	    
	    return ans;
	    
	}
}