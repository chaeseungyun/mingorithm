import java.util.*;

public class AStarAlgorithm {
  private int[][] grid;
  private int start_x;
  private int start_y;
  private int end_x;
  private int end_y;
  private boolean[][] closed_set;
  private int[][] came_from;
  private int[][] g_score;
  private int[][] f_score;
  private PriorityQueue<int[]> open_set;

  public AStarAlgorithm(int[][] grid, int start_x, int start_y, int end_x, int end_y) {
    this.grid = grid;
    this.start_x = start_x;
    this.start_y = start_y;
    this.end_x = end_x;
    this.end_y = end_y;
    this.closed_set = new boolean[grid.length][grid[0].length];
    this.came_from = new int[grid.length][grid[0].length];
    this.g_score = new int[grid.length][grid[0].length];
    this.f_score = new int[grid.length][grid[0].length];
    this.open_set = new PriorityQueue<>((a, b) -> f_score[a[0]][a[1]] - f_score[b[0]][b[1]]);
    init();
  }

  private void init() {
    for (int i = 0; i < grid.length; i++) {
      Arrays.fill(closed_set[i], false);
      Arrays.fill(came_from[i], -1);
      Arrays.fill(g_score[i], Integer.MAX_VALUE);
      Arrays.fill(f_score[i], Integer.MAX_VALUE);
    }
    g_score[start_x][start_y] = 0;
    f_score[start_x][start_y] = heuristic(start_x, start_y);
    open_set.offer(new int[]{start_x, start_y});
  }

  // 맨하탄 거리로 휴리스틱 값을 구한다.
  private int heuristic(int x, int y) {
    return Math.abs(x - end_x) + Math.abs(y - end_y);
  }

  public int[][] run() {
    while (!open_set.isEmpty()) {
      int[] current = open_set.poll();

      if (current[0] == end_x && current[1] == end_y) {
        return reconstructPath(current);
      }

      closed_set[current[0]][current[1]] = true;

      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i == 0 && j == 0) {
            continue;
          }

          int x = current[0] + i;
          int y = current[1] + j;

          if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || closed_set[x][y]) {
            continue;
          }

          int tentative_g_score = g_score[current[0]][current[1]] + 1;

          if (tentative_g_score < g_score[x][y]) {
            came_from[x][y] = current[0] * grid[0].length + current[1];
            g_score[x][y] = tentative_g_score;
            f_score[x][y] = g_score[x][y] + heuristic(x, y);

            if (!open_set.contains(new int[]{x, y})) {
              open_set.offer(new int[]{x, y});
            }
          }
        }
      }
    }

    return null;
  }

  private int[][] reconstructPath(int[] current) {
    int[][] path = new int[g_score[current[0]][current[1]] + 1][2];
    int index = path.length - 1;
    while (current[0] != start_x || current[1] != start_y) {
      path[index--] = new int[]{current[0], current[1]};
      current = new int[]{came_from[current[0]][current[1]] / grid[0].length, came_from[current[0]][current[1]] % grid[0].length};
    }

    path[index] = new int[]{start_x, start_y};

    return path;
  }
}