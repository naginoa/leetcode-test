class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        if (root->left == nullptr && root->right == nullptr) return 1;  //写这一行运行时间可以打败99.94%的用户，去掉变成了44%。
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};