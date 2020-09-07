//没看参考自己做出来的！！
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1)return false;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left&right;
    }
    public int maxDepth(TreeNode root){
        if(root==null)return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1); 
    }
}