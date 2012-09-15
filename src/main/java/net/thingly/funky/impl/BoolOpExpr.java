package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class BoolOpExpr implements Expr {

	enum OP {
		AND, OR
	}

	public OP op;
	public ListExpr l;

	public BoolOpExpr(OP op, ListExpr l) {
		this.op = op;
		this.l = l;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		// TODO ensure that there is at least one parameter? or no...?
		switch (op) {
		case AND:
			return evalAnd(env);
		case OR:
			return evalOr(env);
		default:
			throw new EvalException("unknown boolean operation");
		}
	}

	private Expr evalAnd(Environment env) throws EvalException {
		boolean b = true;
		// break as soon as we've gone false
		for (ListExpr le = l; (b && le.car != NilExpr.NIL); le = le.cdr) {
			// TODO type checking!
			b = b && (((BoolExpr) le.car.eval(env)).eval());
		}
		return b ? BoolExpr.TRUE : BoolExpr.FALSE;
	}

	private Expr evalOr(Environment env) throws EvalException {
		boolean b = false;
		// break as soon as we've gone true
		for (ListExpr le = l; (!b && le.car != NilExpr.NIL); le = le.cdr) {
			// TODO type checking!
			b = b || (((BoolExpr) le.car.eval(env)).eval());
		}
		return b ? BoolExpr.TRUE : BoolExpr.FALSE;
	}

	@Override
	public int compareTo(Expr expr) {
		if ((expr instanceof BoolOpExpr) && (((BoolOpExpr) expr).op == this.op)) {
			return l.compareTo(((BoolOpExpr) expr).l);
		}
		return -1;
	}
}
