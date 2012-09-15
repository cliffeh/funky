package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class DeFun implements Expr {

	public String id;
	public ListExpr vars;
	public Expr body;

	public DeFun(String id, ListExpr vars, Expr body) {
		this.id = id;
		this.vars = vars;
		this.body = body;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		env.putFunction(this.id, this);
		return new IdExpr(this.id);
	}

	public String toString() {
		return "(" + id + " " + vars.toString() + " " + body.toString() + ")";
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof DeFun) {
			DeFun df = ((DeFun) expr);
			if (df.id.equals(this.id) && (df.vars.compareTo(this.vars) == 0)
					&& (df.body.compareTo(this.body) == 0))
				return 0;
		}
		return -1;
	}

}
