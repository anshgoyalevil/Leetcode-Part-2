/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<Integer> arr = new ArrayList<>();
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        f(root1);
        f(root2);
        Collections.sort(arr);
        return arr;
        
    }
    
    public void f(TreeNode root){
        
        if(root!=null){
            f(root.left);
            arr.add(root.val);
            f(root.right);
        }
        
    }
    
}