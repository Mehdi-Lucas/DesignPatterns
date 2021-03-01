package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;

public class SansDoublon implements Visiteur<Boolean>{
    Set setNom = new TreeSet<String>();
  public Boolean visite(Contributeur c){
    return setNom.add(c.nom()); // a compléter;
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = true;
            if (!setNom.add(g.nom())){
             res = false;
             return res;
            } 
        for(Cotisant cot : g.getChildren()){ 
            if (!cot.accepter(this)){
             res = setNom.add(cot.nom());   
            }
        } 
    return res ;
  }
  
}