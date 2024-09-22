package org.centrale.objet.WoE.projettp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clesp
 */
public class Guerrier extends Personnage {
    private Epee arme;
    
    //Constructeurs

    /**
     *
     * @param name Nom
     * @param pV Points de vie
     * @param dA Dégâts attaque
     * @param pPar Point de parade
     * @param paAtt Pourcentage de réussite attaque
     * @param paPar Pourcentage de réussite parade
     * @param dMax Distance attaque max
     * @param arme Arme
     * @param p Position
     */
    public Guerrier(String name,int pV,int dA,int pPar,int paAtt, int paPar, int dMax,Epee arme, Point2D p){
        super(name,pV,dA,pPar,paAtt,paPar,dMax,p);
        this.arme=arme;
    }

    /**
     *
     */
    public Guerrier(){
    }

    /**
     *
     * @param g Copie profonde d'un guerrier
     */
    public Guerrier(Guerrier g){
        super((Personnage) g);
        this.arme=new Epee(g.arme);
    }
    //getters

    /**
     *
     * @return
     */
    public Epee getArme() {
        return arme;
    }
    
    //setters

    /**
     *
     * @param arme
     */

    public void setArme(Epee arme) {
        this.arme.setBonus(arme.getBonus());
    }
    
    //méthodes
    
    /**
     * Affiche les attributs d'un guerrier
     */
    @Override
    public void affiche(){
        System.out.println("Nom "+this.getNom()+"\n"+"pv "+this.getPtVie()+"\n"+"att "+this.getDegAtt()+"\n"+"Par "+this.getPtPar()+"\n"+"PaAtt "+this.getPageAtt()+"\n"+"PaPar "+this.getPagePar()+"\n"+"Distance attaque max "+this.getDistAttMax());
        this.getArme().affiche();
        this.getPos().affiche();
    }
}
