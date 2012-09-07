package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.Expr;

public class IntExpr implements Expr {

	public int value;

	public IntExpr(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.thingly.funky.Expr#eval(java.util.Dictionary)
	 */
	public Expr eval(Environment env) {
		return this;
	}
	
	public String toString(){
		return "" + value;
	}
}
