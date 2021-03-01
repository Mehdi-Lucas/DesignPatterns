package question3;

import question1.*;
import java.util.*;

public class Memento {
     // Note : Un usage du patron Memento, 
     //        d’un premier visiteur pour la sauvegarde et 
     //        d’un second pour la restitution du composite, 
     //        représentent une solution possible. 
     private Map<Cotisant,Integer> save; 
     public Memento(Cotisant c) {
       // sauvegarde
       this.save = c.accepter(new VisiteurSave());
     }

     public void setState(Cotisant c) {
       // restitution
       c.accepter(new VisiteurLoad(this.save));
     }
    
    }