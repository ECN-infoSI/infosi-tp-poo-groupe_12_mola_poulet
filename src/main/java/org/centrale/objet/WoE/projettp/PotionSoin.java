/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class PotionSoin extends Objet {
    private int pvRendus;
    private Point2D pos;
    /**
     * @param pv Nombre de points de vie rendus
     * @param p
     * 
     */
    public PotionSoin(int pv,Point2D p){
        this.pvRendus=pv;
        this.pos=new Point2D (p);
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
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pvRendus
     */
    public void setPvRendus(int pvRendus) {
        this.pvRendus = pvRendus;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}
