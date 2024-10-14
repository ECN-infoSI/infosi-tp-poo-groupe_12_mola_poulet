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

public class World {
    private int longueur;
    private int largeur;
    private Joueur joueur;
    private Entite[][] listeEntite;
    private final static int l=50;
    
    /**
     *
     * @param lo longueur
     * @param la largeur
     * 
     * 
     */
    public World (int lo, int la,Joueur joueur){
        this.longueur=lo;
        this.largeur=la;
        this.joueur=joueur;
        this.listeEntite=new Entite[lo][];
        for (int i=0;i<lo;i++){
            this.listeEntite[i]=new Entite[la];
        }
    }
    
    /**
     *
     */
    public World(){
        this.longueur=l;
        this.largeur=l;
        this.joueur=new Joueur();
        this.listeEntite=new Entite[l][];
        for (int i=0;i<l;i++){
            this.listeEntite[i]=new Entite[l];
        }
    }

    /**
     *
     * @return
     */
    public Entite[][] getListeEntite() {
        return listeEntite;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }
    
    
    // création des positions initiales aléatoires

    /**
     * Créer le monde en générant des positions aléatoires (sur différentes cases)
     * @param nbGuerrier Nombre de guerriers
     * @param nbPaysan Nombre de paysans
     * @param nbArcher Nombre d'archers
     * @param nbEpee Nombre d'épées
     * @param nbLoup Nombre de loups
     * @param nbLapin Nombre de lapins
     * @param nbPotion Nombre de potions
     */
   public void creeMondeAlea(int nbGuerrier,int nbPaysan,int nbArcher,int nbLoup, int nbLapin,int nbPotion,int nbEpee){
       Random r=new Random();
       //Joueur
       joueur.getPerso().setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
       this.listeEntite[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()]=joueur.getPerso();
       //Guerrier
       for (int i=1;i<=nbGuerrier;i++){
           Guerrier thing= new Guerrier();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Paysan
       for (int i=1;i<=nbPaysan;i++){
           
           Paysan thing= new Paysan();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Archer
       for (int i=1;i<=nbArcher;i++){
           
           Archer thing= new Archer();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Loup
       for (int i=1;i<=nbLoup;i++){
           
           Loup thing= new Loup();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Lapins
       for (int i=1;i<=nbLapin;i++){
           
           Lapin thing= new Lapin();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Potions
       for (int i=1;i<=nbPotion;i++){
           PotionSoin thing= new PotionSoin();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
       //Epee
       for (int i=1;i<=nbEpee;i++){
           
           Epee thing= new Epee();
           thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
       }
   }
   /**
    * Affiche les attributs du monde
    */
   public void afficheWorld(){
       System.out.println("["+this.longueur+","+this.largeur+"]");
       int j=listeEntite.length;
       for (int i=0;i<j;i++){
           for (Entite p:listeEntite[i]){
               if (p!=null){
                   p.affiche(); 
               }
           }
        }
    }
   public boolean estTermine(int n){
       return this.joueur.getPerso().getPtVie()<=0;
   }
   public void tourDeJeu(){
       int n; //nombre de tours
       while (!estTermine(n)){
            this.joueur.tourDeJoueur(n, this);
            for (Entite[] ligne: listeEntite){
                for (Entite ia:ligne){
                    if (ia instanceof Creature && ia!=this.joueur.getPerso()){
                        Creature ai=(Creature)ia;
                        ai.tourIA(this);
                        
                    }
                    if(ia instanceof NuageToxique){
                        ((NuageToxique) ia).combattre(((NuageToxique) ia).peutCombattre(this));
                    }
                }
            n++;
            }
        System.out.println("Game Over,"+"\n"+"Vous avez survécu "+n+" tours");
       }
       
   }
}
