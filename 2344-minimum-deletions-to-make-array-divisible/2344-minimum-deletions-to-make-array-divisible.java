class Solution {
    
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    public int minOperations(int[] n, int[] nd) {
        
        int gcd = nd[0];
        
        for(int i = 0; i<nd.length; i++){
            gcd = gcd(gcd, nd[i]);
        }
        
        int ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<n.length; i++){
            pq.add(n[i]);
        }
        System.out.println(gcd);
        while(!pq.isEmpty()){
            int a = pq.peek();
            if(a<gcd && gcd%a!=0){
                ans++;
                pq.poll();
            }
            else if(a>gcd){
                return -1;
            }
            else if(a==gcd){
                return ans;
            }
            else{
                return ans;
            }
        }
        return -1;
    }
}