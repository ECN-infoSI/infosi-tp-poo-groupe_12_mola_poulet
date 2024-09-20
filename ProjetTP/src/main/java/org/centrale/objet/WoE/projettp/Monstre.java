/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;
/**
 *
 * @author clesp
 * Classe mère des monstres de WoE
 */
public class Monstre {
    private int ptVie; //Points de vie
    private int degAtt; // Points d'attaque
    private int ptPar; //
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    //constructeurs
    public Monstre (int pV, int dA, int pPar, int paAtt,int paPar, Point2D p){
        this.ptVie=pV;
        this.degAtt=dA;
        this.ptPar=pPar;
        this.pageAtt=paAtt;
        this.pagePar=paPar;
        //copie profonde
        this.pos=new Point2D(p);
    }
    //constructeur par copie
    public Monstre(Monstre m){
        this.ptVie=m.ptVie;
        this.degAtt=m.degAtt;
        this.ptPar=m.ptPar;
        this.pageAtt=m.pageAtt;
        this.pagePar=m.pagePar;
        this.pos=new Point2D(m.pos);
    }
    public Monstre(){
    }
    //getters
    public int getPtVie(){
        return this.ptVie;
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

    public Point2D getPos() {
        return pos;
    }
   //setters

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

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    //Méthode de déplacement
    //téléportation
    public void deplace(){
        Random r=new Random();
        int dx=r.nextInt(21);
        int dy=r.nextInt(21);
        this.pos.translate(dx-10,dy-10);
    }
    //Déplacement décidé
    public void deplace(int dx,int dy){
        this.pos.translate(dx, dy);
    }
    //Déplacement dans un sens
    public void deplace (int n){
        int sens=(n%8)+1; //entier entre 1 et 8
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
    //affichage
    public void affiche(){
        System.out.println("pv "+this.ptVie+"\n"+"PtAtt "+this.degAtt+"\n"+"PtPar "+this.ptPar+"\n"+"paAtt "+this.pageAtt+"\n"+"paPar "+this.pagePar);
        this.pos.affiche();
    }
}
