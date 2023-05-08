public class Manhattan {
  // 인덱스를 받아야 함, Maze -> Cell[][] cell -> boolean
  public static long calcManhattanDist(int x1, int x2, int y1, int y2)
  {
    return Math.abs((x1-x2) + (y1-y2));
  }
}
