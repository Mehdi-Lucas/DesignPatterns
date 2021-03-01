package question2;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * Write a description of class Memento here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Memento
{
    private ArrayList<String> liste;
    private Map<String, Integer> occurrences;
    public Memento(List<String> listeToSave, Map<String, Integer> occToSave)
    {
        this.liste = new ArrayList<String>();
        this.occurrences = new HashMap();
        this.liste.addAll(listeToSave);
        this.occurrences.putAll(occToSave);
    }
    
    public ArrayList<String> getListState(){
        return liste;
    }
    
    public Map<String, Integer> getOccState(){
        return occurrences;
    }
}
