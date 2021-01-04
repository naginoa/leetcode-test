class Solution {
    public int singleNumber(int[] nums) {
        int a=0, b=0;
        for(Integer i: nums){
            a = (a^i)&~b;
            b = (b^i)&~a;
        }
        return a;
    }
}