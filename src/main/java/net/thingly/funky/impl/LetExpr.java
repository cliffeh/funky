package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class LetExpr implements Expr {

	public ListExpr vars;
	public Expr e;

	public LetExpr(ListExpr vars, Expr e) {
		this.vars = vars;
		this.e = e;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		// maintain scope with a new environment, using env as the parent
		Environment letEnv = new Environment(env);

		// put each of the variables into the environment
		for (ListExpr l = vars; l.cdr != null; l = l.cdr) {
			// TODO double-check that each of these is a variable definition,
			// maybe at parse time?
			l.car.eval(letEnv);
		}

		return e.eval(letEnv);
	}

}
