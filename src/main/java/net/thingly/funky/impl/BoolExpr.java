package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class BoolExpr implements Expr {

	public static final BoolExpr TRUE = new BoolExpr();
	public static final BoolExpr FALSE = new BoolExpr();

	private BoolExpr() {
	}

	protected boolean eval() {
		return this.equals(TRUE);
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		return this;
	}

	public String toString() {
		return eval() ? "#t" : "#f";
	}

	@Override
	public int compareTo(Expr expr) {
		return expr.equals(this) ? 0 : -1;
	}

}
