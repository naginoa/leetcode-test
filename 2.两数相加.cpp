#include <iostream>

using namespace std;
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        //存放最终结果, 指针方便操作
        ListNode result(0), *p = &result;
        //进位符，要考虑当9+3=12的情况等。
        int carry = 0;
        //carry放在条件里是为了表示当最后一位如果也有进位的情况下
        while(l1 || l2 || carry){
            //该位置上目前加的数
            int temp = 0;
            //if条件是为了考虑到两个位数不相等的情况等 如果没有这个数那就不加了 逻辑没毛病
            if(l1 != nullptr) temp += l1->val;
            if(l2 != nullptr) temp += l2->val;
            //要加上这个进位符
            temp += carry;
            //给下一次的进位符赋值
            carry = temp / 10;
            temp = temp % 10;
            //ListNode *pt = l1 ? l1 : l2;   加这句效率更高不知为啥
            //建立一个新的节点.
            ListNode *pt = new ListNode(0);
            //每次pt生成一个新的节点,然后p去把它本身的null赋值给pt,这样pt就存在了p里,下次pt还是新的
            pt->val = temp;

            p->next = pt;
            p = p->next;

            //if条件也是如何判断不进行下一次传递了呢,就是本次的l1，l2为空时
            if(l1!= nullptr) l1 = l1->next;
            if(l2!= nullptr) l2 = l2->next;
        }
        return result.next;
    }
};
int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
