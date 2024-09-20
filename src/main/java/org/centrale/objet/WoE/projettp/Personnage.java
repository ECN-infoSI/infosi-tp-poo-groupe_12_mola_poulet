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
     * 
     * @param name
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p 
     */
    public Personnage(String name,int pV,int dA,int pPar,int paAtt, int paPar, int dMax, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
        nom = name;
        distAttMax = dMax;

    }

    /**
     *
     * @param perso
     */
    public Personnage(Personnage perso){
        super((Creature) perso);
        this.nom = perso.nom;
        this.distAttMax = perso.distAttMax;
        this.pos=new Point2D (perso.pos);
        
    }

    /**
     *
     */
    public Personnage(){
        
    }
    

}
