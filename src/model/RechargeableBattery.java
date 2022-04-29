package model;

public class RechargeableBattery extends Battery implements Rechargeable {
    public final static char BATTERY_LITIO = 'l';
    public final static char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_LITIO = 0.92;
    public final static double FACTOR_NIQUEL_CADIO = 0.80;
    public int chargerNumber;
    public char type;
    

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        super(name, voltage, cost, capacity);
        this.type = type;
        this.chargerNumber = chargerNumber;
    }

    @Override
    public double calculateUsefulLifeCost() {
        double out;
        if (type == 'n') {
            out = (super.getCost() * super.getVoltage() * super.getCapacity())/(1000* chargerNumber * FACTOR_NIQUEL_CADIO);
        } else {
            out = (super.getCost() * super.getVoltage() * super.getCapacity())/(1000* chargerNumber * FACTOR_LITIO); 
        }
        return out;
    }

}
