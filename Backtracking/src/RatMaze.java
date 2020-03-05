public class RatMaze {
    private final int N; // dimension of square
    private final int [] [] MAZE;
    private int [] [] solution;
    public RatMaze (int[][] maze) {
        MAZE=maze;
        N=maze.length;
    }
    public void solveMaze() {

    }
}
class Tester {
    public static void main(String[] args) {
        int [] [] maze = {
                {1,0,0,1},
                {1,0,1,0},
                {1,1,1,1},
                {0,1,0,1}
        };
        RatMaze rm = new RatMaze(maze);
        rm.solveMaze();
    }
}