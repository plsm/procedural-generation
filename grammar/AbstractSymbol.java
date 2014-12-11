/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grammar;

/**
 *
 * @author pedro
 */
public abstract class AbstractSymbol
	implements Symbol
{
	/**
	 * The character code associated with this symbol.
	 */
	final private char code;
	/**
	 * Construct a symbol.
	 * @param code The character code associated with this symbol.
	 */
	protected AbstractSymbol (char code)
	{
		this.code = code;
	}
	@Override
	final public char getCode ()
	{
		return this.code;
	}
	@Override
	final public String toString ()
	{
		return String.valueOf (this.code);
	}
}
