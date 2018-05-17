class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        
        for (int i=0; i < matrix.length / 2; i++) {
            swp(matrix, i, matrix.length - 1 - i);
        }
    }
    
    private void swp(int[][] matrix, int fromi, int toi) {
        for (int i=fromi; i < toi; i++) {
            int temp = matrix[fromi][i];
            matrix[fromi][i] = matrix[toi - i + fromi][fromi];
            matrix[toi - i + fromi][fromi] = matrix[toi][toi - i + fromi];
            matrix[toi][toi - i + fromi] = matrix[i][toi];
            matrix[i][toi] = temp;
        }
    }
}