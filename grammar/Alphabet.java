/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import grammar.symbol.Stem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class Alphabet<S extends Symbol>
{
	private final Map<Character, S> alphabet;
	
	public Alphabet (S[] alphabet)
	{
		this.alphabet = new HashMap<> (alphabet.length);
		for (S s : alphabet) {
			this.alphabet.put (s.getCode (), s);
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
}
