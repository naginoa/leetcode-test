class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowest(root,p,q);
        return res;
    }

    public void lowest(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return;
        if(isFather(p,root)&&root!=p)return;
        if(isFather(q,root)&&root!=q)return;
        if(isFather(root, p)&&isFather(root, q)){
            res=root;
        }
        lowest(root.left, p, q);
        lowest(root.right, p, q);

        return;
    }

    public boolean isFather(TreeNode f, TreeNode son){
        if(f==null)return false;
        if(f.left==son||f.right==son||f==son){
            return true;
        }

        boolean left = isFather(f.left, son);
        boolean right = isFather(f.right, son);

        return left|right;
    }
}