

// Not optimal
//class Solution {
//
//    public int dfs(TreeNode root){
//        if(root == null) return 0;
//
//        return 1 + Math.max(dfs(root.left), dfs(root.right));
//    }
//    public boolean isBalanced(TreeNode root) {
//
//        if(root == null) return true;
//
//        int left = dfs(root.left) ;
//        int right = dfs(root.right);
//
//        int difference = Math.abs(left - right );
//
//        if (difference > 1){
//            return false;
//        }
//        if(isBalanced(root.left) && isBalanced(root.right)) return true;
//        return false;
//    }
//}