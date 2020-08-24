#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;
class TreeNode{
public:
	int val;							//节点中的数据
	TreeNode *left;				//该节点的左节点
	TreeNode *right;				//该节点的右节点
public:
	TreeNode(int val):val(val),left(NULL),right(NULL){}
};
vector <int> preorderTraversal(TreeNode* root){
    //存放节点序列
    vector <int> res;
    //正好和前序后序所需要的数据结构要求一样
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //节点T是自己编程时也会想到要用的
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            if(t->right!=nullptr) call.push(t->right);
            if(t->left!=nullptr) call.push(t->left);
            call.push(t);
            //空指针表示这个指针已经用过了，下次会在else里赋值
            call.push(nullptr);
        }
        else{
            res.push_back(call.top()->val);
            call.pop();
        }
    }
    return res;
}
vector <int> inorderTraversal(TreeNode* root){
    //存放节点序列
    vector <int> res;
    //正好和前序后序所需要的数据结构要求一样
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //节点T是自己编程时也会想到要用的
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            if(t->right!=nullptr) call.push(t->right);
            call.push(t);
            call.push(nullptr);
            if(t->left!=nullptr) call.push(t->left);
            //空指针表示这个指针已经用过了，下次会在else里赋值
        }
        else{
            res.push_back(call.top()->val);
            call.pop();
        }
    }
    return res;
}
vector <int> postorderTraversal(TreeNode* root){
    //存放节点序列
    vector <int> res;
    //正好和前序后序所需要的数据结构要求一样
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //节点T是自己编程时也会想到要用的
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            call.push(t);
            call.push(nullptr);
            if(t->right!=nullptr) call.push(t->right);
            if(t->left!=nullptr) call.push(t->left);
            //空指针表示这个指针已经用过了，下次会在else里赋值
        }
        else{
            res.push_back(call.top()->val);
            call.pop();
        }
    }
    return res;
}
int main()
{
    TreeNode* root = new TreeNode(1);
	root->left = new TreeNode(2);
	root->right = new TreeNode(3);
	root->left->left = new TreeNode(4);
	root->left->right = new TreeNode(5);
	vector <int> res = postorderTraversal(root);
    for(int i=0;i<res.size();i++){
        cout<<res[i]<<endl;
    }
    return 0;
}
