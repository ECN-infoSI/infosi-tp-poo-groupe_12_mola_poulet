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
    
    public void combattre(Creature adversaire);
    public ArrayList<Creature> peutCombattre(World monde);
    
}
