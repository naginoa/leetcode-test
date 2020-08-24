#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;
class TreeNode{
public:
	int val;							//�ڵ��е�����
	TreeNode *left;				//�ýڵ����ڵ�
	TreeNode *right;				//�ýڵ���ҽڵ�
public:
	TreeNode(int val):val(val),left(NULL),right(NULL){}
};
vector <int> preorderTraversal(TreeNode* root){
    //��Žڵ�����
    vector <int> res;
    //���ú�ǰ���������Ҫ�����ݽṹҪ��һ��
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //�ڵ�T���Լ����ʱҲ���뵽Ҫ�õ�
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            if(t->right!=nullptr) call.push(t->right);
            if(t->left!=nullptr) call.push(t->left);
            call.push(t);
            //��ָ���ʾ���ָ���Ѿ��ù��ˣ��´λ���else�︳ֵ
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
    //��Žڵ�����
    vector <int> res;
    //���ú�ǰ���������Ҫ�����ݽṹҪ��һ��
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //�ڵ�T���Լ����ʱҲ���뵽Ҫ�õ�
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            if(t->right!=nullptr) call.push(t->right);
            call.push(t);
            call.push(nullptr);
            if(t->left!=nullptr) call.push(t->left);
            //��ָ���ʾ���ָ���Ѿ��ù��ˣ��´λ���else�︳ֵ
        }
        else{
            res.push_back(call.top()->val);
            call.pop();
        }
    }
    return res;
}
vector <int> postorderTraversal(TreeNode* root){
    //��Žڵ�����
    vector <int> res;
    //���ú�ǰ���������Ҫ�����ݽṹҪ��һ��
    stack <TreeNode *> call;
    if(root!=nullptr) call.push(root);
    while(!call.empty()){
        //�ڵ�T���Լ����ʱҲ���뵽Ҫ�õ�
        TreeNode* t = call.top();
        call.pop();
        if(t!=nullptr){
            call.push(t);
            call.push(nullptr);
            if(t->right!=nullptr) call.push(t->right);
            if(t->left!=nullptr) call.push(t->left);
            //��ָ���ʾ���ָ���Ѿ��ù��ˣ��´λ���else�︳ֵ
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
