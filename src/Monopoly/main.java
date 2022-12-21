package Monopoly;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class main extends JFrame{

    public static void main(String[] args) throws IOException, InterruptedException {//Main method that will make the players
//

        Turns t =new Turns(4);
    }

//
//        /*for(int xx=0; xx<40; xx++){
//
//            System.out.println(xx+(board.getBoardprop(xx)).getName());
//        }
//*/
//        Dice die1 = new Dice();
//        int playersleft = 4;
//        dBoard board = new dBoard();
//        Properties s = new Properties();
//        Properties x = (Properties) (board.getBoardprop(1));
//        Players p1 = new Players("Car");
//        Players p2 = new Players("Boat");
//        Players p3 = new Players("Arch");
//        Players p4 = new Players("Cat");
//        String winner = null;
//        Players[] plist = new Players[4];
//        plist[0] = p1;
//        plist[1] = p2;
//        plist[2] = p3;
//        plist[3] = p4;
//        while (true) {
//            for (int i = 0; i < 4; i++) {
//                playersleft = 4;
//                plist[i]=PlayerTurn(plist[i], die1, board);
//
//                if(plist[i].isLostthegame()){
//                    playersleft=-1;
//                }
//            }
//            if(playersleft==1){
//                winner ="Winner";
//            }
//        }
//    }
//
//    public static Players PlayerTurn(Players p, Dice d, dBoard b) {
//
//        if (!p.isLostthegame()) {
//            int roll = p.takeTurn(d);
//
//            if (roll == 99) {
//                p.getInjail();
//                p.setPosition(10);
//            } else {
//                Cards s = b.getBoardprop(p.getPosition());
//                String ss = String.valueOf(b.getBoardprop(p.getPosition()).getClass());
//
//                        /*
//                        for(int x=0; x<Proplist.length;x++){
//                   if (Proplist[x]==p.getPosition()) {
//                       b.getBoardprop(p.getPosition());
//
//                   }
//               }
//
//
//
//                          }
//                         */
//                p.setPosition((p.getPosition() + roll));
//                if(p.getPosition()>39){
//                    p.setPosition(p.getPosition()-39);
//                    p.addCash(200);
//                }
//
//            Move(p,b, String.valueOf(b.getBoardprop(p.getPosition()).getClass()));
//
//
//
//
//            }
//        }
//            return p;
//    }
//    public static Players Move(Players p, dBoard b, String cname){
//    //    System.out.print(cname);
//        switch (cname) {
//            case "class Monopoly.ChanceandCommunityCards":
//                ChanceandCommunityCards cc =(ChanceandCommunityCards) b.getBoardprop(p.getPosition());
//                if(cc.getName() == "Chance")
//                    p= cc.Chancecards(p);
//                else
//                    p=cc.Communitycards(p);
//                break;
//            case "class Monopoly.Properties":
//                Properties prop =(Properties) b.getBoardprop(p.getPosition());
//                if(prop.getOwner() == null){
//                    //option to buy
//                   // buyProperty(p, b, String.valueOf(b.getBoardprop(p.getPosition()).getClass()));
//
//                }
//                else{
//                    int rent = prop.getRent();
//                }
//
//                break;
//            case "class Monopoly.Railroads":
//                Railroads r =(Railroads) b.getBoardprop(p.getPosition());
//                if(r.getOwner() == null){
//                    //option to buy
//                    int price = r.getPrice();
//
//                }
//                else{
//                    int rent = r.setrent(p);
//                }
//
//                break;
//            case "class Monopoly.Utility":
//                Utility u =  (Utility) b.getBoardprop(p.getPosition());
//                if(u.getOwner()==null){
//
//                }
//                else{
//                    p.DeductCash( u.setrent(u.getOwner()));
//
//                }
//
//                break;
//
//            case "class Monopoly.taxes":
//                taxes t = (taxes)b.getBoardprop(p.getPosition());
//                if(b.getBoardprop(p.getPosition()).getName()=="Income Taxes"){
//                    p.DeductCash(t.getIncomeTax(p));
//                }
//                else{
//                    p.DeductCash(t.getLuxuryTax());
//                }
//                break;
//            case "class Monopoly.Cards":
//                switch (b.getBoardprop(p.getPosition()).getName()){
//                    case "Go":
//                        p.addCash(200);
//                        break;
//
//
//                    case "Jail":
//
//                        break;
//                    case "Free Parking":
//
//                        break;
//                    default:
//
//                }
//                break;
//            default:
//
//                break;
//
//        }
//        return p;
//    }
//    public Players buyProperty(Players p, dBoard b,String ss) {
//
//        int price= 0;
//        switch (ss){
//            case "class Monopoly.Railroads":
//                Railroads r =(Railroads)b.getBoardprop(p.getPosition());
//                price = r.getPrice();
//
//            case "class Monopoly.Properties":
//
//            default:
//                System.out.println("Cant buy this");
//                break;
//
//
//            }
//        if(p.getMoney()-price<0) {
//            System.out.println("Not enough cash");
//        }
//            else{
//                p.DeductCash(price);
//                p.getProperties().add(b.getBoardprop(p.getPosition()));
//        }
//
//
//            b.getBoardprop(p.getPosition());
//
//        return p;

      //  btnRollDice = new JButton("Roll Dice");
      //  btnRollDice.addActionListener(new ActionListener() {
//
//    }


}