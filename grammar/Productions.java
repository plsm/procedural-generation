package grammar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pedro
 */
final public class Productions<S extends Symbol>
{
	final Map<S, List<S>> rules;
	/**
	 * 
	 */
	public Productions ()
	{
		this.rules = new HashMap<> ();
	}
	/**
	 * 
	 * @param head
	 * @param body 
	 */
	public Productions (S head, S[] body)
	{
		this.rules = new HashMap<> ();
		this.put (head, body);
	}
	
	public void put (S head, S[] body)
	{
		if (body != null) {
			this.rules.put (head, Arrays.asList (body));
		}
	}
	/**
	 * 
	 * @param head
	 * @param body
	 * @param alphabet
	 * @return 
	 */
	public boolean put (char head, String body, Alphabet<S> alphabet)
	{
		LinkedList<S> sBody = new LinkedList<> ();
		S sHead = alphabet.get (head);
		if (sHead == null) {
			throw new RuntimeException ("There is no symbol for " + head + ", alphabet is " + alphabet);
//			return false;
		}
		for (char aChar : body.toCharArray ()) {
			S sAChar = alphabet.get (aChar);
			if (sAChar == null) {
				throw new RuntimeException ("There is no symbol for " + aChar + ", alphabet is " + alphabet);
//				return false;
			}
			sBody.add (sAChar);
		}
		this.rules.put (sHead, sBody);
		return true;
	}
	/**
	 * 
	 * @param symbol
	 * @return 
	 */
	public List<S> get (S symbol)
	{
		return this.rules.get (symbol);
	}
	
	public void debug ()
	{
		for (S head : this.rules.keySet ()) {
			System.out.print (head.getCode ());
			System.out.print (" -> ");
			for (S symbol : this.rules.get (head)) {
				System.out.print (symbol.getCode ());
			}
			System.out.println ();
		}
	}
}
