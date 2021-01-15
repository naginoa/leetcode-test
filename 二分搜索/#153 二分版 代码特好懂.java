class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,mid=0;
        while(low<high){
            mid=low+(high-low)/2;
            //mid可能是最小值
            if(nums[mid]<nums[high])high=mid;
            //mid不可能是最小值
            else low=mid+1;
        }
        return nums[low];
    }
}