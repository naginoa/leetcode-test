#include <iostream>
#include <vector>
using namespace std;
class TreeNode{
public:
    int val;
    TreeNode* left;
    TreeNode* right;
public:
    TreeNode(int val):val(val), left(nullptr), right(nullptr){};
};
void dfs(TreeNode* root, int level, vector <vector <int>> &res){
    if (root==nullptr) return ;
    // ������ȵĲ�α��� ��άvector �õݹ��������ݹ�һ�����ǽ�����һ�㣬������level+1
    if (res.size() == level) res.resize(level+1);
    res[level].push_back(root->val);
    dfs(root->left, level+1, res);
    dfs(root->right, level+1, res);
}
int main()
{
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    root->left->left->left = new TreeNode(7);
    vector <vector <int>> res;
    dfs(root, 0, res);
    for(vector <vector <int>> :: iterator it=res.begin();it!=res.end();it++){
        for(int j=0;j<(*it).size();j++){
            cout<<(*it)[j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
