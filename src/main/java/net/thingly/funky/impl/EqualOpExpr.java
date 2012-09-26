package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class EqualOpExpr implements Expr {

	public Expr e1, e2;
	public Expr t, f;

	public EqualOpExpr(Expr e1, Expr e2) {
		this(e1, e2, BoolExpr.TRUE, BoolExpr.FALSE);
	}

	public EqualOpExpr(Expr e1, Expr e2, Expr t, Expr f) {
		this.e1 = e1;
		this.e2 = e2;
		this.t = t;
		this.f = f;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		return (e1.eval(env).compareTo(e2.eval(env)) == 0) ? t.eval(env) : f
				.eval(env);
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof EqualOpExpr) {
			EqualOpExpr eoe = ((EqualOpExpr) expr);
			if ((eoe.e1.compareTo(this.e1) == 0)
					&& (eoe.e2.compareTo(this.e2) == 0))
				return 0;
		}
		return -1;
	}
}
