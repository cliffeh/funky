package net.thingly.funky.impl;

import java.util.List;

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
		vars.eval(letEnv);

		// finally, evaluate the expression
		return e.eval(letEnv);
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof LetExpr) {
			LetExpr le = ((LetExpr) expr);
			if ((le.vars.compareTo(this.vars) == 0)
					&& (le.e.compareTo(this.e) == 0))
				return 0;
		}
		return -1;
	}

}
