/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of the algorithm that parses a sentence and applies grammar production rules.
 * @author pedro
 */
public class Algorithm
{
	static <S extends Symbol> void apply (Word<S> word, Productions<S> productions)
	{
		ListIterator<S> iterator = word.getSymbols ().listIterator ();
		while (iterator.hasNext ()) {
			S head = iterator.next ();
			List<S> body = productions.get (head);
			if (body != null) {
				iterator.remove ();
				for (S symbol : body) {
					iterator.add (symbol);
				}
			}
		}
	}
}
