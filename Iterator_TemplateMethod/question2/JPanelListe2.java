package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import question2.Memento;

public class JPanelListe2 extends JPanel implements ActionListener, ItemListener {

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("décroissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private JButton boutonAnnuler = new JButton("annuler");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;
    private Caretaker save;
    
    public JPanelListe2(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;
        this.save = new Caretaker();
        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        panelBoutons.add(boutonAnnuler);
        cmd.add(panelBoutons);


        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incomplète");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonRetirer.addActionListener(this);
        boutonOccurrences.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);
        boutonAnnuler.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            boolean res = false;
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                res = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("résultat de la recherche de : "
                    + saisie.getText() + " -->  " + res);
            } else if (ae.getSource() == boutonRetirer) {
                
                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur
                .setText("résultat du retrait de tous les éléments commençant par -->  "
                    + saisie.getText() + " : " + res);
            } else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            } else if (ae.getSource() == boutonAnnuler){
                if (!save.empty()){
                Memento m = this.save.getMemento();
                this.liste = m.getListState();
                this.occurrences = m.getOccState();}
                else {
                    afficheur.setText("Rien à annuler!");
                }
            }
            texte.setText(liste.toString());

        } catch (Exception e) {
            afficheur.setText(e.toString());
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == ordreCroissant){
            this.save.addMemento(new Memento(liste, occurrences));
            Collections.sort(this.liste);// à compléter
        }else if (ie.getSource() == ordreDecroissant){
            this.save.addMemento(new Memento(liste, occurrences));
            Comparator comp = new decroissantComp();
            Collections.sort(this.liste, comp);// à compléter
        }
        texte.setText(liste.toString());
    }

    private class decroissantComp implements Comparator{
        public decroissantComp(){
        }
        
        public int compare(Object o1, Object o2){
            return ((String)o1).compareTo((String)o2)*-1;
        }
        
    }

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean resultat = false;
        boolean saveState = false;
        Iterator ite = this.liste.iterator();
        while (ite.hasNext()){
            String str = (String) ite.next();
            if (str.startsWith(prefixe)){
                if (!saveState){
                    saveState = true;
                    this.save.addMemento(new Memento(liste, occurrences));
                }
                occurrences.put(str,0);
                ite.remove();
                resultat = true;         
            }
        }
        return resultat;
    }

}