class Solution {

    public int[] dailyTemperatures(int[] tp) {
        Stack<Integer> st = new Stack<>();
        
        int n = tp.length;

        int[] ans = new int[n];

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && tp[st.peek()] <= tp[i]) {
                st.pop();
            }

            if (!st.isEmpty() && tp[st.peek()] > tp[i]) {
                ans[i] = st.peek() - i;
            }

            st.add(i);
        }

        return ans;
    }
}
