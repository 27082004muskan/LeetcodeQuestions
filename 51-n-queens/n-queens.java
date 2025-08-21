

class Solution {
    void find(int row , int n , List<List<String>> ans , char[][] Board, 
              boolean[] column, boolean[] leftDiag, boolean[] rightDiag){
        // Base condition
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(Board[i]));
            }
            ans.add(temp);
            return;
        }

        // leftDiagonal index = n-1 + col - row
        // rightDiagonal index = row + col

        // 1st: board is empty so we can place queen in any position
        for(int j = 0; j < n; j++){
            if(!column[j] && !leftDiag[n-1+j-row] && !rightDiag[row+j]){
                column[j] = true;
                leftDiag[n-1+j-row] = true;
                rightDiag[row+j] = true;
                Board[row][j] = 'Q';

                find(row+1, n , ans , Board , column , leftDiag , rightDiag);

                // backtrack
                column[j] = false;
                leftDiag[n-1+j-row] = false;
                rightDiag[row+j] = false;
                Board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] Board = new char[n][n];

        // fill board with (.)
        for(int i = 0; i < n; i++){
            Arrays.fill(Board[i], '.');
        }

        // for no 2 queens in a same col
        boolean[] column = new boolean[n];
        boolean[] leftDiag = new boolean[2*n - 1];
        boolean[] rightDiag = new boolean[2*n - 1];

        // fxn call ... 0=row , n=size , ans = jisme store hoga , coln=jismie hai 
        find(0 , n , ans , Board , column , leftDiag , rightDiag);

        return ans ;
    }
}
