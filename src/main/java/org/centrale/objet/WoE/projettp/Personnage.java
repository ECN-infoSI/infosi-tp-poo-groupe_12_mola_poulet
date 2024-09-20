package org.centrale.objet.WoE.projettp;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amolz
 */
public class Personnage {
    private String nom; /*nom du personnage*/
    private int ptVie; /*nombre de point de vie du personnage*/
    private int degAtt; /*degats physiques du personnage*/
    private int ptPar; /* du personnage*/
    private int pageAtt; /*du personnage*/
    private int pagePar; /*du personnage*/
    private int distAttMax; /*distance d'attaque maximale du personnage*/
    private Point2D pos; /*position du personnage*/
    
    public Personnage(String name,int pV,int dA,int pPar,int paAtt, int paPar, int dMax, Point2D p){
        /**
         * creation d'un personnage en fournissant les valeurs de tous les attributs
         */
        nom = name;
        ptVie = pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        distAttMax = dMax;
        pos = p;
    }
    public Personnage(Personnage perso){
        this.nom = perso.nom;
        this.ptVie = perso.ptVie;
        this.degAtt = perso.degAtt;
        this.ptPar = perso.ptPar;
        this.pageAtt = perso.pageAtt;
        this.pagePar = perso.pagePar;
        this.distAttMax = perso.distAttMax;
        this.pos=new Point2D (perso.pos);
        
    }
    public Personnage(){
        
    }
/**
 * 
 * Ensemble des getters des differents attributs
 */
    public String getNom() {
        return nom;
    }
    public int getPtVie() {
        return ptVie;
    }
    public int getDegAtt() {
        return degAtt;
    }
    public int getPtPar() {
        return ptPar;
    }
    public int getPageAtt() {
        return pageAtt;
    }
    public int getPagePar() {
        return pagePar;
    }
    public int getDistAttMax() {
        return distAttMax;
    }
    public Point2D getPos() {
        return this.pos;
    }
/**
 * Ensemble des setters des differents attributs
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void deplace(){
        /**
         * deplace sans argument utilise la fonction nextInt pour teleporter le personnage a une position aleatoire dans un rayon de 10 cases
         */
        Random rand =new Random();
        int dx = rand.nextInt(21)-10;/*permet de determiner la translation selon x entre -10 et 10*/
        int dy = rand.nextInt(21)-10;/*fait la meme chose qu'avant mais selon y*/
        
        this.pos.translate(dx, dy);
    }
    public void deplace(int dx, int dy){
        /**
         * prend en parametres deux entier et translate le personnage selon ces deux entiers
         * dx correspond a la translation horizontale et dy y a la translation verticale
         */
        this.pos.translate(dx, dy);
    }
    public void deplace(int n){
        /**
         * n est un entier compris entre 0 et 7 et permet de decider dans quelle direction deplacer le personnage d'une case dans cette direction
         * 0 correspond au nord et on tourne dans le sens horaire
         */
        int sens=n%8+1;/*permet d'assurer que n est ompris entre 0 et 7*/
        
        switch (sens){
            case 1 :
                this.pos.translate(0, 1);//nord
                break;
            case 2 :
                this.pos.translate(0, 1);//nord-est
                break;
            case 3 : 
                this.pos.translate(1,0);//est
                break;
            case 4 :
                this.pos.translate(1, -1);//sud-est
                break;
            case 5 : 
                this.pos.translate(0, -1);//sud
                break;
            case 6 :
                this.pos.translate(-1, -1);//sud-ouest
                break;
            case 7 : 
                this.pos.translate(-1,0);//ouest
                break;
            case 8 :
                this.pos.translate(-1,1);//nord-ouest
                break;

        }
    }
    
    public void affiche(){
        System.out.println("nom "+this.nom+"\n"+"pv "+this.ptVie+"\n"+"att "+this.degAtt+"\n"+"Par "+this.ptPar+"\n"+"PaAtt "+this.pageAtt+"\n"+"PaPar "+this.pagePar+"\n"+"Range "+this.distAttMax);
        this.pos.affiche(); 
    }
}
