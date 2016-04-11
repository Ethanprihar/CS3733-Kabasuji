package kabasuji.model;

public class ReleaseTile extends PlayableTile
{
	int number;
	int color;
	
	public ReleaseTile()
	{
		super();
		color = 0;
		number = 0;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setColor(int c)
	{
		color = c;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int n)
	{
		number = n;
	}
}
