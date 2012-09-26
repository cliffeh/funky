package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.Expr;

public class NilExpr extends ListExpr {

	public static final NilExpr NIL = new NilExpr();

	private NilExpr() {
	}

	public Expr eval(Environment env) {
		return NIL;
	}

	public String toString() {
		return "()";
	}

	public int compareTo(Expr expr) {
		return (this.equals(expr)) ? 0 : -1;
	}
}
