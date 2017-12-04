package pixels.testReader.reader;

import java.util.List;

import pixels.testReader.TestResultSet;

public interface testResultReader {
	
	public List<TestResultSet> readTestresults(String path) throws testResultReaderException;

}
