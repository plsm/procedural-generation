package grammar.symbol;

import grammar.AbstractSymbol;
import grammar.Turtle;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 * Draw a line along the X axis.
 * @author pedro
 */
final public class Forward
	extends ColouredSymbol
{
	/**
	 * Line Length.
	 */
	final private int delta;
	/**
	 * 
	 * @param delta 
	 */
	public Forward (int delta, float red, float green, float blue)
	{
		super ('F', red, green, blue);
		this.delta = delta;
	}
	/**
	 * 
	 * @param gl 
	 */
	@Override
	public void paint (GL2 gl, Turtle turtle)
	{
		gl.glColor3f (this.red, this.green, this.blue);
		if (!turtle.specifyingPolygonBoundary) {
			gl.glBegin (GL.GL_LINE_STRIP);
		}
		gl.glVertex3d (0, 0, 0);
		gl.glVertex3d (0, delta, 0);
		if (!turtle.specifyingPolygonBoundary) {
			gl.glEnd ();
		}
		gl.glTranslated (0, delta, 0);
	}
}
