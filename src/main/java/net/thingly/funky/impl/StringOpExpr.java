package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class StringOpExpr implements Expr {

	enum OP {
		SUBSTR, STRLEN, CHARAT
	}

	public OP op;
	public Expr e;
	public Expr[] params;

	public StringOpExpr(OP op, Expr e) {
		this(op, e, new Expr[] {});
	}

	public StringOpExpr(OP op, Expr e, Expr[] params) {
		this.op = op;
		this.params = params;
		this.e = e;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		// TODO type check e and params after evaluation!
		e = e.eval(env);
		for (int i = 0; i < params.length; i++) {
			params[i] = params[i].eval(env);
		}
		switch (op) {
		case SUBSTR: {
			switch (params.length) {
			case 1: // pos
				return new StringExpr(
						((StringExpr) e).string
								.substring(((IntExpr) params[0]).value));
			case 2: // pos, len
				return new StringExpr(((StringExpr) e).string.substring(
						((IntExpr) params[0]).value,
						((IntExpr) params[0]).value
								+ ((IntExpr) params[1]).value));
			default:
				throw new EvalException(
						"incorrect number of parameters for substr ("
								+ params.length + ")");
			}
		}
		case STRLEN: {
			if (params.length != 0)
				throw new EvalException(
						"incorrect number of parameters for string-length ("
								+ params.length + ")");
			return new IntExpr(((StringExpr) e).string.length());
		}
		case CHARAT: {
			if (params.length != 1)
				throw new EvalException(
						"incorrect number of parameters for string-char ("
								+ params.length + ")");
			return new StringExpr(
					""
							+ ((StringExpr) e).string
									.charAt(((IntExpr) params[0]).value));
		}
		default:
			throw new EvalException("unknown string operation");
		}
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof StringOpExpr) {
			StringOpExpr soe = ((StringOpExpr) expr);
			if ((soe.op == this.op) && (soe.e.compareTo(this.e) == 0)) {
				if (soe.params.length == this.params.length) {
					for (int i = 0; i < params.length; i++) {
						if (params[i].compareTo(soe.params[i]) != 0) {
							return -1;
						}
					}
					return 0;
				}
			}
		}
		return -1;
	}
}
