package question1;

public class EnsembleTest extends junit.framework.TestCase {
    
	public void testAdd() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(6));
		assertEquals(true, e1.add(7));

		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(8));
		assertTrue(e2.contains(8));
		assertEquals(1, e2.size());
		assertEquals(true, e2.add(9));
		assertEquals(true, e2.add(10));
		
		assertEquals(2, e1.size());
		assertEquals(3, e2.size());
		assertTrue(e1.contains(6));
		assertTrue(e2.contains(10));
		assertTrue(e2.contains(9));
	}
	
	public void testUnion() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));

		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(4));

		question1.Ensemble<Integer> union = e1.union(e2);
		assertEquals(3, union.size());
		assertTrue(union.contains(2));
		assertTrue(union.contains(3));
		assertTrue(union.contains(4));
	}
	
	public void testInter() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));
		assertEquals(true, e1.add(4));
		
		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(4));
		assertEquals(true, e2.add(5));
		
		question1.Ensemble<Integer> inter = e1.inter(e2);
		assertEquals(2, inter.size());
		assertTrue(inter.contains(3));
		assertTrue(inter.contains(4));

	}
	
	public void testDiff() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(1));
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));
		assertEquals(true, e1.add(4));
		
		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(2));
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(5));
		
		question1.Ensemble<Integer> diff = e1.diff(e2);
		assertEquals(2, diff.size());
		assertTrue(diff.contains(1));
		assertTrue(diff.contains(4));

	}
	
	public void diffSym() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(1));
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));
		assertEquals(true, e1.add(4));
		
		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(2));
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(5));
		
		question1.Ensemble<Integer> diffSym = e1.diffSym(e2);
		assertEquals(3, diffSym.size());
		assertTrue(diffSym.contains(1));
		assertTrue(diffSym.contains(4));
		assertTrue(diffSym.contains(5));
	}
}
