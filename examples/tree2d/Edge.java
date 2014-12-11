/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.tree2d;

import grammar.AbstractSymbol;
import grammar.Symbol;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
abstract public class Edge
	extends AbstractSymbol
{
	/**
	 * How much does the turtle moves in the x axis.
	 */
	static public int delta;
	/**
	 * How much does the turtle rotates along the z axis.
	 */
	static public int angle;
	/**
	 * 
	 * @param code 
	 */
	protected Edge (char code)
	{
		super (code);
	}
	/**
	 * 
	 */
	final static public class FORWARD
		extends Edge
	{
		/**
		 * 
		 */
		public FORWARD ()
		{
			super ('F');
		}
		/**
		 * 
		 * @param gl 
		 */
		@Override
		public void paint (GL2 gl)
		{
			gl.glColor3f (1, 0, 0);
			gl.glBegin (GL.GL_LINE_STRIP);
			gl.glVertex3d (0, 0, 0);
			gl.glVertex3d (Edge.delta, 0, 0);
			gl.glEnd ();
			gl.glTranslated (Edge.delta, 0, 0);
		}
	}
	/**
	 * 
	 */
	final static public class PLUS
		extends Edge
	{
		/**
		 * 
		 */
		public PLUS ()
		{
			super ('+');
		}
		/**
		 * 
		 * @param gl 
		 */
		@Override
		public void paint (GL2 gl)
		{
			gl.glRotated (Edge.angle, 0, 0, 1);
		}
	}
	/**
	 * 
	 */
	final static public class MINUS
		extends Edge
	{
		/**
		 * 
		 */
		public MINUS ()
		{
			super ('-');
		}
		/**
		 * 
		 * @param gl 
		 */
		@Override
		public void paint (GL2 gl)
		{
			gl.glRotated (-Edge.angle, 0, 0, 1);
		}
	}
	
}
