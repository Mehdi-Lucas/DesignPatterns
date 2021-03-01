
2) testTroisContributeursUnGroupe(question2): Revoyez DébitMaximal !!! expected:<100> but was:<0>

             GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
             g1.ajouter(new Contributeur("g1_a1",90));
             g1.ajouter(new Contributeur("g1_b1",200));
             g.ajouter(g1);
             GroupeDeContributeurs g2 = new GroupeDeContributeurs("g1");
             g2.ajouter(new Contributeur("g2_a1",90));
             g2.ajouter(new Contributeur("g2_b1",200));
             g2.ajouter(new Contributeur("g_a",200));
             g1.ajouter(g2);
             assertEquals("Le nombre de cotisants est-il erroné ???", 8, g.nombreDeCotisants());
             assertEquals(" Revoyez DébitMaximal !!!", new Integer(90), g.accepter(new DebitMaximal()));
             assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
             assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
         }catch(Exception e){
             fail("exception inattendue !!! " + e.getMessage());
         }
     }
 
     public void testTroisContributeursUnGroupe(){
         try{
             GroupeDeContributeurs g = new GroupeDeContributeurs("g");
             g.ajouter(new Contributeur("g_a",100));
             g.ajouter(new Contributeur("g_b",200));
             g.ajouter(new Contributeur("g_c",300));
             GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
             assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
             assertEquals(" Revoyez DébitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));
             g.ajouter(g1);
             assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide(0)));
             assertEquals("Le nombre de cotisants est-il erroné ???", 3, g.nombreDeCotisants());
             assertEquals(" Revoyez DébitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));