package ait.elevator.model;

public class Truck implements Runnable {
    private static Object monitor = new Object();

    private int nRaces;
    private int capacityLenin;
    private int capacityStalin;
    private Elevator elevatorLenin;
    private Elevator elevatorStalin;

    public Truck(int nRaces, int capacityLenin, int capacityStalin, Elevator elevatorLenin, Elevator elevatorStalin) {
        this.nRaces = nRaces;
        this.capacityLenin = capacityLenin;
        this.capacityStalin = capacityStalin;
        this.elevatorLenin = elevatorLenin;
        this.elevatorStalin = elevatorStalin;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevatorLenin.add(capacityLenin);
                elevatorStalin.add(capacityStalin);
            }
        }
    }
}
