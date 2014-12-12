package grammar;

/**
 *
 * @author pedro
 */
public class Turtle
{
	public boolean specifyingPolygonBoundary;
	public float lineWidth;
	public final float lineDelta;
	Turtle ()
	{
		this.specifyingPolygonBoundary = false;
		this.lineWidth = 1f;
		this.lineDelta = 1f;
	}
	
	void reset ()
	{
		this.specifyingPolygonBoundary = false;
	}
}
