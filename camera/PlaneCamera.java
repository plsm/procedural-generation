package camera;

import java.awt.event.KeyEvent;

/**
 * Represents a camera that moves in a plane.  The user can control the camera position with the up and down arrow keys and change its heading with the left and right arrow keys.
 * @author Pedro Mariano
 */
final public class PlaneCamera
	extends AbstractCamera
{
	/**
	 * Angle between the camera heading and the X axis.
	 */
	protected float angle;
	protected float tilt;
	protected float linearVelocity;
	protected double angularVelocity;
	public PlaneCamera ()
	{
		super ();
		this.angle = 0;
		this.tilt = 0;
		this.linearVelocity = 1;
		this.angularVelocity = Math.PI / 16;
		this.center [0] = this.eye [0] + Math.cos (this.angle);
		this.center [1] = this.eye [1] + Math.sin (this.angle);
		this.center [2] = this.eye [2];
		this.up [0] = this.eye [0];
		this.up [1] = this.eye [1];
		this.up [2] = this.eye [2] + 1;
	}

	@Override
	public boolean keyTyped (KeyEvent e)
	{
		return false;
	}

	@Override
	public boolean keyPressed (KeyEvent ke)
	{
		switch (ke.getKeyCode ()) {
			case KeyEvent.VK_DOWN:
				this.eye [0] -= this.linearVelocity * Math.cos (this.angle);
				this.eye [1] -= this.linearVelocity * Math.sin (this.angle);
				this.center [0] = this.eye [0] + Math.cos (this.angle);
				this.center [1] = this.eye [1] + Math.sin (this.angle);
				return true;
			case KeyEvent.VK_UP:
				this.eye [0] += this.linearVelocity * Math.cos (this.angle);
				this.eye [1] += this.linearVelocity * Math.sin (this.angle);
				this.center [0] = this.eye [0] + Math.cos (this.angle);
				this.center [1] = this.eye [1] + Math.sin (this.angle);
				return true;
			case KeyEvent.VK_RIGHT:
				this.angle += angularVelocity;
				this.center [0] = this.eye [0] + Math.cos (this.angle);
				this.center [1] = this.eye [1] + Math.sin (this.angle);
				return true;
			case KeyEvent.VK_LEFT:
				this.angle -= angularVelocity;
				this.center [0] = this.eye [0] + Math.cos (this.angle);
				this.center [1] = this.eye [1] + Math.sin (this.angle);
				return true;
		}
		return false;
	}

	public void status ()
	{
		super.status ();
		System.out.println ("Angle: " + Math.round ((180 * this.angle) / Math.PI));
	}
}
