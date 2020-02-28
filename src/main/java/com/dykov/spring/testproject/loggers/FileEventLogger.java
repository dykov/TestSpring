package com.dykov.spring.testproject.loggers;

import com.dykov.spring.testproject.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    private void init() {
        this.file = new File(fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IllegalArgumentException("Can't create file: " + fileName, e);
            }
        }

        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Cannot write to file: " + fileName);
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(
                    file, event.toString(), Charset.defaultCharset(), true
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
