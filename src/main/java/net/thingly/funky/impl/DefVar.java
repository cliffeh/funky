package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class DefVar implements Expr {

	public String id;
	public Expr e;

	public DefVar(String id) {
		this(id, null);
	}

	public DefVar(String id, Expr e) {
		this.id = id;
		this.e = e;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		env.putVariable(id, e);
		return new IdExpr(id);
	}

}
