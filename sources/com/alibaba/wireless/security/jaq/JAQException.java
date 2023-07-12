package com.alibaba.wireless.security.jaq;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class JAQException extends Exception {
    private int a;

    public JAQException(int i) {
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

    public void setErrorCode(int i) {
        this.a = i;
    }

    public JAQException(String str, int i) {
        super(str);
        this.a = i;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public JAQException(Throwable th, int i) {
        super(th);
        this.a = i;
    }

    public JAQException(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }
}
