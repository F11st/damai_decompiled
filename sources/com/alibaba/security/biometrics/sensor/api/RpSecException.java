package com.alibaba.security.biometrics.sensor.api;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RpSecException extends Exception {
    public static final int EXCEPTION_NO_COLLECT_STRATEGY = -400;
    public static final int EXCEPTION_NO_DECOR_VIEW_FOUND = -700;
    public static final int EXCEPTION_NO_ENABLED_SENSORS = -500;
    public static final int EXCEPTION_NO_NEED_FOR_COLLECTION = -800;
    public static final int EXCEPTION_NO_WINDOW_FOUND_FROM_ACTIVITY = -600;
    public static final int EXCEPTION_NULL_CONTEXT = -100;
    public static final int EXCEPTION_NULL_SENSOR_DETECTED = -300;
    public static final int EXCEPTION_NULL_SENSOR_MANAGER = -200;
    private int errorCode;

    public RpSecException(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public RpSecException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public RpSecException(Throwable th, int i) {
        super(th);
        this.errorCode = i;
    }

    public RpSecException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = i;
    }
}
