class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i=0;i<matrix.length;i++){
        //     for(int j =0;j<matrix[i].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
                
        //         }
        //     }
        // }
        // return false;
        int n = matrix.length;
        if(n==0) return false;
        int m = matrix[0].length;
        if(m==0) return false;
        
        int start =0 , end = n*m-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            int row_index = mid/m ;
            int col_index = mid%m;
            
            if(matrix[row_index][col_index]==target)
            return true ;
            else if (matrix[row_index][col_index]<target)
            start=mid+1;
            else
            end=mid-1;
            
        }
        return false;
    }

}