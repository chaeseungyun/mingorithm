public class Cell {
  private boolean isWall;
  private boolean isExit;
  private boolean isEmpty;
  private boolean isVisited;

  public enum State {
    EMPTY,
    WALL,
    EXIT,
    VISIT
  }

  public Cell(int isWall) {
    this.isWall = (isWall == 1);
    this.isEmpty = (isWall == 0);
    this.isExit = (isWall == 3);
    this.isVisited = false;
  }

  public boolean isWall() {
    return isWall;
  }

  public boolean isExit() {
    return isExit;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void visit() {
    this.isVisited = true;
  }

  public State getState() {
    if (isWall) {
      return State.WALL;
    } else if (isExit) {
      return State.EXIT;
    } else {
      return State.EMPTY;
    }
  }

  public void setState(State state) {
    if (state == State.WALL) {
      isWall = true;
      isExit = false;
    } else if (state == State.EMPTY) {
      isWall = false;
      isExit = false;
    } else if (state == State.EXIT) {
      isWall = false;
      isExit = true;
    }
  }
}
