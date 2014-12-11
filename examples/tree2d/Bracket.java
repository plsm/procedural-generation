/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.tree2d;

import grammar.Symbol;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public enum Bracket
	implements Symbol
{
	LEFT ('[')
	{
		@Override
		public void paint (GL2 gl)
		{
			gl.glPushMatrix ();
		}
	},
	RIGHT (']')
	{
		@Override
		public void paint (GL2 gl)
		{
			gl.glPopMatrix ();
		}
	};
	
	final private char code;

	private Bracket (char code)
	{
		this.code = code;
	}
	@Override
	public String toString ()
	{
		return String.valueOf (this.code);
	}
}
