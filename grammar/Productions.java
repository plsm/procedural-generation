/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pedro
 */
final public class Productions<S extends Symbol>
{
	final Map<S, List<S>> rules;
	
	Productions (S head, S[] body)
	{
		this.rules = new HashMap<S, List<S>> ();
		this.put (head, body);
	}
	
	public void put (S head, S[] body)
	{
		if (body != null) {
			this.rules.put (head, Arrays.asList (body));
		}
	}
	
	public List<S> get (S symbol)
	{
		return this.rules.get (symbol);
	}
}
