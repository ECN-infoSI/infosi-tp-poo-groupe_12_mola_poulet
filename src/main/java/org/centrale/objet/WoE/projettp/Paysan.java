/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author Amolz
 */
public class Paysan extends Personnage implements IA,Sauvegarde {
    
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

    /**
     *
     * @param ligne
     * Génère un paysan sauvegardé
     */
    public Paysan(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        s=tokenizer.nextToken();
        this.setNom(s);
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
        this.setDistAttMax(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setX(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setY(Integer.parseInt(s));
        
    }

    /**
     *
     * @param monde
     * Tour d'un paysan
     */
    @Override
    public void tourIA(World monde){
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
    }  

    /**
     *
     * @return
     * Sauvegarde d'un paysan
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Paysan "+this.getNom()+" "+this.getPtVie()+" "+this.getDegAtt()+" "+this.getPtPar()+" "+this.getPageAtt()+" "+this.getPagePar()+" "+this.getDistAttMax()+" "+this.getPos().getX()+" "+this.getPos().getY()));
        return s;
    }
}
