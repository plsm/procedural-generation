package grammar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pedro
 * @param <S>
 */
public class Alphabet<S extends Symbol>
{
	private final Map<Character, S> alphabet;
	public Alphabet (S... alphabet)
	{
		this.alphabet = new HashMap<> (alphabet.length);
		for (S s : alphabet) {
			if (s != null) {
				this.alphabet.put (s.getCode (), s);
			}
		}
	}
	
	public S get (char c)
	{
		return this.alphabet.get (c);
	}

	public Alphabet<S> add (S symbol)
	{
		this.alphabet.put (symbol.getCode (), symbol);
		return this;
	}
	@Override
	public String toString ()
	{
		return this.alphabet.toString ();
	}
}
