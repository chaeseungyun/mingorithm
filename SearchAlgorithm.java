import java.io.IOException;


public class SearchAlgorithm {
    LinkedStack<Point> stack;
    Mouse mouse;
    Maze maze;

    SearchAlgorithm(Maze maze){
        this.stack = new LinkedStack<>();
        this.maze = maze;
        mouse = new Mouse(new Point(0,1),maze.getWidth()*maze.getHeight()*2);
    }
    SearchAlgorithm(LinkedStack<Point> stack){
        this.stack = stack;
    }

    // DFS 모드
    boolean DFSAlgorithm(){
        stack.push(new Point(0,1)); // 시작 지점은 무조건 (1,2)
        int walkCount = 0; // 이동한 횟수
        while(!stack.isEmpty()){
            System.out.println("현재 스택: " + stack);
            Point now = stack.pop();
            //mouse.move(now);
            walkCount++;
            System.out.println(now);
            if (maze.getCell(now.x, now.y).isExit()) {
                System.out.println("Exit");
                return true;
            }
            else {
                maze.getCell(now.x, now.y).setState(Cell.State.VISIT);
                if(isValidPos(now.x+1, now.y)){
                    stack.push(new Point(now.x+1, now.y));
                }
                if(isValidPos(now.x-1, now.y)){
                    stack.push(new Point(now.x-1, now.y));
                }
                if(isValidPos(now.x, now.y+1)){
                    stack.push(new Point(now.x+1, now.y+1));
                }
                if(isValidPos(now.x, now.y-1)){
                    stack.push(new Point(now.x, now.y-1));
                }
            }
        }
        return false;
    }

    // 스택 저장공간을 바꾸는 함수
    void replaceStackData(LinkedStack<Point> stack){
        this.stack = stack;
    }

    // 이동할 수 있는 위치인지 확인하는 함수
    boolean isValidPos(int x, int y){

        if (x<0 || y<0 || x>=maze.getWidth()-1 || y>=maze.getHeight()-1)
            return false;
        else
            return !maze.getCell(x, y).isWall() || !maze.getCell(x, y).isVisited();
        // 이미 지나간 자리도 추가 해야하나?
    }

    public static void main(String[] args){
        try {
            int[][] map = ReadMaze.read("test.txt");
            int row = map[0].length;
            int column = map.length;
            Maze maze = new Maze(column, row, map);
            SearchAlgorithm solver = new SearchAlgorithm(maze);
            solver.DFSAlgorithm();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

