package question1;

public class Contributeur extends Cotisant{
    private int solde;

    public Contributeur(String nom, int somme){
        super(nom);
        if (somme >= 0) {
            this.solde = somme;
        } else {
            throw new RuntimeException("la somme allouée lors de la création ne peut être négative"); 
        }
    }

    public int solde(){
        return this.solde;
    }

    public int nombreDeCotisants(){
        return 1;
    }

    public void debit(int somme) throws SoldeDebiteurException{
        if (somme < 0) {
            throw new RuntimeException("la somme ne peut pas etre negatif");
        } else if (somme > this.solde){
            throw new SoldeDebiteurException();
        } else {
            this.solde = solde - somme;
        }
    }

    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     */
    public  void credit(int somme){
        if(somme < 0){ 
            throw new RuntimeException("la somme ne peut pas etre negatif"); 
        } else{                             
            this.solde = solde + somme; 
        }
    }

    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     */
    public void affecterSolde(int somme){
        if(somme <0) throw new RuntimeException("nombre négatif !!!");
        try{
            debit(solde()); credit(somme);// mode élégant ... 
        }catch(SoldeDebiteurException sde){ 
            // exception peu probable
            this.solde = somme; // mode efficace ...
        }
    }

    public <T> T accepter(Visiteur<T> visiteur){
        return visiteur.visite(this);
    }

    public String toString(){
        return "<Contributeur : " + nom + "," + solde + ">";
    }

}
