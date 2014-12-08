/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import java.util.LinkedList;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class Word<S extends Symbol>
{
	protected LinkedList<S> symbols;

	protected Word (S seed)
	{
		this.symbols = new LinkedList<S> ();
		this.symbols.add (seed);
	}
	
	final public void paint (GL2 gl)
	{
		for (S s : this.symbols) {
			System.out.print (s);
			s.paint (gl);
		}
		System.out.println ();
	}
	
	LinkedList<S> getSymbols ()
	{
		return symbols;
	}
}
