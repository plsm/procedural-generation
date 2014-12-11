/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import grammar.Productions;
import grammar.Word;
import grammar.Algorithm;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class Grass
{
	private static final Productions<Grass.Symbol> RULES;
	
	static
	{
		RULES = new Productions<Grass.Symbol> (Symbol.F, new Grass.Symbol[] {Symbol.F, Symbol.F});
		Grass.RULES.put (Symbol.X, new Grass.Symbol[] {
			Symbol.F,
			Symbol.MINUS,
			Symbol.LEFT_PARENTHIS,
			Symbol.LEFT_PARENTHIS,
			Symbol.X,
			Symbol.RIGHT_PARENTHIS,
			Symbol.PLUS,
			Symbol.X,
			Symbol.RIGHT_PARENTHIS,
			Symbol.PLUS,
			Symbol.F,
			Symbol.LEFT_PARENTHIS,
			Symbol.PLUS,
			Symbol.F,
			Symbol.X,
			Symbol.RIGHT_PARENTHIS,
			Symbol.MINUS,
			Symbol.X});
	}
	final private Word<Grass.Symbol> word;
	Grass ()
	{
		this.word = new Word<Symbol> (Symbol.X);
	}
	
	void paint (GL2 gl)
	{
		this.word.paint (gl);
	}
	
	void grow ()
	{
		if (word.length () < 10000) {
			Algorithm.apply (word, Grass.RULES);
		}
	}
	
	private static enum Symbol 
		implements grammar.Symbol
	{
		F ('F')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glColor3f (1, 0, 0);
				gl.glBegin (GL.GL_LINE_STRIP);
				gl.glVertex3d (0, 0, 0);
				gl.glVertex3d (0, 1, 0);
				gl.glEnd ();
				gl.glTranslated (0, 1, 0);
			}
		},
		PLUS ('+')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glRotated (ANGLE, 0, 0, 1);
			}
		},
		MINUS ('-')
		{
			@Override
			public void paint (GL2 gl)
			{
				gl.glRotated (-ANGLE, 0, 0, 1);
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
		},
		X ('X')
		{
			@Override
			public void paint (GL2 gl)
			{
			}
		}
		;

		final static private double ANGLE = 25;

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
