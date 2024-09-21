/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author clesp
 */
public class Epee extends Objet {
    private int Bonus;

    /**
     *
     * @param Bonus Bonus d'attaque au détenteur de l'arme
     */
    public Epee(int Bonus) {
        this.Bonus = Bonus;
    }
    /**
     * 
     * @param e Copie d'une épée
     */
    public Epee (Epee e){
        this.Bonus=e.Bonus;
    }

    /**
     *
     */
    public Epee (){
    }
    //Getter

    /**
     *
     * @return
     */
    public int getBonus() {
        return Bonus;
    }
    //Setter

    /**
     *
     * @param Bonus
     */
    public void setBonus(int Bonus) {
        this.Bonus = Bonus;
    }
    
    
}
