package question1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant>{
  private List<Cotisant> liste;
  
  public GroupeDeContributeurs(String nomDuGroupe){
    super(nomDuGroupe);
    this.liste = new ArrayList<Cotisant>();
  }
  
  public void ajouter(Cotisant cotisant){
     this.liste.add(cotisant);                             
     cotisant.setParent(this); 
  }
  
  
  public int nombreDeCotisants(){
     int nombre = 0;                             
     Iterator<Cotisant> ite = liste.iterator();
        while(ite.hasNext()){                             
          Cotisant cot = ite.next(); 
          nombre = nombre + cot.nombreDeCotisants(); 
        } 
        return nombre; 
  }
  
  public String toString(){
    String str = new String(); 
    for(Cotisant cot : this.liste){                             
        str +=  cot.toString()+" \n " ;
    } 
    return str; 
  }
  
  public List<Cotisant> getChildren(){
    return this.liste;// a completer
  }
  
  public void debit(int somme) throws SoldeDebiteurException{
    if(somme <  0){ 
        throw new RuntimeException("la somme ne peut pas etre negatif"); 
     } else {
            for(Cotisant cot : this.liste){
            try{                             
                cot.debit(somme); 
                } catch( SoldeDebiteurException e){ 
                    throw new SoldeDebiteurException(); 
                } 
            } 
        } 
  }
  
  public void credit(int somme){
     if(somme <  0){ 
            throw new RuntimeException("la somme ne peut pas etre negatif"); 
        } else{ 
            for(Cotisant cot: this.liste){                             
                cot.credit(somme); 
            } 
        } 
  }
  
  public int solde(){
    int solde = 0; 
    for(Cotisant cot : this.liste){                            
       solde = solde + cot.solde();
    } 
       return solde; 
  }
  
  // méthodes fournies
  
 public Iterator<Cotisant> iterator(){
    return new GroupeIterator(liste.iterator());
  }
  
  private class GroupeIterator implements Iterator<Cotisant>{
    private Stack<Iterator<Cotisant>> stk;
    
    public GroupeIterator(Iterator<Cotisant> iterator){
      this.stk = new Stack<Iterator<Cotisant>>();
      this.stk.push(iterator);
    }
    
    public boolean hasNext(){
      if(stk.empty()){
        return false;
      }else{
         Iterator<Cotisant> iterator = stk.peek();
         if( !iterator.hasNext()){
           stk.pop();
           return hasNext();
         }else{
           return true;
         }
      }
    }
    
    public Cotisant next(){
      if(hasNext()){
        Iterator<Cotisant> iterator = stk.peek();
        Cotisant cpt = iterator.next();
        if(cpt instanceof GroupeDeContributeurs){
          GroupeDeContributeurs gr = (GroupeDeContributeurs)cpt;
          stk.push(gr.liste.iterator());
        }
        return cpt;
      }else{
        throw new NoSuchElementException();
      }
    }
    public void remove(){
      throw new UnsupportedOperationException();
    }
  }
  

  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  

}
