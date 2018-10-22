import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSV_Reader 
{
	private final List<TrainingExample> trainingExamples;
	private int dimensionality = 0;
	
	public CSV_Reader(String fileLocation)
	{
		BufferedReader reader = null;
		String splitBy = ",";
		trainingExamples = new ArrayList<TrainingExample>();
		
		try
		{
			reader = new BufferedReader(new FileReader(fileLocation));
			String line = "";
            while ((line = reader.readLine()) != null)
            {
                // use comma as separator
                String[] example = line.split(splitBy);
                if(dimensionality == 0)		// For initializing only once
                {
                    dimensionality = example.length - 1;
                }
                
                double xValues[] = new double[dimensionality];
                for(int i = 0; i < dimensionality; i++)
                {
                	xValues[i] = Double.parseDouble(example[i]);
                }
                double targetFunctionValue = Double.parseDouble(example[example.length - 1]);
                TrainingExample trainingExample = new TrainingExample(xValues, targetFunctionValue);
                trainingExamples.add(trainingExample);
            }
		}
		catch(Exception e)
		{
			dimensionality = 0;
			e.printStackTrace();
		}
	}
	
	public int dimensionalityOfData()
	{
		return dimensionality;
	}
	
	public TrainingExample[] getTrainingExamples()
	{
		TrainingExample result[] = new TrainingExample[trainingExamples.size()];
		result = trainingExamples.toArray(result);
		return result;
	}
}
