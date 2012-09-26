package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.BoolExpr;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class BoolExprTest extends ExprTest {
	@Test
	public void parseBoolExpr() throws ParseException, EvalException {
		out.println("#t");
		out.flush();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.TRUE);

		out.println("#f");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.FALSE);
	}

	@Test
	public void testAnd() throws ParseException, EvalException {
		out.println("(and #t #t)");
		out.flush();

		Expr e = p.parse();
		System.err.println(e.toString());
		
		// Expr e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.TRUE);

		out.println("(and #t #f #t #t)");
		out.flush();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.FALSE);

		out.println("(and #f #f)");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.FALSE);
	}
	
	@Test
	public void testOr() throws ParseException, EvalException {
		out.println("(or #t #t)");
		out.flush();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.TRUE);

		out.println("(or #f #f #t #f)");
		out.flush();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.TRUE);

		out.println("(or #f #f)");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(e, BoolExpr.FALSE);
	}
}
