
public class LinearEquation 
{
	private double coEfficients[];
	
	public LinearEquation(int dimensionality)
	{
		coEfficients = new double[dimensionality+1];
		// Initializing coEfficients with 0
		for(int i = 0; i < coEfficients.length; i++)
		{
			coEfficients[i] = 0;
		}
	}
	
	public int dimensionality()
	{
		return (coEfficients.length - 1);		// Excluding w0
	}
	
	/**
	 * CoEfficients are arranged as w0, w1, w2. So if position value is 0. It returns w0.
	 */
	public double getCoEfficientAt(int position)
	{
		if(position < coEfficients.length && position >= 0)
		{
			return coEfficients[position];
		}
		System.out.println("Invalid position values");
		return 0;
	}
	
	/**
	 * CoEfficients are arranged as w0, w1, w2. So if position value is 0. It sets value at w0.
	 */
	public void setCoEfficientAt(int position, double value)
	{
		if(position >= coEfficients.length || position < 0)
		{
			System.out.println("Invalid position values");
			return;
		}
		coEfficients[position] = value;
	}
	
	/**
	 * @param xValues These values should be arranged like x1, x2, ... order
	 */
	public double valueOfEquation(double xValues[])
	{
		if (xValues.length != (coEfficients.length - 1))
		{
			System.out.println("xValues are not proper values for this equation");
			return 0;
		}
		
		double result = coEfficients[0];
		for(int i = 1; i < coEfficients.length; i++)
		{
			result += (coEfficients[i] * xValues[i-1]);
		}
		return result;
	}
}
