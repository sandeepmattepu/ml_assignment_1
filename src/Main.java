
public class Main 
{

	public static void main(String[] args) 
	{
		String csvFileLocation;
		double threshold;
		double learningRate;
		
		if(args.length < 3)
		{
			System.out.println("Invalid arguments");
			return;
		}
		else
		{
			threshold = Double.parseDouble(args[0]);
			csvFileLocation = args[1];
			learningRate = Double.parseDouble(args[2]);
			
			CSV_Reader csvReader = new CSV_Reader(csvFileLocation);
			TrainingExample trainingExamples[] = csvReader.getTrainingExamples();
			LinearEquation linearEquation = new LinearEquation(csvReader.dimensionalityOfData());
			
			LinearRegressor.startLearning(linearEquation, trainingExamples, learningRate, threshold);
		}
	}

}
