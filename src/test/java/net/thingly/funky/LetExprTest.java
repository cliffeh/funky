package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.LetExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class LetExprTest extends ParserTest {
	@Test
	public void parseLetExpr() throws ParseException, EvalException {
		out.println("(let ((x 10) (y 20)) (+ x y))");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof LetExpr);
		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals((10 + 20), ((IntExpr) e).value);
	}
}
