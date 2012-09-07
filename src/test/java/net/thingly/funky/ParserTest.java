package net.thingly.funky;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

import net.thingly.funky.impl.ParserImpl;

import org.junit.Before;

public class ParserTest {

	protected PrintWriter out;
	protected Parser p;
	protected Environment env;

	@Before
	public void setup() throws IOException {
		PipedInputStream pin = new PipedInputStream();
		PipedOutputStream pout = new PipedOutputStream();
		pin.connect(pout);

		out = new PrintWriter(pout);
		p = new ParserImpl(pin);

		env = new Environment();
	}
}
