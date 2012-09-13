package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.ParseException;
import net.thingly.funky.impl.StringExpr;

import org.junit.Test;

public class StringExprTest extends ExprTest {
	@Test
	public void parseStringExpr() throws ParseException, EvalException {
		String str = "\"this is my string\"";
		out.println(str);
		out.flush();

		Expr e = p.parse();
		assertTrue(e instanceof StringExpr);
		assertEquals(str, ((StringExpr) e).string);
		e = e.eval(env);
		assertTrue(e instanceof StringExpr);
		assertEquals(str, ((StringExpr) e).string);
	}
}
