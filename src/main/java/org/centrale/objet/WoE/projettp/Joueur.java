/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author clesp
 */
public class Joueur {
    public Personnage perso;
    private String nom;
    private String login;
    private String password;
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
    
    public void appartient(Object[] liste){
        for (int j=0;j<=liste.length ;j++){
            
        }
}
    public void demande(){
        System.out.println("Rentrez votre classe voulue : ");
        Scanner s=new Scanner(System.in);
        String nom=s.next();
        try{
            Class classeJoueur=Class.forName(nom);
        } catch(ClassNotFoundException e){
            System.out.println("Veuliez réecrire le nom, il semble y avoir une erreur de saisie");
            this.demande();
        }
        if (classeJoueur.appartient(list_classes) ){
        
    }
        
        
    }
    
}
