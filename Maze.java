public class Maze {
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
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

    public void initialize() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(x, y, CellState.EMPTY);
            }
        }
    }

    public void createWall(int x, int y) {
        cells[y][x].setState(CellState.WALL);
    }

    public void createExit(int x, int y) {
        cells[y][x].setState(CellState.EXIT);
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(cells[y][x].getState() + " ");
            }
            System.out.println();
        }
    }
}
