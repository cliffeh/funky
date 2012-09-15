package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.Expr;

public class ListExpr implements Expr {
	public Expr car;
	public ListExpr cdr;

	public ListExpr() {
		this(NilExpr.NIL);
	}

	public ListExpr(Expr car) {
		this(car, null);
	}

	public ListExpr(Expr car, ListExpr cdr) {
		this.car = car;
		this.cdr = cdr;
	}

	public Expr eval(Environment env) {
		return null; // TODO implement ListExpr.eval()
	}

	public String toString() {
		String str = "(";
		for (ListExpr l = this; !l.car.equals(NilExpr.NIL); l = l.cdr) {
			System.err.println("CAR: " + l.car.toString());
			str += " " + l.car.toString();
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
