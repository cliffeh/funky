package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.NilExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class NilExprTest extends ExprTest {
	@Test
	public void parseNilExpr() throws ParseException, EvalException {
		out.println("()");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof NilExpr);
		assertEquals(NilExpr.NIL, e);

		e = e.eval(env);
		assertTrue(e instanceof NilExpr);
		assertEquals(NilExpr.NIL, e);
	}
}
