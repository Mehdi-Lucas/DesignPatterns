package question4;

import java.io.InputStream;
import java.io.IOException;
import java.io.FilterInputStream;

/**
 * Cette classe "décore" un fichier (InputSream) par la conversion de tous
 * les caractères Minuscule en Majuscule
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class UpperCaseInputStream extends FilterInputStream  { // à compléter

        public UpperCaseInputStream(InputStream input){
         super(input);   
    }
    
    public int read() throws IOException{
        int c = super.read();
        if(c != -1){
            return Character.toUpperCase((char) c);
        } else {
            return -1;
        }
    }
       
}