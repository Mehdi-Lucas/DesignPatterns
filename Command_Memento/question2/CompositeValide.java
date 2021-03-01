package question2;
import question1.Cotisant;
import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class CompositeValide implements Visiteur<Boolean>{
  // Le solde de chaque contributeur doit être supérieur ou égal à un nombre transmis en paramètre 
  // et il n’existe pas de groupe n’ayant pas de contributeurs.
  private int valeur;
  public CompositeValide(int valeur){
      this.valeur = valeur;
    }
  public CompositeValide(){
      this(0);
  }
  
  public Boolean visite(Contributeur c){
    return c.solde() >= valeur; 
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = true;
    if (g.nombreDeCotisants() <= 0) {
     return false;   
    }
    for (Cotisant cot : g.getChildren()){
        if (!cot.accepter(this)){
         res = false; 
         return res;
        }
    }
    return res ;
  }
}