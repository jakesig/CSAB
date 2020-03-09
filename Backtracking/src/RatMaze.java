import java.util.Stack;
import javafx.util.Pair;
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
        //check to see if (x,y) is a valid place in the maze
        if (!isValid(x,y))
            return false;
        //mark current square as part of the solution
        solution[x][y] = 1;
        //check to see if moving right will solve the maze.
        if (solveMazeHelper(x+1, y))
            return true;
        //check to see if moving down will solve the maze.
        if (solveMazeHelper(x, y+1))
            return true;
        //if we reach here, we were not successful
        //unmark current square as part of the solution
        solution[x][y] = 0;
        //return false
        return false;
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
class RatMazeStack{
    private final int N; // dimension of square
    private final int[][] MAZE;
    private boolean[][] visited;
    private int[][] solution;
    private Stack<Pair<Integer, Integer>> stack;

    public RatMazeStack (int[][] maze) {
        MAZE=maze;
        N=maze.length;
        solution = new int[N][N];
        visited = new boolean[N][N];
        stack = new Stack<Pair<Integer, Integer>>();
    }
    public void solveMaze() {
        stack.push(new Pair<Integer, Integer>(0,0));
        if (solveMazeHelper())
            printSolution();
        else
            System.out.println("Whoops.");
    }
    public boolean solveMazeHelper() {
        Pair<Integer, Integer> current = stack.peek();
        int x = current.getKey();
        int y = current.getValue();
        if (x==N-1 && y==N-1) {
            return true;
        }
        if (!isValid(current))
            return false;
        return false;
    }
    public boolean isValid(Pair<Integer, Integer> pair) {
        Integer x = pair.getKey();
        Integer y = pair.getValue();
        //return false if outside of matrix bounds or square is dark.
        return (x>=0 && x<N && y>=0 && y<N && MAZE[x][y]!=0 && !visited[x][y]);
    }
    public void printSolution() {
        System.out.println("There are "+ stack.size() + " steps to the solution: ");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
class Tester {
    public static void main(String[] args) {
        int [] [] maze = {
                {1,0,0,1},
                {1,1,1,1},
                {0,0,0,0},
                {1,1,1,1}
        };
        RatMaze rm = new RatMaze(maze);
        rm.solveMaze();
        RatMazeStack rms = new RatMazeStack(maze);
    }
}