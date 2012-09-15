package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ListExpr;
import net.thingly.funky.impl.IntOpExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class IntOpExprTest extends ExprTest {

	@Test
	public void parseAddOpExpr() throws ParseException, EvalException {
		out.println("(+ 1 2 3)");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IntOpExpr);
		assertEquals('+', ((IntOpExpr) e).op);
		ListExpr l = ((IntOpExpr) e).l;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(1, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(2, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(3, ((IntExpr) l.car).value);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((1 + 2 + 3), ((IntExpr) e).value);

	}

	@Test
	public void parseMulOpExpr() throws ParseException, EvalException {
		out.println("(* 3 7 9)");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IntOpExpr);
		assertEquals('*', ((IntOpExpr) e).op);
		ListExpr l = ((IntOpExpr) e).l;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(3, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(7, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(9, ((IntExpr) l.car).value);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((3 * 7 * 9), ((IntExpr) e).value);

	}

	@Test
	public void parseDivOpExpr() throws ParseException, EvalException {
		out.println("(/ 64 4 2)");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IntOpExpr);
		assertEquals('/', ((IntOpExpr) e).op);
		ListExpr l = ((IntOpExpr) e).l;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(64, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(4, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(2, ((IntExpr) l.car).value);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((64 / 4 / 2), ((IntExpr) e).value);

	}

	@Test
	public void parseSubOpExpr() throws ParseException, EvalException {
		out.println("(- 64 4 2)");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IntOpExpr);
		assertEquals('-', ((IntOpExpr) e).op);
		ListExpr l = ((IntOpExpr) e).l;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(64, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(4, ((IntExpr) l.car).value);
		l = l.cdr;
		assertTrue(l.car instanceof IntExpr);
		assertEquals(2, ((IntExpr) l.car).value);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((64 - 4 - 2), ((IntExpr) e).value);

	}
}
