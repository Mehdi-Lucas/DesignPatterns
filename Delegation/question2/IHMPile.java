package question2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import question1.PilePleineException;
import question1.PileVideException;
// pour le comportement attendu depuis votre répertoire
// exécuter cette commande tp3>appletviewer tp3.html
public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile4 p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile4();

    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("empiler")){

 
            //On récupére l'objet à empiler
            Object objEmpilable = donnee.getText();
            try { //On essaye d'empiler et on affiche le contenu de notre pile avec setText
            p.empiler(objEmpilable); 
            contenu.setText(p.toString());
        } catch (PilePleineException e){ //On fait un catch pour lever une exception si la pile est pleine
           // en cas d'exception
            contenu.setText(p.toString() + " estPleine !");
        }

            
        }else{ //Si c'est pas empiler alors l'utilisateur a appuyer sur depiler
            try{ //On recupere l'objet dans une variable et on l'affiche dans sommet, on en profite pour mettre à jour la pile
            Object retirer = p.depiler();
            sommet.setText(retirer.toString());
            contenu.setText(p.toString());
        } catch (PileVideException e){
            contenu.setText(p.toString() + " estVide !");
        }

        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
