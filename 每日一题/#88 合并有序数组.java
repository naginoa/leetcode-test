class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int point1=0,point2=0;
        while(point1<m&&point2<n){
            if(nums1[point1] < nums2[point2])res[point1+point2]=nums1[point1++];
            else res[point1+point2]=nums2[point2++];
        }
        System.arraycopy(nums1,point1,res,point1+point2,m-point1);
        System.arraycopy(nums2,point2,res,point1+point2,n-point2);
        System.arraycopy(res,0,nums1,0,m+n);
    }
}