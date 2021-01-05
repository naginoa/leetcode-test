class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1, mid=(high+low)/2;
        while(low<=high){
            if(target>nums[mid])low = mid+1;
            if(target<nums[mid])high = mid-1;
            if(target==nums[mid])return mid;
            mid=(high+low)/2;
        }
        return -1;
    }
}