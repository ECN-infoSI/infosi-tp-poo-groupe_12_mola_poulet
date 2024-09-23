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
        Lapin l1=new Lapin(50,10,75,50,50,new Point2D(0,0));
        Lapin l2=new Lapin(50,10,75,50,50,new Point2D(0,0));
        World w=new World(a,p,l1,l2);
        //génération du monde
        w.creeMondeAlea();
        w.getRobin().affiche();
        w.getGuillaumeT().affiche();
        w.getPeon().affiche();
        w.getRoger().affiche();
        w.getBugs().affiche();
        //déplacements
        w.getBugs().deplace();
        w.getBugs().affiche();
        w.getPeon().deplace(2, -3);
        w.getPeon().affiche();
        w.getRobin().deplace(1);
        w.getGuillaumeT().affiche();
        w.getRobin().affiche();
        w.getPeon().deplace(2);
        w.getPeon().affiche();
        w.getBugs().deplace(6);
        w.getBugs().affiche();
    }
}
