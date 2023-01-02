class Solution {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0, j = 0, a = 0, b = 0, c = 0, ans = 0;
        while (j < s.length()) {
            if (s.charAt(j) == 'a') a++;
            if (s.charAt(j) == 'b') b++;
            if (s.charAt(j) == 'c') c++;
            while (a > 0 && b > 0 && c > 0) {
                ans = ans + n - j;
                if (s.charAt(i) == 'a') a--;
                if (s.charAt(i) == 'b') b--;
                if (s.charAt(i) == 'c') c--;
                i++;
            }
            j++;
        }
        return ans;
    }
}
