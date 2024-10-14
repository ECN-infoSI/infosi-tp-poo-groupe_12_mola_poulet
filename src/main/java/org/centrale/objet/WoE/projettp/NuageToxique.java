package org.centrale.objet.WoE.projettp;

import static java.lang.Math.max;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class NuageToxique extends Objet implements Deplacable, Combattant{
    
    private int deg;
    private int rayonAtt;
    private int direction;
    
    /**
     *
     * @param damage
     * @param taille
     * @param directionDep
     * @param position
     */
    public NuageToxique(int damage, int taille, int directionDep, Point2D position){
        super(position);
        
        deg = damage;
        rayonAtt = taille;
        direction = directionDep;
    }
    
    /**
     *
     * @param poisonCloud
     */
    public NuageToxique(NuageToxique poisonCloud){
        super((Objet) poisonCloud);
        
        this.deg = poisonCloud.deg;
        this.rayonAtt = poisonCloud.rayonAtt;
        this.direction = poisonCloud.direction;
    }
    
    /**
     *
     */
    public NuageToxique(){
        super();
    }

    /**
     *
     * @return
     */
    public int getDeg() {
        return deg;
    }

    /**
     *
     * @return
     */
    public int getRayonAtt() {
        return rayonAtt;
    }

    /**
     *
     * @return
     */
    public int getDirection() {
        return direction;
    }

    /**
     *
     * @param deg
     */
    public void setDeg(int deg) {
        this.deg = deg;
    }

    /**
     *
     * @param rayonAtt
     */
    public void setRayonAtt(int rayonAtt) {
        this.rayonAtt = rayonAtt;
    }

    /**
     *
     * @param direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * le deplacement est decide par l'attribut direction, 0 pour le nord, 1 pour le nord-est, 2 pour l'est, etc...
     */
    public void deplace(){
        
        int sens=this.getDirection()%8+1;/*permet d'assurer que n est ompris entre 1 et 8*/
        
        switch (sens){
            case 1 :
                this.getPos().translate(0, 1);//nord
                break;
                
            case 2 :
                this.getPos().translate(1, 1);//nord-estS
                break;
                
            case 3 : 
                this.getPos().translate(1,0);//est
                break;
                
            case 4 :
                this.getPos().translate(1, -1);//sud-est
                break;
                
            case 5 : 
                this.getPos().translate(0, -1);//sud
                break;
                
            case 6 :
                this.getPos().translate(-1, -1);//sud-ouest
                break;
                
            case 7 : 
                this.getPos().translate(-1,0);//ouest
                break;
                
            case 8 :
                this.getPos().translate(-1,1);//nord-ouest
                break;
        }            
    }
    /**
     *
     * @param ennemi
     * Inflige des degats constants a la creature si elle se situe dans le nuage
     */
    public void combattre(Creature ennemi){
        
        if (this.getPos().distance(ennemi.getPos())<=this.getRayonAtt()){
            
            ennemi.setPtVie(max(0, ennemi.getPtVie() - this.getDeg()));
        }
        
    }
}
