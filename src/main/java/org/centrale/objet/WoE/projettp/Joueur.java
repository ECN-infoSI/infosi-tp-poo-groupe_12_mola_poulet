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
    
    public ArrayList<Objet> objetsVoisins(World monde){
        ArrayList<Objet> tab=new ArrayList<>();
        
        for (int i=0;i<monde.getLongueur();i++){
            for(int j=0;j<monde.getLargeur();j++){
                
                if (monde.getListeEntite()[i][j]!=null && monde.getListeEntite()[i][j] instanceof Ramassable){
                    
                    if (this.perso.getPos().distance(monde.getListeEntite()[i][j].getPos())<2){
                        tab.add((Objet)monde.getListeEntite()[i][j]);
                    }
                }
            }
        }
        if (tab.isEmpty()){
            tab=null;
        }
        return tab;
        
        
      
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
                    boolean u=liste[0];
                    for (int i=0;i<liste.length;i++){
                            if (liste[i]){
                                    System.out.println("Tapez "+i+" pour vous deplacer dans la direction "+cardinalites[i]);
                            }
                    }
                    choix=s.next();
                    try{
                        int ch=Integer.parseInt(choix);
                        ch=ch%8;
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
                    this.tourDeJoueur(n,monde);
                }

                break;
                
            case "2":
                if (inventaire.getContenu().size()>=inventaire.getCapacite()){
                        System.out.println("Inventaire plein, impossible de ramasser quoique ce soit");
                        this.tourDeJoueur(n,monde);
                    }
                else{
                        ArrayList<Objet> objetsProx = this.objetsVoisins(monde);
                        try{
                            for (int i=0; i<objetsProx.size();i++){
                                Objet item = objetsProx.get(i);
                                if (item instanceof PotionSoin){
                                    System.out.println("Tapez "+i+" pour ramasser une potion de soin"+"("+((PotionSoin)item).getPvRendus()+"pv rendus)");
                                }
                                if (item instanceof Nourriture){
                                    System.out.println("Tapez "+i+" pour ramasser "+((Nourriture)item).getNom()+"("+((Nourriture)item).getModif()+((Nourriture)item).getStatModifiee()+")");
                                }
                                if (item instanceof Epee){
                                    System.out.println("Tapez "+i+" pour ramasser"+((Epee)item).getName()+"("+((Epee)item).getBonus()+")");
                                }
                            }
                            choix = s.next();
                                
                            try{

                                int itemGrabNum = Integer.parseInt(choix);
                                if(itemGrabNum<=objetsProx.size()){
                                    Objet itemGrab = objetsProx.get(itemGrabNum);
                                    if(itemGrab instanceof Epee){
                                        ((Epee) itemGrab).equiper(this);
                                    }
                                    else{
                                    int itemX = itemGrab.getPos().getX();
                                    int itemY = itemGrab.getPos().getY();

                                    inventaire.getContenu().add(itemGrab);
                                    monde.getListeEntite()[itemX][itemY] = null;
                                    }
                                }
                                else{
                                    System.out.println("Il semble y avoir une erreur");
                                    this.tourDeJoueur(n, monde);
                                }
                            }
                            catch(NumberFormatException error){
                                System.out.println("Il y a une erreur, refaites un choix");
                                this.tourDeJoueur(n,monde);
                            }
                        }catch(NullPointerException exc){
                                System.out.println("Aucun objet a ramasser");
                                this.tourDeJoueur(n, monde);
                        }
                    }  
                break;

            case "3":
                ArrayList<Objet> possessions = this.inventaire.getContenu();
                if (this.inventaire.getContenu().isEmpty()){
                    System.out.println("il n'y a pas d'objet dans votre inventaire");
                    this.tourDeJoueur(n, monde);
                }
                else{
                    for (int i = 0; i<possessions.size();i++){

                        Objet item = possessions.get(i);

                        if (item instanceof PotionSoin)
                            System.out.println("Tapez "+i+" pour utliser "+item.getClass().getSimpleName()+"("+((PotionSoin)item).getPvRendus()+"pv rendus)");

                        else if (item instanceof Nourriture){
                            System.out.println("Tapez "+i+" pour utliser "+((Nourriture)item).getNom()+"("+((Nourriture)item).getModif()+((Nourriture)item).getStatModifiee()+")");
                        }
                    }

                    choix = s.next();
                    try{
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
                    }catch(NumberFormatException exc){
                    this.tourDeJoueur(n,monde);
                    }
                }
                break;
            case "4": 
                try{
                for (int i=0;i<((Combattant)this.perso).peutCombattre(monde).size();i++){

                        System.out.println("Tapez "+i+" pour frapper un "+((Combattant)this.perso).peutCombattre(monde).get(i).getClass().getSimpleName()+ " a la position ");
                        ((Combattant)this.perso).peutCombattre(monde).get(i).getPos().affiche();
                        
                }
                choix=s.next();
                try{
                    int ch=Integer.parseInt(choix);
                    if (ch>((Combattant)this.perso).peutCombattre(monde).size()){
                        System.out.println("Il semble il y avoir une erreur");
                        this.tourDeJoueur(n,monde);
                    }
                    else{
                        Creature ennemi = ((Combattant)this.perso).peutCombattre(monde).get(Integer.parseInt(choix));

                        ((Combattant)this.perso).combattre(ennemi);
                        if (ennemi.getPtVie()<=0){
                            monde.getListeEntite()[ennemi.getPos().getX()][ennemi.getPos().getY()]=null;
                            System.out.println("Cible vaincue");
                        }
                        else{
                            System.out.println("La cible a survecue");
                        }
                    }
                }catch(NumberFormatException exc){
                    System.out.println("Il semble il y avoir une erreur");
                    this.tourDeJoueur(n,monde);
                }}
                catch(NullPointerException exc){
                    System.out.println("Aucun combattant à proximite");
                    this.tourDeJoueur(n, monde);
                }
                break;
            default : 
                this.tourDeJoueur(n,monde);
                break;
        }
    }
}
