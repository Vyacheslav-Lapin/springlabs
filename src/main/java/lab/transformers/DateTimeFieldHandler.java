package lab.transformers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.exolab.castor.types.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {

    private static String dateFormatPattern;

    protected static String format(Instant dateTime) {
        String dateTimeString = "";
        if (dateTime != null) {
//            DateTimeFormatter dateTimeFormatter =
//                    DateTimeFormat.forPattern(dateFormatPattern);
//            dateTimeString = dateTimeFormatter.print(dateTime);
        }
        return dateTimeString;
    }

    protected static Instant parse(String dateTimeString) {
//        Instant.parse()
        DateTime dateTime = new DateTime();
        if (dateTimeString != null) {
//            DateTimeFormatter dateTimeFormatter =
//                    DateTimeFormat.forPattern(dateFormatPattern);
//            dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
        }
//        return dateTime;
        return null;
    }

    @Override
    public void setConfiguration(Properties config) throws ValidityException {
        dateFormatPattern = config.getProperty("date-format");
    }

    @Override
    public Object convertUponGet(Object value) {
        DateTime dateTime = (DateTime) value;
//        return format(dateTime);
        return null;
    }

    @Override
    public Object convertUponSet(Object value) {
        String dateTimeString = (String) value;
        return parse(dateTimeString);
    }

    @Override
    public Class<DateTime> getFieldType() {
        return DateTime.class;
    }
}