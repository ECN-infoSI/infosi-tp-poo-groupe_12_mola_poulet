package org.centrale.objet.WoE.projettp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
    }

    public Joueur(Personnage perso, String nom, String login, String password) {
        this.perso = perso;
        this.nom = nom;
        this.login = login;
        this.password = password;
    }
    public Joueur(Joueur j){
        this.perso=new Personnage(j.perso);
        this.nom=j.nom;
        this.login=j.login;
        this.password=j.password;
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
        System.out.println("Rentrez votre classe voulue : "+"\n"+"Au choix parmi : ");
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
            System.out.println("Veuliez réecrire le nom, il semble y avoir une erreur de saisie");
            this.demande();
        }
    }
    
    public void tourDeJoueur(int n,World monde){
        Scanner s=new Scanner(System.in);
        if (this.perso.peutCombattre(monde)!=null && this.perso.estDeplacable(monde)!=null){
            String[] cardinalites={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest"};
            System.out.println("Voulez-vous vous déplacer ou utiliser un objet?"+"\n"+"Taper 1 pour vous déplacer"+"\n"+"Taper 2 pour utiliser un objet"+"\n");
            String choix=s.next();
            switch (choix){
                case "1" : 
                    boolean[]liste=this.perso.estDeplacable(monde);
                    for (int i=0;i<liste.length;i++){
                            if (liste[i]){
                                    System.out.println("Taper "+i+" pour vous déplacer dans la direction "+cardinalites[i]);
                            }
                            choix=s.next();
                            try{
                                int ch=Integer.parseInt(choix);
                                if (liste[ch]){
                                    this.perso.deplace(ch,monde);
                                }
                                else{
                                        System.out.println("Il y a une erreur refaites un choix");
                                        this.tourDeJoueur(n,monde);
                                    }
                            }catch(NumberFormatException exc){
                                      System.out.println("Il y a une erreur refaites un choix");
                                      this.tourDeJoueur(n,monde);
                            }
                    }
                    break;
                case "2": 
                    
                    break;
                case "3": 
                    for (int i=0;i<this.perso.peutCombattre(monde).size();i++){
                            
                            System.out.println("Taper"+i+" pour frapper la créature à la position "+this.perso.peutCombattre(monde).get(i).getPos());
                    }
                    choix=s.next();
                    try{
                        this.perso.combattre(this.perso.peutCombattre(monde).get(Integer.parseInt(choix)));
                    }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                    break;
                default : 
                    this.tourDeJoueur(n,monde);
                    break;
            }
            
        }
        if(this.perso.peutCombattre(monde)==null && this.perso.estDeplacable(monde)!=null){
            System.out.println("Voulez-vous vous déplacer, utiliser un objet ou combattre ?"+"\n"+"Taper 1 pour vous déplacer"+"\n"+"Taper 2 pour utiliser un objet"+"\n"+"Taper 3 pour combattre");
            String choix=s.next();
            switch (choix){
                case "1" : 
                    System.out.println("Taper 0 pour aller au nord rajouter 1 pour pivoter de 45°");
                    choix=s.next();
                    try{
                        this.perso.deplace(Integer.parseInt(choix),monde);
                    }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                    break;
                case "2": 
                    if (inventaire.getContenu().size()!=0){
                inventaire.affiche();
                System.out.println("Quel objet choisissez-vous ?");
                choix=s.next();
                try{
                    Objet objet=inventaire.getContenu()[Integer.parseInt(choix)];
                    //suppression
                    if (objet instanceof PotionSoin){
                        this.perso.soin((PotionSoin)objet);
                    }
                    if (objet instanceof Epee){
                        if (this.perso instanceof Guerrier){
                            ((Guerrier)perso).setArme((Epee)objet);
                        }
                    }
                    else{
                     effets.add(objet);   
                    }
                }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                    }
                    break;
                default : 
                    this.tourDeJoueur(n,monde);
                    break;
            }
        }
        if (this.perso.peutCombattre(monde)!=null && this.perso.estDeplacable(monde)==null){
            System.out.println("Voulez-vous vous combattre ou utiliser un objet?"+"\n"+"Taper 1 pour combattre"+"\n"+"Taper 2 pour utiliser un objet"+"\n");
            String choix=s.next();
            switch (choix){
                case "1" : 
                    for (int i=0;i<this.perso.peutCombattre(monde).size();i++){
                            
                        System.out.println("Taper"+i+" pour frapper la créature à la position "+this.perso.peut_combattre.get(i).getPos());
                    }
                    choix=s.next();
                    try{
                        this.perso.combattre(this.perso.peutCombattre(monde).get(Integer.parseInt(choix));
                    }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                    break;
                case "2":
                    if (inventaire.getContenu().size()!=0){
                inventaire.affiche();
                System.out.println("Quel objet choisissez-vous ?");
                choix=s.next();
                try{
                    Objet objet=inventaire.getContenu()[Integer.parseInt(choix)];
                    //suppression
                    if (objet instanceof PotionSoin){
                        this.perso.soin((PotionSoin)objet);
                    }
                    if (objet instanceof Epee){
                        if (this.perso instanceof Guerrier){
                            ((Guerrier)perso).setArme((Epee)objet);
                        }
                    }
                    else{
                     effets.add(objet);   
                    }
                }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                    }
                    break;
                default : 
                    this.tourDeJoueur(n,monde);
                    break;
            }
            
        }  
        if (this.perso.peutCombattre(monde)==null && this.perso.estDeplacable(monde)==null){
            if (inventaire.getContenu().size()!=0){
                inventaire.affiche();
                System.out.println("Quel objet choisissez-vous ?");
                String choix=s.next();
                try{
                    Objet objet=inventaire.getContenu()[Integer.parseInt(choix)];
                    //suppression
                    if (objet instanceof PotionSoin){
                        this.perso.soin((PotionSoin)objet);
                    }
                    if (objet instanceof Epee){
                        if (this.perso instanceof Guerrier){
                            ((Guerrier)perso).setArme((Epee)objet);
                        }
                    }
                    else{
                     effets.add(objet);   
                    }
                }catch(NumberFormatException exc){
                        this.tourDeJoueur(n,monde);
                    }
                
            }
        }
    }
        
    
}
