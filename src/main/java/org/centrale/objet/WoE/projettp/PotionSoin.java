/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class PotionSoin extends Objet implements Utilisable{
    private int pvRendus;
    /**
     * @param pv Nombre de points de vie rendus
     * @param p
     * 
     */
    public PotionSoin(int pv,Point2D p){
        super(p);
        this.pvRendus=pv;
    }

    /**
     *
     */
    public PotionSoin(){
        super();
        this.pvRendus=20;
    }

    /**
     *
     * @return
     */
    public int getPvRendus() {
        return pvRendus;
    }


    /**
     *
     * @param pvRendus
     */
    public void setPvRendus(int pvRendus) {
        this.pvRendus = pvRendus;
    }  
    //Méthodes
    /**
     * Affiche les attributs de la potion
     */
    @Override
    public void affiche(){
        System.out.println("Potion : "+"\n"+"Nombre de points de vie rendus "+this.pvRendus);
    }
    
    @Override
    public void utilisation(Joueur player){
        
        Personnage mainCharacter = player.getPerso();
        
        mainCharacter.setPtVie(mainCharacter.getPtVie() + this.pvRendus);
        player.getInventaire().getContenu().remove(this);
        
    }
}
