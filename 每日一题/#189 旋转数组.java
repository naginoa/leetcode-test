class Solution {
    public void rotate(int[] nums, int k) {
        if(k%nums.length==0)return;
        //三从旋转数组
        reverse(nums,0,nums.length-1);
        reverse(nums,0,(k-1)%nums.length);
        reverse(nums,k%nums.length,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        int tmp = 0;
        while(start<=end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}