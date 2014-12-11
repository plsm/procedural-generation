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
	final private char code;

	protected AbstractSymbol (char code)
	{
		this.code = code;
	}

	@Override
	public String toString ()
	{
		return String.valueOf (this.code);
	}
}
