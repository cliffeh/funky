package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class FunExpr implements Expr {

	public String id;
	public ListExpr params;

	public FunExpr(String id) {
		this(id, NilExpr.NIL);
	}

	public FunExpr(String id, ListExpr params) {
		this.id = id;
		this.params = params;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		// retrieve the function definiton from the environment
		DeFun fun = env.getFunction(id);
		if (fun == null)
			throw new EvalException("no function with the name '" + id
					+ "' exists");

		// maintain scope with a new environment, using env as the parent
		Environment funEnv = new Environment(env);

		// evaluate and bind the parameters to their respective variable names
		ListExpr v = fun.vars;
		ListExpr p = params;
		while (v.cdr != null && p.cdr != null) {
			// TODO handle if !(v.car instanceof IdExpr), maybe at defun time
			funEnv.putVariable(((IdExpr) v.car).id, p.car.eval(env));
			v = v.cdr;
			p = p.cdr;
		}
		if (v.cdr != null || p.cdr != null) {
			// TODO try and fail more gracefully than this
			throw new EvalException("function parameter count mismatch");
		}

		// evaluate the function body using the new scope and return the result
		return fun.body.eval(funEnv);
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof FunExpr) {
			FunExpr fe = ((FunExpr) expr);
			if (fe.id.equals(this.id)
					&& (fe.params.compareTo(this.params) == 0))
				return 0;
		}
		return -1;
	}
}
