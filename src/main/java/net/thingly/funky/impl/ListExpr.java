package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class ListExpr implements Expr {

	/** the empty list */
	public static final ListExpr NIL = new ListExpr();

	public Expr car;
	public ListExpr cdr;

	public ListExpr() {
		this(NIL, null);
	}

	public ListExpr(Expr car) {
		this(car, NIL);
	}

	public ListExpr(Expr car, ListExpr cdr) {
		// TODO this seems kinda like a hack...
//		if (car == null)
//			this.car = NIL;
		this.car = car;
		this.cdr = cdr;
	}

	public Expr eval(Environment env) throws EvalException {
		return evalList(this, env);
	}

	private ListExpr evalList(ListExpr list, Environment env)
			throws EvalException {
		if (list.car.equals(NIL))
			return NIL;
		return new ListExpr(list.car.eval(env), evalList(list.cdr, env));
	}

	public String toString() {		
		String str = "(";

		for (ListExpr le = this; !le.car.equals(NIL); le = le.cdr) {
			str += " " + le.car.toString();
		}

		str += ")";
		return str;
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof ListExpr) {
			ListExpr le = ((ListExpr) expr);
			if ((le.car.compareTo(this.car) == 0)
					&& (le.cdr.compareTo(this.cdr) == 0))
				return 0;
		}
		return -1;
	}
}
