// Write a program that processes a group of input lines, each containing an 'A' for arrival, a 'D' for departure, and a license plate number. Cars are assumed to arrive and depart in the order specified. The program should:
// a) Print a message whenever a car arrives or departs.
// b) When a car arrives, the message should specify whether there is room for the car in the garage. If there is no room, the car leaves without entering the garage.
// c) When a car departs, the message should include the number of times the car was moved out of the garage to allow other cars to depart.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GarageSimulation {

    static class Car {
        String licensePlate;
        int moveCount;

        Car(String licensePlate) {
            this.licensePlate = licensePlate;
            this.moveCount = 0;
        }
    }

    public static void main(String[] args) {
        int garageCapacity = 5; 
        Queue<Car> garage = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an action (A for arrival, D for departure) followed by a license plate number:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            char action = input.charAt(0);
            String licensePlate = input.substring(2);

            if (action == 'A') {
                processArrival(garage, garageCapacity, licensePlate);
            } else if (action == 'D') {
                processDeparture(garage, licensePlate);
            } else {
                System.out.println("Invalid action. Please enter 'A' for arrival or 'D' for departure.");
            }
        }

        scanner.close();
    }

    private static void processArrival(Queue<Car> garage, int capacity, String licensePlate) {
        if (garage.size() < capacity) {
            garage.add(new Car(licensePlate));
            System.out.println("Car with license plate " + licensePlate + " has arrived and parked in the garage.");
        } else {
            System.out.println("Car with license plate " + licensePlate + " arrived but the garage is full. The car leaves.");
        }
    }

    private static void processDeparture(Queue<Car> garage, String licensePlate) {
        Queue<Car> tempQueue = new LinkedList<>();
        boolean found = false;
        Car departingCar = null;

        while (!garage.isEmpty()) {
            Car car = garage.poll();
            if (car.licensePlate.equals(licensePlate)) {
                found = true;
                departingCar = car;
                break;
            } else {
                car.moveCount++;
                tempQueue.add(car);
            }
        }

        while (!tempQueue.isEmpty()) {
            garage.add(tempQueue.poll());
        }

        if (found) {
            System.out.println("Car with license plate " + departingCar.licensePlate + " has departed.");
            System.out.println("The car was moved " + departingCar.moveCount + " times to allow other cars to depart.");
        } else {
            System.out.println("Car with license plate " + licensePlate + " not found in the garage.");
        }
    }
}
