/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Arthur
 */
public abstract class Carta implements Comparable {
    
    //Teste
    protected int numero;
    protected int naipe;
    protected boolean enable;
    protected int jogador;
    protected Image sprite;
    protected int multiplicador;
    protected boolean realizouAcao = false;

    @Override
    public int compareTo(Object t) {
        if (t instanceof Carta){
            if (this.numero == ((Carta) t).numero){
                if (this.naipe == ((Carta) t).naipe)
                    return 0;
                return (this.naipe > ((Carta) t).naipe) ? 1:-1;
            }
            return (this.numero > ((Carta) t).numero) ? 1:-1;
        }
        return 0;
    }

    public abstract boolean Acao(Object o);
    
    private String NumeroToString(){
        switch(this.numero){
            case 1:
                return "ace";
            case 11:
                return "jack";
            case 12:
                return "queen";
            case 13:
                return "king";
            default:
                return String.valueOf(this.numero);
        }
    }
    
    private String NaipeToString(){
        switch(this.naipe){
            case 0:
                return "clubs";
            case 1:
                return "diamonds";
            case 2:
                return "hearts";
            case 3:
                return "spades";
            default:
                return "clubs";
        }
    }
    
    
    public Carta (int n) {
        this.numero = (n % 13) + 1;
        this.naipe = n / 13;
        this.multiplicador = 1;
        
        String imgPath = "img/" + this.NumeroToString() + "_of_" + this.NaipeToString() + ".png";
        //imgPatch = "img/2_of_clubs"
        if(this.sprite == null){
            try {
                sprite = ImageIO.read(new File(imgPath));
            } catch (IOException ex) {
                Logger.getLogger(Carta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Draw(Graphics2D g, int x, int y) {
        int sizeHeight = g.getClip().getBounds().height / 6 - 6;
        int sizeWidth = g.getClip().getBounds().width / 10 - 6;
        
        sizeHeight = 94;
        sizeWidth = 74;
        
        g.drawImage(sprite, x, y, sizeWidth, sizeHeight, null);
        
        
    }
    
    public void Enable () {
        enable = true;
    }
    
    public void Disable() {
        enable = false;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getNaipe() {
        return naipe;
    }

    public boolean isEnabled() {
        return enable;
    }

    public int getJogador() {
        return jogador;
    }

    public int getMultiplicador() {
        return multiplicador;
    }
    
}
