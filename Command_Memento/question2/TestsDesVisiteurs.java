package question2;


import java.util.*;
import question1.*;

public class TestsDesVisiteurs extends junit.framework.TestCase{

  public void testACompleter(){
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      g.ajouter(new Contributeur("g_1",400));
      g.ajouter(new Contributeur("g_2",600));
      g.ajouter(new Contributeur("g_3",200));
      assertEquals(200, (int) g.accepter(new DebitMaximal()));
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      assertFalse(" Ce composite n'est pas valide", g1.accepter(new CompositeValide()));
      g1.ajouter(new Contributeur("g_4",100));
      assertTrue(" Ce composite est valide", g1.accepter(new CompositeValide()));
      g1.ajouter(new Contributeur("g_5",50));
      g.ajouter(g1);
      assertEquals(50, (int) g.accepter(new DebitMaximal()));
      assertTrue(" Ce composite est valide", g.accepter(new CompositeValide()));
      GroupeDeContributeurs gd = new GroupeDeContributeurs("gd");
      gd.ajouter(new Contributeur("gd",400));
      assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", gd.accepter(new SansDoublon()));
      GroupeDeContributeurs gd2 = new GroupeDeContributeurs("gd2");
      GroupeDeContributeurs gd2_doublon = new GroupeDeContributeurs("gd2");
      gd2.ajouter(gd2_doublon);
      assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", gd2.accepter(new SansDoublon()));
  }catch(Exception e){
        fail("exception inattendue !!! " + e.getMessage());
      }
  }
  
   public void testTroisContributeurs(){
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      g.ajouter(new Contributeur("g_a",100));
      g.ajouter(new Contributeur("g_b",200));
      g.ajouter(new Contributeur("g_c",300));
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
  }catch(Exception e){
        fail("exception inattendue !!! " + e.getMessage());
      }
  }
  
  public void testCompositeValide(){
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g");
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      g.ajouter(g1);
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

      g1.ajouter(new Contributeur("c",100));
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      assertFalse(g.accepter(new CompositeValide(101)));
      assertTrue(g.accepter(new CompositeValide(50)));
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
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      assertEquals(" Revoyez DébitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));
      GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
      g.ajouter(g1);
      assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide()));
   }catch(Exception e){
        fail("exception inattendue !!! " + e.getMessage());
      }
  }
  

  
   public void testUnContributeurUnGroupeAvecLeMemeNom(){
    try{
      GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
      g.ajouter(new Contributeur("g_a",100));
      g.ajouter(new Contributeur("g_b",200));
      g.ajouter(new Contributeur("g_c",300));
      g.ajouter(new Contributeur("g_d",80));
      assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
      assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
      }catch(Exception e){
        fail("exception inattendue !!! " + e.getMessage());
      }
  }
  

}


