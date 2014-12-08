/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import java.awt.event.KeyEvent;
import javax.media.opengl.GL2;

/**
 * Controls projection atributes namely camera aperture.  Projection atributes can be changed by the user.
 * 
 * @author Pedro Mariano
 */
abstract public class AbstractProjection
	implements Projection
{
	/**
	 * Use a perspective or a parallel projection.
	 */
	protected boolean perspectiveProjection;
	protected float left;
	protected float right;
	protected float top;
	protected float bottom;
	protected float far;
	protected float near;
	/**
	 * Create a default projection.
	 */
	protected AbstractProjection ()
	{
		this.perspectiveProjection = true;
		this.left = -100;
		this.right = 100;
		this.top = 100;
		this.bottom = -2;
		this.far = 10;
		this.near = 1;
	}
	protected AbstractProjection (boolean perspectiveProjection, int horizontal, int vertical, int near, int far)
	{
		this.perspectiveProjection = perspectiveProjection;
		this.left = -horizontal;
		this.right = horizontal;
		this.top = vertical;
		this.bottom = -vertical;
		this.near = near;
		this.far = far;
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
	 *
	 * @param gl
	 */
	@Override
	public void setupProjection (GL2 gl)
	{
		gl.glMatrixMode (GL2.GL_PROJECTION);
		gl.glLoadIdentity ();
		if (this.perspectiveProjection) {
			gl.glFrustum (
				left,   right,
				bottom, top,
				near,   far
			);
		}
		else {
			gl.glOrtho (
				left,   right,
				bottom, top,
				near,   far
			);
		}
	}
	public void status ()
	{
		System.out.println (this.perspectiveProjection ? "Perspective" : "Parallel");
		System.out.format ("Left Right: %5.1f .. %5.1f\n", this.left, this.right);
		System.out.format ("Top Bottom: %5.1f .. %5.1f\n", this.top, this.bottom);
		System.out.format ("  Near Far: %5.1f .. %5.1f\n", this.near, this.far);
	}
}
