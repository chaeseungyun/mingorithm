import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadMaze {
    public static int[][] read(String path) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        int row = 0;
        int column;
        String s = "";
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            row += 1;
        }
        String[] split = s.split(" ");
        column = split.length;

        scanner.close();

        Scanner in = new Scanner(new File(path));
        int[][] maze = new int[row][column];
        int i = 0;
        int j = 0;
        while (in.hasNextInt()) {
            if (j == column) {
                i += 1;
                j = 0;
            }
            maze[i][j] = in.nextInt();
            j += 1;
        }
        return maze;
    }
}
