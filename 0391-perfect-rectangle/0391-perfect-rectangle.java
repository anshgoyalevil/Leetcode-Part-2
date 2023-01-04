class Solution {

    public boolean isRectangleCover(int[][] r) {
        long area = 0;
        HashSet<String> hs = new HashSet<>();

        int xbm = Integer.MAX_VALUE;
        int ybm = Integer.MAX_VALUE;
        int xtm = Integer.MIN_VALUE;
        int ytm = Integer.MIN_VALUE;

        for (int i = 0; i < r.length; i++) {
            int xb = r[i][0];
            int yb = r[i][1];
            int xt = r[i][2];
            int yt = r[i][3];

            xbm = Math.min(xbm, xb);
            ybm = Math.min(ybm, yb);
            xtm = Math.max(xtm, xt);
            ytm = Math.max(ytm, yt);

            area += (xt - xb) * (yt - yb);

            String p1 = xb + " " + yb;
            String p2 = xt + " " + yb;
            String p3 = xb + " " + yt;
            String p4 = xt + " " + yt;

            if (hs.contains(p1)) {
                hs.remove(p1);
            } else {
                hs.add(p1);
            }
            if (hs.contains(p2)) {
                hs.remove(p2);
            } else {
                hs.add(p2);
            }
            if (hs.contains(p3)) {
                hs.remove(p3);
            } else {
                hs.add(p3);
            }
            if (hs.contains(p4)) {
                hs.remove(p4);
            } else {
                hs.add(p4);
            }
        }

        if (!hs.contains(xbm + " " + ybm) || !hs.contains(xtm + " " + ybm) || !hs.contains(xbm + " " + ytm) || !hs.contains(xtm + " " + ytm) || hs.size() != 4) {
            return false;
        }

        return area == (xtm - xbm) * (ytm - ybm);
    }
}
