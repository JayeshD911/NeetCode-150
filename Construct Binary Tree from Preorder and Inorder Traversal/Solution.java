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
    HashMap<Integer, Integer> hm = new HashMap<>();
    int index = 0;

    public TreeNode build (int[] preorder,int start , int end){
        if( start > end ) return null;
        int nodeVal = preorder[index];
        int nodeValInorderPosition =  hm.get(nodeVal);

        index++; //increment in preorder array

        TreeNode node = new TreeNode(nodeVal);

        node.left = build (preorder, start , nodeValInorderPosition - 1);
        node.right = build (preorder, nodeValInorderPosition + 1 , end);

        return node;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0 ; i < inorder.length ; i++){
            hm.put(inorder[i],i);
        }
        return build (preorder, 0 , inorder.length - 1);
    }
}