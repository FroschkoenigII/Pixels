package pixels.jgiven;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.tngtech.jgiven.annotation.IsTag;

@EgpStory
@IsTag( prependType = false , descriptionGenerator = DescriptionGenerator.class )
@Retention( RetentionPolicy.RUNTIME )
public @interface EgpIssue {
	String value();
}
