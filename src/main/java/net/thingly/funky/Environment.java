package net.thingly.funky;

import java.util.Dictionary;
import java.util.Hashtable;

import net.thingly.funky.impl.DeFun;

public class Environment {

	private Environment parent;
	private Dictionary<String, DeFun> funs;
	private Dictionary<String, Expr> vars;

	public Environment() {
		this(null);
	}

	public Environment(Environment parent) {
		this.parent = parent;
		funs = new Hashtable<String, DeFun>();
		vars = new Hashtable<String, Expr>();
	}

	public DeFun getFunction(String name) {
		DeFun fun = funs.get(name);
		if (fun == null && parent != null)
			fun = parent.getFunction(name);
		return fun;
	}

	public Expr getVariable(String name) {
		Expr e = vars.get(name);
		if (e == null && parent != null)
			e = parent.getVariable(name);
		return e;
	}

	public void putFunction(String name, DeFun fun) {
		funs.put(name, fun);
	}

	public void putVariable(String name, Expr var) {
		vars.put(name, var);
	}
}
