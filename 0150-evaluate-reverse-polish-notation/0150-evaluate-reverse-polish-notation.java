class Solution {

    public int evalRPN(String[] tk) {
        Stack<String> st = new Stack<>();

        int ans = 0;
        int idx = 0;
        String p = "";

        while (idx != tk.length) {
            p = tk[idx];
            idx++;

            if (p.equals("+") || p.equals("-") || p.equals("*") || p.equals("/")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                if (p.equals("+")) {
                    ans = b + a;
                    st.push(ans + "");
                } else if (p.equals("-")) {
                    ans = b - a;
                    st.push(ans + "");
                } else if (p.equals("*")) {
                    ans = b * a;
                    st.push(ans + "");
                } else {
                    ans = b / a;
                    st.push(ans + "");
                }
            } else {
                st.push(p);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
