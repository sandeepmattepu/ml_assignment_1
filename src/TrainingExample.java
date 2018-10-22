
public class TrainingExample 
{
	private final double xValues[];
	private final double targetFunctionValue;

	public TrainingExample(double X_Values[], double TargetConceptValue)
	{
		xValues = new double[X_Values.length];
		
		// copying values
		for(int i = 0; i < xValues.length; i++)
		{
			xValues[i] = X_Values[i];
		}
		
		targetFunctionValue = TargetConceptValue;
	}
	
	/**
	 * They are in order of x1, x2, ....
	 */
	public double[] getxValues() 
	{
		return xValues;
	}
	
	public double getTargetFunctionValue() 
	{
		return targetFunctionValue;
	}
}
