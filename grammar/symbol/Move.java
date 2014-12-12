/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar.symbol;

import grammar.AbstractSymbol;
import grammar.Turtle;
import javax.media.opengl.GL2;

/**
 * Move the turtle along the X axis.
 * @author pedro
 */
final public class Move
	extends AbstractSymbol
{
	/**
	 * Distance moved by the turtle.
	 */
	final private int delta;
	/**
	 * Construct a move symbol with the given distance.
	 * @param delta Distance moved by the turtle.
	 */
	public Move (int delta)
	{
		super ('f');
		this.delta = delta;
	}

	@Override
	public void paint (GL2 gl, Turtle turtle)
	{
		gl.glTranslatef (this.delta, 0, 0);
	}
}
