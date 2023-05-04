public class Scanner {
    private Maze maze; // 스캔 대상이 되는 미로
    private Mouse mouse; // 스캔을 실행하는 쥐
    private int scanCost = 3; // 스캔 비용

    public Scanner(Maze maze, Mouse mouse) {
        this.maze = maze;
        this.mouse = mouse;
    }

    // 스캔 기능 구현
    public void scan(int x, int y) {
        // 스캔할 영역의 좌표를 계산한다.
        int startX = x - 2;
        int startY = y - 2;
        int endX = x + 2;
        int endY = y + 2;

        // 미로 상의 영역을 벗어나는지 체크한다.
        if (startX < 0) startX = 0;
        if (startY < 0) startY = 0;
        if (endX >= maze.getWidth()) endX = maze.getWidth() - 1;
        if (endY >= maze.getHeight()) endY = maze.getHeight() - 1;

        // 스캔할 영역의 상태를 출력한다.
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                Cell cell = maze.getCell(j, i);
                System.out.print(cell.getState() + " ");
            }
            System.out.println();
        }

        // 스캔 비용을 차감하고, 스캔 횟수를 증가시킨다.
        mouse.decreaseMana(scanCost);
        mouse.increaseScanCount();
    }
}
