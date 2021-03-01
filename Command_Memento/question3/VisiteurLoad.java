package question3;
import java.util.*;
import question1.*;
/**
 * Write a description of class VisiteurLoad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VisiteurLoad implements question1.Visiteur<Cotisant>
{
    private Map<Cotisant, Integer> save; 
    
    public VisiteurLoad(Map<Cotisant, Integer> save){                             
        this.save=save; 
    } 
    
    public Cotisant visite(Contributeur c){ 
        int solde = this.save.get(c);
        c.affecterSolde(solde); 
        return c ; 
    } 

    public Cotisant visite(GroupeDeContributeurs g){ 
        for(Cotisant c : g.getChildren()){
            c.accepter(this); 
        } 
        return g; 
    } 
}
