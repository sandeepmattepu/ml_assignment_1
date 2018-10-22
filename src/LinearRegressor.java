
public class LinearRegressor 
{
	public static void startLearning(LinearEquation linearEquation, TrainingExample trainingExamples[],
			double learningRate, double threshold)
	{
		double meanSquareError = threshold + 1000;
		int iterationNumber = 1;
		
		double tempCoEfficients[] = new double[linearEquation.dimensionality() + 1];
		while(meanSquareError > threshold)
		{
			// Calculation coefficients values
			for(int currentDimension = 0; currentDimension <= linearEquation.dimensionality(); currentDimension++)
			{
				// Calculation for w0
				double gradientValue = gradientValue(linearEquation, trainingExamples, currentDimension);
				double coEfficientValue = linearEquation.getCoEfficientAt(currentDimension);
				double newCoEfficient = coEfficientValue + (learningRate * gradientValue);
				tempCoEfficients[currentDimension] = newCoEfficient;
			}
			
			// Assign calculated coefficients to the linear equation
			for(int i = 0; i < tempCoEfficients.length; i++)
			{
				linearEquation.setCoEfficientAt(i, tempCoEfficients[i]);
			}
			
			meanSquareError = meanSquareError(linearEquation, trainingExamples);
			outputResult(linearEquation, iterationNumber, meanSquareError);
			iterationNumber++;
		}
	}
	
	/**
	 * 
	 * @param at If any negative or zero values are given then gradient calculation is done for w0.
	 * 			 If positive value is given then gradient is calculated for that x value
	 * 			 Eg:- If at value is 1 then gradient is calculated for w1 with x1 values of training data.
	 */
	private static double gradientValue(LinearEquation linearEquation, TrainingExample trainingExamples[], int at)
	{
		double result = 0;
		for(int i = 0; i < trainingExamples.length; i++)
		{
			double xValue = at > 0 ? trainingExamples[i].getxValues()[at - 1] : 1;
			result += xValue * (trainingExamples[i].getTargetFunctionValue() - 
					linearEquation.valueOfEquation(trainingExamples[i].getxValues()));
		}
		return result;
	}
	
	private static double meanSquareError(LinearEquation linearEquation, TrainingExample trainingExamples[])
	{
		double result = 0;
		for(int i = 0; i < trainingExamples.length; i++)
		{
			result += (trainingExamples[i].getTargetFunctionValue() - linearEquation.valueOfEquation(trainingExamples[i].getxValues()))
					* (trainingExamples[i].getTargetFunctionValue() - linearEquation.valueOfEquation(trainingExamples[i].getxValues()));
		}
		return result;
	}
	
	private static void outputResult(LinearEquation linearEquation, int iterationNumber, double meanSquareError)
	{
		System.out.print(iterationNumber);
		System.out.print(", ");
		
		for(int i = 0; i < (linearEquation.dimensionality() + 1); i++)
		{
			System.out.print(linearEquation.getCoEfficientAt(i));
			System.out.print(", ");
		}
		System.out.println(meanSquareError);
	}
}
