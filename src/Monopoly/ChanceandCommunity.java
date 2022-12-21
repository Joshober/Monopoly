package Monopoly;

import Monopoly.Cards;

import java.util.Random;

class  ChanceandCommunityCards extends Cards {//Child Class specifically for making community and chance cards
    int money;
    int move;

    ChanceandCommunityCards(String name, String text) {
        super(name, text);
    }

   public Players Communitycards(Players p){
        Random r = new Random();
        String text;
       int x = r.nextInt(14);
       switch(x) {

           case 0:
               text = "Advance to go";
               p.setPosition(0);
               p.addCash(200);
               break;
           case 1:
               text = "Bank error in your favor. You get $200!";
               p.addCash(200);
               break;
           case 2:
               text = "Doctors fee. You lose $50!";
               p.DeductCash(50);
               break;
           case 3:
               text = "From sale of stock you get $45";
               p.addCash(45);
               break;
           case 4:
               text = "Get Out of Jail Free!";
               p.setInjail(false);
               break;
           case 5:
               text = "Go to Jail!";
               p.goToJail();
               break;

           case 6:
               text = "Xmas Fund Matures. You get $100!";
               p.addCash(100);
                break;
           case 7:
               text = "Income Tax Refund";
               p.addCash(20);
               break;
           case 8:
               text = "Life Insurance Matures";
               p.addCash(100);
               break;
           case 9:
               text= "Pay Hospitall $100";
               p.DeductCash(100);
               break;
           case 10:
               text = "Pay School Tax";
               p.DeductCash(150);
               break;
           case 11:
               text= "Receive For Services";
                p.DeductCash(150);
                break;
           case 12:
               text = "You won Second Prize in a beauty contest";
               p.addCash(10);
               break;
           case 13:
               text = "You Inherit $100";
                p.addCash(100);
                break;

       }
       return p;
   }
   public Players Chancecards(Players p){
       Random r = new Random();
       String text;
       int x = r.nextInt(6);
       switch(x) {
           case 0:
               text = "Advance to go";
               p.setPosition(0);
               p.addCash(200);
               break;
           case 1:
               text= "Advance to Illinois Ave";
               if(p.getPosition()>25){
                   p.addCash(200);
               }
               p.setPosition(24);
            break;
           case 2:
               text= "Advance to BoardWalk";
               p.setPosition(38);



               break;
           case 3:
               text="Get out of jail free";
               p.setInjail(false);

           case 4:
               text = "Go back 3 spaces";
               p.setPosition(p.getPosition()-3);
           case 5:
               text = "Go to Jail";
               p.goToJail();
       }
       return p;
       }

   }

