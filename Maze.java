public class Maze {
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height, int[][] maze) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        initialize(maze);
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void initialize(int[][] maze) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(maze[x][y]);
            }
        }
    }

    public void createWall(int x, int y) {
        cells[y][x].setState(Cell.State.WALL);
    }

    public void createExit(int x, int y) {
        cells[y][x].setState(Cell.State.EXIT);
    }

    public void print() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                System.out.print(cells[x][y].getState() + " ");
            }
            System.out.println();
        }
    }
}
