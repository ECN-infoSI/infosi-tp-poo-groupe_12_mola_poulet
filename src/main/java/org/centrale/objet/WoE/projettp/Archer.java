/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;

/**
 *
 * @author clesp
 */
public class Archer extends Personnage {
    private int nbFleches;

    /**
     *
     * @param nom Nom de l'archer
     * @param pV Nombre de points de vie de l'archer
     * @param dA Points d'attaque de l'archer
     * @param pPar Point de parade
     * @param paAtt Pourcentage de réussite de l'attaque
     * @param paPar Pourcentage de réussite de la parade
     * @param dMax Distance max 
     * @param p Position
     * @param nbFleches Nombre de flèches
     */
    public Archer(String nom,int pV, int dA, int pPar, int paAtt,int paPar,int dMax, Point2D p,int nbFleches){
        super(nom,pV,dA,pPar,paAtt,paPar,dMax,p);
        this.nbFleches=nbFleches;
    }

    /**
     *
     * @param a Copie profonde d'un archer
     */
    public Archer(Archer a) {
        super((Personnage)a);
        this.nbFleches=a.nbFleches;
    }

    /**
     *
     */
    public Archer() {
    }

    
    
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    
    
    /**
     * Affiche les attributs de l'archer
     */
    @Override
    public void affiche(){
        System.out.println("Nom "+this.getNom()+"\n"+"pv "+this.getPtVie()+"\n"+"att "+this.getDegAtt()+"\n"+"Par "+this.getPtPar()+"\n"+"PaAtt "+this.getPageAtt()+"\n"+"PaPar "+this.getPagePar()+"\n"+"Distance attaque max "+this.getDistAttMax());
        this.getPos().affiche();
        System.out.println("Nombre de flèches "+this.nbFleches);
    }
    
        public void combattre(Creature adversaire){
        Random rand = new Random();
        int jetAtt = rand.nextInt(101);
        int jetPar = rand.nextInt(101);
        
        if (this.getPos().distance(adversaire.getPos())<2){
            
            if (jetAtt>=this.getPageAtt()){
                
                if (jetPar>=adversaire.getPagePar()){
                    
                    if (adversaire.getPtPar()<this.getDegAtt()){
                        
                        adversaire.setPtVie(Math.max(0, adversaire.getPtVie()-(this.getDegAtt()-adversaire.getPtPar())));
                    }
                }
                else{
                    
                    adversaire.setPtVie(Math.max(0, adversaire.getPtVie()-this.getDegAtt()));
                }
            }
            
        }
        else if (this.getPos().distance(adversaire.getPos())<=this.getDistAttMax()&&this.getNbFleches()>0){
            
            if (jetAtt>=this.getPageAtt()){
                
                adversaire.setPtVie(Math.max(0, adversaire.getPtVie()-this.getDegAtt()));
            }
            
            this.setNbFleches(Math.max(0,this.getNbFleches()-1));
        }
    }

    
}

