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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q== null) return true;

        if(p != null && q!= null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); //both right and left subtrees are same
        }

        //if only one of them is null or if values don't match
        return false;
    }
}


//easy to understand
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) return false;

        if (p.val != q.val){
            return false;
        }

        else return isSameTree(p.right,q.right) && isSameTree(p.left, q.left);

    }
}