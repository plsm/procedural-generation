package examples.koch;

import grammar.DOL_System;
import grammar.Productions;
import grammar.Turtle;
import grammar.Word;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class Island
	extends DOL_System<Island.Symbol>
{
	/**
	 * 
	 */
	private static final Word<Island.Symbol> SEED;
	/**
	 * 
	 */
	private static final Productions<Island.Symbol> RULES;
	/**
	 * 
	 */
	static
	{
		SEED = new Word<> (new Island.Symbol[] {
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD
		});
		RULES = new Productions<> (Island.Symbol.FORWARD, new Island.Symbol[] {
			Island.Symbol.FORWARD,
			Island.Symbol.RIGHT,
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD,
			Island.Symbol.FORWARD,
			Island.Symbol.RIGHT,
			Island.Symbol.FORWARD,
			Island.Symbol.RIGHT,
			Island.Symbol.FORWARD,
			Island.Symbol.LEFT,
			Island.Symbol.FORWARD
		});
	}
	
	public Island ()
	{
		super (SEED, RULES);
	}

	public static enum Symbol
		implements grammar.Symbol
	{
		FORWARD ('F')
		{
			@Override
			public void paint (GL2 gl, Turtle turtle)
			{
				gl.glColor3f (0.25f, 1, 0.25f);
				gl.glBegin (GL.GL_LINE_STRIP);
				gl.glVertex3f (0, 0, 0);
				gl.glVertex3f (1, 0, 0);
				gl.glEnd ();
				gl.glTranslatef (1, 0, 0);
			}
		},
		/**
		 *
		 */
		LEFT ('+')
		{
			@Override
			public void paint (GL2 gl, Turtle turtle)
			{
				gl.glRotatef (90, 0, 0, 1);
			}
		},
		RIGHT ('+')
		{
			@Override
			public void paint (GL2 gl, Turtle turtle)
			{
				gl.glRotatef (-90, 0, 0, 1);
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
		public abstract void paint (GL2 gl, Turtle turtle);
	}
}
