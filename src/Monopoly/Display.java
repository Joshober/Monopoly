package Monopoly;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Display extends  JPanel{

   private  JLabel dog = new JLabel();
    private JLabel mon = new JLabel();
    private JLabel boat = new JLabel();
    private JButton btnNextTurn = new JButton("Next Turn");
    private JButton btnRollDice = new JButton("Roll Dice");
    private JButton btnPayRent = new JButton("Pay Rent");

    public JLabel getPlot(int i) {
        return plot[i];
    }

    public void setPlot(JLabel[] plot) {
        this.plot = plot;
    }

    private JLabel[] plot = new JLabel[5];


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    private JButton btnBuy = new JButton("Buy");

    JTextArea panelPlayer1TextArea;
    JTextArea panelPlayer2TextArea;

    public Display(Turns t) throws IOException {

        //btnBuy = new JButton("Buy");

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(new LineBorder(new Color(0,0, 0)));
        rightPanel.setBounds(634, 6, 419, 600);
        rightPanel.setLayout(null);
        rightPanel.setOpaque(true);
        JTextArea infoConsole;
        JPanel playerAssestsPanel;
        CardLayout c1 = new CardLayout();
        infoConsole = new JTextArea();
        infoConsole.setColumns(20);
        infoConsole.setRows(5);
        infoConsole.setBounds(6, 6, 234, 56);
        infoConsole.setLineWrap(true);
        infoConsole.setText("Player 1 starts the game by clicking roll dice");
        infoConsole.setOpaque(true);
        btnBuy.setBounds(950, 180, 100, 80);

        btnPayRent.setBounds(800, 180, 100, 80);

        btnRollDice.setBounds(800, 413, 246, 53);

        btnNextTurn.setBounds(800, 519, 246, 53);

        Dice dice1 = new Dice(244, 406, 40, 40, "Dice1");
        Dice dice2 = new Dice(333, 406, 40, 40, "Dice2");


        btnBuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setBuybtn(true);
                infoConsole.setText(getText());
            }
        });

        btnPayRent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setRented(true);
                infoConsole.setText(getText());
            }
        });
        btnNextTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setPress(true);
                System.out.println("Worked");
                infoConsole.setText(getText());
            }
        });

        btnRollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                t.setRolling(true);



            }
        });

        JLayeredPane lplane = new JLayeredPane();
        //final ImageIcon icon = createImageIcon("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\monopolys.jpg");
        BufferedImage img = ImageIO.read(new File("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\monopolys.jpg"));
        BufferedImage img2 = ImageIO.read(new File("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\dog.png"));
        BufferedImage img3 = ImageIO.read(new File("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\ship.png"));

        ImageIcon icon2 = new ImageIcon(img2);
        ImageIcon icon = new ImageIcon(img);
        ImageIcon icon3= new ImageIcon(img3);
        BufferedImage img4 = ImageIO.read(new File("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\Racecar.jpg"));
        BufferedImage img5 = ImageIO.read(new File("C:\\Users\\Josh\\IdeaProjects\\Monopoly\\src\\Monopoly\\thumble.jpg"));
        ImageIcon icon5 = new ImageIcon(img4);
        ImageIcon icon4= new ImageIcon(img5);
        JLabel car = new JLabel();
        car.setIcon(icon5);
        JLabel themble = new JLabel();
        themble.setIcon(icon4);

        boat.setIcon(icon3);

        dog.setIcon(icon2);
        mon.setIcon(icon);
        mon.setOpaque(true);
        mon.setBounds(0, 0, 800, 803);

        lplane.setBounds(0, 0, 1200, 1000);
        plot[0] = boat;
        plot[1]= dog;
        plot[2]= car;
        plot[3]= themble;
        for (int x=0; x<4;x++){
            plot[x].setBackground(null);
            plot[x].setOpaque(true);
            plot[x].setBounds((x*5), 697, 50, 50);
            lplane.add(plot[x]);


        }
        //250,


        //dog.setIcon(icon);

        lplane.add(mon);
        lplane.add(btnBuy);



        lplane.add(btnRollDice);
        lplane.add(btnNextTurn);
        lplane.add(btnPayRent);
        lplane.add(rightPanel);
        //JWindow s = new JWindow();
        JFrame s = new JFrame();
        s.add(lplane);
        s.setBounds(0, 0, 1000, 1000);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plot[0]=this.dog;
        plot[1]=this.boat;
    }

    public void MovePiece(int i, int index)  {
       // System.out.print(i);
        int side = i/10;


      //  System.out.print("side"+side+"\n");
        i=i-(side*10);
       // System.out.println("Spaces"+i);
        switch(side){
            case 0:
               getPlot(index).setLocation(63,679-(62*i));
                break;
            case 1:
                if(63*i>0)
                    getPlot(index).setLocation((63*i)+63,0);
                else
                    getPlot(index).setLocation((63*i),0);
                break;
            case 2:
                if(63*i>0)
                    getPlot(index).setLocation(752,(63*i)+63);
                else
                    getPlot(index).setLocation(752,(63*i));
                break;
            case 3:
                if(752-(63*i)>0)
                    getPlot(index).setLocation(689-(63*i),710);
                else
                    getPlot(index).setLocation(752-(63*i),710);
                break;
        }

       //System.out.println ((this.dog).getLocation());
       // (this.dog).setLocation(this.dog.getX(),this.getY()-70);


    }

    public void showbuy() {
        this.btnBuy.setVisible(true);
    }

    public void hidebuy() {
        this.btnBuy.setVisible(false);
    }
    public void showrent() {
        this.btnPayRent.setVisible(true);
    }

    public void hiderent() {
        this.btnPayRent.setVisible(false);
    }
    public void showroll() {
        this.btnRollDice.setVisible(false);
    }

    public void hideroll() {
        this.btnRollDice.setVisible(true);
    }
    public void paintComponent(Graphics g, int facevalue) {



        switch (facevalue){
            case 1:
                g.fillOval(getWidth() / 2 - 5 / 2, getHeight() / 2 - 5 / 2, 5, 5);
                break;
            case 2:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                break;
            case 3:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 - 5 / 2, getHeight() / 2 - 5 / 2, 5, 5);
                break;
            case 4:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 + 10, 5, 5);
                break;
            case 5:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 - 5 / 2, getHeight() / 2 - 5 / 2, 5, 5);
                break;
            case 6:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 5 / 2, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 5 / 2, 5, 5);
                break;
            default:
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 15, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 + 10, 5, 5);
                g.fillOval(getWidth() / 2 - 15, getHeight() / 2 - 5 / 2, 5, 5);
                g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 5 / 2, 5, 5);
                break;
        }



    }

}
// A method calls setrent() and set to true for getting rent
// A method calls isPressed() and sets it true for moving
// A method called pbutton() and sets it to true
// A method that calls buybutton() and sets it to true