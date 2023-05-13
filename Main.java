import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    /*int[][] m = ReadMaze.read("C:\\Users\\thslr\\matrix\\Maze1.txt");
    Maze maze = new Maze(m.length, m[0].length, m);
    maze.print();*/

    int[][] grid = ReadMaze.read("C:\\Users\\thslr\\matrix\\Maze1.txt");

    AStarAlgorithm aStar = new AStarAlgorithm(grid, 0, 1, 27, 45);
    int[][] path = aStar.run();

    if (path != null) {
      for (int i = 0; i < path.length; i++) {
        System.out.println("(" + path[i][0] + ", " + path[i][1] + ")");
      }
    } else {
      System.out.println("No path found.");
    }
  }
}
