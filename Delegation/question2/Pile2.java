package question2;


import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par délégation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacité de la pile */
    private int capacite;

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
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
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // à compléter
        return stk.empty();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // à compléter
        return this.taille() == this.capacite();
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
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
     * Retourne le nombre d'élément d'une pile.
     * 
     * @return le nombre d'élément
     */
    public int taille() {
        // à compléter
        return stk.size();
    }

    /**
     * Retourne la capacité de cette pile.
     * 
     * @return le nombre d'élément
     */
    public int capacite() {
        // à compléter
        return this.capacite;
    }

} // Pile2.java
