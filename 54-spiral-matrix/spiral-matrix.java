// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//      List<Integer> result=new ArrayList<>();
//         int n=matrix.length;
//         int m=matrix[0].length;
//         int startRow=0;
//         int endRow=n-1;
//         int startCol=0;
//         int endCol=m-1;
//         while(startRow<=endRow && startCol<=endCol){
//             //first row
//             for (int j=startCol;j<=endCol;j++){
//                 result.add(matrix[startRow][j]);
//             }
//             startRow+=1;
//             //end column
//             for (int i=startRow;i<=endRow;i++){
//                 result.add(matrix[i][endCol]);
//             }
//             endCol-=1;
//             //checking overtake
//             if(startRow<=endRow){
//                 //last row
//                 for (int j=endCol;j>=startCol;j--){
//                     result.add(matrix[endRow][j]);
//                 }
//                 endRow-=1;
//             }

//             if(startCol<=endCol){
//                 //first col
//                 for (int i=endRow;i>=startRow;i--){
//                     result.add(matrix[i][startCol]);
//                 }
//                 startCol+=1;
//             }

//         }
//         return result;   
//     }
// }





// *************************************2ND TYPE SHRADDHA 

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int srow = 0, scol = 0, erow = m - 1, ecol = n - 1;

        List<Integer> ans = new ArrayList<>();

        while (srow <= erow && scol <= ecol) {
            // Top row
            for (int j = scol; j <= ecol; j++) {
                ans.add(mat[srow][j]);
            }

            // Right column
            for (int i = srow + 1; i <= erow; i++) {
                ans.add(mat[i][ecol]);
            }

            // Bottom row
            for (int j = ecol - 1; j >= scol; j--) {
                if (srow == erow) break;
                ans.add(mat[erow][j]);
            }

            // Left column
            for (int i = erow - 1; i > srow; i--) {
                if (scol == ecol) break;
                ans.add(mat[i][scol]);
            }

            srow++;
            erow--;
            scol++;
            ecol--;
        }

        return ans;
    }
}
