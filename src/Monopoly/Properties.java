package Monopoly;

class Properties extends Cards {//Child Class specifically for making Propperty cards

    public void setRent(int rent) {
        this.rent = rent;
    }

    private int rent;

    private boolean owned;




    private int house1,house2,house3,house4,hotel;
    //Storing color by int to make it easier
    private String color;
    private int moragevalue;
    private int addhousecost;

    private int addhotelcost;
    private boolean morgage;
    private int housecount;

    private int sellprice;
    Properties(String color,String name,Boolean morgage,Boolean owned,int price,int addhotelcost,int rent,int house1, int house2, int house3,int house4,int hotel, int sellprice){
        super(name, price);

        this.rent = rent;
        this.owned = owned;
        this.house1 = house1;
        this.house2 = house2;
        this.house3 = house3;
        this.house4 = house4;
        this.hotel = hotel;
        this.color = color;
        this.moragevalue = sellprice;
        this.addhousecost = addhousecost;
        this.addhotelcost = addhotelcost;
        this.morgage = morgage;
        this.sellprice = (addhotelcost/2);
        this.housecount=0;
    }

    public Properties() {
        super("name");
    }

    public int getHousecount(){
       return this.housecount;
    }
    public int getRent(){
    switch(getHousecount()){
        case 1:
            rent =this.house1;
            break;
        case 2:
            rent =this.house2;
            break;

        case 3:
            rent =this.house3;
            break;

        case 4:
            rent =this.house4;
            break;

        case 5:
            rent =hotel;
            break;
        default:
            break;
    }


        return this.rent;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getAddhotelcost() {
        return addhotelcost;
    }

    public void setAddhotelcost(int addhotelcost) {
        this.addhotelcost = addhotelcost;
    }

    public int getMoragevalue() {
        return moragevalue;
    }

    public void setMoragevalue(int moragevalue) {
        this.moragevalue = moragevalue;
    }

    public boolean isMorgage() {
        return morgage;
    }

    public void setMorgage(boolean morgage) {
        this.morgage = morgage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}