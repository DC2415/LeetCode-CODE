import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] direc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        List<int[]> res = new ArrayList<>();
        int stp = 0;
        int dir = 0;
        
        res.add(new int[]{rStart, cStart});
        
        while (res.size() < rows * cols) {
            if (dir == 0 || dir == 2) {
                stp++;
            }
            for (int c = 0; c < stp; c++) {
                rStart += direc[dir][0];
                cStart += direc[dir][1];
                
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res.add(new int[]{rStart, cStart});
                }
            }
            dir = (dir + 1) % 4;
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
