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
    /**
     * @param pv Nombre de points de vie rendus
     * 
     */
    public PotionSoin(int pv){
        this.pvRendus=pv;
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
     * @param pvRendus
     */
    public void setPvRendus(int pvRendus) {
        this.pvRendus = pvRendus;
    }  
}
