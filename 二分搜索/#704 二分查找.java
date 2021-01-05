class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        if(nums.length==1){
            if(nums[0]==target)return 0;
            else return -1;
        }
        return bin(nums, target, 0, nums.length-1);
    }
    public int bin(int[] nums, int target, int start, int end){
        if(start==end-1){
            if(nums[start]==target)return start;
            else if(nums[end]==target)return end;
            else return -1;
        }
        int mid = (start+end)/2;
        if(target<nums[mid])return bin(nums, target, start, mid);
        else return bin(nums, target, mid, end);
    }
}