package grammar;

import java.util.LinkedList;
import java.util.List;
import javax.media.opengl.GL2;

/**
 * Represents a word that is used to draw an object.
 * 
 * @author Pedro Mariano
 */
public class Word<S extends Symbol>
{
	/**
	 * The symbols that make up this word.
	 */
	protected List<S> symbols;
	/**
	 * Construct a self drawing word with a symbol seed.
	 *
	 * @param seed 
	 */
	public Word (S seed)
	{
		this.symbols = new LinkedList<> ();
		this.symbols.add (seed);
	}
	/**
	 * Construct a self drawing word with a symbol seed.
	 *
	 * @param seed 
	 */
	public Word (S[] symbols)
	{
		this.symbols = new LinkedList<> (java.util.Arrays.asList (symbols));
	}
	/**
	 * Paint this word.  Each symbol of the alphabet is responsible for drawing.
	 *
	 * @param gl 
	 */
	final public void paint (GL2 gl)
	{
		gl.glPushMatrix ();
		for (S s : this.symbols) {
			s.paint (gl);
		}
		gl.glPopMatrix ();
	}
	/**
	 * Paint this word and write each symbol to standard output.  Each symbol of the alphabet is responsible for drawing.
	 *
	 * @param gl 
	 */
	final public void paintDebug (GL2 gl)
	{
		gl.glPushMatrix ();
		for (S s : this.symbols) {
			System.out.print (s);
			s.paint (gl);
		}
		gl.glPopMatrix ();
		System.out.println ();
	}
	/**
	 * Get the symbols in this word.
	 *
	 * @return the symbols in this word.
	 */
	List<S> getSymbols ()
	{
		return symbols;
	}
	public String getSymbolCodesAsString ()
	{
		StringBuilder result = new StringBuilder (this.symbols.size ());
		for (S s : this.symbols) {
			result.append (s.getCode ());
		}
		return result.toString ();
	}
	/**
	 * Return the length of this word.
	 *
	 * @return the length of this word.
	 */
	final public int length ()
	{
		return symbols.size ();
	}
	/**
	 * Return a string representation of this word.
	 *
	 * @return a string representation of this word.
	 */
	@Override
	public String toString ()
	{
		StringBuilder result = new StringBuilder (this.length () * 10);
		for (S s : this.symbols) {
			result.append (s.toString ());
		}
		return result.toString ();
	}
}
