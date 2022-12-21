package Monopoly;
//A virtual board that stores the location and value of the property the player lands on

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
public class dBoard {


    private Dictionary<Integer, Cards> Boardprop  = new Hashtable<Integer, Cards>();;

    dBoard() throws IOException {
    Boardprop = setupBoard(Boardprop);
    }

    private Properties getproperties(int i) throws IOException {//Gets cards to set as properties then store in an array

        FileReader readfile = new FileReader("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\Proplist.txt");
        BufferedReader readbuffer = new BufferedReader(readfile);
        String name = null;
        String color = null;




        int[] info = new int[10];


        for(int lines=0;lines<i*11;lines++){

            readbuffer.readLine();
        }
        for(int x=0;x<10;x++){
            if(x==0){

                color=(readbuffer.readLine());

            } else if (x==1) {
                name=(readbuffer.readLine());

            }

            else{

                info[x]=Integer.parseInt(readbuffer.readLine());

            }

        }



        Properties card = new Properties(color,name,false,false,info[0],info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8]);
      //  System.out.println(card.getRent());

        return card;
    }
    private Dictionary<Integer, Cards> setupBoard(Dictionary<Integer, Cards> board) throws IOException { //sets all the spots on the arraylist to a specific card

   Utility Utility = new Utility("Electric company",150);
        board.put(12, Utility);
        Utility Utility2 = new Utility("Water company",150);
        board.put(28, Utility2);
        Railroads reading = new Railroads("Reading railroad",200);
        board.put(5, reading);
        Railroads bando = new Railroads("B&O railroad",200);
        board.put(15, bando);
        Railroads Pennsylvania = new Railroads("Pennsylvania railroad",200);
        board.put(25, Pennsylvania);
        Railroads ShortLine = new Railroads("Short Line",200);
        board.put(35, ShortLine);
        Cards c = new Cards("Go","Pass go and get $200");
        board.put(0,c);
        Cards jail = new Cards("Jail","Just visiting");
        board.put(10,jail);
        Cards freeparking = new Cards("FreeParking","");
        board.put(20,freeparking);
        Cards gotojail = new Cards("Go To jail","Do not pass go");
        board.put(30,gotojail);
        ChanceandCommunityCards chance = new ChanceandCommunityCards("Chance","Chance card");
        ChanceandCommunityCards community = new ChanceandCommunityCards("Community","community Chest");
        taxes incometax = new taxes("Income Taxes");
        taxes luxarytax = new taxes("Luxary Taxes");
        board.put(4,incometax);
        board.put(38,luxarytax);
        board.put(2,community);
        board.put(17,community);
        board.put(22,chance);
        board.put(7,chance);
        board.put(36,chance);
        board.put(33,community);

        /*Properties MediterraneanAv = new Properties("MediterraneanAv",2,false,10,30,90,160,250,"Brown",30,50,50,true, 30);
        Properties BalticAvenue = new Properties("Baltic Avenue",4,false,20,60,180,320,450,"Brown",30,50,50,true, 30);
        Properties OrientalAvenue= new Properties("Oriental Avenue",6,false,30,90,270,400,450,"Brown",30,50,50,true, 50);
        Properties VermontAvenue= new Properties("Vermont Avenue",6,false,30,90,270,400,450,"Brown",30,50,50,true, 50);

        board.put(2,MediterraneanAv);
        board.put(4,BalticAvenue);

    */
           int[] PropertiesLocation = new int[]{1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
       for (int x = 0; x<22;x++){
            board.put(PropertiesLocation[x],getproperties(x));

       }

        return board;
    }

    public Cards getBoardprop(int x) {
        return this.Boardprop.get(x);
    }

    public void setBoardprop(Dictionary<Integer, Cards> boardprop) {

        this.Boardprop = boardprop;
    }
}
