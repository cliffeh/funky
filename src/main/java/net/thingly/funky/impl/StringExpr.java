package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class StringExpr implements Expr {

	public String string;

	public StringExpr(String string) {
		this.string = string;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		return this;
	}

	public String toString() {
		return string;
	}

}
