/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar.symbol;

import grammar.AbstractSymbol;
import grammar.Turtle;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
final public class Rotate
	extends AbstractSymbol
{
	/**
	 * Rotation angle.
	 */
	private final float angle;
	private final float axisX;
	private final float axisY;
	private final float axisZ;
	/**
	 * Return a rotate along the z axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Plus (float angle)
	{
		return new Rotate ('+', Math.abs (angle), 0, 0, 1);
	}
	/**
	 * Return a rotate along the z axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Minus (float angle)
	{
		return new Rotate ('-', -Math.abs (angle), 0, 0, 1);
	}
	/**
	 * Return a rotate along the y axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Ampersand (float angle)
	{
		return new Rotate ('&', Math.abs (angle), 0, 1, 0);
	}
	/**
	 * Return a rotate along the y axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Circumflex (float angle)
	{
		return new Rotate ('^', -Math.abs (angle), 0, 1, 0);
	}
	/**
	 * Return a rotate along the y axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Backslash (float angle)
	{
		return new Rotate ('\\', -Math.abs (angle), 1, 0, 0);
	}
	/**
	 * Return a rotate along the y axis symbol.
	 * @param angle
	 * @return 
	 */
	static public Rotate Slash (float angle)
	{
		return new Rotate ('/', Math.abs (angle), 1, 0, 0);
	}
	static public Rotate Backwards ()
	{
		return new Rotate ('|', 180, 1, 0, 0);
	}
	/**
	 * Rotate instances are created using static methods.
	 * @param code
	 * @param angle The rotation angle.
	 * @param axisX 
	 * @param axisY
	 * @param axisZ 
	 */
	private Rotate (char code, float angle, float axisX, float axisY, float axisZ)
	{
		super (code);
		this.angle = angle;
		this.axisX = axisX;
		this.axisY = axisY;
		this.axisZ = axisZ;
	}
	@Override
	public void paint (GL2 gl, Turtle turtle)
	{
		gl.glRotatef (this.angle, this.axisX, this.axisY, this.axisZ);
	}
}
