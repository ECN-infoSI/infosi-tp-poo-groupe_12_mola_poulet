/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.StringTokenizer;


/**
 *
 * @author clesp
 */
public class PotionSoin extends Objet implements Utilisable, Ramassable,Sauvegarde{
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
     * @param ligne
     * Génération d'une potion sauvegardée
     */
    public PotionSoin(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        if(s.equals("Inventaire")){
            s=tokenizer.nextToken();
        }
        s=tokenizer.nextToken();
        this.pvRendus=Integer.parseInt(s);
        s=tokenizer.nextToken();
        this.getPos().setX(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setY(Integer.parseInt(s));
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
    
    /**
     *
     * @param player
     * utilisation d'une potion
     */
    @Override
    public void utilisation(Joueur player){
        
        Personnage mainCharacter = player.getPerso();
        
        mainCharacter.setPtVie(mainCharacter.getPtVie() + this.pvRendus);
        player.getInventaire().getContenu().remove(this);
        
    }

    /**
     *
     * @return
     * sauvegarde d'une potion
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("PotionSoin "+this.pvRendus+" "+this.getPos().getX()+" "+this.getPos().getY()));
        return s;
    }
}
