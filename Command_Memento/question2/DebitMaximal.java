package question2;
import question1.Cotisant;
import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class DebitMaximal implements Visiteur<Integer>{

  public Integer visite(Contributeur c){
    return c.solde(); // a compléter
  }
  
  public Integer visite(GroupeDeContributeurs g){
    int res = g.solde();

        for(Cotisant cot : g.getChildren()){ 
            if (cot.nombreDeCotisants() > 0){
            int minSolde = cot.accepter(this);
            if (res == 0 || minSolde < res ){                             
                res = minSolde; 
            } 
        } }
    return res ;
  }
}