package example2;

import camera.AbstractCamera;
import camera.FixedCamera;
import camera.PlaneCamera;
import camera.SpaceCamera;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import projection.AbstractProjection;
import projection.EditableProjection;

/**
 * An OpenGL and key listener.
 * 
 * @author Pedro Mariano
 */
public class Listener
	implements
		GLEventListener,
		KeyListener
{
	/**
	 * 
	 */
	protected AbstractCamera camera;
	/**
	 *
	 */
	protected AbstractProjection projection;
	/**
	 * The OpenGL AWT component that this listener is attached to.
	 */
	protected final GLCanvas canvas;
	
	Palm grass = new Palm ();
	
	Listener (GLCanvas canvas)
	{
		this.canvas = canvas;
		//this.camera = new PlaneCamera ();
		//this.camera = new FixedCamera (new double[] {3, 0, 0}, new double[] {0, 0, 0}, new double[] {0, 1, 0});
		this.camera = new SpaceCamera (
			new double[] {0, 0, 3},
			new float[] {0, 0, -1},
			new float[] {0, 1, 0});
		this.projection = new EditableProjection (true, 100, 100, 1, 10);
		this.status ();
	}
	public void init (GLAutoDrawable glad)
	{
		System.out.println ("GLEventListener.init(GLAutoDrawable)");
	}

	public void dispose (GLAutoDrawable glad)
	{
		System.out.println ("GLEventListener.dispose(GLAutoDrawable)");
	}

	public void display (GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL ().getGL2 ();
		gl.glMatrixMode (GL2.GL_MODELVIEW);
		gl.glClear (GL.GL_COLOR_BUFFER_BIT);
		gl.glLoadIdentity ();
		
		GLU glu = GLU.createGLU (gl);
		this.camera.placeCamera (glu);
		gl.glTranslatef (0, -100, 0);
		this.grass.paint (gl);
	}

	@Override
	public void reshape (GLAutoDrawable drawable, int x, int y, int width, int height)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glViewport (0, 0, width, height);
		this.projection.setupProjection (gl);
		gl.glMatrixMode (GL2.GL_MODELVIEW);
	}

	@Override
	public void keyTyped (KeyEvent ke)
	{
		if (!this.camera.keyTyped (ke)) {
			if (!this.projection.keyTyped (ke)) {
				switch (ke.getKeyChar ()) {
				case 'g':
					this.grass.grow ();
					break;
				default:
					return;
				}
			}
		}
//		this.canvas.setBounds (10, 10, 300, 300);
		this.canvas.display ();
		this.status ();
	}

	@Override
	public void keyPressed (KeyEvent ke)
	{
		if (this.camera.keyPressed (ke)) {
	//		this.canvas.setBounds (10, 10, 300, 300);
			this.canvas.display ();
			this.status ();
		}
	}

	@Override
	public void keyReleased (KeyEvent ke)
	{
	}
	/**
	 * Print the properties of the projection parameters and of the camera.
	 */
	protected void status ()
	{
		System.out.println ("\n\n");
		this.projection.status ();
		this.camera.status ();
	}
	
}
