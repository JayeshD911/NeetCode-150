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
    int ans;

    public void dfs(TreeNode root, int maxValue){
        if (root == null) return;

        if(root.val >= maxValue){
            maxValue = root.val;
            ans++;
        }

        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
        return;
    }
    public int goodNodes(TreeNode root) {

        dfs(root, Integer.MIN_VALUE);
        return ans;
    }
}