/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar.symbol;

import grammar.Symbol;
import javax.media.opengl.GL2;

/**
 * A stem that does not draw anything.
 * @author pedro
 */
public enum Stem
	implements Symbol
{
	/**
	 * 
	 */
	X;
	/**
	 * 
	 * @param gl 
	 */
	@Override
	public void paint (GL2 gl)
	{
		
	}
	/**
	 * 
	 * @return
	 */
	@Override
	public char getCode ()
	{
		return 'X';
	}
}
