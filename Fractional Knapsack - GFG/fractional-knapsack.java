//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    class SortItem implements Comparator<Item>{
        
        @Override
        public int compare(Item p1, Item p2){
        
            if((double)p2.value/(double)p2.weight < (double)p1.value/(double)p1.weight){
                return -1;
            }
            else if((double)p2.value/(double)p2.weight > (double)p1.value/(double)p1.weight){
                return 1;
            }
            else{
                return 0;
            }
        }
        
    }
    
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        ArrayList<Item> mid = new ArrayList<>();
        
        for(int i = 0; i<arr.length; i++){
            mid.add(new Item(arr[i].value, arr[i].weight));
        }
        
        int it = 0;
        
        double ans = 0;
        
        Collections.sort(mid, new SortItem());
        
        while(W != 0){
            if(it==arr.length){
                break;
            }
            if(mid.get(it).weight <= W){
                ans+=mid.get(it).value;
                W-=mid.get(it).weight;
                it++;
            }
            else{
                double part = ((double)mid.get(it).value/(double)mid.get(it).weight)*W;
                ans+=part;
                break;
            }
        }
        
        return ans;
        
    }
}