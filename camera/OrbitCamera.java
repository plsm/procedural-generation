/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package camera;

import com.jogamp.opengl.math.VectorUtil;
import java.awt.event.KeyEvent;

/**
 *
 * @author pedro
 */
final public class OrbitCamera
	extends AbstractCamera
{
	static private final double ANGLE = Math.PI / 4;
	
	private double angleZX;
	
	private double angleZY;
	
	private float distance;
	
	public OrbitCamera (double[] center, float distance)
	{
		super (
			new double[] {center [0] + distance, center [1], center [2]},
			center,
			new double[] {0, 1, 0});
		this.angleZX = 0;
		this.angleZY = 0;
		this.distance = distance;
		this.computeEye ();
	}
	private void computeEye ()
	{
		eye [0] = this.center [0] + this.distance * Math.cos (this.angleZX) * Math.cos (this.angleZY);
		eye [1] = this.center [1] + this.distance * Math.sin (this.angleZY);
		eye [2] = this.center [2] + this.distance * Math.sin (this.angleZX) * Math.cos (this.angleZY);
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
				this.angleZX -= OrbitCamera.ANGLE;
				break;
			case 'd':
				this.angleZX += OrbitCamera.ANGLE;
				break;
			case 'w':
				this.angleZY += OrbitCamera.ANGLE;
				break;
			case 's':
				this.angleZY -= OrbitCamera.ANGLE;
				break;
			case 'x':
				this.distance += 10;
				break;
			case 'z':
				if (this.distance <= 10) {
					return false;
				}
				distance -= 10;
				break;
			default:
				return false;
		}
		this.computeEye ();
		return true;
	}
	@Override
	public void status ()
	{
		super.status ();
		System.out.format ("Angle ZX:  %5.1fº\n", 180 * this.angleZX / Math.PI);
		System.out.format ("Angle ZY:  %5.1fº\n", 180 * this.angleZY / Math.PI);
	}
	
}
