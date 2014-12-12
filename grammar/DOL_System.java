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
	 * The seed of this DOL-system.
	 */
	final protected Word<S> seed;
	/**
	 * Production rules that are applied to the word to derive a new one.
	 */
	final private Productions<S> rules;
	/**
	 * Current word of this system.
	 */
	protected Word<S> word;
	/**
	 * How many derivations have been applied to the seed of this DOL-system.
	 */
	protected int numberDerivations;
	/**
	 * How many deriviations should be applied to obtain a certain structure.
	 */
	final private int targetDerivations;
	/**
	 * 
	 */
	final private Turtle turtle;
	/**
	 * 
	 * @param seed
	 * @param rules 
	 * @param targetDerivations 
	 */
	protected DOL_System (Word<S> seed, Productions<S> rules, int targetDerivations)
	{
		this.seed = seed;
		this.rules = rules;
		this.word = (Word<S>) seed.clone ();
		this.targetDerivations = targetDerivations;
		this.numberDerivations = 0;
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
	/**
	 * 
	 * @return 
	 */
	final public String getWordAsString ()
	{
		return this.word.toString ();
	}
	final public int getNumberDerivations ()
	{
		return this.numberDerivations;
	}
	/**
	 * 
	 */
	final public void derive ()
	{
		Algorithm.apply (word, this.rules);
		this.numberDerivations++;
	}
	final public void deriveToTarget ()
	{
		this.word = this.seed.clone ();
		this.numberDerivations = 0;
		while (this.numberDerivations < this.targetDerivations) {
			this.derive ();
		}
	}
}
