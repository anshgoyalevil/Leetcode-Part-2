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
    
    int ans = 0;
    
    public int c(TreeNode root){
        if(root==null){
            return 0;
        }
        return c(root.left) + c(root.right) + 1;
    }
    
    public int s(TreeNode root){
        if(root==null){
            return 0;
        }
        return s(root.left) + s(root.right) + root.val;
    }
    
    public void f(TreeNode root){
        if(root!=null){
            int s = s(root);
            int c = c(root);
            if(s/c == root.val){
                ans++;
            }
            f(root.left);
            f(root.right);
        }
    }

    public int averageOfSubtree(TreeNode root) {
        f(root);
        return ans;
    }
}
