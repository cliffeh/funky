package net.thingly.funky;

import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntOpExpr;
import net.thingly.funky.impl.ParseException;
import net.thingly.funky.impl.QuoteExpr;

import org.junit.Test;

public class QuoteExprTest extends ExprTest {
	@Test
	public void parseQuoteExpr() throws ParseException, EvalException {
		out.println("(quote (+ 1 2))");
		out.flush();

		Expr e = p.parse();
		assertTrue(e instanceof QuoteExpr);
		e = e.eval(env);
		assertTrue(e instanceof IntOpExpr);
		// TODO make sure it's actually the OpExpr we're expecting

		out.println("'(+ 1 2)");
		out.close();

		e = p.parse();
		assertTrue(e instanceof QuoteExpr);
		e = e.eval(env);
		assertTrue(e instanceof IntOpExpr);
		// TODO make sure it's actually the OpExpr we're expecting
	}
}
