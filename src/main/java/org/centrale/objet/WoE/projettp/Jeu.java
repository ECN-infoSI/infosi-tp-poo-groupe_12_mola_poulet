/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author clesp
 */
public class Jeu {

    /**
     * Initialise le jeu
     */
    public static void initialisationJeu() {
        //début
        System.out.println("Bienvenue aventurier dans World of ECN ! Une grande quete vous attend." + "\n"
                + "Ma memoire me fait un peu defaut, etes-vous un nouveau joueur ?"+"\n");
        System.out.println("1- Non");
        System.out.println("2- Oui");
        Scanner s = new Scanner(System.in);
        String choix = s.next();
        Joueur profil;
        System.out.println("\n");
        switch (choix) {
            case "2":
                //nouveau joueur
                profil = Joueur.creationJoueur();
                System.out.println("Creation d'une nouvelle partie : ");
                World w = World.creationMonde(profil);
                w.getJoueur().demande();
                Random r = new Random();
                float n = w.getLongueur() * w.getLargeur();
                w.creeMondeAlea(r.nextInt((int) Math.floor(n * 0.15) + 1), r.nextInt((int) Math.floor(n * 0.10) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), r.nextInt((int) Math.floor(n * 0.1) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), r.nextInt((int) Math.floor(n * 0.07) + 1), r.nextInt((int) Math.floor(n * 0.03) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), 1);
                w.tourDeJeu();
                break;
            case "1":
                //ancien joueur
                System.out.println("Entrez votre pseudo : ");
                String nom = s.next();
                System.out.println("Entrez votre login :");
                String login = s.next();
                System.out.println("Entrez votre mot de passe : ");
                String mdp = s.next();
                profil = new Joueur(new Personnage(), nom, login, mdp, new ArrayList<>(), new Inventaire());
                Jeu.ancienJoueur(profil);
                break;
            default:
                System.out.println("Erreur");
                Jeu.initialisationJeu();
                break;
        }

    }

    /**
     *
     * @param profil
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * Permet le choix d'une sauvegarde
     */
    public static World choixSauvegarde(Joueur profil) throws FileNotFoundException, IOException {
        
        System.out.println("\n"+"Entrez le nom de la sauvegarde");
        Scanner s = new Scanner(System.in);
        String nomSauvegarde = s.next()+".txt";
        //chargement de la partie
        World w = World.chargementPartie(nomSauvegarde, profil);
        return w;
    }

    /**
     *
     *
     * @param profil joueur
     */
    public static void ancienJoueur(Joueur profil) {
        System.out.println("Bon retour " + profil.getNom()+ " !" + "\n" + "Taper 1 pour créer une nouvelle partie, 2 pour charger une sauvegarde");
        Scanner s = new Scanner(System.in);
        String choix = s.next();
        switch (choix) {
            case "1":
                System.out.println("Creation d'une nouvelle partie : ");
                World w = World.creationMonde(profil);
                //Création du personnage principal
                w.getJoueur().demande();
                int n = w.getLongueur() * w.getLargeur();
                //génération du monde
                Random r = new Random();
                w.creeMondeAlea(r.nextInt((int) Math.floor(n * 0.15) + 1), r.nextInt((int) Math.floor(n * 0.10) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), r.nextInt((int) Math.floor(n * 0.1) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), r.nextInt((int) Math.floor(n * 0.07) + 1), r.nextInt((int) Math.floor(n * 0.03) + 1), r.nextInt((int) Math.floor(n * 0.05) + 1), 1);
                w.tourDeJeu();
                break;
            case "2":
                try {
                    //Chargement d'une sauvegarde
                    w = Jeu.choixSauvegarde(profil);
                    w.tourDeJeu();
                } catch (Exception e) {
                    System.out.println("Erreur dans la lecture du fichier");
                    Jeu.ancienJoueur( profil);
                }
                break;
            default:
                System.out.println("Erreur");
                Jeu.ancienJoueur( profil);
                break;
        }
    }
}
