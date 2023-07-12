package tb;

import android.content.Context;
import android.os.SystemClock;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class sj {
    private static sj i;
    private volatile String c;
    private volatile Context a = null;
    private volatile boolean b = false;
    private volatile boolean d = false;
    private volatile String e = null;
    private boolean h = false;
    private long g = SystemClock.elapsedRealtime();
    private String f = "" + System.currentTimeMillis();

    private sj() {
    }

    public static sj c() {
        if (i == null) {
            synchronized (sj.class) {
                if (i == null) {
                    i = new sj();
                }
            }
        }
        return i;
    }

    public String a() {
        return this.c;
    }

    public Context b() {
        return this.a;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public long f() {
        return this.g;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.h;
    }

    public void j() {
        this.b = true;
    }

    public void k(String str) {
        this.c = str;
    }

    public void l(Context context) {
        this.a = context;
    }

    public void m() {
        this.h = true;
    }

    public void n(String str) {
        this.e = str;
    }

    public void o() {
        this.d = true;
    }
}
