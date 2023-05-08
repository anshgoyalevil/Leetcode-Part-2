class Solution {

    class Pair {
        int f;
        int s;

        Pair(int a, int b) {
            f = a;
            s = b;
        }
    }

    class SortPair implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.f - o2.f;
        }
    }

    public int[][] merge(int[][] iv) {
        ArrayList<Pair> ar = new ArrayList<>();

        for (int i = 0; i < iv.length; i++) {
            ar.add(new Pair(iv[i][0], iv[i][1]));
        }

        Collections.sort(ar, new SortPair());

        int s = ar.get(0).f;
        int e = ar.get(0).s;

        ArrayList<Pair> mid = new ArrayList<>();

        for (int i = 1; i < ar.size(); i++) {
            if (ar.get(i).f <= e) {
                e = Math.max(ar.get(i).s, e);
            } else {
                mid.add(new Pair(s, e));
                s = ar.get(i).f;
                e = ar.get(i).s;
            }
        }
        
        mid.add(new Pair(s, e));
        
        int [][] ans = new int [mid.size()][2];
        
        for(int i = 0; i<mid.size(); i++){
            ans[i][0] = mid.get(i).f;
            ans[i][1] = mid.get(i).s;
        }
        
        return ans;
        
    }
}
