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
    
    public Archer robin;
    public Archer guillaumeT;
    public Paysan peon;
    public Lapin bugs;
    public Lapin roger;
    public Loup wolfie;
    public Guerrier grosBill;

    /**
     *
     * @param a Un archer
     * @param p Un paysan
     * @param l1 Un lapin
     * @param l2 Un lapin
     */
    public World (Archer a,Paysan p, Lapin l1,Lapin l2,Loup w,Guerrier g){
        this.robin=new Archer(a);
        this.guillaumeT=new Archer(this.robin);
        this.peon=new Paysan(p);
        this.bugs=new Lapin(l1);
        this.roger=new Lapin(l2);
        this.wolfie=new Loup(w);
        this.grosBill=new Guerrier(g);
    }

    /**
     *
     * @return
     */
    public Archer getGuillaumeT() {
        return guillaumeT;
    }

    /**
     *
     * @return
     */
    public Archer getRobin() {
        return robin;
    }

    /**
     *
     * @return
     */
    public Paysan getPeon() {
        return peon;
    }

    /**
     *
     * @return
     */
    public Lapin getBugs() {
        return bugs;
    }

    /**
     *
     * @return
     */
    public Lapin getRoger() {
        return roger;
    }

    public Loup getWolfie() {
        return wolfie;
    }

    public Guerrier getGrosBill() {
        return grosBill;
    }
    
    
    // création des positions initiales aléatoires

    /**
     * Créer le monde en générant des positions aléatoires (sur différentes cases)
     */
   public void creeMondeAlea(){
       Random r=new Random();
       //Archer
       this.robin.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       Point2D p1=this.robin.getPos();
       this.guillaumeT.setPos(p1);
       //Paysan
       this.peon.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       Point2D p2=this.peon.getPos();
       //vérification de position non déjà utilisée
       while (p1.distance(p2)==0){
           this.peon.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
       //lapins et vérifications de non colision 
       this.bugs.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       Point2D p3=this.bugs.getPos();
        while (p1.distance(p3)==0){
           this.bugs.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
        while (p2.distance(p3)==0){
           this.bugs.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
       this.roger.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       Point2D p4=this.roger.getPos();
       while (p1.distance(p4)==0){
           this.roger.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
       while (p2.distance(p4)==0){
           this.roger.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
       while (p3.distance(p4)==0){
           this.roger.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       }
   }
   
   public void afficheWorld(){
       
   }
}
