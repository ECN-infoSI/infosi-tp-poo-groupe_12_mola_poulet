/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import static java.sql.JDBCType.NULL;

/**
 *
 * @author clesp
 */
public class Epee extends Objet implements Utilisable{
    private String name;
    private int bonus;

    /**
     *
     * @param nom Nom de l'épée
     * @param bonus Bonus d'attaque
     * @param p
     */
    public Epee(String nom,int bonus,Point2D p) {
        super(p);
        this.name=nom;
        this.bonus = bonus;
    }
    /**
     * 
     * @param e Copie d'une épée
     */
    public Epee (Epee e){
        super((Objet) e);
        this.name=e.name;
        this.bonus=e.bonus;
    }

    /**
     *
     */
    public Epee (){
        super();
        this.name="Epee lambda";
        this.bonus=5;
    }
    //Getter

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    public int getBonus() {
        return bonus;
    }
    //Setter

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @param bonus 
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    //méthodes
    
    /**
     * Affiche les attributs de l'épée
     */
    @Override
    public void affiche(){
        System.out.println("[Nom de l'arme : "+this.name+", Bonus de l'arme : "+this.bonus+"]");
    }
    
    @Override
    public void utilisation(Joueur player){
        
        if (!(player.getPerso() instanceof Guerrier)){
            System.out.println("seul un guerrier peut equiper une epee");
        }
        else{
            Guerrier rambo = ((Guerrier)player.getPerso());
            
            if (rambo.getArme() == null){
                
                rambo.setArme(this);
                rambo.setDegAtt(rambo.getDegAtt() + bonus);
                rambo.getInventaire().add(this);
                
            }
            else{
                rambo.setDegAtt(rambo.getDegAtt()-rambo.getArme().getBonus() + this.bonus);
                rambo.setArme(this);
                rambo.getInventaire().remove(rambo.getArme());
                rambo.getInventaire().add(this);
                
            }
        }
        
    }
    
}
