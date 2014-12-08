/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.awt.event.KeyEvent;

/**
 * A camera that does not move.
 * @author pedro
 */
public class FixedCamera
	extends AbstractCamera
{
	public FixedCamera (double[] eye, double[] center, double[] up)
	{
		super (eye, center, up);
	}

	@Override
	public boolean keyPressed (KeyEvent ke)
	{
		return false;
	}

	@Override
	public boolean keyTyped (KeyEvent ke)
	{
		return false;
	}
	
}
