/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;
/**
 *
 * @author clesp
 * 
 */
public class Monstre extends Creature {

    //constructeurs

    /**
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     */
    public Monstre (int pV, int dA, int pPar, int paAtt,int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    //constructeur par copie

    /**
     *
     * @param m
     */
    public Monstre(Monstre m){
        super((Creature) m);
    }

    /**
     *
     */
    public Monstre(){
    }
}
