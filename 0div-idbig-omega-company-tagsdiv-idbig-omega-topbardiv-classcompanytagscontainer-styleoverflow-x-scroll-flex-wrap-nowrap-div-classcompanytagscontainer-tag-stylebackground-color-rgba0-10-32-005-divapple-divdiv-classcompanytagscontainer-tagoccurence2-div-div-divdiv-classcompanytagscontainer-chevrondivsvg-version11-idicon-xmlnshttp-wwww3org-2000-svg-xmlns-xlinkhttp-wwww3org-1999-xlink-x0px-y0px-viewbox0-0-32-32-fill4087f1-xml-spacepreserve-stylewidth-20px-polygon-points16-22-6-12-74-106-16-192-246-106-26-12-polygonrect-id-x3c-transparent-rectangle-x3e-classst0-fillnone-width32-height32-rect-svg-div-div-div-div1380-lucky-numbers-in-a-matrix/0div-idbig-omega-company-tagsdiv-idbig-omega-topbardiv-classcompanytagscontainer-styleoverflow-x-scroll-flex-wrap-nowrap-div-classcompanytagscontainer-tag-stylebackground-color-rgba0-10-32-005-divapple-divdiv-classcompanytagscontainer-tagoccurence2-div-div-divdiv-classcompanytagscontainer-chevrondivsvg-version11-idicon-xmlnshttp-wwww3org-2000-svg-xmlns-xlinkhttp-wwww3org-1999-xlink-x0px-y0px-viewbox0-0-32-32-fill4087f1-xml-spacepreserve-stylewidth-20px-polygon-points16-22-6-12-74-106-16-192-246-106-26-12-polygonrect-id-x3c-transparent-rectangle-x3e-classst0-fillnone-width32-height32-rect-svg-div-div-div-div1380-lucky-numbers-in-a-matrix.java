import java.util.*;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Initialize arrays to store the minimum of each row and the maximum of each column
        int[] rowsMin = new int[n];
        Arrays.fill(rowsMin, Integer.MAX_VALUE);
        int[] colsMax = new int[m];
        
        // Calculate minimum values for each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowsMin[i] = Math.min(rowsMin[i], matrix[i][j]);
            }
        }
        
        // Calculate maximum values for each column
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colsMax[j] = Math.max(colsMax[j], matrix[i][j]);
            }
        }
        
        // Find all lucky numbers
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == rowsMin[i] && matrix[i][j] == colsMax[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        
        return luckyNumbers;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        System.out.println(sol.luckyNumbers(matrix)); // Output: [15]
    }
}