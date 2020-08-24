#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    int strStr(string haystack, string needle) {
        //要注意看题，尺寸是0时返回0
        if(needle.size()==0) return 0;
        if(needle.size()>haystack.size()) return -1;
        int flag = 0;
        for(int i=0;i<=(haystack.length()-needle.length());i++){
            for(int j=0;j<needle.length();j++){
                if(haystack[i+j] == needle[j]){
                    flag += 1;
                    cout<<flag<<" ";
                    if(flag == needle.size()) return i;
                }
                else flag = 0;
                cout<<flag<<endl;
            }
            //这里要注意加上，不然有的会错
            flag = 0;
        }
        return -1;
    };
};
class Solution2 {
public:
    int strStr(string haystack, string needle) {
        if(needle.size()==0) return 0;
        if(needle.size()>haystack.size()) return -1;
        for(int i=0;i<=(haystack.length()-needle.length());i++){
            cout<<i<<" "<<needle.size()<<endl;
            cout<<haystack.substr(i,needle.size())<<endl;
            cout<< needle.compare(haystack.substr(i,needle.size()))<<endl;
            if( needle.compare(haystack.substr(i,needle.size())) == 0){
                return i;
            }
        }
        return -1;
    };
};
int main()
{
    Solution s;
    Solution2 s2;
    cout << s2.strStr("hello", "ll") << endl;
    string c = "hello";
    return 0;
}
