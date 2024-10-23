package com.sarangkamarang.logdebug;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerToFiles {
    private static final String TAG = "LoggerToFile";
    private Context context;

    public LoggerToFiles(Context context) {
        this.context = context;
    }

    public void logToFile(String message) {
        File logFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "app_log.txt");
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileWriter writer = new FileWriter(logFile, true);
            writer.append(message);
            writer.append("\n");
            writer.flush();
            writer.close();
            Log.d(TAG, "Log saved to " + logFile.getAbsolutePath());

        } catch (IOException e) {
            Log.e(TAG, "Error writing log to file", e);
        }
    }
}
