package org.centrale.objet.WoE.projettp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clesp
 */
public class TestPoint2D {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //création d'objets Point2D
        Point2D p1=new Point2D(1 ,7);
        Point2D p2=new Point2D (3,5);
        Point2D p3=new Point2D ();
        Point2D p4=new Point2D (p1);
        //Test
        p1.affiche();
        p4.affiche();
        System.out.println(p1.getX());
        System.out.println(p1.getY());
        System.out.println(p1.distance(p2));
        p3.setX(0);
        p3.setY(2);
        p3.affiche();
        p2.setPosition(0,2);
        p2.affiche();
        p2.translate(1, 2);
        p2.affiche();
    }
}
