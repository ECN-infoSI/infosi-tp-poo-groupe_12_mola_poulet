/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author Amolz
 */
public class Paysan extends Personnage{
    
    /**
     *
     * @param name Nom du paysan
     * @param pV Nombre de points de vie
     * @param dA Points d'attaque
     * @param pPar Points de parade
     * @param paAtt Pourcentage de réussite attaque
     * @param paPar Pourcentage de réussite parade
     * @param dMax Distance max
     * @param p Position
     */
    public Paysan(String name, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(name, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     *
     * @param villager Paysan à copier
     */
    public Paysan(Paysan villager) {
        super((Personnage) villager);
    }

    /**
     *
     */
    public Paysan(){
        super();
    }  
}
