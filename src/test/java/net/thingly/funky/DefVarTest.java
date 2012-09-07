package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.DefVar;
import net.thingly.funky.impl.IdExpr;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class DefVarTest extends ParserTest {

	@Test
	public void parseDefVar() throws ParseException, EvalException {
		String id = "x";
		int value = 20;
		out.println("(defvar " + id + " " + value + ")");
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof DefVar);
		assertEquals("x", ((DefVar) e).id);
		// TODO assertions about e.l?

		e = e.eval(env);
		assertTrue(e instanceof IdExpr);
		assertEquals(id, ((IdExpr) e).id);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals(value, ((IntExpr) e).value);
	}
}
