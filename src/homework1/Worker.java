package homework1;

import java.util.HashMap;

public class Worker {
    private int capacity;
    private HashMap<Task, Integer> MoneyMap = new HashMap<>();
    private HashMap<Task, Integer> WorkMap = new HashMap<>();
    private HashMap<Task, Integer> ValueMap = new HashMap<>();

    public Worker(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<Task, Integer> getMoneyMap() {
        return MoneyMap;
    }

    public HashMap<Task, Integer> getValueMap() {
        return ValueMap;
    }

    public HashMap<Task, Integer> getWorkMap() {
        return WorkMap;
    }
}
