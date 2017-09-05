package com.pereira.felipe.fortunecookie;

import android.content.Context;
import android.content.Intent;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Felipe on 05/09/2017.
 */

public class HandleAppCrash implements Thread.UncaughtExceptionHandler {
    private final Context myContext;
    Class<?> intentClass;

    public HandleAppCrash(Context context, Class<?> intentClass) {
        this.myContext = context;
        this.intentClass = intentClass;
    }

    public static void deploy(Context context, Class<?> intentClass) {
        Thread.setDefaultUncaughtExceptionHandler(new HandleAppCrash(context, intentClass));
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        System.err.println(stackTrace);
        Intent intent = new Intent(this.myContext, this.intentClass);
        intent.putExtra("stackTrace", stackTrace.toString());
        this.myContext.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }
}