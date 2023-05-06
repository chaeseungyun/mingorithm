public class Mouse {
    private int x; // 쥐의 위치
    private int y; // 쥐의 위치
    private int distance; // 쥐의 이동 거리
    private String direction; // 방향(상,하,좌,우) : 안 필요할 수도
    private int energy; // 에너지
    private int maxEnergy; // 최대치
    private int mana;// 마나
    private int maxMana; // 마나 최대치

    private int scanCount;

    public Mouse(int startX, int startY) { //
        x = startX;
        y = startY;
        distance = 0;
        direction = "down";
        energy = 100;
        maxEnergy = 100;
        mana = 50;
        maxMana = 50;
    }

    public void move(int distance, String direction) { // 쥐 이동 : 이동 거리, 방향, 에너지 등 업데이트
        // 이동 거리와 방향을 업데이트합니다.
        this.distance += distance;
        this.direction = direction;
        // 에너지를 소비합니다.
        this.energy -= distance;
    }

    public void useItem(String itemName) { // 아이템 사용 메소드, 사용할 수 있는 아이템 횟수
        // 아이템을 사용하고 수량을 감소시킵니다.

    }

    public int getEnergy() { // 쥐의 에너지 반환
        return energy;
    }

    public int getMana() { // 쥐의 마나 반환
        return mana;
    }

    public void decreaseMana(int amount) { // 마나 감소 메소드
        if (this.mana >= amount) {
            this.mana -= amount;
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
        return x;
    }

    public int getY() { // 쥐의 y좌표 반환
        return y;
    }
}
