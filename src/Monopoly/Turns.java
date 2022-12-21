package Monopoly;

import java.io.IOException;

import static jdk.internal.net.http.common.Utils.close;

public class Turns {
    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public boolean isRolling() {
        return rolling;
    }

    public void setRolling(boolean rolling) {
        this.rolling = rolling;
    }

    private boolean rolling=false;
    private boolean rented=false;
    boolean press = false;

    public boolean isBuybtn() {
        return buybtn;
    }

    public void setBuybtn(boolean buybtn) {
        this.buybtn = buybtn;
    }

    private boolean buybtn= false;
    Turns(int pcount) throws IOException, InterruptedException {//Main method that will make the players
        Dice die1 = new Dice();
        int playersleft = pcount;
        dBoard board = new dBoard();
       // Properties s = new Properties();
        //Properties x = (Properties) (board.getBoardprop(1));
        /*for(int xx=0; xx<40; xx++){
            System.out.println(xx+(board.getBoardprop(xx)).getName());
        }
*/
        Players p1 = new Players("Car");
        Players p2 = new Players("Boat");
        Players p3 = new Players("Arch");
        Players p4 = new Players("Cat");
        String winner = null;

        Players[] plist = new Players[4];
        plist[0] = p1;
        plist[1] = p2;
        plist[2] = p3;
        plist[3] = p4;
        Display d = new Display(this);

        while (winner == null) {
            for (int i = 0; i < pcount; i++) {
                playersleft = pcount;
                plist[i]=PlayerTurn(plist[i], die1, board,d,i);
                System.out.print(plist[i].getPosition());


                while(isPress() == false){

                    if(buybtn == true) {
                        plist[i] = buyProperty(plist[i], board,d,i);


                    }
                    System.out.println(plist[i].getPosition());
                    //Button Press
               }
                setBuybtn(false);

                setPress(false);
                if(plist[i].isLostthegame()){
                    playersleft=-1;
                }
System.out.println("done");
            }
            if(playersleft==1){
                winner ="Winner";
            }
        }
    }
    public void ButtonPress(){
        setPress(true);


    }
    public Players PlayerTurn(Players p, Dice d, dBoard b,Display ds, int i) throws InterruptedException {
   // while (rolling==false){

    //}
        if (!p.isLostthegame()) {
            int roll = p.takeTurn(d);

            if (roll == 99) {
                p.getInjail();
                p.setPosition(10);
            } else {
                Cards s = b.getBoardprop(p.getPosition());
                String ss = String.valueOf(b.getBoardprop(p.getPosition()).getClass());


                p.setPosition((p.getPosition() + roll));
                if(p.getPosition()>39){
                    p.setPosition(p.getPosition()-39);
                    p.addCash(200);
                }

                    ds.MovePiece(p.getPosition(), i);



                //System.out.println(p.getPosition());
              p= Move(p,b, String.valueOf(b.getBoardprop(p.getPosition()).getClass()),ds, i);




            }
        }
        ds.hidebuy();
        ds.hiderent();

        return p;
    }
    public Players Move(Players p, dBoard b, String cname,Display ds,int indexing) throws InterruptedException {
        //    System.out.print(cname);
        switch (cname) {
            case "class Monopoly.ChanceandCommunityCards":
                ChanceandCommunityCards cc =(ChanceandCommunityCards) b.getBoardprop(p.getPosition());
                if(cc.getName() == "Chance")
                    p= cc.Chancecards(p);
                else
                    p=cc.Communitycards(p);
                break;
            case "class Monopoly.Properties":
                Properties prop =(Properties) b.getBoardprop(p.getPosition());
                if(prop.getOwner() == null){
                    ds.showbuy();
                    //option to buy
                    // buyProperty(p, b, String.valueOf(b.getBoardprop(p.getPosition()).getClass()));

                }
                else{
                    ds.showrent();
                    while(rented==false){
                        wait(500);
                    }

                    p.DeductCash( prop.getRent());
                    ds.setText("Rent paid:"+prop.getRent());
                   rented =false;

                }

                break;
            case "class Monopoly.Railroads":
                Railroads r =(Railroads) b.getBoardprop(p.getPosition());

                if(r.getOwner() == null){
                    //option to buy
                    ds.showbuy();

                }
                else{
                    ds.showrent();
                    while(rented==false){

                    }
                    p.DeductCash(r.setrent(p));
                    ds.setText("Rent paid:"+r.setrent(p));
                    rented =false;
                }

                break;
            case "class Monopoly.Utility":
                Utility u =  (Utility) b.getBoardprop(p.getPosition());
                if(u.getOwner()==null){
                ds.showbuy();
                }
                else{
                    ds.showrent();
                    while(rented==false){

                    }
                    p.DeductCash(u.setrent(p));
                    ds.setText("Rent paid:"+u.setrent(p));
                    rented =false;
                }

                break;

            case "class Monopoly.taxes":
                taxes t = (taxes)b.getBoardprop(p.getPosition());
                if(b.getBoardprop(p.getPosition()).getName()=="Income Taxes"){
                    p.DeductCash(t.getIncomeTax(p));
                }
                else{
                    p.DeductCash(t.getLuxuryTax());
                }
                break;
            case "class Monopoly.Cards":
                System.out.print(String.valueOf(b.getBoardprop(p.getPosition()).getName()));
                switch (String.valueOf(b.getBoardprop(p.getPosition()).getName())){
                    case "Jail":
                        System.out.println("Your in jail");
                        p.goToJail();
                        p.setPosition(10);
                        ds.MovePiece(10,indexing);
                        close();
                        break;
                    case "Go":
                        p.addCash(200);
                        break;



                    case "Free Parking":

                        break;


                }
                break;
            default:

                break;

        }
        return p;
    }
    public Players buyProperty(Players p, dBoard b, Display ds, int i) {

        int price= 0;
        String ss = String.valueOf((b.getBoardprop(p.getPosition())).getClass());
        switch (ss){
            case "class Monopoly.Railroads":
                Railroads r =(Railroads)b.getBoardprop(p.getPosition());
                price = r.getPrice();

            case "class Monopoly.Properties":

            default:

              System.out.println(b.getBoardprop(p.getPosition()).getName());
                break;


        }
        if(p.getMoney()-price<0) {
           ds.setText("Not enough cash");
        }
        else{
            p.DeductCash(price);
            p.getProperties().add(b.getBoardprop(p.getPosition()));
            ds.setText("You bought "+b.getBoardprop(p.getPosition()));
        }


        b.getBoardprop(p.getPosition());

        return p;

    }

}