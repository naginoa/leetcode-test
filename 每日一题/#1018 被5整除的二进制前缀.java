class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new LinkedList<>();
        if(A.length==0)return res;
        int num = 0;
        for(int i=0;i<A.length;i++){
            num = num * 2 + A[i];
            //需要每次除10，保留个位即可
            num %= 10;
            if(num%5==0)res.add(true);
            else res.add(false);
        }
        return res;
    }
}