/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.tree2d;

import grammar.AbstractSymbol;
import grammar.DOL_System;
import grammar.Symbol;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class Tree2D
	extends DOL_System
{
	/**
	 * 
	 */
	private final int delta;
	/**
	 * 
	 */
	private final int angle;
	/**
	 * 
	 */
	private final Word<Symbol> SEED;
	/**
	 * 
	 */
	private final Productions<Symbol> RULES;
	/**
	 * 
	 */
	static public Tree2D createTree1 ()
	{
		SEED = new Word<> (new Tree2D.FORWARD ());
		RULES = new Productions<> (Tree2D.FORWARD, new Island.Symbol[] {
			Tree2D.FORWARD,
			Bracket.RIGHT,
			Tree2D.PLUS,
			Tree2D.FORWARD,
			Bracket.LEFT,
			Tree2D.FORWARD,
			Bracket.RIGHT,
			Tree2D.MINUS,
			Bracket.FORWARD
		});
	}
	
	/**
	 * 
	 */
	final public class FORWARD
		extends AbstractSymbol
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
			gl.glVertex3d (delta, 0, 0);
			gl.glEnd ();
			gl.glTranslated (delta, 0, 0);
		}
	}
	/**
	 * 
	 */
	final public class PLUS
		extends AbstractSymbol
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
			gl.glRotated (angle, 0, 0, 1);
		}
	}
	/**
	 * 
	 */
	final static public class MINUS
		extends AbstractSymbol
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
