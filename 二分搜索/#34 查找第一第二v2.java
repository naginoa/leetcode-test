//和查找一个数的区别就是一个数的时候如果找到那么直接返回函数结果，而该方法是要满足low<=high才会结束
class Solution {
    public int[] searchRange(int[] nums, int target){
        int[] a = {0,0};
        a[0] = bin(nums, target, true);
        a[1] = bin(nums, target, false);
        return a;
    }
    public int bin(int[] nums, int target, boolean isLeft){
        int low=0,high=nums.length-1,mid=(low+high)/2,ans=-1;
        while(low<=high){
            if(nums[mid]<target)low=mid+1;
            if(nums[mid]>target)high=mid-1;
            if(nums[mid]==target){
	//进入该条件后，之后的数都是等于的情况。为真时，找到最左边的坐标。为假时，mid继续+1跳出循环。
                ans=mid;
                if(isLeft){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            mid=(low+high)/2;
        }
        return ans;
    }
}