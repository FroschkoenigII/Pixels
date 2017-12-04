package pixels.testReader;

import java.util.ArrayList;
import java.util.List;

public class TestResultSet {

	private List<String> messageLines;
	
	private String errormessage;
	
	private String originalMessage;

	public List<String> getMessageLines() {
		if(messageLines == null)
			messageLines = new ArrayList<String>();
		return messageLines;
	}

	public void setMessageLines(List<String> messageLines) {
		this.messageLines = messageLines;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getOriginalMessage() {
		return originalMessage;
	}

	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}
	
	
	
	
}
