class Solution {
    public int maximum69Number (int num) {
        String a = num + "";

        String ans = "";

        boolean change = true;

        for(int i = 0; i<a.length(); i++){
            if(change && a.charAt(i) == '6'){
                ans+='9';
                change = false;
            }
            else{
                ans+=a.charAt(i);
            }
        }
        return Integer.parseInt(ans);
    }
}