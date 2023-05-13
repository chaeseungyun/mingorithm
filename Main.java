import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] readMaze = ReadMaze.read("C:\\2019136139 허준기 코드\\Mingorithm term Project\\mingorithm\\test.txt");
        Maze maze = new Maze(readMaze.length, readMaze[0].length, readMaze);
        //GUI gui = new GUI(); // GUI 객체 생성
        //maze.print();
        DrawMaze.drawMaze(maze);
        DrawMaze.drawMazeToText(maze);

        GUI gui = new GUI(maze);
        gui.repaint();
    }
}
