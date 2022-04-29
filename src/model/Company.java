package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
        int counterTraditionalBatteries = 0;
        int counterRechargeable = 0;
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i] instanceof RechargeableBattery) {
                counterRechargeable ++;
            } else if(batteries[i] instanceof Battery) {
                counterTraditionalBatteries ++;
            }
        }
    	return "Baterias tradicionales: " + counterTraditionalBatteries + "\nBaterias recargables: " +  counterRechargeable;
    }
    
    public String showBatteriesInfo() {
        String str = "";
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i] instanceof RechargeableBattery ) {
                str += "\nBateria recargable"+ "\nNombre: " + batteries[i].getName() + "\nCosto de vida util: "+ ((RechargeableBattery) batteries[i]).calculateUsefulLifeCost() + "\n";
            } else if (batteries[i] instanceof Battery) {
                str += "\nBateria no recargable"+ "\nNombre: " + batteries[i].getName() + "\nCosto de vida util: 0" + "\n";
            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        int counterRechargeableBatteries = 0;
        double sumUtilLife = 0;
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i] instanceof RechargeableBattery) {
                counterRechargeableBatteries ++;
                sumUtilLife += ((RechargeableBattery) batteries[i]).calculateUsefulLifeCost();
            }
        }
		return sumUtilLife / counterRechargeableBatteries;
	}

}
