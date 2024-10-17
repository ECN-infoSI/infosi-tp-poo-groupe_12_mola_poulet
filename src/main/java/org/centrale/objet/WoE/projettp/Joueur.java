package org.centrale.objet.WoE.projettp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author clesp
 */
public class Joueur {
    public Personnage perso;
    private String nom;
    private String login;
    private String password;
    private List<Utilisable> effets;
    private Inventaire inventaire;
    public final static Class[] list_classes={Archer.class,Guerrier.class};
    
    public Joueur(){
        this.perso=new Personnage();
        this.nom="Matteo Lamblin";
        this.login="jaimelacrypte";
        this.password="user";
        this.effets = new ArrayList();
        this.inventaire = new Inventaire();
    }

    public Joueur(Personnage personnage, String name, String log, String pwrd, List<Utilisable> liste, Inventaire inventory) {
        this.perso = personnage;
        this.nom = name;
        this.login = log;
        this.password = pwrd;
        this.effets = liste;
        this.inventaire = inventory;
    }
    public Joueur(Joueur player){
        this.perso=new Personnage(player.perso);
        this.nom=player.nom;
        this.login=player.login;
        this.password=player.password;
        this.effets = player.effets;
        this.inventaire = player.inventaire;
    }

    public Personnage getPerso() {
        return perso;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Utilisable> getEffets() {
        return effets;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }
    

    public void setPerso(Personnage perso) {
        this.perso = new Personnage(perso);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private Class appartient(Class classe,Class[] liste){
        Class res=null;
        for (Class liste1 : liste) {
            if (liste1.equals(classe)) {
                res = liste1;
            }
        }
        return res;
    }
    public void demande(){
        Random r=new Random();
        System.out.println("Entrez la classe voulue : "+"\n"+"Au choix parmi : ");
        for (Class classe: list_classes){
            System.out.println(classe.getSimpleName());
        }
        Scanner s=new Scanner(System.in);
        String name=s.next();
        try{
            Class classeJoueur=Class.forName("org.centrale.objet.WoE.projettp."+name);
            Class res=this.appartient(classeJoueur,list_classes);
            if (res!=null){ 
                System.out.println("Rentrez son nom : ");
                String nomPerso=s.next();
                switch (res.getSimpleName()){
                    case "Archer": 
                        this.perso=new Archer(nomPerso,20+r.nextInt(21),10+r.nextInt(11),5+r.nextInt(6),60+r.nextInt(36),20+r.nextInt(11),2+r.nextInt(5),new Point2D(0,0),30+r.nextInt(31));
                        break;
                    case "Guerrier":
                        this.perso=new Guerrier(nomPerso,30+r.nextInt(21),20+r.nextInt(21),15+r.nextInt(11),80+r.nextInt(16),10+r.nextInt(11),1,new Epee(),new Point2D(0,0));
                        break;
                    default: 
                       System.out.println("Vous ne pouvez pas jouer cette classe");
                       this.demande();
                }
            }
            else{
                System.out.println("Vous ne pouvez pas jouer cette classe");
                this.demande();
            }
        } catch(ClassNotFoundException e){
            System.out.println("Veulliez reecrire le nom, il semble y avoir une erreur de saisie");
            this.demande();
        }
    }
    
    public Objet[] objetsVoisins(World monde){
        
        
        Objet[] voisinage = new Objet[8];
        int[] listeNb={5,6,7,4,0,3,2,1};
        int nb=0;
        
        Personnage mainCharacter = this.perso;

        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                
                if(j!=0 || i!=0){
                    if (mainCharacter.getPos().getX()>0+i && mainCharacter.getPos().getX()+i<monde.getLongueur() && mainCharacter.getPos().getY()+j>0 && mainCharacter.getPos().getY()+j<monde.getLargeur()){
                        Entite thing = monde.getListeEntite()[mainCharacter.getPos().getX()+i][mainCharacter.getPos().getY()+j];
                        if (thing instanceof Ramassable)
                        voisinage[listeNb[nb]]=(Objet)thing;
                        nb++;
                    }
                }
            } 
        }
        if (voisinage == new Objet[]{null,null,null,null,null,null,null,null}){
            voisinage = null;
        }
        return voisinage;
    }
        
    
    
    public void tourDeJoueur(int n,World monde){
        
        Scanner s=new Scanner(System.in);
            
        String[] cardinalites={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest"};
        
        System.out.println("Voulez-vous vous deplacer, ramasser un objet, utiliser un objet, combattre ou ne rien faire ?"+"\n"+
                            "Tapez 1 pour vous deplacer"+"\n"+
                            "Tapez 2 pour ramasser un objet"+"\n"+
                            "Taper 3 pour utiliser un objet"+"\n"+
                            "Tapez 4 pour attaquer une creature a portee"+"\n"+
                            "Tapez 0 pour ne rien faire");
        String choix=s.next();
        switch (choix){

            case "0" :
                break;
            
            case "1" : 
                try{
                    boolean[]liste=this.perso.estDeplacable(monde);
                    for (int i=0;i<liste.length;i++){
                            if (liste[i]){
                                    System.out.println("Tapez "+i+" pour vous deplacer dans la direction "+cardinalites[i]);
                            }
                    }
                    choix=s.next();
                    try{
                        int ch=Integer.parseInt(choix);
                        if (liste[ch]){
                            this.perso.deplace(ch,monde);
                        }
                        else{
                                System.out.println("Il y a une erreur, refaites un choix");
                                this.tourDeJoueur(n,monde);
                            }
                    }
                    catch(NumberFormatException exc){
                              System.out.println("Il y a une erreur, refaites un choix");
                              this.tourDeJoueur(n,monde);
                    }
                }
                catch(NullPointerException error){
                    System.out.println("Vous ne pouvez pas vous deplacer, choisissez une autre action");
                    tourDeJoueur(n,monde);
                }

                break;
                
            case "2":
                if (inventaire.getContenu().size()>=inventaire.getCapacite()){
                        System.out.println("Inventaire plein, impossible de ramasser quoique ce soit");
                        tourDeJoueur(n,monde);
                    }
                else{
                    try{

                        Objet[] objetsProx = objetsVoisins(monde);

                        for (int i=0; i<objetsProx.length;i++){
                            Objet item = objetsProx[i];
                            if (item instanceof PotionSoin)
                                System.out.println("Tapez "+i+" pour ramasser une potion de soin"+"("+((PotionSoin)item).getPvRendus()+"pv rendus)");

                            else if (item instanceof Nourriture){
                                System.out.println("Tapez "+i+" pour ramasser "+((Nourriture)item).getNom()+"("+((Nourriture)item).getModif()+((Nourriture)item).getStatModifiee()+")");
                            }

                        }

                        choix = s.next();
                        try{

                            int itemGrabNum = Integer.parseInt(choix);
                            Objet itemGrab = objetsProx[itemGrabNum];
                            int itemX = itemGrab.getPos().getX();
                            int itemY = itemGrab.getPos().getY();
                            
                            inventaire.getContenu().add(itemGrab);
                            monde.getListeEntite()[itemX][itemY] = null;
                        }
                        catch(NumberFormatException error){
                            System.out.println("Il y a une erreur, refaites un choix");
                            tourDeJoueur(n,monde);
                        }

                    }
                    catch(NullPointerException error){
                        System.out.println("Aucun objet ramassable a proximite");
                        tourDeJoueur(n,monde);
                    }
                }
                break;

            case "3":
                ArrayList<Objet> possessions = this.inventaire.getContenu();

                try{
                    for (int i = 0; i<possessions.size();i++){

                        Objet item = possessions.get(i);

                        if (item instanceof PotionSoin)
                            System.out.println("Tapez "+i+" pour utliser "+item.toString()+"("+((PotionSoin)item).getPvRendus()+"pv rendus)");

                        else if (item instanceof Nourriture){
                            System.out.println("Tapez "+i+" pour utliser "+item.toString()+"("+((Nourriture)item).getModif()+((Nourriture)item).getStatModifiee()+")");
                        }
                    }

                    choix = s.next();
                    int item_used_num = Integer.parseInt(choix);

                    if (item_used_num >= possessions.size()){
                        System.out.println("Erreur, il n'y a pas un tel objet a utiliser");
                        this.tourDeJoueur(n, monde);
                    }
                    else{
                        Objet item_used = possessions.get(item_used_num);

                        if (item_used instanceof PotionSoin){
                            ((PotionSoin)item_used).utilisation(this);
                            System.out.println("Votre personnage a maintenant "+this.getPerso().getPtVie()+" pv");
                        }
                        else if (item_used instanceof Nourriture){
                            Nourriture plat = (Nourriture)item_used;
                            plat.utilisation(this);
                            System.out.println("Votre personnage a vu sa stat " +plat.getStatModifiee() + " changee de " + plat.getModif() + "points");
                        }
                    }

                }
                catch(IllegalStateException error){
                    System.out.println("il n'a pas d'objet dans votre inventaire");
                    this.tourDeJoueur(n, monde);
                }

                break;
            case "4": 
                for (int i=0;i<((Combattant)this.perso).peutCombattre(monde).size();i++){

                        System.out.println("Tapez"+i+" pour frapper un "+((Combattant)this.perso).peutCombattre(monde).get(i).getClass().getSimpleName()+ " a la position ");
                        ((Combattant)this.perso).peutCombattre(monde).get(i).getPos().affiche();
                }
                choix=s.next();
                try{

                    Creature ennemi = ((Combattant)this.perso).peutCombattre(monde).get(Integer.parseInt(choix));

                    ((Combattant)this.perso).combattre(ennemi);
                    if (ennemi.getPtVie()<=0){
                        monde.getListeEntite()[ennemi.getPos().getX()][ennemi.getPos().getY()]=null;
                        System.out.println("Cible vaincue");
                    }
                    else{
                        System.out.println("La cible a survecue");
                    }
                }catch(NumberFormatException exc){
                    this.tourDeJoueur(n,monde);
                }
                break;
            default : 
                this.tourDeJoueur(n,monde);
                break;
        }
    }
}
