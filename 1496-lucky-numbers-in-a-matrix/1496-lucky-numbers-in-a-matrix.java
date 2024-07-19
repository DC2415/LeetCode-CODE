class Solution {
    public List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) { 
            for (int j = 0; j < mat[i].length; j++) { 
                if (mini(mat, i, mat[i][j]) && maxi(mat, j, mat[i][j])) {
                    ans.add(mat[i][j]);
                }
            }
        }
        return ans;
    }

    public boolean mini(int[][] mat, int row, int ele) {
        for (int i = 0; i < mat[row].length; i++) { 
            if (ele > mat[row][i]) {
                return false;
            }
        }
        return true;
    }

    public boolean maxi(int[][] mat, int col, int ele) {
        for (int i = 0; i < mat.length; i++) {
            if (ele < mat[i][col]) {
                return false;
            }
        }
        return true;
    }
}