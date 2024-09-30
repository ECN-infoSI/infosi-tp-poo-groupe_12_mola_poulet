package org.centrale.objet.WoE.projettp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public abstract class Entite {
    
    private Point2D pos; //position de l'entite
    
    /**
     *
     * @param position Position de l'entite
     */
    public Entite(Point2D position){
        pos = new Point2D(position);
    }
    
    /**
     *
     * @param thing copie profonde d'une entite
     */
    public Entite(Entite thing){
        this.pos = new Point2D(thing.pos);
    }
    
    /**
     *
     */
    public Entite(){
        this.pos=new Point2D(0,0);
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void affiche(){}
            
}
