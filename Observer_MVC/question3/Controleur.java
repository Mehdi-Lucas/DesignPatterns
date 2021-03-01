package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;
import question3.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(new PilePusher());
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new PilePusher());
        boutons.add(add);   add.addActionListener(new Addition());
        boutons.add(sub);   sub.addActionListener(new Soustraction());
        boutons.add(mul);   mul.addActionListener(new Multiplication());
        boutons.add(div);   div.addActionListener(new Division());
        boutons.add(clear); clear.addActionListener(new PileClearer());
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        Integer cap = pile.capacite();

        switch(pile.taille()) {
            case 0:
            push.setEnabled(true);
            add.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
            clear.setEnabled(false);
            sub.setEnabled(false);
            break;
            case 1:
            push.setEnabled(true);
            add.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
            clear.setEnabled(true);
            sub.setEnabled(false);
            break;
            default:
            push.setEnabled(true);
            if (pile.taille() == cap) push.setEnabled(false);
            add.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
            clear.setEnabled(true);
            sub.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    private class PileClearer implements ActionListener {
        public void actionPerformed(ActionEvent action){
            try {
                while (!pile.estVide()) pile.depiler();
            } catch (PileVideException e){
                System.out.println("Pile vide"); 
            }
            actualiserInterface();
        }

    }
    private class PilePusher implements ActionListener {
        public void actionPerformed(ActionEvent action){
            try {
                try {
                    pile.empiler(operande());
                } catch (NumberFormatException ne){ 
                    System.out.println("Mauvais format");
                }
            } catch (PilePleineException e){
                System.out.println("Pile pleine"); 
            }
            actualiserInterface();
        }

    }

    private class Addition implements ActionListener {
        public void actionPerformed(ActionEvent action){
            Integer element1 = null; //Declaration des element de l'operation
            try {
                element1 = pile.depiler(); // On recupere le premier element
                Integer element2 = pile.depiler(); // On recupere le deuxieme element
                Integer resultat = element1 + element2; // On effectue l'operation voulu sur les elements
                try {
                    pile.empiler(resultat); //On remet le resutlat dans la pile
                } catch (PilePleineException e) {
                    System.out.println("Pile pleine");  //il faut catch l'exception pour compiler
                }
            } catch (PileVideException e){ 
                System.out.println("Pile vide");
                try {
                    pile.empiler(element1); //dans le cas ou on a une erreur il faut essayer de remettre le premier element
                } catch (PilePleineException ep) {
                    System.out.println("Pile pleine");  
                }
            }
            actualiserInterface();
        }

    }

    private class Soustraction implements ActionListener {
        public void actionPerformed(ActionEvent action){
            Integer element1 = null; //Declaration des element de l'operation
            try {
                element1 = pile.depiler(); // On recupere le premier element
                Integer element2 = pile.depiler(); // On recupere le deuxieme element
                Integer resultat = element2 - element1; // On effectue l'operation voulu sur les elements
                try {
                    pile.empiler(resultat); //On remet le resutlat dans la pile
                } catch (PilePleineException e) {
                    System.out.println("Pile pleine");  //il faut catch l'exception pour compiler
                }
            } catch (PileVideException e){ 
                System.out.println("Pile vide");
                try {
                    pile.empiler(element1); //dans le cas ou on a une erreur il faut essayer de remettre le premier element
                } catch (PilePleineException ep) {
                    System.out.println("Pile pleine");  
                }
            }
            actualiserInterface();
        }

    }

    private class Multiplication implements ActionListener {
        public void actionPerformed(ActionEvent action){
            Integer element1 = null; //Declaration des element de l'operation
            try {
                element1 = pile.depiler(); // On recupere le premier element
                Integer element2 = pile.depiler(); // On recupere le deuxieme element
                Integer resultat = element2 * element1; // On effectue l'operation voulu sur les elements
                try {
                    pile.empiler(resultat); //On remet le resutlat dans la pile
                } catch (PilePleineException e) {
                    System.out.println("Pile pleine");  //il faut catch l'exception pour compiler
                }
            } catch (PileVideException e){ 
                System.out.println("Pile vide");
                try {
                    pile.empiler(element1); //dans le cas ou on a une erreur il faut essayer de remettre le premier element
                } catch (PilePleineException ep) {
                    System.out.println("Pile pleine");  
                }
            }
            actualiserInterface();
        }

    }

    private class Division implements ActionListener {
        public void actionPerformed(ActionEvent action){
            Integer element1 = null; //Declaration des element de l'operation
            Integer resultat = null; 
            try {
                element1 = pile.depiler(); // On recupere le premier element
                Integer element2 = pile.depiler(); // On recupere le deuxieme element
                try {
                    pile.empiler(element2 / element1);  // On effectue l'operation voulu sur les elements
                } catch (PilePleineException ep) { 
                    System.out.println("Pile Pleine");
                } catch (ArithmeticException ae) { //Si il y'a une divison par zero on aura une exception
                    System.out.println("Division par zero"); 
                    try {
                        if (element2 != null) pile.empiler(element2);
                        if (element1 != null) pile.empiler(element1);//On remet le elements dans la pile
                    } catch (PilePleineException e) {
                        System.out.println("Pile pleine");  //il faut catch l'exception pour compiler
                    }
                }
            } catch (PileVideException e){ 
            System.out.println("Pile vide");
            try {
                pile.empiler(element1); //dans le cas ou on a une erreur il faut essayer de remettre le premier element
            } catch (PilePleineException ep) {
                System.out.println("Pile pleine");  
            }
        }
        actualiserInterface();
    }

}

// à compléter
// en cas d'exception comme division par zéro, 
// mauvais format de nombre suite à l'appel de la méthode operande
// la pile reste en l'état (intacte)

}
