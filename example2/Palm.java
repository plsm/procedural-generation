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
		RULES = new Productions<Palm.Symbol> (Symbol.TRUNK_STEM, new Palm.Symbol[] {Symbol.NEW_TRUNK, Symbol.TRUNK_STEM});
		Palm.RULES.put (Symbol.NEW_TRUNK, new Palm.Symbol[] {
			Symbol.OLD_TRUNK,
			Symbol.LEFT_PARENTHIS,
			Symbol.LEAF_STEM,
			Symbol.RIGHT_PARENTHIS,
			Symbol.NEW_TRUNK
		});
		Palm.RULES.put (Symbol.LEAF_STEM, new Palm.Symbol[] {
			Symbol.LEAF,
			Symbol.LEAF_STEM
		});
		Palm.RULES.put (Symbol.LEAF, new Palm.Symbol[] {
			Symbol.LEAF,
			Symbol.LEAF
		});
	}
	final private Word<Palm.Symbol> word;
	Palm ()
	{
		this.word = new Word (Symbol.TRUNK_STEM);
	}
	
	void paint (GL2 gl)
	{
		this.word.paintDebug (gl);
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
		NEW_TRUNK ('T')
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
		OLD_TRUNK ('T')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glColor3f (0.5f, 0.1f, 0);
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
		TRUNK_STEM ('s')
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
		LEAF_STEM ('l')
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
		},
		LEFT_PARENTHIS ('[')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glPushMatrix ();
			}
		},
		RIGHT_PARENTHIS (']')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glPopMatrix ();
			}
		};
		
		final private char code;

		Symbol (char code)
		{
			this.code = code;
		}
		@Override
		public char getCode ()
		{
			return code;
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
