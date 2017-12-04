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
		try (Stream<Path> paths = Files.walk(Paths.get("C:\\Users\\langenf\\Desktop\\TestFolder"))) {
			testfiles =paths
		        .filter(Files::isRegularFile)
		        .map(Path::toFile)
		        .collect(Collectors.toList());   	
		}catch(IOException e)
		{
			throw new testResultReaderException(e);
		}
		
		for(File f : testfiles)
		{
			if (f.getName().endsWith(".txt"))
			{
				System.out.println(f.getName());
				TestResultSet trs = new TestResultSet();
				try {
					trs.getMessageLines().addAll(Files.readAllLines(f.toPath()));
					testSets.add(trs);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(TestResultSet ts : testSets)
		{
			for(String line : ts.getMessageLines())
			{
				System.out.println(line);
			}
		}
		
		return null;
	}

}
