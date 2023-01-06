class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int l1 = (p3[1] - p1[1])*(p3[1]-p1[1]) + (p3[0] - p1[0])*(p3[0]-p1[0]);
        int l2 = (p4[1] - p1[1])*(p4[1]-p1[1]) + (p4[0] - p1[0])*(p4[0]-p1[0]);
        int l3 = (p2[1] - p1[1])*(p2[1]-p1[1]) + (p2[0] - p1[0])*(p2[0]-p1[0]);
        int l4 = (p3[1] - p2[1])*(p3[1]-p2[1]) + (p3[0] - p2[0])*(p3[0]-p2[0]);
        int l5 = (p4[1] - p2[1])*(p4[1]-p2[1]) + (p4[0] - p2[0])*(p4[0]-p2[0]);
        int l6 = (p4[1] - p3[1])*(p4[1]-p3[1]) + (p4[0] - p3[0])*(p4[0]-p3[0]);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
		
        if(l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0 || l5 == 0 || l6 == 0){
            return false;
        }
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        
        
        for(int p : list){
            set.add(p);
        }
        return set.size() == 2;
    }
}