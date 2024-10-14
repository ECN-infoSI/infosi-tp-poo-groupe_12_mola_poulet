package org.centrale.objet.WoE.projettp;

import static java.lang.Math.max;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class Nourriture extends Objet implements TempsAttente, Utilisable{
    
    private int modif;
    private int toursRestants;
    private String statModifiee;
    private boolean consomme;
    
    public Nourriture(int boost, int temps, String stat, boolean bouffe, Point2D pos){
        
        super(pos);
        modif = boost;
        toursRestants = temps;
        statModifiee = stat;
        consomme = bouffe;    
        
    }
    
    public Nourriture(Nourriture food){
        
        super((Objet)food);
        this.modif = food.modif;
        this.toursRestants = food.toursRestants;
        this.statModifiee = food.statModifiee;
        this.consomme = food.consomme;
        
    }
    
    public Nourriture(){
        
        super();
        
    }

    public int getModif() {
        return modif;
    }

    public int getToursRestants() {
        return toursRestants;
    }

    public String getStatModifiee() {
        return statModifiee;
    }

    public boolean isConsomme() {
        return consomme;
    }

    public void setModif(int modif) {
        this.modif = modif;
    }

    public void setToursRestants(int toursRestants) {
        this.toursRestants = toursRestants;
    }

    public void setStatModifiee(String statModifiee) {
        this.statModifiee = statModifiee;
    }

    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }

    
    @Override
    public void expiration() {
        
        if (toursRestants <= 0 & consomme==true){
            this.setModif(0);
        }
        else if (consomme==true){
            this.setToursRestants(this.getToursRestants()-1);
        }
    }
    

    @Override
    public void utilisation(Joueur player){
        
        Personnage mainCharacter = player.getPerso();
        
        switch (statModifiee){
        
            case "degAtt":
                mainCharacter.setDegAtt(max(0, mainCharacter.getDegAtt() + modif));
                break;
                
            case "ptPar":
                mainCharacter.setPtPar(mainCharacter.getPtPar() + modif);
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
    @Override
    public void affiche(){
        System.out.println("Nourriture : "+"\n"+modif+" sur "+this.statModifiee+" pendant "+this.toursRestants);
    }
    
    
}
