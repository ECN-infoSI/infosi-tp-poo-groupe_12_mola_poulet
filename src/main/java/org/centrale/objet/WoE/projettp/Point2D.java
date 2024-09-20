package org.centrale.objet.WoE.projettp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clesp
 */
public class Point2D {
    private int x; //coordonnée
    private int y; //coordonnée
    //constructeur d'objet sans argument
    public Point2D() {    
    }
    //avec argument
    public Point2D (int x,int y){
        this.x=x;
        this.y=y;
    }
    //avec copie d'un objet déja construit
    public Point2D (Point2D p){
        x=p.x;
        y=p.y;
    }
    //setters
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    //getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    //setter des deux composantes
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void translate (int dx, int dy){
        this.x+=dx;
        this.y+=dy;
    }
    //getter des deux composantes
    public void affiche(){
        System.out.println("["+this.x+";"+this.y+"]");
    }
    //distance entre deux points
    public float distance(Point2D p){
        double X=(double)this.x-p.x;
        double Y=(double)this.y-p.y;
        return (float)Math.sqrt(X*X+Y*Y);
    }
}
