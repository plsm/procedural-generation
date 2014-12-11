/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar.symbol;

import grammar.AbstractSymbol;

/**
 *
 * @author pedro
 */
public abstract class ColouredSymbol
	extends AbstractSymbol
{
	protected final float red;
	protected final float green;
	protected final float blue;
	protected ColouredSymbol (char code, float red, float green, float blue)
	{
		super (code);
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
}
