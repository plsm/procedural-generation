/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import grammar.Algorithm;
import grammar.Productions;
import grammar.Word;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class Palm
{
	private static final Productions<Palm.Symbol> RULES;
	
	static
	{
		RULES = new Productions<Palm.Symbol> (Symbol.STEM, new Palm.Symbol[] {Symbol.TRUNK, Symbol.STEM});
		Palm.RULES.put (Symbol.TRUNK, new Palm.Symbol[] {
			Symbol.TRUNK,
			Symbol.TRUNK,
			Symbol.LEAF});
	}
	final private Word<Palm.Symbol> word;
	Palm ()
	{
		this.word = new Word (Symbol.STEM);
	}
	
	void paint (GL2 gl)
	{
		this.word.paint (gl);
	}
	
	void grow ()
	{
		if (word.length () < 1000) {
			Algorithm.apply (word, Palm.RULES);
		}
	}
	
	private static enum Symbol 
		implements grammar.Symbol
	{
		TRUNK ('T')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glColor3f (0.75f, 0, 0);
				gl.glBegin (GL2.GL_QUAD_STRIP);
				gl.glVertex3f (0, 0, 0);
				gl.glVertex3f (0, 1, 0);
				gl.glVertex3f (0, 0, 1);
				gl.glVertex3f (0, 1, 1);
				gl.glVertex3f (1, 0, 1);
				gl.glVertex3f (1, 1, 1);
				gl.glVertex3f (1, 0, 0);
				gl.glVertex3f (1, 1, 0);
				gl.glEnd ();
				gl.glTranslatef (0, 1, 0);
				gl.glRotatef (2, 0, 1, 0);
			}
		},
		STEM ('s')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glColor3f (0.25f, 1, 0.25f);
				gl.glBegin (GL.GL_LINE_STRIP);
				gl.glVertex3f (0, 0, 0);
				gl.glVertex3f (1, 0, 0);
				gl.glVertex3f (0.5f, 1, 0);
				gl.glEnd ();
			}
		},
		LEAF ('L')
{
			@Override
			public void paint (GL2 gl)
			{
				gl.glColor3f (0, 1, 0);
				gl.glBegin (GL.GL_LINE_STRIP);
				gl.glVertex3f (0, 0, 0);
				gl.glVertex3f (1, 0, 0);
				gl.glEnd ();
				gl.glTranslatef (1, 0, 0);
			}
		};
		
		final private char code;

		Symbol (char code)
		{
			this.code = code;
		}
		@Override
		public String toString ()
		{
			return String.valueOf (this.code);
		}
		@Override
		public abstract void paint (GL2 gl);

	}
}
