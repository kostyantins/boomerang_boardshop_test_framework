package project.utils;

import org.testng.Reporter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Logger {

    private Logger() {

    }

    private static final Date CURRENT_LOG_DATE = new Date();
    private static final Format LOG_FORMATTER = new SimpleDateFormat("dd:MMM:yyyy, HH:mm"); //do not forget to try delete: "HH:mm:ss - " !!!

    public static void logInfo(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='1' color='blue'>" + "INFO" + "</font></b>" + " - " + value + "</p>");
    }

    public static void logPass(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='1' color='green'>" + "PASS" + "</font></b>" + " - " + value + "</p>");
    }

    public static void logFail(final String value) {
        Reporter.log("<p>" + LOG_FORMATTER.format(CURRENT_LOG_DATE)
                + "<b> <font size='2' color='red'>" + "FAIL" + "</font></b>" + " - " + value + "</p>");
    }
}
