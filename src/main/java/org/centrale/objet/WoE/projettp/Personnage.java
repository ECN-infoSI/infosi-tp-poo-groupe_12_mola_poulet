package org.centrale.objet.WoE.projettp;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class Personnage extends Creature{
    private String nom; //nom du personnage
    private int distAttMax; //distance d'attaque maximale du personnage

    
    /**
     * Construit un personnage
     * @param name Nom
     * @param pV Points de vie
     * @param dA Points d'attaque
     * @param pPar Points de parade
     * @param paAtt Pourcentage réussite attaque
     * @param paPar Pourcentage reussite parade
     * @param dMax Distance max
     * @param p Position
     */
    public Personnage(String name,int pV,int dA,int pPar,int paAtt, int paPar, int dMax, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
        nom = name;
        distAttMax = dMax;

    }

    /**
     *
     * @param perso Personnage à copier
     */
    public Personnage(Personnage perso){
        super((Creature) perso);
        this.nom = perso.nom;
        this.distAttMax = perso.distAttMax;
        
    }

    /**
     *
     */
    public Personnage(){
        super();
        this.nom="Personnage lambda";
        this.distAttMax=1;
        
    }
    //getters

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }
    
    //setters

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    //Méthodes
    /**
     * Méthode permettant de se soigner via une potion puis de supprimer 
     * la potion du terrain (et de la mémoire)
     * @param pot Potion
     */
    /**
     * Affiche les attributs du personnage
     */
    @Override
    public void affiche(){
        System.out.println("Nom "+this.nom+"\n"+"pv "+this.getPtVie()+"\n"+"att "+this.getDegAtt()+"\n"+"Par "+this.getPtPar()+"\n"+"PaAtt "+this.getPageAtt()+"\n"+"PaPar "+this.getPagePar()+"\n"+"Distance attaque max "+this.distAttMax);
        this.getPos().affiche();
    }
    public void combattre(Creature ennemi){
        
    }
    public ArrayList<Creature> peutCombattre(World monde){
        
        return null;
        
    }
}

