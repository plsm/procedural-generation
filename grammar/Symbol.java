/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public interface Symbol
{
	/**
	 * Paint this symbol.
	 * @param gl 
	 */
	public void paint (GL2 gl, Turtle turtle);
	/**
	 * Get the character code associated with this symbol.  Each symbol should have a unique character code.
	 * @return The character code associated with this symbol.
	 */
	public char getCode ();
}
