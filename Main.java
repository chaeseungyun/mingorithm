import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      // 미로 파일 읽어오기
      File file = new File("maze.txt");
      Scanner scanner = new Scanner(file);

      // 미로 클래스 생성
      Maze maze = new Maze(scanner);

      // 쥐 객체 생성
      Mouse mouse = new Mouse(1, 1);

      // 스캐너 객체 생성
      Scanner scannerItem = new Scanner();

      // 출구를 찾을 때까지 쥐 객체를 이동시키기
      while (!maze.isExit(mouse.getX(), mouse.getY())) {
        // 쥐의 현재 위치에서 이동 가능한 방향 찾기
        Direction[] directions = maze.getAvailableDirections(mouse.getX(), mouse.getY());

        // 스캐너 아이템을 사용할 수 있는 상태인지 체크
        if (mouse.getMana() >= 3) {
          // 스캐너 아이템 사용
          int[] scanResult = scannerItem.scan(maze, mouse.getX(), mouse.getY());
          System.out.println("스캔 결과:");
          maze.printMaze(scanResult[0], scanResult[1], scanResult[2], scanResult[3]);
          mouse.useMana(3);
        }

        // 이동 가능한 방향이 없으면 쥐는 멈춤
        if (directions.length == 0) {
          break;
        }

        // 이동 방향 선택
        Direction selectedDirection = mouse.selectDirection(directions);

        // 쥐 이동 및 에너지 소모
        mouse.move(selectedDirection);
        mouse.useEnergy(1);

        // 현재 쥐의 상태 출력
        System.out.println("현재 쥐의 상태:");
        System.out.println("위치: (" + mouse.getX() + ", " + mouse.getY() + ")");
        System.out.println("이동 가능한 방향: " + Direction.toString(directions));
        System.out.println("남은 에너지: " + mouse.getEnergy());
        System.out.println("마나: " + mouse.getMana());
        System.out.println();
      }

      // 출구를 찾은 경우
      if (maze.isExit(mouse.getX(), mouse.getY())) {
        System.out.println("출구를 찾았습니다!");
      } else {
        System.out.println("출구를 찾지 못했습니다.");
      }

      // 스캐너 사용 횟수 출력
      System.out.println("스캐너를 사용한 횟수: " + scannerItem.getUsageCount());

      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
