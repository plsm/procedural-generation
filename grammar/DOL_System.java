/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grammar;

import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 * @param <S>
 */
public class DOL_System<S extends Symbol>
{
	/**
	 * 
	 */
	final protected Word<S> word;
	/**
	 * 
	 */
	final private Productions<S> rules;
	/**
	 * 
	 */
	protected int numberGrowths;
	/**
	 * 
	 */
	final private Turtle turtle;
	/**
	 * 
	 * @param word
	 * @param rules 
	 */
	protected DOL_System (Word<S> word, Productions<S> rules)
	{
		this.word = word;
		this.rules = rules;
		this.numberGrowths = 0;
		this.turtle = new Turtle ();
	}
	/**
	 * 
	 * @param gl 
	 */
	final public void paint (GL2 gl)
	{
		this.turtle.reset ();
		this.word.paint (gl, turtle);
	}
	
	final public void grow ()
	{
		Algorithm.apply (word, this.rules);
		this.numberGrowths++;
	}
}
