class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        if (root==null)return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode t = deque.removeFirst();
                tmp.add(t.val);
                if (t.left!=null)deque.addLast(t.left);
                if (t.right!=null)deque.addLast(t.right);
            }
            result.add(tmp);
        }
        return result;
    }
}