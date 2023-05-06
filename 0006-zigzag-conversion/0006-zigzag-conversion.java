class Solution {
    public String convert(String s, int nr) {
        
        if(nr == 1){
            return s;
        }
        
        int a = (nr-1)*2;
        
        int it1 = a;
        int it2 = 0;
        int e = 0;
        
        String ans = "";
        
        for(int i = 0; i<nr; i++){
            e = 0;
            for(int j = i; j<s.length();){
                if(e==0){
                    ans+=s.charAt(j);
                    j+=it1 == 0 ? it2 : it1;
                    e = 1;
                }
                else{
                    ans+=s.charAt(j);
                    j+=it2 == 0 ? it1 : it2;
                    e = 0;
                }
            }
            
            it1-=2;
            it2+=2;
            
        }
        
     return ans;
        
    }
}