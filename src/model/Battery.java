package model;

public class Battery {
    private String name;
    private double voltage;
    private double cost;
    private double capacity;


    public Battery(String name, double voltage, double cost, double capacity) {
        this.name = name;
        this.voltage = voltage;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVoltage() {
        return this.voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    
}
