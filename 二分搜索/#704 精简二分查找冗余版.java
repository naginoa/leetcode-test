class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target)return 0;
            else return -1;
        }
        int low=0, high=nums.length-1, mid=(high+low)/2;
        while(low+1<=high){
            if(target>nums[mid])low = mid;
            if(target<nums[mid])high = mid;
            if(target==nums[mid])return mid;
            if(low+1==high){
                if(target==nums[low])return low;
                if(target==nums[high])return high;
                else break;
            }
            mid=(high+low)/2;
        }
        return -1;
    }
}