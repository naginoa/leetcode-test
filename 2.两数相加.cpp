#include <iostream>

using namespace std;
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        //������ս��, ָ�뷽�����
        ListNode result(0), *p = &result;
        //��λ����Ҫ���ǵ�9+3=12������ȡ�
        int carry = 0;
        //carry������������Ϊ�˱�ʾ�����һλ���Ҳ�н�λ�������
        while(l1 || l2 || carry){
            //��λ����Ŀǰ�ӵ���
            int temp = 0;
            //if������Ϊ�˿��ǵ�����λ������ȵ������ ���û��������ǾͲ����� �߼�ûë��
            if(l1 != nullptr) temp += l1->val;
            if(l2 != nullptr) temp += l2->val;
            //Ҫ���������λ��
            temp += carry;
            //����һ�εĽ�λ����ֵ
            carry = temp / 10;
            temp = temp % 10;
            //ListNode *pt = l1 ? l1 : l2;   �����Ч�ʸ��߲�֪Ϊɶ
            //����һ���µĽڵ�.
            ListNode *pt = new ListNode(0);
            //ÿ��pt����һ���µĽڵ�,Ȼ��pȥ���������null��ֵ��pt,����pt�ʹ�����p��,�´�pt�����µ�
            pt->val = temp;

            p->next = pt;
            p = p->next;

            //if����Ҳ������жϲ�������һ�δ�������,���Ǳ��ε�l1��l2Ϊ��ʱ
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
