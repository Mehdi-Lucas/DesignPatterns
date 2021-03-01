package question1;

public class TestsACompleter extends junit.framework.TestCase{
    private Memoire m;
    private Variable i,j,k,w;
    private VisiteurExpression<Integer> ve;
    private VisiteurExpression<String>  vp,vi;

    public void setUp(){
        m  = new Memoire();
        i  = new Variable(m,"i",3);
        j = new Variable(m,"j",5);
        k  = new Variable(m,"k",8);
        w = new Variable(m,"w",2);
        ve = new VisiteurEvaluation( m);
        vi = new VisiteurInfixe( m);
        vp = new VisiteurPostfixe( m);
        assertNotNull(i);assertNotNull(j);
        assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
    }

    public void testUneAddition(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
    }

    public void testMultiplication(){
        Expression expr = new Multiplication(new Constante(4), new Constante(3));
        assertEquals(" 4*3 != 12 ?, curieux ",12,expr.accepter(ve).intValue());
    }

    public void testSoustraction(){
        Expression expr = new Soustraction(new Constante(4), new Constante(3));
        assertEquals(" 4-3 != 1 ?, curieux ",1,expr.accepter(ve).intValue());
    }

    public void testDivision(){
        Expression expr = new Division(new Constante(4), new Constante(2));
        assertEquals(" 4/2 != 2 ?, curieux ",2,expr.accepter(ve).intValue());
        try{
            new Division(i,new Constante(0)).accepter(ve);
            fail("division par zéro ? possible ");
        }catch(ArithmeticException ae){
        }
    }
    
    public void testVariable(){
        assertEquals("{i=3, j=5, k=8, w=2}",m.toString());
    }
    public void testVisiteurInfixe(){
        Expression expr = new Addition(new Constante(4), new Constante(3));
        assertEquals("(4 + 3)",expr.accepter(vi));
        Expression expr2 = new Soustraction(expr, new Constante(2));
        assertEquals("((4 + 3) - 2)", expr2.accepter(vi));
        Expression expr3 = new Multiplication(expr, expr2);
        assertEquals("((4 + 3) * ((4 + 3) - 2))", expr3.accepter(vi));
        Expression expr4 = new Division(expr3, new Constante(3));
        assertEquals("(((4 + 3) * ((4 + 3) - 2)) / 3)", expr4.accepter(vi));
        
        Expression expr5 = new Division(new Constante(15), new Constante(3));
        assertEquals("(15 / 3)", expr5.accepter(vi));
    }

    public void testVisiteurPostfixe(){
        Expression expr6 = new Addition(new Constante(4), new Constante(3));
        assertEquals("(4,3)+",expr6.accepter(vp));
        Expression expr7 = new Soustraction(expr6, new Constante(2));
        assertEquals("((4,3)+,2)-", expr7.accepter(vp));
        Expression expr8 = new Multiplication(expr6, expr7);
        assertEquals("((4,3)+,((4,3)+,2)-)*", expr8.accepter(vp));
        Expression expr9 = new Division(expr8, new Constante(3));
        assertEquals("(((4,3)+,((4,3)+,2)-)*,3)/", expr9.accepter(vp));
        
        Expression expr10 = new Division(new Constante(15), new Constante(3));
        assertEquals("(15,3)/", expr10.accepter(vp));
    }

    // à compléter
    // à compléter
    // à compléter

}
