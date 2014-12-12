/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grammar.symbol;

import grammar.Symbol;
import grammar.Turtle;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public enum Colour
	implements Symbol
{
	/**
	 *
	 */
	NEXT ('\'')
	{
		@Override
		public void paint (GL2 gl, Turtle turtle)
		{
		}
		
	};
	/**
	 * 
	 */
	final private char code;
	/**
	 * 
	 * @param code 
	 */
	private Colour (char code)
	{
		this.code = code;
	}
	/**
	 * 
	 * @return 
	 */
	@Override
	public char getCode ()
	{
		return this.code;
	}
	/**
	 * 
	 * @param gl
	 * @param turtle 
	 */
	@Override
	abstract public void paint (GL2 gl, Turtle turtle);
	/**
	 * 
	 * @return 
	 */
	@Override
	public String toString ()
	{
		return String.valueOf (this.code);
	}
	
}
