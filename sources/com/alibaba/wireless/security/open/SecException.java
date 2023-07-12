package com.alibaba.wireless.security.open;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecException extends Exception {
    public static final int ERROR_NULL_CONTEXT = -100;
    private int a;

    public SecException(int i) {
        this.a = i;
    }

    public SecException(String str, int i) {
        super(str);
        this.a = i;
    }

    public SecException(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public SecException(Throwable th, int i) {
        super(th);
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public void setErrorCode(int i) {
        this.a = i;
    }
}
