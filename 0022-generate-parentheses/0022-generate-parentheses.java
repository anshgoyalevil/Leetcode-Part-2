class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        f(n, 1, 0, "(");
        return ans;
    }

    public void f(int n, int l, int r, String a) {
        
        if(a.length() == n*2){
            ans.add(a);
            return;
        }
        
        if(l<n){
            f(n, l+1, r, a+'(');
        }
        if(r<l){
            f(n, l, r+1, a+')');
        }
        
    }
}
