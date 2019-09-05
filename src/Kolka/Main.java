package Kolka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame{

    public Main(){
        this.setTitle("Animacja");
        this.setBounds(400,200,500,400);
        JButton bttn1= (JButton)panel.add(new JButton("Siemka"));
        bttn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartAnimacji();
            }
        });

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void StartAnimacji() {

        Thread watek = new Thread(new Runnable() {
            @Override
            public void run() {
                panel.kolka.add(new Kolko());
                for(int j=0;j<3000;j++){
                    panel.kolka.get(panel.kolka.size()-1).x += panel.kolka.get(panel.kolka.size()-1).dx;
                    panel.kolka.get(panel.kolka.size()-1).y += panel.kolka.get(panel.kolka.size()-1).dy;

                    if ((panel.kolka.get(panel.kolka.size()-1).y +10)>= getBounds().getMaxY()) {
                        panel.kolka.get(panel.kolka.size()-1).y =  (int)(getBounds().getMaxY()-10);
                        panel.kolka.get(panel.kolka.size()-1).dy = -(panel.kolka.get(panel.kolka.size()-1).dy);
                    }
                    if ((panel.kolka.get(panel.kolka.size()-1).x +10)>= getBounds().getMaxX()){
                        panel.kolka.get(panel.kolka.size()-1).x =  (int)(getBounds().getMaxX()-10);
                        panel.kolka.get(panel.kolka.size()-1).dx = -(panel.kolka.get(panel.kolka.size()-1).dx);
                    }
                    if ((panel.kolka.get(panel.kolka.size()-1).y)<= getBounds().getMinY()) {
                        panel.kolka.get(panel.kolka.size()-1).y =  (int)(getBounds().getMinY());
                        panel.kolka.get(panel.kolka.size()-1).dy = -(panel.kolka.get(panel.kolka.size()-1).dy);
                    }
                    if ((panel.kolka.get(panel.kolka.size()-1).x)<= getBounds().getMinX()) {
                        panel.kolka.get(panel.kolka.size()-1).x =  (int)(getBounds().getMinX());
                        panel.kolka.get(panel.kolka.size()-1).dx = -(panel.kolka.get(panel.kolka.size()-1).dx);
                    }

                    try{
                        Thread.sleep(3);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                    repaint();
                }
            }
        });

        watek.start();
    }

    public static void main(String[] args) {

        new Main().setVisible(true);
    }
    private PanelRys panel = new PanelRys();
}
class PanelRys extends JPanel{
    public PanelRys(){
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i =0; i<kolka.size();i++){
            g.drawOval(kolka.get(i).x,kolka.get(i).y,kolka.get(i).promien,kolka.get(i).promien);
        }

    }
    ArrayList<Kolko> kolka = new ArrayList();

}
class Kolko {
    int x=15;
    int y=15;
    int promien=10;
    int dx=1;
    int dy=1;

}