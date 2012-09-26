package net.thingly.funky;

public interface Expr extends Comparable<Expr> {
	public Expr eval(Environment env) throws EvalException;
}
