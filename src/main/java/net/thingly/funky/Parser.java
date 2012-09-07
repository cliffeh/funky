package net.thingly.funky;

import net.thingly.funky.impl.ParseException;

public interface Parser {
	public Expr parse() throws ParseException;
}
