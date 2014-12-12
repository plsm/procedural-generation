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
public enum Width
	implements Symbol
{
	DECREMENT ('!')
	{
		@Override
		public void paint (GL2 gl, Turtle turtle)
		{
			if (turtle.lineWidth > turtle.lineDelta) {
				turtle.lineWidth -= turtle.lineDelta;
			}
		}
	};
	final private char code;

	private Width (char code)
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
