package Monopoly;

class Railroads extends Cards{
private int rent;
private String name;
Railroads(String name,int price){
    super(name,price);
    this.name = name;
    this.rent= 0;;
}

    public int setrent(Players player){
        int[]rents = new int[4];
        int index=0;
        rents[1]=25;
        rents[2]=50;
        rents[3]=100;
        rents[4]=200;

        if(player.checkproperties("Reading Railroad")!=null){
            index++;
        }
        if (player.checkproperties("Water Company")!=null){
            index++;
        }
        if(player.checkproperties("Reading Railroad")!=null){
            index++;
        }
        if (player.checkproperties("Water Company")!=null){
            index++;
        }
        return (rents[index]);
    }

}
