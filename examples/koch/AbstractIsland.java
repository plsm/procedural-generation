package examples.koch;

import grammar.DOL_System;
import grammar.Productions;
import grammar.Word;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class AbstractIsland
	extends DOL_System<AbstractIsland.Symbol>
{
	/**
	 * 
	 */
	private static final Word<AbstractIsland.Symbol> SEED;
	/**
	 * 
	 */
	private static final Productions<AbstractIsland.Symbol> RULES;
	/**
	 * 
	 */
	static
	{
		SEED = new Word<> (new AbstractIsland.Symbol[] {
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD
		});
		RULES = new Productions<> (AbstractIsland.Symbol.FORWARD, new AbstractIsland.Symbol[] {
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.RIGHT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.RIGHT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.RIGHT,
			AbstractIsland.Symbol.FORWARD,
			AbstractIsland.Symbol.LEFT,
			AbstractIsland.Symbol.FORWARD
		});
	}
	
	public AbstractIsland ()
	{
		super (SEED, RULES);
	}

	public static enum Symbol
		implements grammar.Symbol
	{
		FORWARD ('F')
		{
			@Override
			public void paint (GL2 gl)
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
			public void paint (GL2 gl)
			{
				gl.glRotatef (90, 0, 0, 1);
			}
		},
		RIGHT ('+')
		{
			@Override
			public void paint (GL2 gl)
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
		public abstract void paint (GL2 gl);
	}
}
