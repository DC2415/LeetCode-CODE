// class pair{
//     int row;
//     int col;
//     int color;
//     public pair(int r, int c,int co){
//         row=r;
//         col=c;
//         color=col;
//     }
// }
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int n=image.length;
//         int m=image[0].length;
//         if (image[sr][sc] == color) {
//             return image;
//         }
//         Queue<pair> qu=new LinkedList<>();
        
//         qu.add(new pair(sr,sc,image[sr][sc]));
//         int[] drow={1,0,-1,0};
//         int[] dcol={0,1,0,-1};
//         while(!qu.isEmpty()){
//             pair a=qu.poll();
//            int r=a.row;
//            int c=a.col;
//            int co=a.color;
//             image[r][c]=color;
//             for(int i=0;i<4;i++){
//               int  nr=r+drow[i];
//                 int nc=c+dcol[i];
//                 if(nr>=0 && nr<n && nc>=0 && nc <m && image[nr][nc]==co){
//                     qu.add(new pair(nr,nc,co));
//                 }
//             }
//         }
//         return image;

//     }
// }
class Pair {
    int row;
    int col;
    int color;

    public Pair(int r, int c, int co) {
        row = r;
        col = c;
        color = co;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];

        // If the original color is the same as the new color, no need to proceed
        if (originalColor == newColor) {
            return image;
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(sr, sc, originalColor));
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!qu.isEmpty()) {
            Pair a = qu.poll();
            int r = a.row;
            int c = a.col;
            int co = a.color;

            // Fill the current cell with the new color
            image[r][c] = newColor;

            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                // Add to queue if the cell is within bounds and has the original color
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == co) {
                    qu.add(new Pair(nr, nc, co));
                }
            }
        }
        return image;
    }
}
