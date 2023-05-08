public class Mouse {
    private Point location;
    private int distance; // 쥐의 이동 거리
    private String direction; // 방향(상,하,좌,우) : 안 필요할 수도
    private int energy; // 에너지
    //    private int maxEnergy; // 최대치
    private int mana;// 마나
    //    private int maxMana; // 마나 최대치
    private int scanCount;
    //private Maze maze; // 스캔 대상이 되는 미로


    public Mouse(Point location, int energy ) { //
        this.location = location;
        this.energy = energy;
//        maxEnergy = 100;
        mana = 3;
//        maxMana = 50;
    }

    public void move(int distance, String direction) { // 쥐 이동 : 이동 거리, 방향, 에너지 등 업데이트
        // 이동 거리와 방향을 업데이트합니다.
        this.distance += 1;
        this.direction = direction;
        // 에너지를 소비합니다.
        this.energy -= 1;
        this.mana +=0.1;
    }

    public void useItem(String itemName) { // 아이템 사용 메소드, 사용할 수 있는 아이템 횟수
        //마나를 쓸 수 있는지 확인
        //쓸 수 없으면 못 쓴다고 알림 띄우기
        if(mana<3)
            System.out.print("마나가 부족합니다.");
        else{
            //스캔너 클래스 실행
            //Scanner scanner = new Scanner(maze, this);
            //스캔 횟수 증가, 마나 감소 : 스캐너에서 다룸
            //scanner.scan();
        }
    }

    public int getEnergy() { // 쥐의 에너지 반환
        return energy;
    }

    public int getMana() { // 쥐의 마나 반환
        return mana;
    }

    public void decreaseMana(){ // 마나 감소 메소드 -> item 메소드 내에서 사용
        if (this.mana >= 3) {
            this.mana -= 3;
        } else {
            System.out.println("Not enough mana.");
        }
    }

    public void increaseScanCount() { // 스캔 횟수 증가 메소드
        scanCount++;
    }

    public int getScanCount() { // 스캔 횟수 반환 메소드
        return scanCount;
    }

    public int getX() { // 쥐의 x좌표 반환
        return location.x;
    }

    public int getY() { // 쥐의 y좌표 반환
        return location.y;
    }

}
