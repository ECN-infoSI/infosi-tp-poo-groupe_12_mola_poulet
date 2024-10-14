/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author clesp
 */
public class Lapin extends Monstre{

    /**
     *
     * @param pV Nombre de Points de vie
     * @param dA Points d'attaque
     * @param pPar Points de parade
     * @param paAtt Pourcentage de réussite attaque
     * @param paPar Pourcentage de réussite parade
     * @param p Position
     */
    public Lapin(int pV, int dA, int pPar, int paAtt,int paPar, Point2D p){
        super(pV,dA,pPar,paAtt,paPar,p);
    }

    /**
     *
     * @param l Copie d'un lapin
     */
    public Lapin(Lapin l) {
        super((Monstre)l);
    }

    /**
     *
     */
    public Lapin() {
        super();
    }
    @Override
    public void tourIA(World monde){
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
    }   
}
