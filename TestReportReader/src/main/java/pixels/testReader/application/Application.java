package pixels.testReader.application;

import pixels.testReader.reader.testResultReader;
import pixels.testReader.reader.testResultReaderException;
import pixels.testReader.reader.testResultReaderImpl;

public class Application {

	public static void main(String[] args) throws testResultReaderException {

		String testpath = "abc";
		testResultReader testReader = new testResultReaderImpl(); 
		testReader.readTestresults(testpath);
		

	}

}
