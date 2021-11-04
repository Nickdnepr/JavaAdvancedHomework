package learning.java.advanced;

public class Dungeon {

    private int bucks;

    public Dungeon(int bucks) {
        this.bucks = bucks;
    }

    public int earnBucks(int earningCapacity) {
        int earnedBucks = Math.min(earningCapacity, bucks);
        bucks -= earningCapacity;
        if (bucks < 0) {
            bucks = 0;
        }
        System.out.println("Dungeon bucks taken: " + earnedBucks + ". Bucks left: " + getBucks());
        return earnedBucks;
    }

    public int getBucks() {
        return bucks;
    }
}
