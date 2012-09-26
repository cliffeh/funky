package net.thingly.funky.impl;

import java.util.List;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class FunExpr implements Expr {

	public String id;
	public ListExpr actuals;

	public FunExpr(String id) {
		this(id, NilExpr.NIL);
	}

	public FunExpr(String id, ListExpr actuals) {
		this.id = id;
		this.actuals = actuals;
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
		ListExpr f = fun.formals;
		ListExpr a = actuals;

		for (; (!f.car.equals(ListExpr.NIL) && !a.car.equals(ListExpr.NIL)); f = f.cdr, a = a.cdr) {
			// TODO what if !(f.car instanceof IdExpr)?
			funEnv.putVariable(((IdExpr) f.car).id, a.car.eval(env));
		}
		// check for a parameter count mismatch
		if (!f.car.equals(ListExpr.NIL))
			throw new EvalException(
					"parameter count mismatch: too few parameters provided to function '"
							+ id + "'");
		if (!a.car.equals(ListExpr.NIL))
			throw new EvalException(
					"parameter count mismatch: too many parameters provided to function '"
							+ id + "'");

		// evaluate the function body using the new scope and return the result
		return fun.body.eval(funEnv);
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof FunExpr) {
			FunExpr fe = ((FunExpr) expr);
			if (fe.id.equals(this.id)
					&& (fe.actuals.compareTo(this.actuals) == 0))
				return 0;
		}
		return -1;
	}
}
