/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Archer extends Personnage {
    private int nbFleches;

    /**
     *
     * @param nom Nom de l'archer
     * @param pV Nombre de points de vie de l'archer
     * @param dA Points d'attaque de l'archer
     * @param pPar Point de parade
     * @param paAtt Pourcentage de réussite de l'attaque
     * @param paPar Pourcentage de réussite de la parade
     * @param dMax Distance max 
     * @param p Position
     * @param nbFleches Nombre de flèches
     */
    public Archer(String nom,int pV, int dA, int pPar, int paAtt,int paPar,int dMax, Point2D p,int nbFleches){
        super(nom,pV,dA,pPar,paAtt,paPar,dMax,p);
        this.nbFleches=nbFleches;
    }

    /**
     *
     * @param a Copie profonde d'un archer
     */
    public Archer(Archer a) {
        super((Personnage)a);
        this.nbFleches=a.nbFleches;
    }

    /**
     *
     */
    public Archer() {
    }
}
