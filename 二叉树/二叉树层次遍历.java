package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CengTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
        ArrayList<TreeNode> line = new ArrayList<>();
        line.add(a);
        res.add(line);
        cengOrderVer(a);
    }

    //自己开始写的有很大问题
    /*
    public static ArrayList<ArrayList<TreeNode>> cengOrder(TreeNode root, ArrayList<ArrayList<TreeNode>> res) {
        if (root == null) return new ArrayList<ArrayList<TreeNode>>();
        for (int i = 0; i < res.size(); i++) {
            ArrayList<TreeNode> t = new ArrayList<>();
            for (TreeNode it2 : res.get(i)) {
                if (it2 != null) {
                    if (it2.left != null) {
                        t.add(it2.left);
                    }
                    if (it2.right != null) {
                        t.add(it2.right);
                    }
                }
            }
            res.add(t);
        }
        return res;
    }*/

    //看了一眼答案
    public static void cengOrderVer(TreeNode root){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<String> at = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode t = queue.poll();
                at.add(String.valueOf(t.val));
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }
            }
            res.add(at);
        }
        for (ArrayList<String> it:res){
            for (String it2:it){
                System.out.print(it2+" ");
            }
            System.out.println();
        }
    }
}
