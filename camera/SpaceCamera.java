/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.awt.event.KeyEvent;
import com.jogamp.opengl.math.Matrix4;
import com.jogamp.opengl.math.VectorUtil;

/**
 * A camera that moves in 3D space.
 * @author pedro
 */
final public class SpaceCamera
	extends AbstractCamera	
{
	/**
	 * 
	 */
	private float[] frontVector;
	/**
	 * 
	 */
	private float[] upVector;
	/**
	 * 
	 */
	final private float ANGLE = (float) (Math.PI / 16);
	transient Matrix4 matrix;
	transient float[] swap;
	/**
	 * Construct a default space camera.
	 */
	public SpaceCamera ()
	{
		this.frontVector = new float[] {1, 0, 0, 1};
		this.upVector = new float[] {0, 1, 0, 1};
		this.matrix = new Matrix4 ();
		this.swap = new float[4];
	}
	public SpaceCamera (double[] eye, double[] center, double[] up)
	{
		super (eye, center, up);
		this.frontVector = new float[] {1, 0, 0, 1};
		this.upVector = new float[] {(float) up [0], (float) up [1], (float) up [2], 1};
		this.matrix = new Matrix4 ();
		this.swap = new float[4];
	}
	public SpaceCamera (double[] eye, float[] frontVector, float[] upVector)
	{
		this.eye = new double[] {eye [0], eye [1], eye[2]};
		this.frontVector = new float[] {frontVector [0], frontVector [1], frontVector [2], 1};
		this.upVector = new float[] {upVector [0], upVector [1], upVector [2], 1};
		this.matrix = new Matrix4 ();
		this.swap = new float[4];
		this.updateCenterUp ();
	}
	private void rotate (float[] axis, float angle)
	{
		this.matrix.loadIdentity ();
		// calculate rotation matrix
		/*
		float beta = (float) Math.atan2 (axis [2], axis [0]);
		float gama = (float) Math.atan2 (axis [1], Math.sqrt (axis [0] * axis [0] + axis [2] * axis [2]));
		this.matrix.rotate (-beta, 0, 1, 0);
		this.matrix.rotate (gama, 0, 0, 1);
		this.matrix.rotate (angle, 1, 0, 0);
		this.matrix.rotate (-gama, 0, 0, 1);
		this.matrix.rotate (beta, 0, 1, 0);
		*/
		this.matrix.rotate (angle, axis [0], axis [1], axis [2]);
		float[] s;
		// update frontVector and upVector
		this.matrix.multVec (this.frontVector, this.swap);
		s = this.swap;
		this.swap = this.frontVector;
		this.frontVector = s;
		this.matrix.multVec (this.upVector, this.swap);
		s = this.swap;
		this.swap = this.upVector;
		this.upVector = s;
		// update center and up
		this.updateCenterUp ();
	}
	private void updateCenterUp ()
	{
		for (int i = 0; i < 3; i++) {
			this.center [i] = this.eye [i] + this.frontVector [i];
			this.up [i] = this.upVector [i];
		}
	}
	@Override
	public boolean keyPressed (KeyEvent ke)
	{
		return false;
	}

	@Override
	public boolean keyTyped (KeyEvent ke)
	{
		char code = ke.getKeyChar ();
		switch (code) {
			case 'a':
				rotate (this.upVector, this.ANGLE);
				return true;
			case 'd':
				rotate (this.upVector, -this.ANGLE);
				return true;
			case 'w':
				VectorUtil.crossVec3 (this.swap, this.frontVector, this.upVector);
				rotate (this.swap, this.ANGLE);
				return true;
			case 's':
				VectorUtil.crossVec3 (this.swap, this.frontVector, this.upVector);
				this.rotate (this.swap, -this.ANGLE);
				return true;
			case 'q':
				rotate (this.frontVector, -this.ANGLE);
				return true;
			case 'e':
				rotate (this.frontVector, this.ANGLE);
				return true;
			case 'z':
				for (int i = 0; i < 3; i++) {
					this.eye [i] -= this.frontVector [i];
				}
				this.updateCenterUp ();
				return true;
			case 'x':
				for (int i = 0; i < 3; i++) {
					this.eye [i] += this.frontVector [i];
				}
				this.updateCenterUp ();
				return true;
		}
		return false;
	}
	@Override
	public void status ()
	{
		super.status ();
		System.out.format ("Front vector:  ( %5.1f , %5.1f , %5.1f )\n", this.frontVector [0], this.frontVector [1], this.frontVector [2]);
		System.out.format ("   Up vector:  ( %5.1f , %5.1f , %5.1f )\n", this.upVector [0], this.upVector [1], this.upVector [2]);
	}
}
