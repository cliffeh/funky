package net.thingly.funky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.thingly.funky.impl.IdExpr;
import net.thingly.funky.impl.IntExpr;
import net.thingly.funky.impl.ParseException;

import org.junit.Test;

public class IdExprTest extends ExprTest {

	@Test
	public void parseIdExpr() throws ParseException, EvalException {
		String id = "x";
		int value = 123;

		env.putVariable(id, new IntExpr(value));
		out.println(id);
		out.close();

		Expr e = p.parse();
		assertTrue(e instanceof IdExpr);
		assertEquals(id, ((IdExpr) e).id);

		e = e.eval(env);
		assertTrue(e instanceof IntExpr);
		assertEquals(value, ((IntExpr) e).value);
	}

}
