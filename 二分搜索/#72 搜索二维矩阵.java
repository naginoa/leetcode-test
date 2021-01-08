class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int chang = matrix.length, kuan = matrix[0].length;
        int low=0,high=chang*kuan-1,mid=(low+high)/2;
        while(low<=high){
            if(target<matrix[mid/kuan][mid%kuan])high=mid-1;
            if(target>matrix[mid/kuan][mid%kuan])low=mid+1;
            if(target==matrix[mid/kuan][mid%kuan])return true;
            mid=(low+high)/2;
        }
        return false;
    }
}