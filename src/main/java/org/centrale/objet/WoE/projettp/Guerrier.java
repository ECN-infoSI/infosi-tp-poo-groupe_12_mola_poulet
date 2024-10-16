package org.centrale.objet.WoE.projettp;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clesp
 */
public class Guerrier extends Personnage implements Combattant,IA {
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
        super();
        this.arme=new Epee();
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
    
    /**
     * Système de combat (corps à corps)
     * @param c Créature à combattre
     */
    
    public void combattre(Creature c){
        Random r=new Random();
        if (this.getPos().distance(c.getPos())<Math.sqrt(2)){
            //Case adjacente (distance inférieure à sqrt(2)
            int n=r.nextInt(101);
            if (n<=this.getPageAtt()){
                //Attaque réussie
                int k=r.nextInt(101);
                if (k>c.getPagePar()){
                    //Parade ratée
                    c.setPtVie(Math.max(c.getPtVie()-this.getDegAtt()-this.getArme().getBonus(),0));  
                }
                else{
                    //Parade réussie
                    c.setPtVie(Math.max(0,Math.min(c.getPtVie(),c.getPtVie()-this.getDegAtt()-this.getArme().getBonus()+c.getPtPar())));
                }
            }
        }
    }
    @Override
    public ArrayList<Creature> peutCombattre(World monde){
        ArrayList<Creature> tab=new ArrayList<>();
        for (int i=0;i<monde.getLongueur();i++){
            for(int j=0;j<monde.getLargeur();j++){
                if (i!=this.getPos().getX() || j!=this.getPos().getY()){
                if (monde.getListeEntite()[i][j]!=null && monde.getListeEntite()[i][j] instanceof Creature){
                    if (this.getPos().distance(monde.getListeEntite()[i][j].getPos())<=this.getDistAttMax()){
                        tab.add((Creature)monde.getListeEntite()[i][j]);
                    }
                }
                }
            }
        }
        if (tab.isEmpty()){
            tab=null;
        }
        return tab;
    }
    @Override
    public void tourIA(World monde){
        ArrayList<Creature> liste=this.peutCombattre(monde);
        if (null != liste && liste.contains(monde.getJoueur().getPerso())){
            System.out.println("On vous attaque !");
            this.combattre(monde.getJoueur().getPerso());
            if (monde.getJoueur().getPerso().getPtVie()<=0){
                System.out.println("Vous êtes mort");
            }
            else{
                System.out.println("Vous avez survécu");
            }
        }
        else{
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
        }
    }
}
