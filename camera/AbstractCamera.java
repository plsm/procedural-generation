package camera;

import java.awt.event.KeyEvent;
import javax.media.opengl.glu.GLU;

/**
 * Provides basic properties of and operation on the OpenGL camera.  The operation allow users to control the camera.
 * 
 * @author Pedro Mariano
 */
abstract public class AbstractCamera
{
	/**
	 * Camera coordinates.
	 */
	protected double[] eye;
	/**
	 * Coordinates of where the camera is pointing.
	 */
	protected double[] center;
	/**
	 * Up vector used when setting the camera properties.
	 */
	protected double[] up;
	/**
	 * Constructs a default camera.
	 */
	protected AbstractCamera ()
	{
		this (new double[] {0, 0, 0}, new double[] {1, 0, 0}, new double[] {0, 0, 1});
	}
	/**
	 * Constructs a camere with the given properties.
	 * @param eye
	 * @param center
	 * @param up 
	 */
	protected AbstractCamera (double[] eye, double[] center, double[] up)
	{
		this.eye = eye;
		this.center = center;
		this.up = up;
	}
	/**
	 * Place the camera in the world.
	 * @param glu 
	 */
	final public void placeCamera (GLU glu)
	{
		glu.gluLookAt (
			this.eye [0], this.eye [1], this.eye [2],
			this.center [0], this.center [1], this.center [2],
			this.up [0], this.up [1], this.up [2]
			);
	}
	/**
	 * Process the key event.
	 * @param ke The key event to process.
	 * @return {@code true} if the event was processed by this method.
	 */
	abstract public boolean keyPressed (KeyEvent ke);
	/**
	 * Process the key event.
	 * @param ke The key event to process.
	 * @return {@code true} if the event was processed by this method.
	 */
	abstract public boolean keyTyped (KeyEvent ke);
	/**
	 * Print debug information to standard output.
	 */
	public void status ()
	{
		System.out.format ("   Eye:  ( %5.1f , %5.1f , %5.1f )\n", this.eye [0], this.eye [1], this.eye [2]);
		System.out.format ("Center:  ( %5.1f , %5.1f , %5.1f )\n", this.center [0], this.center [1], this.center [2]);
		System.out.format ("    Up:  ( %5.1f , %5.1f , %5.1f )\n", this.up [0], this.up [1], this.up [2]);
	}
}
