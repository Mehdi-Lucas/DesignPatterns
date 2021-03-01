package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        //Si notre vecteur ne contient pas l'element alors on l'ajoute dans notre ensemble
        try {
        if (! this.contains(t)){
            return this.table.add(t);
          }
        } catch (Exception e){
           System.out.println("Attention : " + e.getMessage()); 
        }
        return false;
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
                Ensemble unionSet = new Ensemble();
                unionSet.addAll(e);
                unionSet.addAll(this);
		return unionSet;
	}

	public Ensemble<T> inter(Ensemble<? extends T> e) {
		// à compléter pour la question1-2
                Ensemble interSet = new Ensemble();
                interSet.addAll(this);
                interSet.retainAll(e);
		return interSet;
	}

	public Ensemble<T> diff(Ensemble<? extends T> e) {
		// à compléter pour la question1-2
                Ensemble diffSet = new Ensemble();
                diffSet.addAll(this);
                diffSet.removeAll(e);
		return diffSet;
	}

	Ensemble<T> diffSym(Ensemble<? extends T> e) {
		// à compléter pour la question1-2
                Ensemble inter = this.inter(e);
                Ensemble union = this.union(e);
                Ensemble diffSym = union.diff(inter);
		return diffSym;
		
	}
	
}
