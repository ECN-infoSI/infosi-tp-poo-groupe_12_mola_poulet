/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author clesp
 */
public class Lapin extends Monstre implements IA,Sauvegarde{

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

    /**
     *
     * @param ligne
     * Génération d'un lapin sauvegardé
     */
    public Lapin(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        s=tokenizer.nextToken();
        this.setPtVie(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setDegAtt(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPtPar(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPageAtt(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPagePar(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setX(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setY(Integer.parseInt(s));
    }
    
    /**
     *
     * @param monde
     * Tour d'un lapin IA
     */
    @Override
    public void tourIA(World monde){
        //déplacement aléatoire
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
    }   

    /**
     *
     * @return
     * sauvegarde d'un lapin
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Lapin "+this.getPtVie()+" "+this.getDegAtt()+" "+this.getPtPar()+" "+this.getPageAtt()+" "+this.getPagePar()+" "+this.getPos().getX()+" "+this.getPos().getY()));
        return s;
    }
}
