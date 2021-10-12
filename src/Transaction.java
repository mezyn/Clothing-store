
public class Transaction {

    private String ID;
    private int unitsSold;
    private double profit;


    public Transaction(String ID, int unitsSold, double profit){

        this.ID = ID;
        this.unitsSold = unitsSold;
        this.profit = profit;
    }



    @Override
    public String toString() {
        return "<" + this.ID + ">: <" + this.unitsSold + "> item(s). <" + this.profit + "> SEK.";


    }


    public String getID() {return ID;}

    public int getUnitsSold() {return unitsSold;}

    public void setUnitsSold(int unitsSold) {this.unitsSold = unitsSold;}

    public void setProfit(double profit) {this.profit = profit;}

    public void getProfit(double profit) {this.profit = profit;}


}


