package question2;


import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacit� de la pile */
    private int capacite;

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile2(int taille) {
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille; 
        this.stk = new Stack();
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);  
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // � compl�ter
        return stk.empty();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // � compl�ter
        return this.taille() == this.capacite();
    }

    /**
     * Retourne une repr�sentation en String d'une pile, contenant la
     * repr�sentation en String de chaque �l�ment.
     * 
     * @return une repr�sentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = this.taille() - 1; i >= 0; i--) {
            s = s + stk.get(i).toString();
            if (i > 0)
                s = s + ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof PileI) {
            PileI p = (PileI) o;
            return this.capacite() == p.capacite()
            && this.hashCode() == p.hashCode();
        } else
            return false;
    }

    // fonction fournie
    public int hashCode() {
        int code = capacite; 
        for (int i = this.taille() - 1; i >= 0; i--) {
            code = code + (stk.get(i).hashCode());
        }
        return code;
    }

    /**
     * Retourne le nombre d'�l�ment d'une pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int taille() {
        // � compl�ter
        return stk.size();
    }

    /**
     * Retourne la capacit� de cette pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int capacite() {
        // � compl�ter
        return this.capacite;
    }

} // Pile2.java
