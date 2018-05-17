class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] usedRows;
        int[] usedCols;
        
        for (int i=0; i < board.length; i++) {
            usedRows = new int[10];
            usedCols = new int[10];
            
            for (int j=0; j < board.length; j++) {
                usedRows[board[i][j] == '.' ? 0 : board[i][j] - '0']++;
                usedCols[board[j][i] == '.' ? 0 : board[j][i] - '0']++;
            }
            
            if (hasDups(usedRows) || hasDups(usedCols)) {
                return false;
            }
        }
        
        for (int i=0; i < 9; i+=3) {
            for (int j=0; j < 9; j+=3) {
                int[] used = new int[10];
                
                int fromii = i;
                int toii = i + 3;
                int fromjj = j;
                int tojj = j + 3;
                
                for (int ii=fromii; ii < toii; ii++) {
                    for (int jj=fromjj; jj < tojj; jj++) {
                        used[board[ii][jj] == '.' ? 0 : board[ii][jj] - '0']++;
                    }
                }
                
                if (hasDups(used)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasDups(int[] used) {
        for (int i=1; i < used.length; i++) {
            if (used[i] > 1) {
                return true;
            }
        }
        
        return false;
    }
}