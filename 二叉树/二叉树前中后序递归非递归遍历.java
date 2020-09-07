package tree;

import java.util.*;

public class OrderTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        //preOrderTree(a);
        //inOrderTree(a);
        postOrderTree(a);
        //preOrder(a);
        //inOrder(a);
        postOrder(a);
    }

    //recursion
    public static void preOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        if (root.left != null) preOrderTree(root.left);
        if (root.right != null) preOrderTree(root.right);
    }

    public static void inOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) inOrderTree(root.left);
        System.out.println(root.val);
        if (root.right != null) inOrderTree(root.right);
    }

    public static void postOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) postOrderTree(root.left);
        if (root.right != null) postOrderTree(root.right);
        System.out.println(root.val);
    }

    //non-recursion
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.removeFirst();
            res.add(t);
            if (t.right != null) {
                stack.addFirst(t.right);
            }
            if (t.left != null) {
                stack.addFirst(t.left);
            }
        }
        for (TreeNode it : res) {
            System.out.println(it.val);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }
            node = stack.removeLast();
            res.add(node);
            node = node.right;
            for (TreeNode it : res) {
                System.out.println(it.val);
            }
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.removeFirst();
            res.addFirst(t);
            if (t.right != null) {
                stack.addLast(t.right);
            }
            if (t.left != null) {
                stack.addLast(t.left);
            }
        }
        for (TreeNode it : res) {
            System.out.println(it.val);
        }
    }

}
