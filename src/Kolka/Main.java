package Kolka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends JFrame{

    public Main(){
        this.setTitle("Animacja");
        this.setBounds(400,200,500,400);
        JButton bttn1= (JButton)panelB.add(new JButton("Siemka"));
        panelRys.setBackground(Color./*LIGHT_*/GRAY);
        ;
        bttn1.addActionListener(e -> StartAnimacji());

        this.getContentPane().add(panelB, BorderLayout.SOUTH);
        this.getContentPane().add(panelRys);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void StartAnimacji() {

        panelRys.addKolko();
    }

    private JPanel panelB = new JPanel();
    private PanelRys panelRys = new PanelRys();

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}


class PanelRys extends JPanel{

    LinkedList<Kolko> kolka = new LinkedList();

    public void addKolko(){
        kolka.add(new Kolko());
        Thread thread = new Thread(new KolkoThread(kolka.get(kolka.size()-1)));
        thread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i =0; i<kolka.size();i++){
            g.drawOval(kolka.get(i).x,kolka.get(i).y,kolka.get(i).promien,kolka.get(i).promien);
        }

    }
    JPanel ten = this;
    public class KolkoThread implements Runnable {

        Kolko kolo;

        public KolkoThread(Kolko kolo){
            this.kolo = kolo;
        }


        @Override
        public void run() {
            for(int i =0;i<3000;i++){
                    this.kolo.ruszKolkiem(ten);
                    repaint();
                    try{
                        Thread.sleep(3);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

}

class Kolko {
    int x = 5;
    int y = 5;
    int promien = 10;
    int dx = 1;
    int dy = 1;

    public void ruszKolkiem(JPanel pojemnik) {


        Rectangle krawedzieOkna = pojemnik.getBounds();
                x += dx;
                y += dy;

                if ((y + 10) >= krawedzieOkna.getMaxY()) {
                    y = (int) (krawedzieOkna.getMaxY() -15);
                    dy = -dy;
                }
                if ((x + 10) >= krawedzieOkna.getMaxX()) {
                    x = (int) (krawedzieOkna.getMaxX() - 15);
                   dx = -dx;
                }
                if (y < krawedzieOkna.getMinY()) {
                    y = (int) (krawedzieOkna.getMinY());
                    dy = -dy;
                }
                if (x <  krawedzieOkna.getMinX()) {
                   x = (int) (krawedzieOkna.getMinX());
                    dx = -dx;
                }

    }
}