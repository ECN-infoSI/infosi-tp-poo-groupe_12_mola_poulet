/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

import java.util.ArrayList;

/**
 *
 * @author Amolz
 */
public class Inventaire {
    
    private int capacite;
    private ArrayList<Objet> contenu;
    
    private int defaultCapacite = 15;
    
    /**
     *
     * @param taille Taille inventaire
     * @param inInventory Contenu
     */
    public Inventaire(int taille, ArrayList<Objet> inInventory){
        
        capacite = taille;
        contenu = inInventory;
        
    }
        
    /**
     *
     * @param inventory
     * Copie superficielle d'un inventaire
     */
    public Inventaire(Inventaire inventory){
        
        this.capacite = inventory.capacite;
        this.contenu = inventory.contenu;
    }
    
    /**
     *
     */
    public Inventaire(){
        
        capacite = defaultCapacite;
        contenu = new ArrayList<>();
        
    }
    //Getters
    /**
     *
     * @return
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     *
     * @return
     */
    public ArrayList<Objet> getContenu() {
        return contenu;
    }
    //setters
    /**
     *
     * @param capacite
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     *
     * @param contenu
     */
    public void setContenu(ArrayList<Objet> contenu) {
        this.contenu = contenu;
    }
    //Méthodes
    /**
     *
     * @param item
     * ajoute un objet dans l'inventaire
     */
    public void ajout(Objet item){
        
        if (item instanceof NuageToxique){
            System.out.println("Impossible de mettre du gaz dans son inventaire");
        }
        else{
            contenu.add(item);
        }
        
    }

    /**
     * affiche l'inventaire
     */
    public void affiche(){
        for(int i=0;i<this.contenu.size();i++){
            System.out.println("i- ");
            this.contenu.get(i).affiche();
        }
    }
    
}
