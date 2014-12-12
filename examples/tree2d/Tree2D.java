/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.tree2d;

import grammar.symbol.SquareBracket;
import grammar.Alphabet;
import grammar.DOL_System;
import grammar.Productions;
import grammar.Symbol;
import grammar.Word;
import grammar.symbol.Forward;
import grammar.symbol.Move;
import grammar.symbol.Rotate;
import grammar.symbol.Stem;

/**
 *
 * @author pedro
 */
public class Tree2D
	extends DOL_System
{
	/**
	 * 
	 * @param delta
	 * @param angle
	 * @return 
	 */
	static private Alphabet createAlphabet (int delta, float angle)
	{
		Forward forward = new Forward (delta, 1f, 0f, 0f);
		Rotate plus = Rotate.Plus (angle);
		Rotate minus = Rotate.Minus (angle);
		return new Alphabet (
			forward,
			plus,
			minus,
			SquareBracket.LEFT,
			SquareBracket.RIGHT
		);
	}
	static private Alphabet createAlphabetWithSteam (int delta, float angle)
	{
		return createAlphabet (delta, angle).add (Stem.X);
	}
	/**
	 * Generate a tree by calculating <i>n=5</i> derivations.
	 */
	static public Tree2D createTree1 ()
	{
		int delta = 5;
		float angle = 25.7f;
		Alphabet alphabet = createAlphabet (delta, angle);
		Word seed = new Word<> (alphabet.get ('F'));
		Productions rules = new Productions ();
		rules.put ('F', "F[+F]F[-F]F", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * Generate a tree by calculating <i>n=5</i> derivations.
	 */
	static public Tree2D createTree2 ()
	{
		int delta = 5;
		int angle = 20;
		Alphabet alphabet = createAlphabet (delta, angle);
		Word seed = new Word<> (alphabet.get ('F'));
		Productions rules = new Productions ();
		rules.put ('F', "F[+F]F[-F][F]", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * Generate a tree by calculating <i>n=4</i> derivations.
	 */
	static public Tree2D createTree3 ()
	{
		int delta = 5;
		float angle = 22.5f;
		Alphabet alphabet = createAlphabet (delta, angle);
		Word seed = new Word<> (alphabet.get ('F'));
		Productions rules = new Productions ();
		rules.put ('F', "FF-[-F+F+F]+[+F-F-F]", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * Generate a tree by calculating <i>n=7</i> derivations.
	 */
	static public Tree2D createTree4 ()
	{
		int delta = 5;
		float angle = 20;
		Alphabet alphabet = createAlphabetWithSteam (delta, angle);
		Word seed = new Word<> (alphabet.get ('X'));
		Productions rules = new Productions ();
		rules.put ('X', "F[+X]F[-X]+X", alphabet);
		rules.put ('F', "FF", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * Generate a tree by calculating <i>n=7</i> derivations.
	 */
	static public Tree2D createTree5 ()
	{
		int delta = 5;
		float angle = 25.7f;
		Alphabet alphabet = createAlphabetWithSteam (delta, angle);
		Word seed = new Word<> (alphabet.get ('X'));
		Productions rules = new Productions ();
		rules.put ('X', "F[+X][-X]FX", alphabet);
		rules.put ('F', "FF", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * Generate a tree by calculating <i>n=5</i> derivations.
	 */
	static public Tree2D createTree6 ()
	{
		int delta = 5;
		float angle = 22.5f;
		Alphabet alphabet = createAlphabetWithSteam (delta, angle);
		Word seed = new Word<> (alphabet.get ('X'));
		Productions rules = new Productions ();
		rules.put ('X', "F-[[X]+X]+F[+FX]-X", alphabet);
		rules.put ('F', "FF", alphabet);
		return new Tree2D (seed, rules);
	}
	/**
	 * 
	 * @param seed
	 * @param rules 
	 */
	private Tree2D (Word seed, Productions rules)
	{
		super (seed, rules);
		rules.debug ();
		System.out.println ();
	}
}
