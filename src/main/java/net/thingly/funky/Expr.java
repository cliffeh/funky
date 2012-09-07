package net.thingly.funky;

public interface Expr {
	public Expr eval(Environment env) throws EvalException;
}
