/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;
import java.util.Scanner;
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
//        //Initialisation du monde
//        World w=new World();
//        w.getJoueur().demande();
//        Random r= new Random();
//        w.creeMondeAlea(r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21));
//        w.afficheWorld();
//        
//        //Tests des performances de la matrice
//        World w2=new World(10000,10000,new Joueur());
//        w2.getJoueur().demande();
//        w2.creeMondeAlea(700000, 100000, 100000, 100000, 100000, 1000, 1537);
//        //w2.afficheWorld();
//        int sum=0;
//        long debut=System.nanoTime();
//        int j=w2.getListeEntite().length;
//        for (int i=0;i<j;i++){
//           for (Entite p:w2.getListeEntite()[i]){
//                if (p instanceof Creature){
//                    sum+=((Creature) p).getPtVie();
//                }
//           }
//            
//        }
//        System.out.println("Points de vie totaux : "+sum);
//        long fin=System.nanoTime();
//        System.out.println("Temps écoulé en ns : "+(fin-debut)); 
        System.out.println("Bienvenue dans World of ECN !"+"\n"+"Etes-vous un nouveau joueur ?");
        System.out.println("1- Non");
        System.out.println("2- Oui");
        Scanner s=new Scanner(System.in);
        String choix=s.next();
        Joueur profil;
        switch (choix){
            case "2":
                System.out.println ("Choisissez un pseudo : ");
                String nom=s.next();
                System.out.println("Définissez un login :");
                String login=s.next();
                System.out.println("Définissez un mot de passe : ");
                String mdp=s.next();
                profil=new Joueur(null,nom,login,mdp,null,null);
                break;
            case "1":
                // faudrait une base de données
                profil=new Joueur();
                break;
            default: 
                //à faire dans une méthode de World
                profil=new Joueur();
                break;
        }
        System.out.println("Creation d'une nouvelle partie : ");
        System.out.println("Quelle longueur ?");
        String longueur=s.next();
        System.out.println("Quelle largeur ?");
        String largeur=s.next();
        World w=new World();
        try{
            w=new World(Integer.parseInt(longueur),Integer.parseInt(largeur),profil);
            }catch(NumberFormatException exc){
            }    
        finally{
            w.getJoueur().demande();
            Random r= new Random();
            w.creeMondeAlea(r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21), r.nextInt(21));
            w.getListeEntite()[w.getJoueur().getPerso().getPos().getX()][w.getJoueur().getPerso().getPos().getY()]=null;
            w.getJoueur().getPerso().setPos(new Point2D (0,0));
            w.getListeEntite()[0][0]=w.getJoueur().getPerso();
            
            w.tourDeJeu();
        }
    }
}
