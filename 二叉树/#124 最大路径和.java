class Solution {
    //可以定义一个最小值
    public int ma = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ma;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        ma = ma>root.val?ma:root.val;
        ma = ma>root.val+left?ma:root.val+left;
        ma = ma>root.val+right?ma:root.val+right;
        //第四种情况不符合题意，不能继续dfs
        ma = ma>root.val+right+left?ma:root.val+right+left;

        return Math.max(Math.max(root.val, root.val+left), root.val+right);
    }
}