package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gh extends Exception {
    private gq a;

    /* renamed from: a  reason: collision with other field name */
    private gr f420a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f421a;

    public gh() {
        this.a = null;
        this.f420a = null;
        this.f421a = null;
    }

    public gh(gq gqVar) {
        this.a = null;
        this.f420a = null;
        this.f421a = null;
        this.a = gqVar;
    }

    public gh(String str) {
        super(str);
        this.a = null;
        this.f420a = null;
        this.f421a = null;
    }

    public gh(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f420a = null;
        this.f421a = null;
        this.f421a = th;
    }

    public gh(Throwable th) {
        this.a = null;
        this.f420a = null;
        this.f421a = null;
        this.f421a = th;
    }

    public Throwable a() {
        return this.f421a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gq gqVar;
        gr grVar;
        String message = super.getMessage();
        return (message != null || (grVar = this.f420a) == null) ? (message != null || (gqVar = this.a) == null) ? message : gqVar.toString() : grVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f421a != null) {
            printStream.println("Nested Exception: ");
            this.f421a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f421a != null) {
            printWriter.println("Nested Exception: ");
            this.f421a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        gr grVar = this.f420a;
        if (grVar != null) {
            sb.append(grVar);
        }
        gq gqVar = this.a;
        if (gqVar != null) {
            sb.append(gqVar);
        }
        if (this.f421a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f421a);
        }
        return sb.toString();
    }
}
