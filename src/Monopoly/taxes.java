package Monopoly;

class taxes extends Cards {

   private int incomeTax;
  private  double taxPercent;


   private int luxuryTax;

    public taxes(String name)
    {
        super(name);
        setIncomeTax(200);
        setTaxPercent(0.10);
        setLuxuryTax(75);
    }

    public int getIncomeTax(Players p) {
        return ((int) getTaxPercent()*(p.getMoney()));
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public int getLuxuryTax() {
        return luxuryTax;
    }

    public void setLuxuryTax(int luxuryTax) {
        this.luxuryTax = luxuryTax;
    }

    public void applyTaxes(Players p) {
        p.getMoney();

    }


}