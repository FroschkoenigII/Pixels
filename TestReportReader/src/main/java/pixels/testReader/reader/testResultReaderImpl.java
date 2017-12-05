package pixels.testReader.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pixels.testReader.reader.testResultReader;
import pixels.testReader.TestResultSet;

public class testResultReaderImpl implements testResultReader {

	public List<TestResultSet> readTestresults(String path) throws testResultReaderException {

		List<File> testfiles = new ArrayList<File>();
		List<TestResultSet> testSets = new ArrayList<TestResultSet>();
		testfiles.addAll(collectFilesFromPath("C:\\Users\\langenf\\Desktop\\TestFolder"));

		for (File f : testfiles) {
			if (f.getName().endsWith(".txt")) {
				System.out.println(f.getName());
				TestResultSet trs = new TestResultSet();
				try {
					trs.setTestclassPath(f.getName());
					trs.getMessageLines().addAll(Files.readAllLines(f.toPath()));
					testSets.add(trs);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		for (TestResultSet ts : testSets) {
			try {
				parseToObject(ts);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error while parsing " + ts.getTestclassPath() + e.getMessage());
			}
		}

		return null;
	}

	private void parseToObject(TestResultSet ts) {

		String testNameLine = ts.getMessageLines().get(1);
		ts.setTestclassName(testNameLine.substring(9));
		String testErrorLine = ts.getMessageLines().get(3);

		String testErrors = testErrorLine.substring(testErrorLine.indexOf("Failures: ") + 10,
				testErrorLine.indexOf(", Errors"));
		int errorCount = Integer.valueOf(testErrors);

		System.out.println(ts.getTestclassName() + " has " + errorCount + " errors!");

		if (errorCount != 0) {

			int currentLine = 4;
			for (int i = 0; i < errorCount; i++) {
				String errormessage = "";
				while (currentLine + 1 < ts.getMessageLines().size()
						&& !ts.getMessageLines().get(currentLine).equals("")) {
					errormessage = errormessage.concat(ts.getMessageLines().get(currentLine));
					errormessage = errormessage.concat("\n");
					currentLine++;
				}
				currentLine++;
				ts.getErrormessage().add(errormessage);
				//System.out.println("Errolar msg "+i +": " + errormessage);
				
				/*
				 *
{
    "fields": {
       "project":
       { 
          "id": "10701"
       },
       "summary": "TestIssue.",
       "description": "TestIssue",
       "issuetype": {
          "id": "10601"
       },
       "components": [
       	{
       	"id": "10934"
        }
       ]
   }
}
				 * 
				 * 
				 * 
				 * 
				 */
			}
		}

	}

	private List<File> collectFilesFromPath(String path) throws testResultReaderException {
		List<File> testfiles = new ArrayList<File>();
		try (Stream<Path> paths = Files.walk(Paths.get(path))) {
			testfiles = paths.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
		} catch (IOException e) {
			throw new testResultReaderException(e);
		}
		return testfiles;
	}

}
