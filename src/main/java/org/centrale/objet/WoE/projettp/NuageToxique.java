package org.centrale.objet.WoE.projettp;

import static java.lang.Math.max;
import java.util.ArrayList;
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
    
    
    public void deplace(int dx, int dy,World monde){
        if (this.getPos().getX()+dx<monde.getLongueur() && this.getPos().getY()+dy<monde.getLargeur() && monde.getListeEntite()[this.getPos().getX()+dx][this.getPos().getY()+dy]!=null){
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=null;
           this.getPos().translate(dx, dy);
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=this;
        }
    }
    @Override
  
    public void deplace(World monde){
        
        int sens=this.getDirection()%8+1;/*permet d'assurer que n est ompris entre 1 et 8*/
        
                switch (sens){
            case 1 :
                this.deplace(0, 1,monde);//nord
                break;
            case 2 :
                this.deplace(1, 1,monde);//nord-estS
                break;
            case 3 : 
                this.deplace(1,0,monde);//est
                break;
            case 4 :
                this.deplace(1, -1,monde);//sud-est
                break;
            case 5 : 
                this.deplace(0, -1,monde);//sud
                break;
            case 6 :
                this.deplace(-1, -1,monde);//sud-ouest
                break;
            case 7 : 
                this.deplace(-1,0,monde);//ouest
                break;
            case 8 :
                this.deplace(-1,1,monde);//nord-ouest
                break;

        }
    }
    /**
     *
     * @param ennemi
     * Inflige des degats constants a la creature si elle se situe dans le nuage
     */
    @Override
    public void combattre(Creature ennemi){
        
       
    }
    public void combattre (ArrayList<Creature> ennemis){
        for (Creature ennemi:ennemis){
            
            ennemi.setPtVie(max(0, ennemi.getPtVie() - this.getDeg()));
        }
        
    }
    @Override
    public ArrayList<Creature> peutCombattre(World monde){
        ArrayList<Creature> tab=new ArrayList<>();
        for (int i=0;i<monde.getLongueur();i++){
            for(int j=0;j<monde.getLargeur();j++){
                if (monde.getListeEntite()[i][j]!=null && monde.getListeEntite()[i][j] instanceof Creature){
                    if (this.getPos().distance(monde.getListeEntite()[i][j].getPos())<=this.rayonAtt){
                        tab.add((Creature)monde.getListeEntite()[i][j]);
                    }
                }
            }
        }
         return tab;
    }
}
