package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    private static SimpleDateFormat a = d.C0347d.a("yy.MM.dd.HH");
    private File g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private int h = 10;
    private String i = ".log";
    private long j = AbsPerformance.LONG_NIL;

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        b(j);
        d(i4);
        b(str2);
        c(j2);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File[] d(long j) {
        File b = b();
        String c = c(a(j));
        try {
            b = new File(b, c);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String b2 = m.b();
        File file = null;
        if (!TextUtils.isEmpty(b2) || b2 != null) {
            try {
                File file2 = new File(b2, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
        }
        return new File[]{b, file};
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public String c() {
        return this.b;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.j = j;
    }

    public void b(String str) {
        this.i = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(File file) {
        this.g = file;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.h = i;
    }
}
