/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Objet {
    private Point2D pos;//position
    //Constructeurs
    /**
     * @param p Position
     */
    public Objet(Point2D p){
        this.pos=new Point2D(p);
    }

    /**
     *
     */
    public Objet(){
    }

    /**
     *
     * @param o copie profonde d'un objet
     */
    public Objet(Objet o){
        this.pos=new Point2D(o.pos);
    }
    //getters

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }
    
    //setters

    /**
     *
     * @param pos
     */

    public void setPos(Point2D pos) {
        this.pos.setPosition(pos.getX(), pos.getY());
    }
    //méthodes
    /**
     * Affiche les attributs de l'objet
     */
    public void affiche(){
        this.getPos().affiche();
    }
}
