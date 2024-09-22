/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Loup extends Monstre{
    //constructeurs

    /**
     *
     * @param pV Points de vie
     * @param dA Dégâts d'attaque
     * @param pPar Points de parade
     * @param paAtt Pourcentage réussite attaque
     * @param paPar Pourcentage réussite parade
     * @param p Position
     */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    /**
     *
     * @param l copie profonde d'un loup
     */
    public Loup(Loup l) {
        super((Monstre)l);
    }

    /**
     *
     */
    public Loup() {
    }
}
