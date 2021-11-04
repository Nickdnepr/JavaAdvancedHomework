package learning.java.advanced;

public class Gym implements Runnable{

    private FullMaster fullMaster;

    public Gym(FullMaster fullMaster) {
        this.fullMaster = fullMaster;
    }

    @Override
    public void run() {
        while(fullMaster.getDungeon().getBucks()>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fullMaster.addSlave(new Slave(fullMaster.getDungeon(), 3));
            System.out.println("The Gym has spawned a new slave!");
        }
    }
}
