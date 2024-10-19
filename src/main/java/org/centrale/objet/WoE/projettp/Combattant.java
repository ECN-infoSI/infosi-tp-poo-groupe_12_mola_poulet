package org.centrale.objet.WoE.projettp;

import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public interface Combattant {
    
    /**
     *
     * @param adversaire adversaire à combattre
     */
    public void combattre(Creature adversaire);

    /**
     *
     * @param monde
     * @return
     * renvoie la liste des entités combattables
     */
    public ArrayList<Creature> peutCombattre(World monde);
    
}
