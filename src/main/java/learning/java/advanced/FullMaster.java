package learning.java.advanced;

import java.util.ArrayList;
import java.util.List;

public class FullMaster {

    private Dungeon dungeon;
    private Gym gym;
    private List<Slave> slaves;

    public FullMaster() {
        dungeon = new Dungeon(1000);
        gym = new Gym(this);
        slaves = new ArrayList<>();
        run();
    }

    public void run() {
        addSlave(new Slave(dungeon, 3));
        addSlave(new Slave(dungeon, 3));
        addSlave(new Slave(dungeon, 3));
        new Thread(gym).start();
    }

    public void addSlave(Slave slave) {
        slaves.add(slave);
        new Thread(slave).start();
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}
