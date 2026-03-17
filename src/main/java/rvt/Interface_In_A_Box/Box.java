package rvt.Interface_In_A_Box;
import java.util.ArrayList;

public class Box implements Packable {
    private double maxCapacity;
    private ArrayList<Packable> listOfObjects;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.listOfObjects = new ArrayList<>();

    }

    public double weight() {

        double weight = 0;

        for (Packable object: listOfObjects) {
            weight += object.weight();

        }

        return weight;

    }

    public void add(Packable object) {
        this.listOfObjects.add(object);

    }

    public String toString() {
        if (this.weight() <= this.maxCapacity) {
            return "Box: " + this.listOfObjects.size() + " items, total weight: " + this.weight() + " kg";

        } else {
            return "Box: " + this.listOfObjects.size() + " items, total weight: exceeds, its weight is " + this.weight() + " when the maximum capacity is " + this.maxCapacity + " kg!";

        }

    }

}