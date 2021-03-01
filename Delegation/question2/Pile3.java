package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        //construire un vecteur avec la taille passé en argument et incrémentation de zero quand on atteint le max
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector(taille, 0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        int position = this.taille()-1;
        v.add(0, o); 
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if (estVide())
            throw new PileVideException();
        return v.remove(0);
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.get(0);
    }

    public int taille() {
        // à compléter
        return v.size();
    }

    public int capacite() {
        // à compléter
        return v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        return v.capacity() == v.size();
    }

    public String toString() {
        // à compléter
        return v.toString();
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
        int code = capacite(); 
        for (int i = v.size() - 1; i >= 0; i--) {
            code = code + (v.get(i).hashCode());
        }
        return code;
    }

}
