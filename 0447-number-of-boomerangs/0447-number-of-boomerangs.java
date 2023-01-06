class Solution {

    public int numberOfBoomerangs(int[][] p) {
        int n = p.length;
        if (n == 0) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (map.containsKey(distance(p[i], p[j]))) {
                    int value = map.get(distance(p[i], p[j]));
                    count += 2 * value;
                    map.put(distance(p[i], p[j]), value + 1);
                } else {
                    map.put(distance(p[i], p[j]), 1);
                }
            }
        }
        return count;
    }

    public Double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
