class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==nullptr) return true;
        
        return Helper(root->left, root->right);
    }
    bool Helper(TreeNode* l, TreeNode* r){
        if(l == nullptr && r == nullptr) return true;
        if(l == nullptr || r == nullptr) return false;
        if(l->val != r->val) return false;
        return (Helper(l->left, r->right) && Helper(l->right, r->left));
    }
};