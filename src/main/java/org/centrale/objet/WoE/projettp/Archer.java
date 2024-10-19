/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;


/**
 *
 * @author clesp
 */
public class Archer extends Personnage implements Combattant,IA,Sauvegarde{
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
        super();
        this.nbFleches=40;
    }

    /**
     *
     * @param ligne
     * Permet la génération à partir d'une sauvegarde
     */
    public Archer(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        if (s.equals("Joueur")){
            s=tokenizer.nextToken();
        }
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
        s=tokenizer.nextToken();
        this.nbFleches=Integer.parseInt(s);
    }
    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     *
     * @param nbFleches
     */
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
    /**
     * Méthode permettant le combat d'un archer (au corps à corps et à distance)
     * @param adversaire adversaire à combattre
     */
    @Override
    public void combattre(Creature adversaire){
        Random rand = new Random();
        int jetAtt = rand.nextInt(101);
        int jetPar = rand.nextInt(101);
        
        if (this.getPos().distance(adversaire.getPos())<=Math.sqrt(2)){
            
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
        else if (this.getPos().distance(adversaire.getPos())<=Math.sqrt(2)*this.getDistAttMax()&& this.getNbFleches()>0){
            
            if (jetAtt>=this.getPageAtt()){
                
                adversaire.setPtVie(Math.max(0, adversaire.getPtVie()-this.getDegAtt()));
            }
            
            this.setNbFleches(Math.max(0,this.getNbFleches()-1));
        }
    }
    
    /**
     *
     * @param monde
     * @return
     */
    @Override
    public ArrayList<Creature> peutCombattre(World monde){
        
        ArrayList<Creature> tab=new ArrayList<>();
        for (int i=0;i<monde.getLongueur();i++){
            for(int j=0;j<monde.getLargeur();j++){
                if (i!=this.getPos().getX() || j!=this.getPos().getY()){
                    if (monde.getListeEntite()[i][j]!=null && monde.getListeEntite()[i][j] instanceof Creature){
                    
                        if (this.getPos().distance(monde.getListeEntite()[i][j].getPos())<=Math.sqrt(2)*this.getDistAttMax()){
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
    
    /**
     *
     * @param monde
     * Tour d'un archer IA
     */
    @Override
    public void tourIA(World monde){
        ArrayList<Creature> liste=this.peutCombattre(monde);
        //Attaque si possibilité il y a
        if (null != liste && liste.contains(monde.getJoueur().getPerso())){
            System.out.println("Un Archer vous attaque !");
            this.combattre(monde.getJoueur().getPerso());
            if (monde.getJoueur().getPerso().getPtVie()<=0){
                System.out.println("Vous êtes mort");
                monde.getListeEntite()[monde.getJoueur().getPerso().getPos().getX()][monde.getJoueur().getPerso().getPos().getY()]=null;
            }
            else{
                System.out.println("Vous avez survécu");
            }
        }
        //Sinon déplacement possible aléatoire
        else{
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
        }
    }

    /**
     *
     * @return
     * Sauvegarde un archer
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Archer "+this.getNom()+" "+this.getPtVie()+" "+this.getDegAtt()+" "+this.getPtPar()+" "+this.getPageAtt()+" "+this.getPagePar()+" "+this.getDistAttMax()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+this.nbFleches));
        return s;
    }
}

