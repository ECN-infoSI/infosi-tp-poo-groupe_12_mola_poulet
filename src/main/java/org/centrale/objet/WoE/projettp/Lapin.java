/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Lapin extends Monstre{
    public Lapin(int pV, int dA, int pPar, int paAtt,int paPar, Point2D p){
        super(pV,dA,pPar,paAtt,paPar,p);
    }

    public Lapin(Lapin l) {
        super((Monstre)l);
    }

    public Lapin() {
    }
    
}
