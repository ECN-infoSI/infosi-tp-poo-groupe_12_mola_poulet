/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.StringTokenizer;

/**
 *
 * @author clesp
 */
public class Epee extends Objet implements Ramassable,Sauvegarde{
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
        this.name="Epeelambda";
        this.bonus=2;
    }

    /**
     *
     * @param ligne informations
     * charge l'épée d'une sauvegarde
     */
    public Epee(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        s=tokenizer.nextToken();
        this.name=s;
        s=tokenizer.nextToken();
        //chargement de la position si l'épée n'est pas équipée
        this.bonus=Integer.parseInt(s);
        if (tokenizer.hasMoreTokens()){
            s=tokenizer.nextToken();
            this.getPos().setX(Integer.parseInt(s));
            s=tokenizer.nextToken();
            this.getPos().setY(Integer.parseInt(s));
        }
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
    
    /**
     *
     * @param player joueur qui équipe l'épée
     */
    public void equiper(Joueur player){
        
        if (!(player.getPerso() instanceof Guerrier)){
            System.out.println("seul un guerrier peut equiper une epee");
        }
        else{
            Guerrier rambo = ((Guerrier)player.getPerso());
            
            if (rambo.getArme() == null){
                
                rambo.setArme(this);
                rambo.setDegAtt(rambo.getDegAtt() + bonus);
                
            }
            else{
                rambo.setDegAtt(rambo.getDegAtt()-rambo.getArme().getBonus() + this.bonus);
                rambo.setArme(this);

                
            }
        }
        
    }

    /**
     *
     * @return
     * Sauvegarde l'épée
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Epee "+this.name+" "+this.bonus+" "+this.getPos().getX()+" "+this.getPos().getY()));
        return s;
    }
}
    
