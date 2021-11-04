package learning.java.advanced;

public class Slave implements Runnable {

    private Dungeon dungeon;
    private int earningCapacity;
    private int bucks;
    private String name;

    public Slave(Dungeon dungeon, int earningCapacity) {
        this.dungeon = dungeon;
        this.earningCapacity = earningCapacity;
        this.bucks = 0;
        this.name = "Slave #" + IdGen.getId();
    }

    @Override
    public void run() {
        while (dungeon.getBucks() > 0) {
            synchronized (dungeon){
                System.out.println(name + " is earning bucks");
                int bucksFromDungeon = dungeon.earnBucks(earningCapacity);
                bucks += bucksFromDungeon;
                System.out.println(name + " earned " + bucksFromDungeon + ". Total bucks: " + bucks);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getBucks() {
        return bucks;
    }

    public String getName() {
        return name;
    }
}
