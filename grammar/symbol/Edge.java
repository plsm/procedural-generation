package grammar.symbol;

import grammar.AbstractSymbol;
import grammar.Turtle;
import javax.media.opengl.GL2;

/**
 * Move the turtle along the X axis.
 * @author pedro
 */
final public class Edge
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
	public Edge (int delta)
	{
		super ('f');
		this.delta = delta;
	}

	@Override
	public void paint (GL2 gl, Turtle turtle)
	{
		gl.glVertex3d (0, 0, 0);
		gl.glVertex3d (0, delta, 0);
		gl.glTranslatef (0, this.delta, 0);
	}
}
