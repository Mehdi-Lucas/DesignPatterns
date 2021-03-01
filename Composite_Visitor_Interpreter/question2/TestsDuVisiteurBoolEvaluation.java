package question2;

import question1.*;

public class TestsDuVisiteurBoolEvaluation extends junit.framework.TestCase {

	protected Contexte m;
	protected VisiteurExpressionBooleenne<Boolean> veb;

	public void setUp() {
		m = new Memoire();
		veb = new VisiteurBoolEvaluation(new VisiteurEvaluation(m));
	}

	public void testVisiteurBoolEvaluation() {
		assertTrue(new Vrai().accepter(veb));
		assertFalse(new Faux().accepter(veb));
		assertTrue(new Sup(new Constante(5), new Constante(3)).accepter(veb));
                assertTrue(new Egal(new Addition(new Constante(5),new Constante(3)),new Constante(8)).accepter(veb));
                assertFalse(new Inf(new Variable(m,"i"),new Variable(m,"j")).accepter(veb));
                assertTrue(new Inf(new Variable(m,"i"),new Addition(new Variable(m,"j"),new Constante(1))).accepter(veb));
                assertFalse(new Ou(new Sup(new Variable(m,"i"),new Variable(m,"j")), new Inf(new Variable(m,"i"),new Variable(m,"j"))).accepter(veb));
                assertFalse(new Et(new Sup(new Variable(m,"i"),new Variable(m,"j")), new Inf(new Variable(m,"i"),new Variable(m,"j"))).accepter(veb));
                assertTrue(new Et(new Ou(new Vrai(),new Vrai()), new Et(new Vrai(),new Vrai())).accepter(veb));
        		// etc ...
	}
	
}
