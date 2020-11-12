// Time Complexity: O(m*n), we possibly visit all nodes 
// Space Complexity: O(m*n), call stack can possibly go as deep as the number of nodes (if every pixel has the same color as the starting pixel)

class Solution {
    int color; 
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge 
        if(image == null | image.length == 0) return image;
        color = image[sr][sc];
        if(color == newColor) return image;
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int newColor) {
        //base case
        if(i < 0 | i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) return;
        
        //logic
        int [][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        image[i][j] = newColor;
        for(int [] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(image, r, c, newColor);
        }
    }
}
