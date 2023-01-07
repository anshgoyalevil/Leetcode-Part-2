class Solution {

    public int minimumCardPickup(int[] cards) {
        
        int mn = Integer.MAX_VALUE;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i<cards.length; i++){
            if(hm.containsKey(cards[i])){
                mn = Math.min(mn, i - hm.get(cards[i])+1);
                hm.put(cards[i], i);
            }
            else{
                hm.put(cards[i], i);
            }
        }
        if(mn == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return mn;
        }
    }
}
