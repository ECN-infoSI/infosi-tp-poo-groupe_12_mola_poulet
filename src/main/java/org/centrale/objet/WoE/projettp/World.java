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
    private final int longueur;
    private final int largeur;
    private final Joueur joueur;
    private Entite[][] listeEntite;
    private final static int l=50;
    
    /**
     *
     * @param lo longueur
     * @param la largeur
     * 
     * 
     */
    public World (int lo, int la,Joueur joueur){
        this.longueur=lo;
        this.largeur=la;
        this.joueur=joueur;
        this.listeEntite=new Entite[lo][];
        for (int i=0;i<lo;i++){
            this.listeEntite[i]=new Entite[la];
        }
    }
    
    /**
     *
     */
    public World(){
        this.longueur=l;
        this.largeur=l;
        this.joueur=new Joueur();
        this.listeEntite=new Entite[l][];
        for (int i=0;i<l;i++){
            this.listeEntite[i]=new Entite[l];
        }
    }

    /**
     *
     * @return
     */
    public Entite[][] getListeEntite() {
        return listeEntite;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }
    
    
    // création des positions initiales aléatoires

    /**
     * Créer le monde en générant des positions aléatoires (sur différentes cases)
     * @param nbGuerrier Nombre de guerriers
     * @param nbPaysan Nombre de paysans
     * @param nbArcher Nombre d'archers
     * @param nbEpee Nombre d'épées
     * @param nbLoup Nombre de loups
     * @param nbLapin Nombre de lapins
     * @param nbPotion Nombre de potions
     */
   public void creeMondeAlea(int nbGuerrier,int nbPaysan,int nbArcher,int nbLoup, int nbLapin,int nbPotion,int nbEpee, int nbNourriture, int nbNuageToxique){
       Random r=new Random();
       //Joueur
       joueur.getPerso().setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
       this.listeEntite[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()]=joueur.getPerso();
       //Guerrier
       for (int i=1;i<=nbGuerrier;i++){
           Guerrier thing= new Guerrier();
           definePos(thing);
       }
       //Paysan
       for (int i=1;i<=nbPaysan;i++){
           
           Paysan thing= new Paysan();
           definePos(thing);
       }
       //Archer
       for (int i=1;i<=nbArcher;i++){
           
           Archer thing= new Archer();
           definePos(thing);
       }
       //Loup
       for (int i=1;i<=nbLoup;i++){
           
           Loup thing= new Loup();
           definePos(thing);
       }
       //Lapins
       for (int i=1;i<=nbLapin;i++){
           
           Lapin thing= new Lapin();
           definePos(thing);
       }
       //Potions
       for (int i=1;i<=nbPotion;i++){
           PotionSoin thing= new PotionSoin();
           definePos(thing);
       }
       //Epee
       for (int i=1;i<=nbEpee;i++){
           
           Epee thing= new Epee();
           definePos(thing);
       }
       
       //Nourriture
       for (int i=1; i<=nbNourriture; i++){
           
           Nourriture thing = createFood();
           definePos(thing);
        }
       
        //Nuage Toxique
        for (int i=1; i < nbNuageToxique; i++){
            NuageToxique thing = new NuageToxique(3,(int)Math.floor(Math.min(largeur, longueur)*0.2),r.nextInt(8),null);
            definePos(thing);
        }       
   }
   /**
    * Affiche les attributs du monde
    */
   public void afficheWorld(){
       System.out.println("["+this.longueur+","+this.largeur+"]");
       int j=listeEntite.length;
       for (int i=0;i<j;i++){
           for (Entite p:listeEntite[i]){
               if (p!=null){
                   p.affiche(); 
               }
           }
        }
    }
   
   public void definePos(Entite thing){
       
       Random r = new Random();
       
       thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           while (listeEntite[thing.getPos().getX()][thing.getPos().getY()]!=null){
                thing.setPos(new Point2D (r.nextInt(this.longueur),r.nextInt(this.largeur)));
           }
           this.listeEntite[thing.getPos().getX()][thing.getPos().getY()]=thing;
   }
   
   public Nourriture createFood(){
       
       Random r = new Random();
       
       String[] listeStats = new String[]{"degAtt","ptPar","pageAtt","pagePar","distAttMax"};
       String[] listeNomsBonus = new String[]{"Pomme", "Pasteque", "Pain", "Viande de boeuf cuite"};
       String[] listeNomsMalus = new String[]{"Patate germee","Oeil d'araignee", "Viande putrifiee", "Poisson Globe"};
       
       String statNomModif = listeStats[r.nextInt(5)];
       int plage = 7;
       String nom;
       int modifBase = r.nextInt(plage)-2;
       int modifStat = 0;
       int temps = r.nextInt(4)+1;
      
       
       while ( 0 != modifBase){
           modifBase = r.nextInt(plage)-2;
       }
       
       switch (statNomModif){
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
               modifStat = r.nextInt(5)-2;
       }
       
       if (modifStat<0){
           nom = listeNomsMalus[r.nextInt(listeNomsMalus.length)];
       }
       else{
           nom = listeNomsBonus[r.nextInt(listeNomsBonus.length)];
       }
       
       
       return new Nourriture(nom,modifStat,temps,statNomModif, false, null);
       
       
   }
   
   
   public boolean estTermine(int n){
       return (this.joueur.getPerso().getPtVie()<=0);
   }
   public void tourDeJeu(){
       int n=0; //nombre de tours
       while (!estTermine(n)){
           
           
           this.afficheMonde(this);
           System.out.print("Voici les stats acutelles de votre personnage");
           joueur.getPerso().affiche();

           this.joueur.tourDeJoueur(n, this);

           for (Entite[] ligne: listeEntite){
               for (Entite ia:ligne){

                   if (ia instanceof Creature && ia!=this.joueur.getPerso()){
                       ((IA)ia).tourIA((this));
                   }
                   if(ia instanceof NuageToxique){
                       ((NuageToxique) ia).combattre(((NuageToxique) ia).peutCombattre(this));
                       if(((NuageToxique) ia).peutCombattre(this).contains(this.joueur.getPerso())){
                           System.out.println("Fuyez pauvres fous");
                           if (this.joueur.getPerso().getPtVie()<=0){
                               System.out.println("Vous avez succombé au nuage toxique");
                            }
                        }
                    }
                }

            }
            
            for (Utilisable cooldown:joueur.getEffets()){
                ((Nourriture)cooldown).expiration();
                
                if (((Nourriture)cooldown).getToursRestants()<=0){
                    joueur.getEffets().remove(cooldown);
                }
                
            }
            
            n++;
       }
       System.out.println("Game Over,"+"\n"+"Vous avez survécu "+n+" tours");
   }
   public void afficheMonde(World monde){
        Entite[][] map=monde.getListeEntite();
        for (int i=0;i<=map.length;i++){
            String afficheLigne="";
            for (Entite item : map[i]) {
                if (item==monde.getJoueur().getPerso()){
                    afficheLigne+="Vous ";
                }
                if (item==null){
                    afficheLigne+="* ";
                }
                if (item instanceof Guerrier){
                    afficheLigne+="G ";
                }
                if (item instanceof Archer){
                   afficheLigne+="A "; 
                }
                if (item instanceof Loup){
                    afficheLigne+="L";
                }
                if (item instanceof Lapin){
                    afficheLigne+="B";
                }
                if (item instanceof Paysan){
                    afficheLigne+="P";
                }
                if (item instanceof PotionSoin){
                    afficheLigne+="J";
                }
                if(item instanceof Nourriture){
                    afficheLigne+="N";
                }
                if (item instanceof NuageToxique){
                    afficheLigne+="Nuage "+String.valueOf((((NuageToxique) item)).getRayonAtt())+" ";
                }
                if (item instanceof Epee){
                    afficheLigne+="E ";
                }
                
            }
            System.out.println(afficheLigne);
        }
    }
}
