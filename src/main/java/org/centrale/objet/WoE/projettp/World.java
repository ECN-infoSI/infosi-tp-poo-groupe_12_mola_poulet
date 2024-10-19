/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author clesp
 */
public class World {

    private final int longueur;
    private final int largeur;
    private final Joueur joueur;
    private Entite[][] listeEntite;
    private final static int l = 50;

    /**
     *
     * @param lo longueur
     * @param la largeur
     * @param joueur
     *
     *
     */
    public World(int lo, int la, Joueur joueur) {
        this.longueur = lo;
        this.largeur = la;
        this.joueur = joueur;
        this.listeEntite = new Entite[lo][];
        for (int i = 0; i < lo; i++) {
            this.listeEntite[i] = new Entite[la];
        }
    }

    /**
     *
     */
    public World() {
        this.longueur = l;
        this.largeur = l;
        this.joueur = new Joueur();
        this.listeEntite = new Entite[l][];
        for (int i = 0; i < l; i++) {
            this.listeEntite[i] = new Entite[l];
        }
    }
    //getters
    /**
     *
     * @return
     */
    public Entite[][] getListeEntite() {
        return listeEntite;
    }

    /**
     *
     * @return
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     *
     * @return
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     *
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    // création des positions initiales aléatoires
    /**
     * Créer le monde en générant des positions aléatoires (sur différentes
     * cases)
     *
     * @param nbGuerrier Nombre de guerriers
     * @param nbPaysan Nombre de paysans
     * @param nbArcher Nombre d'archers
     * @param nbEpee Nombre d'épées
     * @param nbLoup Nombre de loups
     * @param nbLapin Nombre de lapins
     * @param nbPotion Nombre de potions
     * @param nbNourriture
     * @param nbNuageToxique
     */
    public void creeMondeAlea(int nbGuerrier, int nbPaysan, int nbArcher, int nbLoup, int nbLapin, int nbPotion, int nbEpee, int nbNourriture, int nbNuageToxique) {
        Random r = new Random();

        //Joueur
        joueur.getPerso().setPos(new Point2D(r.nextInt(this.longueur), r.nextInt(this.largeur)));
        this.listeEntite[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()] = joueur.getPerso();

        //Guerrier
        for (int i = 1; i <= nbGuerrier; i++) {
            Guerrier thing = new Guerrier();
            definePos(thing);
        }
        //Paysan
        for (int i = 1; i <= nbPaysan; i++) {

            Paysan thing = new Paysan();
            definePos(thing);
        }
        //Archer
        for (int i = 1; i <= nbArcher; i++) {

            Archer thing = new Archer();
            definePos(thing);
        }
        //Loup
        for (int i = 1; i <= nbLoup; i++) {

            Loup thing = new Loup();
            definePos(thing);
        }
        //Lapins
        for (int i = 1; i <= nbLapin; i++) {

            Lapin thing = new Lapin();
            definePos(thing);
        }
        //Potions
        for (int i = 1; i <= nbPotion; i++) {
            PotionSoin thing = new PotionSoin();
            definePos(thing);
        }
        //Epee
        for (int i = 1; i <= nbEpee; i++) {

            Epee thing = new Epee();
            definePos(thing);
        }

        //Nourriture
        for (int i = 1; i <= nbNourriture; i++) {

            Nourriture thing = createFood();
            definePos(thing);
        }

        //Nuage Toxique
        for (int i = 1; i <= nbNuageToxique; i++) {
            NuageToxique thing = new NuageToxique(3, (int) Math.floor(Math.min(largeur, longueur) * 0.2), r.nextInt(8), new Point2D());
            definePos(thing);
        }
    }

    /**
     * Affiche les attributs du monde
     */
    public void afficheWorld() {
        System.out.println("[" + this.longueur + "," + this.largeur + "]");
        int j = listeEntite.length;
        for (int i = 0; i < j; i++) {
            for (Entite p : listeEntite[i]) {
                if (p != null) {
                    p.affiche();
                }
            }
        }
    }

    /**
     * Permet de placer une entité sur une case inoccupée
     * @param thing
     */
    public void definePos(Entite thing) {

        Random r = new Random();
        //vérification
        thing.setPos(new Point2D(r.nextInt(this.longueur), r.nextInt(this.largeur)));
        while (listeEntite[thing.getPos().getX()][thing.getPos().getY()] != null) {
            thing.setPos(new Point2D(r.nextInt(this.longueur), r.nextInt(this.largeur)));
        }
        this.listeEntite[thing.getPos().getX()][thing.getPos().getY()] = thing;
    }

    /**
     *
     * @return
     * Génération de nourriture aléatoire
     */
    public Nourriture createFood() {

        Random r = new Random();

        String[] listeStats = new String[]{"degAtt", "ptPar", "pageAtt", "pagePar", "distAttMax"};
        String[] listeNomsBonus = new String[]{"Pomme", "Pasteque", "Pain", "Viande_de_boeuf_cuite"};
        String[] listeNomsMalus = new String[]{"Patate_germee", "Oeil_d'araignee", "Viande_putrifiee", "Poisson_Globe"};

        String statNomModif = listeStats[r.nextInt(5)];
        int plage = 7;
        String nom;
        int modifBase = (int) (r.nextInt(plage) - Math.floor(plage / 2));
        int modifStat = 0;
        int temps = r.nextInt(4) + 1;

        while (0 != modifBase) {
            modifBase = (int) (r.nextInt(plage) - Math.floor(plage / 2));
        }

        switch (statNomModif) {
            case "degAtt":
                modifStat = modifBase * 3;
                break;

            case "ptPar":
                modifStat = modifBase * 4;
                break;

            case "pageAtt":
                modifStat = modifBase * 5;
                break;

            case "pagePar":
                modifStat = modifBase * 5;
                break;

            case "distAttMax":
                modifStat = r.nextInt(5) - 2;
                break;
        }

        if (modifStat < 0) {
            nom = listeNomsMalus[r.nextInt(listeNomsMalus.length)];
        } else {
            nom = listeNomsBonus[r.nextInt(listeNomsBonus.length)];
        }

        return new Nourriture(nom, modifStat, temps, statNomModif, false, new Point2D());

    }

    /**
     *
     * @param n Numéro de tour
     * @return
     * Détermine si la partie est terminée ou non
     */
    public boolean estTermine(int n) {
        return (this.joueur.getPerso().getPtVie() <= 0);
    }

    /**
     * Tour de jeu
     */
    public void tourDeJeu() {
        int n = 0; //nombre de tours
        while (!estTermine(n)) {
            //avant tour
            this.afficheMonde(this);
            System.out.print("Voici les stats actuelles de votre personnage" + "\n");
            joueur.getPerso().affiche();
            //tour de joueur
            this.joueur.tourDeJoueur(n, this);
            //tour des IA
            for (Entite[] ligne : listeEntite) {
                for (Entite ia : ligne) {

                    if (ia instanceof Creature && ia != this.joueur.getPerso()) {
                        ((IA) ia).tourIA((this));
                    }
                    if (ia instanceof NuageToxique) {
                        ((NuageToxique) ia).combattre(((NuageToxique) ia).peutCombattre(this));
                        if (((NuageToxique) ia).peutCombattre(this).contains(this.joueur.getPerso())) {
                            System.out.println("Fuyez pauvres fous, vous etes dans le nuage toxique !");
                            if (this.joueur.getPerso().getPtVie() <= 0) {
                                System.out.println("Vous avez succombé au nuage toxique");
                            }
                        }
                    }
                }

            }
            //actualisation des effets
            for (Utilisable cooldown : joueur.getEffets()) {
                ((Nourriture) cooldown).expiration(joueur);

                if (((Nourriture) cooldown).getToursRestants() <= 0) {
                    joueur.getEffets().remove(cooldown);
                }

            }

            n++;
        }
        System.out.println("Game Over," + "\n" + "Vous avez survécu " + n + " tours");
    }

    /**
     *
     * @param monde
     * affiche la carte du monde en fin de tours
     */
    public void afficheMonde(World monde) {
        //légende
        System.out.println("X : vous, *=rien, G=Guerrier, A=Archer, J=Potion, N=Nourriture, P=Paysan, L=Loup, B=Lapin, Nombre=Nuage toxique et son rayon");
        Entite[][] map = monde.getListeEntite();
        for (Entite[] map1 : map) {
            String afficheLigne = "";
            for (Entite item : map1) {
                if (item == monde.getJoueur().getPerso()) {
                    afficheLigne += "X  ";
                }
                if (item == null) {
                    afficheLigne += "*  ";
                }
                if (item instanceof Guerrier && item != monde.getJoueur().getPerso()) {
                    afficheLigne += "G  ";
                }
                if (item instanceof Archer && item != monde.getJoueur().getPerso()) {
                    afficheLigne += "A  ";
                }
                if (item instanceof Loup) {
                    afficheLigne += "L  ";
                }
                if (item instanceof Lapin) {
                    afficheLigne += "B  ";
                }
                if (item instanceof Paysan) {
                    afficheLigne += "P  ";
                }
                if (item instanceof PotionSoin) {
                    afficheLigne += "J  ";
                }
                if (item instanceof Nourriture) {
                    afficheLigne += "N  ";
                }
                if (item instanceof NuageToxique) {
                    afficheLigne += (((NuageToxique) item).getRayonAtt()) + "  ";
                }
                if (item instanceof Epee) {
                    afficheLigne += "E  ";
                }
            }
            System.out.println(afficheLigne);
        }
    }

    /**
     *
     * @param profil
     * @return
     * Création d'un monde
     */
    public static World creationMonde(Joueur profil) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choisissez la longueur de votre monde, pour la taille par défaut, ne rentrez pas un nombre");
        String longueur = s.next();
        System.out.println("Choisissez la largeur de votre monde");
        String largeur = s.next();
        World w = new World();
        try {
            int lo = Integer.parseInt(longueur);
            int la = Integer.parseInt(largeur);
            if (lo * la >= 10) {
                w = new World(lo, la, profil);
            } else {
                System.out.println("Monde trop petit");
                creationMonde(profil);
            }
        } catch (NumberFormatException exc) {
            System.out.println("Monde par defaut choisi");
        }
        return w;
    }

    /**
     *
     * @param nomFichier Nom du fichier à charger
     * @param joueur
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * Charge une partie sauvegardé
     * 
     */
    public static World chargementPartie(String nomFichier, Joueur joueur) throws FileNotFoundException, IOException {
        BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));
        //génération du monde
        String ligne=fichier.readLine();
        StringTokenizer tokenizer = new StringTokenizer(ligne," ");
        String s = tokenizer.nextToken();
        s = tokenizer.nextToken();
        int longueur = Integer.parseInt(s);
        ligne = fichier.readLine();
        tokenizer = new StringTokenizer(ligne," ");
        s = tokenizer.nextToken();
        s= tokenizer.nextToken();
        int largeur = Integer.parseInt(s);
        World w = new World(longueur, largeur, joueur);
        ligne = fichier.readLine();
        //génération des entités
        while (ligne != null) {
            World.ajoutElement(w, ligne);
            ligne = fichier.readLine();
        }
        fichier.close();
        return w;
    }

    /**
     *
     * @param w monde
     * @param ligne Informations
     * Ajoute des entités sauvegardée sur la carte
     */
    public static void ajoutElement(World w, String ligne) {
        StringTokenizer tokenizer = new StringTokenizer(ligne," ");
        String s = tokenizer.nextToken();
        try {
            switch (s) {
                //génération du joueur et de son perso
                case "Joueur":
                    {
                        s = tokenizer.nextToken();
                        Class classe = Class.forName("org.centrale.objet.WoE.projettp." + s);
                        Constructor ct = classe.getConstructor(new Class[]{String.class});
                        Object o = ct.newInstance((Object[]) new String[]{ligne});
                        Personnage p=(Personnage)o;
                        w.joueur.setPerso(p);
                        w.listeEntite[w.joueur.getPerso().getPos().getX()][w.joueur.getPerso().getPos().getY()] = w.joueur.getPerso();
                        break;
                    }
                //génération de son inventaire
                case "Inventaire":
                    {
                        s = tokenizer.nextToken();
                        Class classe = Class.forName("org.centrale.objet.WoE.projettp." + s);
                        Constructor ct = classe.getConstructor(String.class);
                        Object o = ct.newInstance(ligne);
                        Objet f = (Objet) o;
                        w.joueur.getInventaire().getContenu().add(f);
                        break;
                    }
                //génération des IA et objets
                default:
                    {
                        Class classe = Class.forName("org.centrale.objet.WoE.projettp." + s);
                        Constructor ct = classe.getConstructor(String.class);
                        Object o = ct.newInstance(ligne);
                        Entite f = (Entite) o;
                        w.listeEntite[f.getPos().getX()][f.getPos().getY()] = f;
                        break;
                    }
            }

        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
        }
    }

    /**
     *
     * @param nomSauvegarde Nom de la sauvegarde
     * @throws IOException
     * Permet de sauvegarder une partie
     */
    public void sauvegardePartie(String nomSauvegarde) throws IOException{
        BufferedWriter fichier=new BufferedWriter(new FileWriter(nomSauvegarde));
        //sauvegarde du monde
        fichier.write("longueur "+this.longueur+"\n");
        fichier.write("largeur "+this.largeur+"\n");
        //sauvegarde du tableau
        for (int i=0;i<this.getLongueur();i++){
            for(int j=0;j<this.getLargeur();j++){
                if (this.listeEntite[i][j]!=null){
                    if (this.listeEntite[i][j]!=this.joueur.getPerso()){
                        String ligne=((Sauvegarde)listeEntite[i][j]).sauvegardeElement();
                        fichier.write(ligne);
                        fichier.newLine();
                    }
                }
            }
        }
        //sauvegarde du joueur et de son inventaire
        fichier.write("Joueur ");
        String ligne=((Sauvegarde)this.joueur.getPerso()).sauvegardeElement();
        fichier.write(ligne);
        fichier.newLine();
        for (Objet objet:this.joueur.getInventaire().getContenu()){
            fichier.write("Inventaire ");
            ligne=((Sauvegarde)objet).sauvegardeElement();
            fichier.write(ligne);
            fichier.newLine();
        }
        fichier.close();
    }
}

