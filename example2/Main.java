/*
 * Main.java
 *
 * Created on 5 de Dezembro de 2014, 18:12
 *
 */

package example2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

/**
 *
 * @author <a href="mailto:mariano.pedro@gmail.com">Pedro Mariano</a>
 *
 * @version 1.0 5 de Dezembro de 2014
 */
public class Main
{
	
	/**
	 * Creates a new instance of Main
	 */
	static public void main (String[] args)
	{
		GLProfile glp = GLProfile.getDefault ();
		GLCapabilities caps = new GLCapabilities (glp);
		GLCanvas canvas = new GLCanvas (caps);

		Frame frame = new Frame ("Planta");
		frame.setSize (300, 300);
		frame.add (canvas);
		frame.setVisible (true);

		frame.addWindowListener (new WindowAdapter () {
			@Override
			public void windowClosing (WindowEvent e) {
				System.exit (0);
			}
		});

		Listener listener;
		listener = new Listener (canvas);
		canvas.addGLEventListener (listener);
		canvas.addKeyListener (listener);
	}
	
}

// Local Variables:
// mode: java
// mode: flyspell-prog
// ispell-local-dictionary: "british"
// End:
