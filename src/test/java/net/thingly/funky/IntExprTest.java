package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class IntExprTest extends ExprTest {
	@Test
	public void parseIntExpr() throws ParseException, EvalException {
		int value = 123;
		out.println("" + value);
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IntExpr);
		assertEquals(value, ((IntExpr) e).value);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals(value, ((IntExpr) e).value);
	}
}
