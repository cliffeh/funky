package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.Expr;

public class IdExpr implements Expr {

	public String id;

	public IdExpr(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.thingly.funky.Expr#eval(java.util.Dictionary)
	 */
	public Expr eval(Environment env) {
		Expr e = env.getVariable(id);
		return (e == null) ? NilExpr.NIL : e; // TODO check for null
	}

	public String toString() {
		return id;
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof IdExpr) {
			if (((IdExpr) expr).id.equals(this.id))
				return 0;
		}
		return -1;
	}
}
