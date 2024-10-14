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
public class Creature extends Entite implements Deplacable, IA {
    
    private int ptVie; //nombre de point de vie du personnage
    private int degAtt; //degats physiques du personnage
    private int ptPar; // niveau de parade du personnage
    private int pageAtt; //taux de reussite d'attaque du personnage
    private int pagePar; //taux de reussite de parade du personnage
    
    /**
     *
     * @param pV Nombre de point de vie de la créature
     * @param att Degats physiques de la créature
     * @param par Niveau de parade de la créature
     * @param pAtt Taux de reussite d'attaque de la créature
     * @param pPar Taux de reussite de parade de la créature
     * @param p Position de la créature
     */
    public Creature(int pV, int att, int par, int pAtt, int pPar, Point2D p){
        super(p);
        ptVie = pV;
        degAtt = att;
        ptPar = par;
        pageAtt = pAtt;
        pagePar = pPar;
        
    }
    
    /**
     *
     * @param crea Copie d'une créature 
     */
    public Creature(Creature crea){
        
        super((Entite) crea);    
        this.ptVie = crea.ptVie;
        this.degAtt = crea.degAtt;
        this.ptPar = crea.ptPar;
        this.pageAtt = crea.pageAtt;
        this.pagePar = crea.pagePar;
   
    }
    
    /**
     *
     */
    public Creature(){
        super();
        
        this.ptVie = 50;
        this.degAtt = 50;
        this.ptPar = 20;
        this.pageAtt = 80;
        this.pagePar = 30;
    }

    /**
     *
     * @return 
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @return 
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }
    
    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    /**
     * deplace sans argument utilise la fonction nextInt pour teleporter le personnage a une position aleatoire dans un rayon de 10 cases
     */
    @Override
    public void deplace(World monde){
        Random rand =new Random();
        int dx = rand.nextInt(21)-10;//permet de determiner la translation selon x entre -10 et 10
        int dy = rand.nextInt(21)-10;//fait la meme chose qu'avant mais selon y
        if (this.getPos().getX()+dx<monde.getLongueur() && this.getPos().getY()+dy<monde.getLargeur() && monde.getListeEntite()[this.getPos().getX()+dx][this.getPos().getY()+dy]!=null){
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=null;
           this.getPos().translate(dx, dy);
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=this;
        }
        else{
            this.deplace(monde);
        }
        
    }

    /**
     * prend en parametres deux entier et translate le personnage selon ces deux entiers
     * dx correspond a la translation horizontale et dy y a la translation verticale
     * @param dx
     * @param dy
     */
    public void deplace(int dx, int dy,World monde){
        if (this.getPos().getX()+dx<monde.getLongueur() && this.getPos().getY()+dy<monde.getLargeur() && monde.getListeEntite()[this.getPos().getX()+dx][this.getPos().getY()+dy]!=null){
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=null;
           this.getPos().translate(dx, dy);
           monde.getListeEntite()[this.getPos().getX()][this.getPos().getY()]=this;
        }
    }

    /**
     * n est un entier compris entre 0 et 7 et permet de decider dans quelle direction deplacer le personnage d'une case dans cette direction
     * 7 correspond au nord et on tourne dans le sens horaire
     * @param n
     */

    public void deplace(int n,World monde){
        
        int sens=n%8+1;/*permet d'assurer que n est ompris entre 1 et 8*/
        
        switch (sens){
            case 1 :
                this.deplace(0, 1,monde);//nord
                break;
            case 2 :
                this.deplace(1, 1,monde);//nord-estS
                break;
            case 3 : 
                this.deplace(1,0,monde);//est
                break;
            case 4 :
                this.deplace(1, -1,monde);//sud-est
                break;
            case 5 : 
                this.deplace(0, -1,monde);//sud
                break;
            case 6 :
                this.deplace(-1, -1,monde);//sud-ouest
                break;
            case 7 : 
                this.deplace(-1,0,monde);//ouest
                break;
            case 8 :
                this.deplace(-1,1,monde);//nord-ouest
                break;

        }
    }
    public boolean[] estDeplacable (World monde){
        boolean[]res=new boolean[8];
        int[] listeNb={5,6,7,4,0,3,2,1};
        int nb=0;
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if(j!=0 || i!=0){
                    res[listeNb[nb]]=((i!=0 || j!=0) && this.getPos().getX()+i<monde.getLongueur() && this.getPos().getY()+j<monde.getLargeur() && monde.getListeEntite()[this.getPos().getX()+i][this.getPos().getY()+j]!=null);
                    nb++;
                }
            } 
        }
        if (res==new boolean[]{false,false,false,false,false,false,false,false}){
            res=null;
        }
        return res;
    }
    /**
     * Affiche les attributs de la créature
     */
    @Override
    public void affiche(){
        System.out.println("pv "+this.ptVie+"\n"+"att "+this.degAtt+"\n"+"Par "+this.ptPar+"\n"+"PaAtt "+this.pageAtt+"\n"+"PaPar "+this.pagePar);
        this.getPos().affiche(); 
        
    }
    @Override
    public void tourIA(World monde){
        
    }   
    
}
