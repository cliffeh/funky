package net.thingly.funky.impl;

import net.thingly.funky.Environment;
import net.thingly.funky.EvalException;
import net.thingly.funky.Expr;

public class OpExpr implements Expr {

	public char op;
	public ListExpr l;

	public OpExpr(char op, ListExpr l) {
		this.op = op;
		this.l = l;
	}

	@Override
	public Expr eval(Environment env) throws EvalException {
		switch (op) {
		case '+':
			return evalAdd(env);
		case '-':
			return evalSub(env);
		case '*':
			return evalMul(env);
		case '/':
			return evalDiv(env);
		default:
			throw new EvalException("unknown operation: '" + op + "'");
		}
	}

	private Expr evalAdd(Environment env) throws EvalException {
		int result = 0;
		for (ListExpr le = l; le.car != NilExpr.NIL; le = le.cdr) {
			Expr e = le.car.eval(env);
			if (!(e instanceof IntExpr))
				throw new EvalException(
						"attempt to apply an Integer operation to a non-integer");
			result += ((IntExpr) e).value;
		}
		return new IntExpr(result);
	}

	private Expr evalSub(Environment env) throws EvalException {
		Expr e = l.car.eval(env);
		if (!(e instanceof IntExpr))
			throw new EvalException(
					"attempt to apply an Integer operation to a non-integer");
		int result = ((IntExpr) e).value;
		if (l.cdr.car == NilExpr.NIL)
			result = -result;

		for (ListExpr le = l.cdr; le.car != NilExpr.NIL; le = le.cdr) {
			e = le.car.eval(env);
			if (!(e instanceof IntExpr))
				throw new EvalException(
						"attempt to apply an Integer operation to a non-integer");
			result -= ((IntExpr) e).value;
		}
		return new IntExpr(result);
	}

	private Expr evalMul(Environment env) throws EvalException {
		int result = 1;
		for (ListExpr le = l; le.car != NilExpr.NIL; le = le.cdr) {
			Expr e = le.car.eval(env);
			if (!(e instanceof IntExpr))
				throw new EvalException(
						"attempt to apply an Integer operation to a non-integer");
			result *= ((IntExpr) e).value;
		}
		return new IntExpr(result);
	}

	private Expr evalDiv(Environment env) throws EvalException {
		Expr e = l.car.eval(env);
		if (!(e instanceof IntExpr))
			throw new EvalException(
					"attempt to apply an Integer operation to a non-integer");
		int result = ((IntExpr) e).value;
		e = l.cdr.car.eval(env);
		if (!(e instanceof IntExpr))
			throw new EvalException("divison requires at least two operands");
		result = result / ((IntExpr) e).value;

		for (ListExpr le = l.cdr.cdr; le.car != NilExpr.NIL; le = le.cdr) {
			e = le.car.eval(env);
			if (!(e instanceof IntExpr))
				throw new EvalException(
						"attempt to apply an Integer operation to a non-integer");
			result = result / ((IntExpr) e).value;
		}
		return new IntExpr(result);
	}

	public String toString() {
		String str = "(" + op;
		for (ListExpr le = l; le.car != NilExpr.NIL; le = le.cdr) {
			str += " " + le.car.toString();
		}
		str += ")";
		return str;
	}
}
