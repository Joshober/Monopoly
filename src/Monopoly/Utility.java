package Monopoly;

class Utility extends Cards {
    private int rent;
    Utility(String name,int price){
        super(name,price);
        this.setName(name);
    }
    private int getroll(Players p){
        return 0;
    }
    public int setrent(Players p){

        int roll= getroll(p);
        int rent=4*roll;
        if(p.checkproperties("Electric Company")&&p.checkproperties("Water Company")==true);
        rent = 10*roll;
        return rent;
    }
}