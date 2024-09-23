/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //Initialisation du monde
        Archer a=new Archer("Robin des bois",50,10,75,50,50,5,new Point2D(0,0),10);
        Paysan p=new Paysan("Malon",50,10,75,50,50,5,new Point2D(0,0));
        Lapin l1=new Lapin(50,10,10,50,50,new Point2D(0,0));
        Lapin l2=new Lapin(50,10,10,50,50,new Point2D(0,0));
        Loup lo=new Loup(50,10,75,50,50,new Point2D(0,0));
        Epee arme=new Epee("Master Sword",30,new Point2D(0,0));
        Guerrier g=new Guerrier ("Link",50,10,10,50,50,5,arme,new Point2D(0,0));
        PotionSoin s=new PotionSoin(10,new Point2D(0,0));
        World w=new World(a,p,l1,l2,lo,g,s);
        //génération du monde
        w.creeMondeAlea();
        w.afficheWorld();

        //Tests de combat et de soin
        w.getGrosBill().setPos(new Point2D (w.getBugs().getPos().getX()+1,w.getBugs().getPos().getY()));
        w.getGrosBill().combattre(w.getBugs());
        w.getBugs().affiche();
        w.getRobin().setPos(new Point2D (w.getGrosBill().getPos().getX()+3,w.getGrosBill().getPos().getY()));
        w.getRobin().combattre(w.getGrosBill());
        w.getRobin().affiche();
        w.getGrosBill().affiche();
        w.getGrosBill().setPos(new Point2D (w.getPotion().getPos().getX(),w.getPotion().getPos().getY()));
        w.getGrosBill().soin(w.getPotion());
        w.getGrosBill().affiche();
    }
}
