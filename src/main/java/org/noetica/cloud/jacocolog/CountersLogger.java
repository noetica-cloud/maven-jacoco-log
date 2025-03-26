package org.noetica.cloud.jacocolog;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.jacoco.core.analysis.ICoverageNode.CounterEntity;

@Named
@Singleton
public class CountersLogger {

    private final Log log = new SystemStreamLog();

    private int digits = 2;

    private static final DecimalFormatSymbols NUMBER_FORMAT_LOCALE = new DecimalFormatSymbols(Locale.ENGLISH);

    private CounterEntity[] counters = CounterEntity.values();

    public void setCounters(CounterEntity[] counters) {
        this.counters = counters;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public void log(JacocoCounters coverage) {
        log.info("Test Coverage:");
        for (CounterEntity type : counters) {
            log.info("    - " + toCounterString(type) + " Coverage: "
                    + formatNumber(coverage.getCounters().get(type)) + "%");
        }
    }
    
    private String formatNumber(final double value) {
        String format = "#" + (digits == 0 ? "" : ".") + new String(new char[digits]).replace("\0", "#");
        return new DecimalFormat(format, NUMBER_FORMAT_LOCALE).format(value);
    }

    private String toCounterString(CounterEntity counter) {
        switch (counter) {
            case CLASS:
                return "Class";
            case METHOD:
                return "Method";
            case BRANCH:
                return "Branch";
            case LINE:
                return "Line";
            case INSTRUCTION:
                return "Instruction";
            case COMPLEXITY:
                return "Complexity";
            default:
                return "Unknown";
        }
    }
}
