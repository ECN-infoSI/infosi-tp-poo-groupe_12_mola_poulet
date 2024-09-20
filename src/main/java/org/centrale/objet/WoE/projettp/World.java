/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;
import org.centrale.objet.WoE.projettp.Archer;
import org.centrale.objet.WoE.projettp.Lapin;
/**
 *
 * @author clesp
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;
    public Lapin roger;
    public World (Archer a,Paysan p, Lapin l1,Lapin l2){
        this.robin=new Archer(a);
        this.peon=new Paysan(p);
        this.bugs=new Lapin(l1);
        this.roger=new Lapin(l2);
    }

    public Archer getRobin() {
        return robin;
    }

    public Paysan getPeon() {
        return peon;
    }

    public Lapin getBugs() {
        return bugs;
    }

    public Lapin getRoger() {
        return roger;
    }
    
    // création des positions initiales aléatoires
   public void creeMondeAlea(){
       Random r=new Random();
       //Archer
       this.robin.setPos(new Point2D (r.nextInt(51)-25,r.nextInt(51)-25));
       Point2D p1=this.robin.getPos();
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
}
