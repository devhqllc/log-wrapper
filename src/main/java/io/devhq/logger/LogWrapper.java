package io.devhq.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.util.Arrays;

@RequiredArgsConstructor
public class LogWrapper {
    private final ObjectMapper objectMapper;


    public void debug(Logger logger, String message, Pair... attributes) {
        String logMessage = prepareLog(message, attributes);
        logger.debug(logMessage);
    }

    public void error(Logger logger, String message, Pair... attributes) {
        String logMessage = prepareLog(message, attributes);
        logger.error(logMessage);
    }

    public void info(Logger logger, String message, Pair... attributes) {
        String logMessage = prepareLog(message, attributes);
        logger.info(logMessage);
    }

    public void trace(Logger logger, String message, Pair... attributes) {
        String logMessage = prepareLog(message, attributes);
        logger.trace(logMessage);
    }

    public void warn(Logger logger, String message, Pair... attributes) {
        String logMessage = prepareLog(message, attributes);
        logger.warn(logMessage);
    }


    private String prepareLog(String message, Pair... attributes) {
        LogObjectDto logObject = new LogObjectDto();
        logObject.setMessage(StringUtils.capitalize(message));
        logObject.setAttributes(attributes);
        logObject.setDate(ZonedDateTime.now());
        try {
            return objectMapper.writeValueAsString(logObject);
        } catch (Exception e) {
            return MessageFormat.format("Something gone wrong during logging, raw log will be written, {message:{0};attributes:{1}}",
                    message, Arrays.toString(attributes));
        }

    }
}
