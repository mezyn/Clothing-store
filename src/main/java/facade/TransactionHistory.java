package facade;

import java.text.DecimalFormat;

public class TransactionHistory {

    private final String ID;
    private int unitsSold;
    private double profit;


    public TransactionHistory(String ID, int unitsSold, double profit){

        this.ID = ID;
        this.unitsSold = unitsSold;
        this.profit = profit;
    }


    @Override
    public String toString() {

        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String stringProfit = decimal2.format(this.profit);
        return "" + this.ID + ": " + this.unitsSold + " item(s). " + stringProfit + " SEK";

    }


    public String getID() {return ID;}

    public int getUnitsSold() {return unitsSold;}

    //We know that these methods are not in use, but will leave them here for possible future usage.

    public void setUnitsSold(int unitsSold) {this.unitsSold = unitsSold;}

    public void setProfit(double profit) {this.profit = profit;}

    public double getProfit() {return profit;}

}