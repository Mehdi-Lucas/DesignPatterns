package question2;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
/**
 * Write a description of class Caretaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Caretaker
{
    private Stack pileEtat;
    
    public Caretaker(){
        this.pileEtat = new Stack<Memento>();
    }
    
    public void addMemento(Memento m) {
     pileEtat.push(m); 
    }
    // instance variables - replace the example below with your own
    public Memento getMemento (){
     return ((Memento)this.pileEtat.pop());   
    }
    
    public boolean empty(){
     return pileEtat.empty();   
    }
}
