
1) testDebitMaximalSurUnGroupeDeGroupes(question2): le débit maximal est-il erroné ???

             g.ajouter(new Contributeur("g_b",200));
             g.ajouter(new Contributeur("g_c",300));
             GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
             g1.ajouter(new Contributeur("g1_a1",130));
             g1.ajouter(new Contributeur("g1_b1",200));
             g.ajouter(g1);
 
             assertTrue(" le débit maximal est-il erroné ??? ", g.accepter(new DebitMaximal()) == 120);
 
         }catch(Exception e){
             fail("exception inattendue !!! " + e.getMessage());
         }
     }
 
     public void testDebitMaximalSurUnGroupeDeGroupes(){
         try{
             GroupeDeContributeurs g = new GroupeDeContributeurs("g");
             g.ajouter(new Contributeur("g_a",120));
             g.ajouter(new Contributeur("g_b",200));
             g.ajouter(new Contributeur("g_c",300));
             GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
             GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
             g2.ajouter(new Contributeur("g1_a1",30));
             g1.ajouter(g2);
             g.ajouter(g1);
             assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
             GroupeDeContributeurs g3 = new GroupeDeContributeurs("g3");
             g1.ajouter(g3);
             assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
 
             assertTrue(" le débit maximal est-il erroné ??? ", g.accepter(new DebitMaximal()) == 30);
