# include <string>
class Solution {
public:
    string reverseWords(string s) {
        string b;
        vector <string> bb;
        for(int i=0;i<s.size();i++){
            //cout<<s[s.size()-i-1]<<endl;
            if(s[s.size()-i-1] == ' '){
                bb.push_back(b);
                b = "";
            }
            else {
                b = b + s[s.size()-i-1];
            };
        }
        b = b + " ";
        for(int i=0;i<bb.size();i++){
            b += bb[bb.size()-i-1];
            b += " ";
        }
        b.erase(b.end() - 1);
        return b;
    }
};