package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;
import tb.jn1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    public String b;
    public String c;
    public int d;
    public String g;
    public int h;
    public int i;
    public int j;
    public final StringBuilder a = new StringBuilder();
    public long e = 0;
    public long f = 0;

    public c(int i, String str, int i2, String str2) {
        this.b = null;
        this.c = "HMS";
        this.d = 0;
        this.j = 0;
        this.j = i;
        this.b = str;
        this.d = i2;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static String a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D";
    }

    public final c b() {
        this.e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f = currentThread.getId();
        this.h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.j;
        if (length > i) {
            StackTraceElement stackTraceElement = stackTrace[i];
            this.g = stackTraceElement.getFileName();
            this.i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> c a(T t) {
        this.a.append(t);
        return this;
    }

    public c a(Throwable th) {
        a((c) '\n').a((c) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public final StringBuilder a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    public final StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append(jn1.ARRAY_START);
        sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        String a = a(this.d);
        sb.append(' ');
        sb.append(a);
        sb.append(r10.DIR);
        sb.append(this.c);
        sb.append(r10.DIR);
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.h);
        sb.append(jn1.CONDITION_IF_MIDDLE);
        sb.append(this.f);
        sb.append(' ');
        sb.append(this.g);
        sb.append(jn1.CONDITION_IF_MIDDLE);
        sb.append(this.i);
        sb.append(jn1.ARRAY_END);
        return sb;
    }
}
