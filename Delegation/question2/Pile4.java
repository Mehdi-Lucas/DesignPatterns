package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
        this.nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        // à compléter
        this.stk = new Maillon(o, this.stk);
        this.nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
        Object mToReturn = this.stk.element();
        this.stk = this.stk.suivant();
        this.nombre--;
        return mToReturn;

    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.element(); // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.nombre == 0; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.nombre == this.capacite; // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        Maillon m = this.stk;
        String s = "[";
        for (int i = nombre - 1; i >= 0; i--) {

            s = s + m.element().toString();
            if (i > 0)
                s = s + ", ";
            m = m.suivant();
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

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        Maillon m = this.stk;
        int code = capacite(); 
        for (int i = this.taille() - 1; i >= 0; i--) {
            code = code + m.element().hashCode();
            m = m.suivant();

        }
        return code;
    }

    public int taille() {
        return nombre;
    }
}