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
public enum CurlyBracket
	implements Symbol
{
	LEFT ('{')
	{
		@Override
		public void paint (GL2 gl, Turtle turtle)
		{
			gl.glBegin (GL2.GL_POLYGON);
		}
	},
	RIGHT ('}')
	{
		@Override
		public void paint (GL2 gl, Turtle turtle)
		{
			gl.glEnd ();
		}
	};
	
	final private char code;

	private CurlyBracket (char code)
	{
		this.code = code;
	}
	@Override
	public char getCode ()
	{
		return this.code;
	}
	@Override
	abstract public void paint (GL2 gl, Turtle turtle);
	@Override
	public String toString ()
	{
		return String.valueOf (this.code);
	}
}
