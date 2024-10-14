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
public class TestWoE {

    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //Initialisation du monde
        World w=new World();
        w.getJoueur().demande();
        Random r= new Random();
        w.creeMondeAlea(r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21));
        w.afficheWorld();
        
        //Tests des performances de la matrice
        World w2=new World(10000,10000,new Joueur());
        w2.getJoueur().demande();
        w2.creeMondeAlea(700000, 100000, 100000, 100000, 100000, 1000, 1537);
        //w2.afficheWorld();
        int sum=0;
        long debut=System.nanoTime();
        int j=w2.getListeEntite().length;
        for (int i=0;i<j;i++){
           for (Entite p:w2.getListeEntite()[i]){
                if (p instanceof Creature){
                    sum+=((Creature) p).getPtVie();
                }
           }
            
        }
        System.out.println("Points de vie totaux : "+sum);
        long fin=System.nanoTime();
        System.out.println("Temps écoulé en ns : "+(fin-debut)); 
    }
}
