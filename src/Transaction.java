
public class Transaction {

    private String ID;
    private int amount;
    private double purchasePrice;

    public Transaction(String ID, int amount, double purchasePrice){

        this.ID = ID;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        return "<" + this.ID + ">: <" + this.amount + "> item(s). <" + this.purchasePrice + "> SEK.";
    }

    public String getID() {return ID;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public void setPurchasePrice(double purchasePrice) {this.purchasePrice = purchasePrice;}

    public void getPurchasePrice (double purchasePrice) {this.purchasePrice = purchasePrice;}
}

