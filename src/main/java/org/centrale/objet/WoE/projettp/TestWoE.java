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
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //Initialisation du monde
        World w=new World();
        Random r= new Random();
        w.creeMondeAlea(r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21));
        w.afficheWorld();
        
        World w2=new World(1000,1000);
        w2.creeMondeAlea(20, 20, 20, 20, 20, 0, 0);
        int sum=0;
        long debut=System.nanoTime();
        for (Entite p:w2.getListeEntite()){
            if (p instanceof Creature){
                sum+=((Creature) p).getPtVie();
            }
        }
        System.out.println("Points de vie totaux : "+sum);
        long fin=System.nanoTime();
        System.out.println("Temps écoulé en ns : "+(fin-debut));
        sum=0;
        debut=System.nanoTime();
        ArrayList<Entite> list=w2.getListeEntite();
        for(int i=0;i<list.size();i++){
            if (list.get(i) instanceof Creature){
                sum+=((Creature) w2.getListeEntite().get(i)).getPtVie();
            }
        }
        fin=System.nanoTime();
        System.out.println("Temps écoulé en ns : "+(fin-debut));
        
    }
}
