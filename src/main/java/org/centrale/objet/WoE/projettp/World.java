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
public class World {
    private int longueur;
    private int largeur;
    private ArrayList<Entite> listeEntite;
    private final static int l=50;
    
    /**
     *
     * @param a Un archer
     * @param p Un paysan
     * @param l1 Un lapin
     * @param l2 Un lapin
     * @param w Un loup
     * @param g Un guerrier
     * @param s Une potion
     * 
     * 
     */
    public World (int lo, int la){
        this.longueur=lo;
        this.largeur=la;
        this.listeEntite=new ArrayList<>();
    }
    
    public World(){
        this.longueur=l;
        this.largeur=l;
        this.listeEntite=new ArrayList<>();
    }

    public ArrayList<Entite> getListeEntite() {
        return listeEntite;
    }
    

    
    // création des positions initiales aléatoires

    /**
     * Créer le monde en générant des positions aléatoires (sur différentes cases)
     */
   public void creeMondeAlea(int nbGuerrier,int nbPaysan,int nbArcher,int nbLoup, int nbLapin,int nbPotion,int nbEpee){
       Random r=new Random();
       //Guerrier
       for (int i=1;i<=nbGuerrier;i++){
           
           Guerrier thing= new Guerrier();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Paysan
       for (int i=1;i<=nbPaysan;i++){
           
           Paysan thing= new Paysan();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Archer
       for (int i=1;i<=nbArcher;i++){
           
           Archer thing= new Archer();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Loup
       for (int i=1;i<=nbLoup;i++){
           
           Loup thing= new Loup();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Lapins
       for (int i=1;i<=nbLapin;i++){
           
           Lapin thing= new Lapin();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Potions
       for (int i=1;i<=nbPotion;i++){
           
           PotionSoin thing= new PotionSoin();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
       //Epee
       for (int i=1;i<=nbEpee;i++){
           
           Epee thing= new Epee();
           thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
           int j=0; 
           while (j<this.listeEntite.size()){
               if (thing.getPos().distance(this.listeEntite.get(j).getPos())==0){
                   thing.setPos(new Point2D (r.nextInt(this.longueur+1),r.nextInt(this.largeur+1)));
                   j=0;
               }
               else{
                   j++;
               }
           }
           this.listeEntite.add(thing);
       }
   }
   /**
    * Affiche les attributs du monde
    */
   public void afficheWorld(){
       System.out.println("("+this.longueur+","+this.largeur+")");
       for (Entite p:this.listeEntite){
           p.affiche();
       }
   }
}
