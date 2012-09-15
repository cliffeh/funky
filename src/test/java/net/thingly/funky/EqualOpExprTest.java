package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.BoolExpr;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class EqualOpExprTest extends ExprTest {
	@Test
	public void parseEqualOpExpr() throws ParseException, EvalException {
		int v1 = 123, v2 = 456;
		out.println("(eq " + v1 + " " + v2 + ")");
		out.flush();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(BoolExpr.FALSE, e);

		out.println("(eq " + v1 + " " + v1 + ")");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof BoolExpr);
		assertEquals(BoolExpr.TRUE, e);
	}

	@Test
	public void parseEqualOpExprWithAdditionalOperands() throws ParseException,
			EvalException {
		int v1 = 123, v2 = 456;
		String v3 = "(+ 12 27)", v4 = "(+ 20 25)";
		out.println("(eq " + v1 + " " + v1 + " " + v3 + " " + v4 + ")");
		out.flush();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((12 + 27), ((IntExpr) e).value);

		out.println("(eq " + v1 + " " + v2 + " " + v3 + " " + v4 + ")");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((20 + 25), ((IntExpr) e).value);
	}
}
