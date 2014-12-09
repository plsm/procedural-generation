/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import java.awt.event.KeyEvent;

/**
 * A projection that can be controled by the user using the keyboard.
 * 
 * @author Pedro Mariano
 */
public class EditableProjection
	extends AbstractProjection
{
	/**
	 * The minimum value of the distance between the center axis and the left, right, bottom, up and near planes.
	 */
	final float MIN;
	/**
	 * How much the projection planes change.
	 */
	final float DELTA;
	/**
	 * Construct an editable projection
	 * @param min The minimum value of the distance between the center axis and the left, right, bottom, up and near planes.
	 * @param delta 
	 */
	public EditableProjection (boolean perspectiveProjection, int horizontal, int vertical, int near, int far, float min, float delta)
	{
		super (perspectiveProjection, horizontal, vertical, near, far);
		this.MIN = Math.abs (min);
		this.DELTA = Math.abs (delta);
	}

	public EditableProjection (boolean perspectiveProjection, int horizontal, int vertical, int near, int far)
	{
		this (perspectiveProjection, horizontal, vertical, near, far, 1.0f, 0.1f);
	}
	/**
	 * 
	 * @param ke
	 * @return 
	 */
	@Override
	public boolean keyTyped (KeyEvent ke)
	{
		switch (ke.getKeyChar ()) {
			case 'o':
				this.right += this.DELTA;
				this.left -= this.DELTA;
				return true;
			case 'i':
				if (this.right > this.MIN) {
					this.right -= this.DELTA;
					this.left += this.DELTA;
					return true;
				}
				return false;
			case 'u':
				this.top += this.DELTA;
				this.bottom -= this.DELTA;
				return true;
			case 'j':
				if (this.top > this.MIN) {
					this.top -= this.DELTA;
					this.bottom += this.DELTA;
					return true;
				}
				return false;
			case 'p':
				this.far += this.DELTA;
				return true;
			case 'l':
				if (this.far > this.near + this.DELTA) {
					this.far -= this.DELTA;
					return true;
				}
				return false;
			case 'k':
				if (this.near < this.far + this.DELTA) {
					this.near += this.DELTA;
					return true;
				}
				return false;
			case 'm':
				if (this.near > this.MIN) {
					this.near -= this.DELTA;
					return true;
				}
				return false;
			case ' ':
				this.perspectiveProjection = !this.perspectiveProjection;
				return true;
		}
		return false;
	}

	@Override
	public boolean keyPressed (KeyEvent ke)
	{
		return false;
	}
}
