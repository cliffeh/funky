package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class QuoteExpr implements Expr {

	public Expr quote;

	public QuoteExpr(Expr quote) {
		this.quote = quote;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		return quote;
	}

	@Override
	public int compareTo(Expr expr) {
		if (expr instanceof QuoteExpr) {
			return ((QuoteExpr) expr).quote.compareTo(this.quote);
		}
		return -1;
	}
}
