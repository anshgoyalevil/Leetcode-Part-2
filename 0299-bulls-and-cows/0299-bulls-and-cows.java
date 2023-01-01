class Solution {
    public String getHint(String s, String g) {
        
        HashMap<Character, Integer> ghm = new HashMap<>();
        HashMap<Character, Integer> shm = new HashMap<>();
        
        int b = 0;
        int c = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == g.charAt(i)){
                b++;
            }
            else{
                shm.put(s.charAt(i), shm.getOrDefault(s.charAt(i), 0)+1);
                ghm.put(g.charAt(i), ghm.getOrDefault(g.charAt(i), 0)+1);
            }
        }
        
        for(Map.Entry<Character, Integer> e: ghm.entrySet()){
            if(shm.containsKey(e.getKey())){
                c+=Math.min(e.getValue(), shm.get(e.getKey()));
            }
        }
        return b+"A"+c+"B";
    }
}