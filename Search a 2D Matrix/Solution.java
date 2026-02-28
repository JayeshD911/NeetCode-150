class Solution {
    public boolean search(int[] nums, int target) {
        int N = nums.length;
        int l = 0;
        int r = N-1;
        int mid = 0;

        while(l <= r){
            mid = l + (r - l) / 2;
            if (nums [mid] == target ) return true;
            else if (nums [mid] > target ) r = mid - 1;
            else  l = mid + 1;
        }

        return false;

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        int mid = 0;

        while(low <= high){
            mid = low + (high - low ) /2;

            if (target <= matrix[mid][cols -1]  && target >= matrix[mid][0] ){
                return search(matrix[mid] , target) ;
            }
            else if (target <= matrix[mid][cols -1]  && target <= matrix[mid][0]  ){
                high = mid -1;
            }
            else low = mid +1;
        }
        return false;
    }
}
