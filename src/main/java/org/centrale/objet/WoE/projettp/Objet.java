/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Objet extends Entite {
    
    private Point2D pos;//position
    
    //Constructeurs
    /**
     * @param p Position
     */
    public Objet(Point2D p){
        super(p);
    }

    /**
     *
     */
    public Objet(){
        this.pos=new Point2D(0,0);
    }

    /**
     *
     * @param o copie profonde d'un objet
     */
    public Objet(Objet o){
        super((Entite) o);
    }

    //méthodes
    /**
     * Affiche les attributs de l'objet
     */
    @Override
    public void affiche(){
        this.getPos().affiche();
    }
}
