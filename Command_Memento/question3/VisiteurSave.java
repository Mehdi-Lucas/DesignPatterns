package question3;
import question1.*;
import java.util.*;

/**
 * Write a description of class VisiteurSave here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VisiteurSave implements question1.Visiteur<Map<Cotisant,Integer>> {
    public Map<Cotisant, Integer> visite(Contributeur c){ 
        Map<Cotisant, Integer> saveMap = new HashMap<Cotisant, Integer>();
        saveMap.put(c, c.solde()); 
        return saveMap; 
    } 

    public Map<Cotisant, Integer> visite(GroupeDeContributeurs g) {                            
        Map<Cotisant, Integer> saveMap = new HashMap<Cotisant, Integer>();  
        for(Cotisant c: g.getChildren()){                             
            Map<Cotisant, Integer> infoCot =  c.accepter(this);                             
            saveMap.putAll(infoCot); 
        } 
        return saveMap; 
    } 
}