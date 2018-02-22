package pixels.jgiven;

import java.lang.annotation.Annotation;

import com.tngtech.jgiven.annotation.TagDescriptionGenerator;
import com.tngtech.jgiven.config.TagConfiguration;

public class DescriptionGenerator implements TagDescriptionGenerator {
    
    public String generateDescription( TagConfiguration tagConfiguration,
            Annotation annotation, Object value ) {
        return String.format(
           "<a href='https://github.com/examplelink/%s'>EgpIssue%s</a>",
            value, value );
    }
}