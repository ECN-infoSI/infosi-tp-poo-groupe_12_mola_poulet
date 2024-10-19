package org.centrale.objet.WoE.projettp;

import static java.lang.Math.max;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class Nourriture extends Objet implements TempsAttente, Utilisable, Ramassable,Sauvegarde{
    
    private String nom;
    private int modif;
    private int toursRestants;
    private String statModifiee;
    private boolean consomme;
    
    /**
     *
     * @param name Nom du plat
     * @param boost Bonus ou malus du plat
     * @param temps Nombre de tours d'effet
     * @param stat Stat affectée
     * @param bouffe Est consommée ou pas
     * @param pos Position
     */
    public Nourriture(String name, int boost, int temps, String stat, boolean bouffe, Point2D pos){
        
        super(pos);
        nom = name;
        modif = boost;
        toursRestants = temps;
        statModifiee = stat;
        consomme = bouffe;    
        
    }
    
    /**
     *
     * @param food
     * Copie de nourriture
     */
    public Nourriture(Nourriture food){
        
        super((Objet)food);
        this.nom = food.nom;
        this.modif = food.modif;
        this.toursRestants = food.toursRestants;
        this.statModifiee = food.statModifiee;
        this.consomme = food.consomme;
        
    }
    
    /**
     *
     */
    public Nourriture(){
 
        super();  
    }
    
    /**
     *
     * @param ligne
     * Génération de nourriture sauvegardée
     */
    public Nourriture (String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        if(s.equals("Inventaire")){
            s=tokenizer.nextToken();
        }
        s=tokenizer.nextToken();
        this.nom=s;
        s=tokenizer.nextToken();
        this.modif=Integer.parseInt(s);
        s=tokenizer.nextToken();
        this.toursRestants=Integer.parseInt(s);
        s=tokenizer.nextToken();
        this.statModifiee=s;
        s=tokenizer.nextToken();
        this.consomme=Boolean.parseBoolean(s);
        s=tokenizer.nextToken();
        this.getPos().setX(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setY(Integer.parseInt(s));

    }
    //getters
    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getModif() {
        return modif;
    }

    /**
     *
     * @return
     */
    public int getToursRestants() {
        return toursRestants;
    }

    /**
     *
     * @return
     */
    public String getStatModifiee() {
        return statModifiee;
    }

    /**
     *
     * @return
     */
    public boolean isConsomme() {
        return consomme;
    }
    //setters
    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param modif
     */
    public void setModif(int modif) {
        this.modif = modif;
    }

    /**
     *
     * @param toursRestants
     */
    public void setToursRestants(int toursRestants) {
        this.toursRestants = toursRestants;
    }

    /**
     *
     * @param statModifiee
     */
    public void setStatModifiee(String statModifiee) {
        this.statModifiee = statModifiee;
    }

    /**
     *
     * @param consomme
     */
    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }
    //méthodes
    /**
     *Diminue le temps d'effet et le fait disparaitre
     */
    @Override
    public void expiration(Joueur player) {
        
        if (toursRestants <= 0 & consomme==true){
            this.setModif(-this.getModif());
            this.utilisation(player);
            System.out.println("Fin de l'effet de "+this.nom);
        }
        else if (consomme==true){
            this.setToursRestants(this.getToursRestants()-1);
        }
    }
    
    /**
     *
     * @param player
     * Utilisation d'un objet
     */
    @Override
    public void utilisation(Joueur player){
        
        Personnage mainCharacter = player.getPerso();
        
        switch (statModifiee){
        
            case "degAtt":
                mainCharacter.setDegAtt(max(0, mainCharacter.getDegAtt() + modif));
                break;
                
            case "ptPar":
                mainCharacter.setPtPar(max(0,mainCharacter.getPtPar() + modif));
                break;
                
            case "pageAtt":
                mainCharacter.setPageAtt(max(0, -max(-100, -(mainCharacter.getPageAtt() + modif))));
                break;
                
            case "pagePar":
                mainCharacter.setPagePar(max(0, -max(-100, -(mainCharacter.getPagePar() + modif))));
                break;
                
            case "distAttMax":
                mainCharacter.setDistAttMax(max(0, mainCharacter.getDistAttMax() + modif));
                break;
                
        }
        consomme = true;
        player.getInventaire().getContenu().remove(this);
        player.getEffets().add(this);
    }

    /**
     *
     */
    @Override
    public void affiche(){
        System.out.println("Nourriture : "+"\n"+modif+" sur "+this.statModifiee+" pendant "+this.toursRestants);
    }

    /**
     *
     * @return
     * Sauvegarde de nourriture
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Nourriture "+this.nom+" "+this.modif+" "+this.toursRestants+" "+this.statModifiee+" "+this.consomme+" "+this.getPos().getX()+" "+this.getPos().getY()));
        return s;
    }
    
}
