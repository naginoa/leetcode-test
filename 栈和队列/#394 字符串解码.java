class Solution {
    public static String decodeString(String s) {
        Deque<Integer> dequeI = new LinkedList<>();
        Deque<String> dequeS = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer result = new StringBuffer();
        int mutiNum = 0;
        for (Character c:s.toCharArray()){
            if (c>='0' && c<='9') mutiNum = mutiNum * 10 + c-'0';
            else if (c>='a' && c<='z') stringBuffer.append(c);
            else if (c=='['){
                dequeI.push(mutiNum);
                mutiNum = 0;
                dequeS.push(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            }
            else if (c==']'){
                int len = dequeI.pop();
                for (int i = 0; i < len; i++) {
                    result.append(stringBuffer);
                }
                stringBuffer = new StringBuffer(dequeS.pop() + result);
//                System.out.println(stringBuffer);
                result.delete(0, result.length());
            }
        }
        return stringBuffer.toString();
    }
}