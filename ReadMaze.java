import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadMaze {
  public static int[][] read(String path) throws IOException {
    Scanner scanner = new Scanner(new File(path));
    int row = 0;
    int column;
    String s = "";
    while(scanner.hasNextLine()) {
      s = scanner.nextLine();
      row += 1;
    }
    String[] split = s.split(" ");
    column = split.length;

    scanner.close();

    Scanner in = new Scanner(new File(path));
    int[][] maze = new int[row][column];
    int i=0;
    int j=0;
    int c;

    while(in.hasNextInt())
    {
      c = in.nextInt();
      if (j == column) {
        i += 1;
        j = 0;
      }
      if (j!=1 && i!=0) {
        if ((i==0 || i==row-1 || j==0 || j==column-1) && c==0) {
          maze[i][j] = 2;
        } else maze[i][j] = c;
      } else maze[i][j] = c;
      j += 1;
    }
    return maze;
  }
}
