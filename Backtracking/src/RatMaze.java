public class RatMaze {
    private final int N; // dimension of square
    private final int[][] MAZE;

    private int[][] solution;

    public RatMaze (int[][] maze) {
        MAZE=maze;
        N=maze.length;
        solution = new int[N][N];
    }
    public void solveMaze() {
        if (solveMazeHelper(0,0))
            printSolution();
        else
            System.out.println("Whoops.");
    }
    public boolean solveMazeHelper(int x, int y) {
        //if we found a solution, return true
        if (x==N-1 && y==N-1) {
            solution[x][y] = 1;
            return true;
        }
    }
    public boolean isValid(int x, int y) {
        //return false if outside of matrix bounds or square is dark.
        return (x>=0 && x<N && y>=0 && y<N && MAZE[x][y]!=0);
    }
    public void printSolution() {
        for(int i=0; i<solution.length; ++i) {
            for (int j = 0; j < solution[0].length; j++)
                System.out.print(solution[i][j] + "\t");
            System.out.println();
        }
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