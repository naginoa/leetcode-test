class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(Integer n:nums){
            result ^= n;
        }
        return result;
    }
}