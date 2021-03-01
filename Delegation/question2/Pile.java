package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;
    private int capacite;

    public Pile(int taille) {
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.capacite = taille;
        this.ptr = 0;
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // à compléter
        if (estVide())
            throw new PileVideException();
        return zone[ptr-1]; //vu qu'on depile pas il faut envoyer l'index-1
    }

    public int capacite() {
        // à compléter
        return this.capacite;
    }

    public int taille() {
        // à compléter
        return this.ptr;
    }

    public boolean estVide() {
        // à compléter
        return ptr == 0;
    }

    public boolean estPleine() {
        // à compléter
        return ptr == zone.length;
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
        for (int i = ptr - 1; i >= 0; i--) {
            code = code + (zone[i].hashCode());
        }
        return code;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}