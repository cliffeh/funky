package net.thingly.funky;

import java.io.IOException;
import java.io.OutputStream;

public interface Printer {
	public void print(OutputStream out, Expr expr) throws IOException;
}
