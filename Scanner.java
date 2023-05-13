public class Scanner {
    private Maze maze; // 스캔 대상이 되는 미로
    private Mouse mouse; // 스캔을 실행하는 쥐
    private int scanCost = 3; // 스캔 비용

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    Point startpoint; //23.05.13
    Point endpoint; //23.05.13


    // public Scanner(Maze maze, Mouse mouse) {
    //     this.maze = maze;
    //     this.mouse = mouse;
    // }

    public Scanner(Mouse mouse) {
        this.maze = maze; // 이러면 private으로 선언한 게 들어가나..?
        this.mouse = mouse;
    }

    // 스캔 기능 구현
    public void scan(Point scanpoint) { // //23.05.13 어디서 인자 scanpoint를 전달받지?
        // 스캔할 영역의 좌표를 계산한다.
        // int x = maze.getWidth()-2; // 일단 이렇게 고정해놓음
        // int y = maze.getHeight()-2; // 중점 선택하는 알고리즘 만들면 x, y 전달받아서 할 예정
        int x = scanpoint.x; //23.05.13
        int y = scanpoint.y; //23.05.13

        startX = x - 2;
        startY = y - 2;
        endX = x + 2;
        endY = y + 2;

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
        mouse.decreaseMana();
        mouse.increaseScanCount();

        startpoint = new Point(startX, startY); //23.05.13
        endpoint = new Point(endX, endY); //23.05.13

    }

    // public int getStartX () { return startX; } // 이렇게 따로 반환하는 걸로 바꿨는데
    // public int getStartY () { return startY; } // 한꺼번에 return하는 건 잘 모르겠음
    // public int getEndX () { return endX; }
    // public int getEndY () { return endY; } 

    public Point getStartPoint() {return startpoint;} //23.05.13
    public Point getEndPoint() {return endpoint;} //23.05.13

//    방법1. 객체를 이용하여 반환
//    class MultipleValues {
//        int value1;
//        String value2;
//        // 생성자, getter/setter 등
//    }
//
//    public MultipleValues getMultipleValues() {
//        MultipleValues result = new MultipleValues();
//        result.setValue1(10);
//        result.setValue2("hello");
//        return result;
//    }
//
//    방법2. 배열 이용하ㅏ여 반환
//    방법3. 리스트 같은 컬렌션에 담아 반환 -> 이 두개는 할 수 있을 것 같긴 한데 굳이..? 비효율적이라고 뭐라고 하려나

}
