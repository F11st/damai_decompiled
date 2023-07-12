package com.taobao.accs;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsException extends Exception {
    private int mErrorCode;

    public AccsException(int i) {
        this.mErrorCode = i;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("errorCode = " + this.mErrorCode);
        super.printStackTrace(printStream);
    }

    public AccsException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("errorCode = " + this.mErrorCode);
        super.printStackTrace(printWriter);
    }

    public AccsException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public AccsException(String str, Throwable th, int i) {
        super(str, th);
        this.mErrorCode = i;
    }

    public AccsException(Throwable th, int i) {
        super(th);
        this.mErrorCode = i;
    }
}
