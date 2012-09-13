package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;
import net.thingly.funky.impl.StringExpr;

import org.junit.Test;

public class StringExprTest extends ExprTest {

	private final String str = "this is my string";

	@Test
	public void parseStringExpr() throws ParseException, EvalException {
		out.println("\"" + str + "\"");
		out.flush();

		Expr e = p.parse();
		assertTrue(e instanceof StringExpr);
		assertEquals(str, ((StringExpr) e).string);
		e = e.eval(env);
		assertTrue(e instanceof StringExpr);
		assertEquals(str, ((StringExpr) e).string);
	}

	// TODO put this in its own StringOpExpr class?
	@Test
	public void testSubstr() throws ParseException, EvalException {
		// syntax: (substr string pos len?)
		int pos = 5, len = 2;
		out.println("(substr \"" + str + "\" " + pos + ")");
		out.flush();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof StringExpr);
		assertEquals(str.substring(pos), ((StringExpr) e).string);

		out.println("(substr \"" + str + "\" " + pos + " " + len + ")");
		out.close();

		e = p.parse().eval(env);
		assertTrue(e instanceof StringExpr);
		assertEquals(str.substring(pos, (pos + len)), ((StringExpr) e).string);
	}

	@Test
	public void testStringLength() throws ParseException, EvalException {
		out.println("(string-length \"" + str + "\")");
		out.close();

		Expr e = p.parse().eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals(str.length(), ((IntExpr) e).value);
	}
}
