import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DrawMaze {
    public static void drawMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    System.out.print("0 ");   // □
                }

                if (maze[i][j] == 1) {
                    System.out.print("1 ");  // ■
                }


                if (maze[i][j] == 2) {
                    System.out.print("2 ");
                }

                if (maze[i][j] == 3) {
                    System.out.print("3 ");
                }
            }
            System.out.println("");
        }
    }

    public static void drawMazeToText(int[][] maze) throws IOException {
        FileWriter file = new FileWriter("C:\\2019136139 허준기 코드\\maze.txt");
        BufferedWriter bw = new BufferedWriter(file);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    bw.write("■ ");  // ■
                }

                if (maze[i][j] == 0) {
                    bw.write("□ ");   // □
                }

                if (maze[i][j] == 2) {
                    bw.write("※ ");    // 지나온길
                }

                if (maze[i][j] == 3) {
                    bw.write("X");    // 출구
                }
            }
            bw.newLine();
        }
        bw.close();
        file.close();
    }
}
