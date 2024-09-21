package org.centrale.objet.WoE.projettp;
import java.util.Random;

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
        
    }

    /**
     * Méthode permettant de se soigner via une potion puis de supprimer 
     * la potion du terrain (et de la mémoire)
     * @param pot Potion
     */
    public void soin(PotionSoin pot){
        this.setPtVie(this.getPtVie()+pot.getPvRendus());
        pot=null;
    }
}
