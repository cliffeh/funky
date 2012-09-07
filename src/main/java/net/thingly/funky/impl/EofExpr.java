package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class EofExpr implements Expr {

	public static final EofExpr EOF = new EofExpr();

	public EofExpr() {
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		return EOF;
	}

	public String toString() {
		return "<EOF>";
	}

}
