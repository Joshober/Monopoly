package Monopoly;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import javax.sound.sampled.Line;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//Dice Class to do rolls and return a list of rolls that the character needs to move
public class Dice extends JPanel {

Random r =new Random();
int doubles = 0;
int values = 1;
private int value;
private int value2;
    public Dice( ) {

    }
    public Dice(int xCoord, int yCoord, int width, int length, String labelString) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, length);
    }

    public ArrayList move(ArrayList moves, Dice d1){//Rolls the dice then stores the values to an array while also checking for doubles and if
         moves.clear();
       boolean turn =true;
         while (turn == true) {
             d1.roll();
             moves.add(d1.value + d1.value2);

             if (d1.checkfordoubles() != true) {
                 turn = false;
             }

         }
        return moves;
    }
    private int getroll1(){
       return this.value;
    }//Private methods to get the dice rolls for the move method
    private int getroll2(){
        return this.value;
    }
    private boolean checkfordoubles(){//Private method to check doubles for move method
       if (this.value == this.value2)
        return true;
       else{
           return false;
       }
    }
    public void roll (){//Private method for rolling dice
        this.value = r.nextInt(6)+1;
        this.value2 = r.nextInt(6)+1;
        repaint();
    }





    //}

}


