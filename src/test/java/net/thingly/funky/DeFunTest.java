package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.DeFun;
import net.thingly.funky.impl.IdExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class DeFunTest extends ParserTest {
	@Test
	public void parseDeFun() throws ParseException, EvalException {
		String id = "foo";
		String[] vars = { "x", "y" };
		String fun = "(* x y)";

		String str = "(defun " + id + " (";
		for (String v : vars) {
			str += " " + v;
		}
		str += ") " + fun + ")";
		out.println(str);
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof DeFun);
		assertEquals(id, ((DeFun) e).id);

		e = e.eval(env);
		assertTrue(e instanceof IdExpr);
		assertEquals(id, ((IdExpr) e).id);
	}
}
