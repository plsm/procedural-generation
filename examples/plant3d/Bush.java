/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examples.plant3d;

import grammar.Alphabet;
import grammar.DOL_System;
import grammar.Productions;
import grammar.Turtle;
import grammar.Word;
import grammar.symbol.Colour;
import grammar.symbol.CurlyBracket;
import grammar.symbol.Edge;
import grammar.symbol.Forward;
import grammar.symbol.Rotate;
import grammar.symbol.SquareBracket;
import grammar.symbol.Width;
import javax.media.opengl.GL2;

/**
 * Represents the DOL-System presented in figure 1.25 from <i>The Algorithmic Beauty of Plants</i>.
 *
 * @author Pedro Mariano
 */
public class Bush
	extends DOL_System
{
	private static final Alphabet ALPHABET;
	private static final Productions RULES;
	private static final int TARGET_DERIVATIONS = 7;
	static
	{
		ALPHABET = Bush.createAlphabet ();
		RULES = Bush.createProductions ();
		RULES.debug ();
		System.out.println ();
	}
	private static Alphabet createAlphabet ()
	{
		int delta = 5;
		float angle = 22.5f;
		return new Alphabet (
			new Forward (delta, 1f, 0f, 0f),
			new Edge (delta),
			Rotate.Plus (angle),
			Rotate.Minus (angle),
			Rotate.Ampersand (angle),
			Rotate.Circumflex (angle),
			Rotate.Slash (angle),
			Rotate.Backwards (),
			SquareBracket.LEFT,
			SquareBracket.RIGHT,
			CurlyBracket.LEFT,
			CurlyBracket.RIGHT,
			Colour.NEXT,
			Width.DECREMENT,
			Symbol.APEX,
			Symbol.LEAF,
			Symbol.STEM
		);
	}
	private static Productions createProductions ()
	{
		Alphabet alphabet = createAlphabet ();
		Productions rules = new Productions ();
		rules.put ('A', "[&FL!A]/////'[&FL!A]///////'[&FL!A]", alphabet);
		rules.put ('F', "S/////F", alphabet);
		rules.put ('S', "FL", alphabet);
		rules.put ('L', "['''^^^{-f+f+f-|-f+f+f}]", alphabet);
		return rules;
	}
	public Bush ()
	{
		super (new Word (Bush.ALPHABET.get ('A')), Bush.RULES, Bush.TARGET_DERIVATIONS);
	}
	enum Symbol
		implements grammar.Symbol
	{
		APEX ('A'),
		LEAF ('L'),
		STEM ('S');
		
		final private char code;

		private Symbol (char code)
		{
			this.code = code;
		}
		@Override
		public char getCode ()
		{
			return this.code;
		}
		@Override
		public void paint (GL2 gl, Turtle turtle)
		{
		}
		@Override
		public String toString ()
		{
			return String.valueOf (this.code);
		}
	}
}
