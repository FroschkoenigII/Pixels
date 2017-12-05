package pixels.testReader;

import java.util.ArrayList;
import java.util.List;

public class TestResultSet {
	
	private String testclassPath;

	private String testclassName;
	
	private List<String> messageLines;
	
	private List<String> errormessages;
	
	private String originalMessage;
	
	public String getTestclassPath() {
		return testclassPath;
	}

	public void setTestclassPath(String testclassPath) {
		this.testclassPath = testclassPath;
	}

	public List<String> getMessageLines() {
		if(messageLines == null)
			messageLines = new ArrayList<String>();
		return messageLines;
	}

	public String getTestclassName() {
		return testclassName;
	}

	public void setTestclassName(String testclassName) {
		this.testclassName = testclassName;
	}

	public void setMessageLines(List<String> messageLines) {
		this.messageLines = messageLines;
	}

	public List<String> getErrormessage() {
		if(errormessages == null)
			errormessages = new ArrayList<String>();
		return errormessages;
	}

	public void setErrormessage(List<String> errormessage) {
		this.errormessages = errormessage;
	}

	public String getOriginalMessage() {
		return originalMessage;
	}

	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}
	
	
	
	
}
