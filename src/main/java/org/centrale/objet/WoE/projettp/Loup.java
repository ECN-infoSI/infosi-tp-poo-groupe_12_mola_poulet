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
public class Loup extends Monstre implements Combattant,IA{
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
        super();
    }
    
    /**
     * Système de combat (corps à corps)
     * @param c Créature à combattre
     */
    
    @Override
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
                    c.setPtVie(Math.max(c.getPtVie()-this.getDegAtt(),0));  
                }
                else{
                    //Parade réussie
                    c.setPtVie(Math.max(0,Math.min(c.getPtVie(),c.getPtVie()-this.getDegAtt()+c.getPtPar())));
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
                    if (this.getPos().distance(monde.getListeEntite()[i][j].getPos())<2){
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
        if (liste.contains(monde.getJoueur().getPerso())){
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

