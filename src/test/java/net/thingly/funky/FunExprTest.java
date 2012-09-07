package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class FunExprTest extends ParserTest {
	@Test
	public void parseFunExpr() throws ParseException, EvalException {
		String id = "foo";
		String[] vars = { "x", "y" };
		String fun = "(* x y)";

		String str = "(defun " + id + " (";
		for (String v : vars) {
			str += " " + v;
		}
		str += ") " + fun + ")";
		out.println(str);
		out.println("(foo 7 9)");
		out.close();

		Expr e = p.parse().eval(env); // parse the DeFun
		e = p.parse().eval(env); // parse the FunExpr
		assertTrue(e instanceof IntExpr);
		assertEquals((7 * 9), ((IntExpr) e).value);
	}
}
