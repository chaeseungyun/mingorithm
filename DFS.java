import java.io.IOException;
import java.security.AlgorithmConstraints;
import java.util.logging.XMLFormatter;

public class DFS {
    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        void printPoint(){
            System.out.printf("(%d, %d) ", this.x, this.y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d) ", this.x, this.y);
        }
    }

    // 연결리스트를 위한 노드
    static class Node<T>{
        Node link;
        T data;

        Node(){
            this.link = null;
            this.data = null;
        }
        Node(T data){
            this.link = null;
            this.data = data;
        }
        Node(Node link, T data){
            this.link = link;
            this.data = data;
        }
    }

    // 연결리스트를 활용한 스택
    static class LinkedStack<T> {
        Node<T> top;
        int size; // 현재 스택의 크기 카운트

        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return top == null;
        }
        //isFull 없음

        void clear() {
            this.top = null;
        }

        void push(T data) {
            Node<T> n = new Node<T>(this.top, data);
            this.top = n;
            this.size += 1;
        }

        T pop() {
            if (!this.isEmpty()) {
                Node<T> n = this.top;
                this.top = n.link;
                this.size -= 1;
                return n.data;
            } else { // 비어있을 때 pop 시도
                System.out.println("Empty Stack: Can't do pop function");
                return null;
            }
        }

        // 가장 위의 데이터 값만 가져오는 연산
        T peek() {
            if (!this.isEmpty()) return this.top.data;
            else {
                System.out.println("Empty Stack: Can't do peek function");
                return null;
            }
        }

        // class print 가능
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node n = this.top;
            for(int i=0; i<this.size; i++) {
                result.append(n.data);
                n = n.link;
            }
            return "top -> "+result.toString()+" ]";
        }
    }

    // 우리만의 알고리즘(이 될 예정)
    static class SearchAlgorithm {
        LinkedStack<Point> stack;
        int[][] map; // 실제로는 MAP 클래스 필요

        SearchAlgorithm(){
            this.stack = new LinkedStack<>();
        }
        SearchAlgorithm(LinkedStack<Point> stack){
            this.stack = stack;
        }

        // DFS 모드
        boolean DFSAlgorithm(){
            stack.push(new Point(0,1)); // 시작 지점은 무조건 (1,2)
            System.out.println("현재 스택: " + stack);
            int walkCount = 0; // 이동한 횟수
            while(!stack.isEmpty()){
                Point now = stack.pop();
                walkCount++;
                System.out.println(now);
                if (map[now.y][now.x] == -1)
                    return true;
                else {
                    map[now.y][now.x] = 2;
                    if (isValidPos(now.x+1, now.y, map))
                        stack.push(new Point(now.x+1, now.y));
                    if (isValidPos(now.x-1, now.y, map))
                        stack.push(new Point(now.x-1, now.y));
                    if (isValidPos(now.x, now.y+1, map))
                        stack.push(new Point(now.x, now.y+1));
                    if (isValidPos(now.x, now.y-1, map))
                        stack.push(new Point(now.x, now.y-1));
                }
            }
            return false;
        }

        // 스택 저장공간을 바꾸는 함수
        void replaceStackData(LinkedStack<Point> stack){
            this.stack = stack;
        }

        // 이동할 수 있는 위치인지 확인하는 함수
        boolean isValidPos(int x, int y, int[][] map){
            int row = map[0].length;
            int column = map.length;
            if (x<0 || y<0 || x>=column || y>=row)
                return false;
            else
                return map[y][x] == 0 || map[y][x] == -1;
            // 이미 지나간 자리도 추가 해야하나?
        }


    }

    public static void main(String[] args){
        // 연결리스트 스택 기본 예제 시작
        LinkedStack<Point> stack = new LinkedStack<>();
        stack.push(new Point(3,4));
        stack.push(new Point(4,9));
        stack.push(new Point(23,3));
        System.out.println(stack);
        stack.pop();
        Point p = stack.pop();
        System.out.println(p); // toString 함수 있어서 print로 Point 정보를 바로 출력 가능하다.
        // 예제 끝

        try {
            int[][] map = ReadMaze.read("test.txt");
            SearchAlgorithm solver = new SearchAlgorithm();
            solver.map = map;
            solver.DFSAlgorithm();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

