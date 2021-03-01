package question3;

import question3.tp3.Pile2;
import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;
    /* à compléter */

    public PileModele(PileI<T> pileb) {
        this.pile = pileb;
    }

    public void empiler(T o) throws PilePleineException {
        try {
            this.pile.empiler(o);
            this.setChanged();
            this.notifyObservers(o);
        }
        catch (PilePleineException e) {
            e.printStackTrace();
        }

    }

    public T depiler() throws PileVideException {
        try {
            T o = pile.depiler();
            setChanged();
            notifyObservers(o);
            return o;
        }
        catch (PileVideException e) {
            e.printStackTrace();
            return null;
        }
    }

    public T sommet() throws PileVideException {
        if (this.estVide()){
            throw new PileVideException();
        }
        return pile.sommet();
    }

    public int taille() {
        return pile.taille();
    }

    public int capacite() {
        return pile.capacite();
    }

    public boolean estVide() {
        return pile.estVide();
    }

    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }



}

/**
 * notez qu'un message d'alerte subsiste à la compilation (unsafe ...) dû à
 * l'emploi de notifyObservers, incontournable et sans conséquence ici
 */
