class Solution {

    public List<String> fullJustify(String[] w, int mw) {
        List<String> ans = new ArrayList<>();

        String line = "";
        int rem = mw;
        int sp = 0;

        for (int i = 0; i < w.length;) {
            // System.out.println(w[i]);
            if (rem >= w[i].length()) {
                // System.out.println(rem + " " + w[i]);
                line += w[i] + " ";
                rem -= w[i].length() + 1;
                sp++;
                i++;
            } else {
                sp--;
                line = line.substring(0, line.length() - 1);
                int stringLength = line.length() - sp;
                String[] wds = line.split("\\s+");
                int spaceleft = mw - stringLength;
                if (wds.length == 1) {
                    line = line + " ".repeat(spaceleft);
                    ans.add(line);
                    rem = mw;
                    line = "";
                    sp = 0;
                    continue;
                }
                String newline = "";
                int it = wds.length - 1;
                while (spaceleft > 0 && sp > 0) {
                    int spaces = spaceleft / sp;
                    String spacechar = " ".repeat(spaces);
                    newline = spacechar + wds[it] + newline;
                    it--;
                    spaceleft -= spaces;
                    sp--;
                }
                newline = wds[it] + newline;
                rem = mw;
                line = "";
                sp = 0;
                ans.add(newline);
            }
        }
        
        System.out.println(line);

        if (!line.equals("")) {
            line = line.substring(0, line.length() - 1);
            int spl = mw - line.length();
            String spacechar = " ".repeat(spl);
            if(spl > 0){
                line += spacechar;
            }
            ans.add(line);
        }

        return ans;
    }
}
