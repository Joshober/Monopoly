//Class the creates players and stores most of theyre functions

package Monopoly;
import java.util.Dictionary;
import java.util.ArrayList;
import java.util.Hashtable;

public class Players {//Creates players
    private int money=1500;
    private boolean injail=false;
    private Dictionary<String, Cards> PlayerProp  = new Hashtable<String, Cards>();;
    private String boardpice;

    public ArrayList<Cards> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Cards> properties) {
        this.properties = properties;
    }

    ArrayList<Cards> properties = new ArrayList();
    private int position = 0;
    public ArrayList<Integer> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Integer> moves) {
        this.moves = moves;
    }

    ArrayList<Integer> moves = new ArrayList();

    public boolean isLostthegame() {
        return lostthegame;
    }

    public void setLostthegame(boolean lostthegame) {
        this.lostthegame = lostthegame;
    }

    private boolean lostthegame;
     Players(String boardpice) {
        this.boardpice = boardpice;


    }
    public void goToJail(){//Takes players to jail
         setInjail(true);
         setPosition(10);

         //Move to space jail
    }
    public int takeTurn(Dice die1){//Moves players
        this.moves = die1.move(this.moves,die1);
        int move =0;
        if ((this.moves).size() <4) {
            if(this.injail == true){

                if ((this.moves).size() <3){
                    //Say you're stuck in jail
                }

            }
            for(int i =0; i< getMoves().size();i++){

               move =+ getMoves().get(i);
                //Getspace(moves[i]);
            }
            //Getspace()
        }
        else {
            move = 99;
        }
        return move;
    }
    public void setInjail(Boolean check){
         if(check==true)
         this.injail = true;
         else
         this.injail = false;
    }//Set players to jail mainly for comminity chest cards
    public boolean getInjail(){return this.injail;}
    public int getMoney(){
        return (this.money);



     }
    public Boolean checkproperties(String s){
    boolean check = false;
         if((this.getPlayerProp()).get(s)!= null){
        check = true;
    }
        return null;
    }


    public Dictionary<String, Cards> getPlayerProp() {
        return PlayerProp;
    }

    public void setPlayerProp(Dictionary<String, Cards> playerProp) {
        PlayerProp = playerProp;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public void DeductCash(int deduction){
         this.money =- deduction;
         if(this.money<0){
             setLostthegame(true);
         }
    }
    public void addCash(int addition){
        this.money =+ addition;
    }
}



