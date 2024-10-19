package org.centrale.objet.WoE.projettp;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clesp
 */
public class Guerrier extends Personnage implements Combattant,IA,Sauvegarde {
    private Epee arme;
    
    //Constructeurs

    /**
     *
     * @param name Nom
     * @param pV Points de vie
     * @param dA Dégâts attaque
     * @param pPar Point de parade
     * @param paAtt Pourcentage de réussite attaque
     * @param paPar Pourcentage de réussite parade
     * @param dMax Distance attaque max
     * @param arme Arme
     * @param p Position
     */
    public Guerrier(String name,int pV,int dA,int pPar,int paAtt, int paPar, int dMax,Epee arme, Point2D p){
        super(name,pV,dA,pPar,paAtt,paPar,dMax,p);
        this.arme=arme;
    }

    /**
     *
     */
    public Guerrier(){
        super();
        this.arme=new Epee();
    }

    /**
     *
     * @param g Copie profonde d'un guerrier
     */
    public Guerrier(Guerrier g){
        super((Personnage) g);
        this.arme=new Epee(g.arme);
    }
    
    /**
     *
     * @param ligne
     * Chargement d'un guerrier sauvegardé
     */
    public Guerrier(String ligne){
        super();
        StringTokenizer tokenizer=new StringTokenizer(ligne," ");
        String s=tokenizer.nextToken();
        if (s.equals("Joueur")){
            s=tokenizer.nextToken();
        }
        s=tokenizer.nextToken();
        this.setNom(s);
        s=tokenizer.nextToken();
        this.setPtVie(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setDegAtt(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPtPar(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPageAtt(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setPagePar(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.setDistAttMax(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setX(Integer.parseInt(s));
        s=tokenizer.nextToken();
        this.getPos().setY(Integer.parseInt(s));
        //chargement de l'épée équipée
        s=tokenizer.nextToken()+" ";
        while (tokenizer.hasMoreTokens()){
            s+=tokenizer.nextToken()+" ";
        }
        this.arme=new Epee(s);
    }
    //getters

    /**
     *
     * @return
     */
    public Epee getArme() {
        return arme;
    }
    
    //setters

    /**
     *
     * @param arme
     */

    public void setArme(Epee arme) {
        this.arme.setBonus(arme.getBonus());
    }
    
    //méthodes
    
    /**
     * Affiche les attributs d'un guerrier
     */
    @Override
    public void affiche(){
        System.out.println("Nom "+this.getNom()+"\n"+"pv "+this.getPtVie()+"\n"+"att "+this.getDegAtt()+"\n"+"Par "+this.getPtPar()+"\n"+"PaAtt "+this.getPageAtt()+"\n"+"PaPar "+this.getPagePar()+"\n"+"Distance attaque max "+this.getDistAttMax());
        this.getArme().affiche();
        this.getPos().affiche();
    }
    
    /**
     * Système de combat (corps à corps)
     * @param c Créature à combattre
     */
    
    @Override
    public void combattre(Creature c){
        Random r=new Random();
        if (this.getPos().distance(c.getPos())<=Math.sqrt(2)){
            //Case adjacente (distance inférieure à sqrt(2)
            int n=r.nextInt(101);
            if (n<=this.getPageAtt()){
                //Attaque réussie
                int k=r.nextInt(101);
                if (k>c.getPagePar()){
                    //Parade ratée
                    c.setPtVie(Math.max(c.getPtVie()-this.getDegAtt()-this.getArme().getBonus(),0));  
                }
                else{
                    //Parade réussie
                    c.setPtVie(Math.max(0,Math.min(c.getPtVie(),c.getPtVie()-this.getDegAtt()-this.getArme().getBonus()+c.getPtPar())));
                }
            }
        }
    }

    /**
     *
     * @param monde
     * @return
     * renvoie la liste des entités combattables
     */
    @Override
    public ArrayList<Creature> peutCombattre(World monde){
        ArrayList<Creature> tab=new ArrayList<>();
        for (int i=0;i<monde.getLongueur();i++){
            for(int j=0;j<monde.getLargeur();j++){
                if (i!=this.getPos().getX() || j!=this.getPos().getY()){
                if (monde.getListeEntite()[i][j]!=null && monde.getListeEntite()[i][j] instanceof Creature){
                    if (this.getPos().distance(monde.getListeEntite()[i][j].getPos())<=Math.sqrt(2)*this.getDistAttMax()){
                        tab.add((Creature)monde.getListeEntite()[i][j]);
                    }
                }
                }
            }
        }
        if (tab.isEmpty()){
            tab=null;
        }
        return tab;
    }

    /**
     *
     * @param monde
     * Tour d'un guerrier IA
     */
    @Override
    public void tourIA(World monde){
        ArrayList<Creature> liste=this.peutCombattre(monde);
        //Combat si le joueur est à portée
        if (null != liste && liste.contains(monde.getJoueur().getPerso())){
            System.out.println("Un guerrier vous attaque !");
            this.combattre(monde.getJoueur().getPerso());
            if (monde.getJoueur().getPerso().getPtVie()<=0){
                System.out.println("Vous êtes mort");
            }
            else{
                System.out.println("Vous avez survécu");
            }
        }
        else{
            Random r=new Random();
            int n=r.nextInt(8);
            this.deplace(n,monde);
        }
    }

    /**
     *
     * @return
     * Sauvegarde un guerrier
     */
    @Override
    public String sauvegardeElement() {
        String s=((String)("Guerrier "+this.getNom()+" "+this.getPtVie()+" "+this.getDegAtt()+" "+this.getPtPar()+" "+this.getPageAtt()+" "+this.getPagePar()+" "+this.getDistAttMax()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+" "+"Epee "+this.arme.getName()+" "+this.arme.getBonus()));
        return s;
    }
}
