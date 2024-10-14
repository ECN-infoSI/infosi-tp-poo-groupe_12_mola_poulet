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
    private ArrayList<Objet> dansInventaire;
    
    private int defaultCapacite = 20;
    
    public Inventaire(int taille, ArrayList<Objet> inInventory){
        
        capacite = taille;
        dansInventaire = inInventory;
        
    }
    
    public Inventaire(Inventaire inventory){
        
        this.capacite = inventory.capacite;
        this.dansInventaire = inventory.dansInventaire;
    }
    
    public Inventaire(){
        
        capacite = defaultCapacite;
        dansInventaire = new ArrayList();
        
    }
    
    public void ajout(Objet item){
        
        if (item instanceof NuageToxique){
            System.out.println("Impossible de mettre du gaz dans son inventaire");
        }
        else{
            dansInventaire.add(item);
        }
        
    }
    
}
