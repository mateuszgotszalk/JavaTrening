package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main extends JFrame {

    public Main(){
        this.setTitle("Animacja");
        this.setBounds(400,200,500,400);
        JButton button1 = (JButton)panelPrzyciskow.add(new JButton("Start"));
        panel2.setBackground(Color.GRAY);
        button1.addActionListener(e -> {
            try {
                startAnimation();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        this.getContentPane().add(panel2);
        this.getContentPane().add(panelPrzyciskow,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void startAnimation() throws InterruptedException {
        panel2.addKropelka();
    }

    private PanelAnimation panel2 = new PanelAnimation();
    private JPanel panelPrzyciskow = new JPanel();
    public static void main(String[] args) {

        new Main().setVisible(true);
    }
    class PanelAnimation extends JPanel{

        public void addKropelka() throws InterruptedException {

            for (int i =0; i<40;i++){
                kolo.x++;
                kolo.y++;
                this.paint(this.getGraphics());

                Thread.sleep(5);

            }
        }
        Kolko kolo = new Kolko();

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            g.setColor(Color.GREEN);
            g.drawOval(kolo.x,kolo.y,kolo.promien,kolo.promien);

        }
    }

}
class Kolko {
    int x;
    int y;
    int promien;
    int dx=1;
    int dy=1;

    Kolko()
    {
        x = 15;
        y = 15;
        promien = 20;
    }
}