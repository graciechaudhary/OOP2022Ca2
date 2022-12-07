package com.dkit.gd2.GracieChaudhary.CA2;

public class MilkingMachine implements IMilkable{

    private boolean connectedToTank;
    private MilkTank milkTank;

    public MilkingMachine(boolean connectedToTank){
        this.connectedToTank = connectedToTank;
    }

    public MilkTank getMilkTank() {
        if(connectedToTank==true){
            return milkTank;
        }
        else{
            return null;
        }
    }
    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }

    @Override
    public void milk() {

    }
}
