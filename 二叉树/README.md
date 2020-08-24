# leetcode-test

## 二叉树

### 前中后序的非递归遍历

C++
    首先使用vector用作存储节点值，也就是最后输出的存储变量。
    stack 栈  正好满足前序变量的存储数据结构。
    
伪代码:

    定义连续数据结构，定义数据结构
    根节点先放入栈
    while 栈不为空时 :
        取栈顶元素
        删除栈顶元素
        
        当栈顶元素为空时：
            (前序排列)
            先把右结点放入栈中(LIFO)
            后把左节点放入栈中
            最后放入当前节点
            并且加入空指针(为的是标记该节点已经做过处理，可以在下一次循环进行处理，下一次的else中)        否则:
            (这个否则就是对上一把处理过的中间结点进行处理)
            加入到序列结构中
            然后删除该节点 
            
### 104. 二叉树的最大深度

```
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        if (root->left == nullptr && root->right == nullptr) return 1;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};
```

其中第二个判断句如果加上的话可以超过99.94%的运行时间，去掉的话运行时间会增大约四倍，
虽然代码量少了，但运算量增大，原因应该是一个需要计算空点的层数，一个不需要计算空点层数。
