package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.model.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITYLENIN = 10;
    private static final int CAPACITYSTALIN = 10;


    public static void main(String[] args) throws InterruptedException {
        Elevator elevatorLenin = new Elevator("V.I. Lenin");
        Elevator elevatorStalin = new Elevator("Parteigenosse Stalin");
        Truck[] trucks1 = new Truck[N_TRUCK];
        for (int i = 0; i < trucks1.length; i++) {
            trucks1[i] = new Truck(N_RACES, CAPACITYLENIN, CAPACITYSTALIN,elevatorLenin,elevatorStalin);
        }

        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] =new Thread(trucks1[i]);
            threads[i].start();
        }
        for (Thread thread:threads){
            thread.join();
        }
        System.out.println("Elevator "+elevatorLenin.getName()+" has "+elevatorLenin.getCurrentVolume());
        System.out.println("Elevator "+elevatorStalin.getName()+" has "+elevatorStalin.getCurrentVolume());

    }
}