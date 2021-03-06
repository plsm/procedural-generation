/*
 * To change this template, choose Tools | Templates
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
import grammar.symbol.Forward;
import grammar.symbol.Move;
import grammar.symbol.Rotate;
import grammar.symbol.SquareBracket;
import grammar.symbol.Width;
import javax.media.opengl.GL2;

/**
 *
 * @author pedro
 */
public class FlowerPlant
	extends DOL_System
{
	private static final Alphabet ALPHABET;
	private static final Productions RULES;
	private static final int TARGET_DERIVATIONS = 7;
	static
	{
		ALPHABET = FlowerPlant.createAlphabet ();
		RULES = FlowerPlant.createProductions ();
		RULES.debug ();
		System.out.println ();
	}
	private static Alphabet createAlphabet ()
	{
		int delta = 5;
		float angle = 18f;
		return new Alphabet (
			new Forward (delta, 1f, 0f, 0f),
			new Move (delta),
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
			Symbol.PLANT,
			Symbol.INTERNODE,
			Symbol.FLOWER,
			Symbol.LEAF,
			Symbol.SEG,
			Symbol.PEDICEL,
			Symbol.WEDGE,
			Colour.NEXT,
			Width.DECREMENT
		);
	}
	private static Productions createProductions ()
	{
		Alphabet alphabet = createAlphabet ();
		Productions rules = new Productions ();
		rules.put ('p', "i+[p+o]--//[--l]i[++l]-[po]++po", alphabet);
		rules.put ('i', "Fs[//&&l][//^^l]Fs", alphabet);
		rules.put ('s', "sFs", alphabet);
		rules.put ('l', "['{+f-ff-+|+f-ff-f}]", alphabet);
		rules.put ('o', "[&&&e'{+f-ff-+|+f-ff-f}]", alphabet);
		rules.put ('e', "FF", alphabet);
		rules.put ('w', "['^F][{&&&&-f+f|-f+f}]", alphabet);
		return rules;
	}
	public FlowerPlant ()
	{
		super (new Word (FlowerPlant.ALPHABET.get ('p')), FlowerPlant.RULES, FlowerPlant.TARGET_DERIVATIONS);
	}
	enum Symbol
		implements grammar.Symbol
	{
		PLANT     ('p'),
		INTERNODE ('i'),
		FLOWER    ('o'),
		LEAF      ('l'),
		SEG       ('s'),
		WEDGE     ('w'),
		PEDICEL   ('e');
		
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
