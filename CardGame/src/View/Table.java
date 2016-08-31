/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
/**
 *
 * @author Arthur
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class Table extends JPanel {
    
    private ArrayList<Observer> observers;

    public Table() {
        observers = new ArrayList<Observer>();
    }
    
    public void registerObserver(Observer ob){
        observers.add(ob);
    }

    public void drawRetangulo (Graphics2D g) {
        int width =  getWidth()/2;
        int height = getHeight() /6;
        int margem = height /6;
        
        g.setColor (Color.WHITE);
     
        for (int i = 0; i < 5; i++) {
            g.fillRect(width /2, margem * (i+1) + height * i, width, height);
        }
        
    }
    
    @Override //sobrescrita do metodo paintComponent da classe JPanel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        drawRetangulo ((Graphics2D) g);
        Graphics2D g2 = (Graphics2D)g;
        for(Observer ob : observers){
            ob.update(null, g);
        }
    }

    

    
}