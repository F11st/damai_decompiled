package tb;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.taobao.windvane.connect.HttpRequest;
import com.ali.alihadeviceevaluator.cpu.AliHACPUTracker;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes9.dex */
public class k4 {
    public static final String CONFIG_CPUTRACKTICK = "cpuTrackTick";
    public static final int DEVICE_IS_FATAL = 3;
    public static final int DEVICE_IS_GOOD = 0;
    public static final int DEVICE_IS_NORMAL = 1;
    public static final int DEVICE_IS_RISKY = 2;
    public static final int HIGH_END_DEVICE = 0;
    public static final int LOW_END_DEVICE = 2;
    public static final int MEDIUM_DEVICE = 1;
    private Context a;
    private Handler b;
    private volatile C9331c c;
    private volatile C9330b d;
    private volatile AliHACPUTracker e;
    private volatile C9332d f;
    private volatile l4 g;
    private volatile C9333e h;

    /* compiled from: Taobao */
    /* renamed from: tb.k4$b */
    /* loaded from: classes9.dex */
    public class C9330b {
        public int e;
        public int a = 0;
        public float b = 0.0f;
        public float c = -1.0f;
        public float d = -1.0f;
        public int f = -1;
        public int g = -1;

        public C9330b(k4 k4Var) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k4$c */
    /* loaded from: classes9.dex */
    public class C9331c {
        public float a = 0.0f;
        public int b = 0;
        public int c = 0;
        public String d = "0";
        public int e = -1;

        public C9331c(k4 k4Var) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k4$d */
    /* loaded from: classes9.dex */
    public class C9332d {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public int j = -1;
        public int k = -1;

        public C9332d(k4 k4Var) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k4$e */
    /* loaded from: classes9.dex */
    public class C9333e {
        public int b;
        public int c;
        public int a = -1;
        public int d = -1;

        public C9333e(k4 k4Var) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.k4$f */
    /* loaded from: classes9.dex */
    private static class C9334f {
        private static k4 a = new k4();
    }

    private int a(int i, int... iArr) {
        if (-1 == i) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                i2 = -1;
                break;
            } else if (i >= iArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        return (i2 != -1 || i < 0) ? i2 : iArr.length;
    }

    public static k4 d() {
        return C9334f.a;
    }

    public C9330b b() {
        if (this.a == null) {
            return new C9330b(this);
        }
        if (this.d == null) {
            i4 i4Var = new i4();
            i4Var.a();
            if (this.e == null) {
                this.e = new AliHACPUTracker(Process.myPid(), this.b);
            }
            this.d = new C9330b(this);
            this.d.a = i4Var.a;
            this.d.b = i4Var.c;
            this.d.e = i4Var.e;
            this.d.f = a(i4Var.e, 8, 5);
        }
        this.d.c = this.e.peakCurProcessCpuPercent();
        this.d.d = this.e.peakCpuPercent();
        this.d.g = a((int) (100.0f - this.d.d), 90, 60, 20);
        return this.d;
    }

    public C9331c c() {
        if (this.a == null) {
            return new C9331c(this);
        }
        if (this.c == null) {
            j4 a = j4.a(this.a);
            this.c = new C9331c(this);
            this.c.a = a.a;
            this.c.c = a.c;
            this.c.b = a.b;
            m4 m4Var = new m4();
            m4Var.a(this.a);
            this.c.d = String.valueOf(m4Var.a);
            this.c.e = a(m4Var.b, 8, 6);
        }
        return this.c;
    }

    public C9332d e() {
        if (this.a == null) {
            return new C9332d(this);
        }
        if (this.f == null) {
            this.f = new C9332d(this);
            this.g = new l4();
        }
        try {
            long[] a = this.g.a();
            this.f.a = a[0];
            this.f.b = a[1];
            long[] b = this.g.b();
            this.f.c = b[0];
            this.f.d = b[1];
            int i = b[0] != 0 ? (int) ((b[1] * 100.0d) / b[0]) : -1;
            long[] c = this.g.c();
            this.f.e = c[0];
            this.f.f = c[1];
            int i2 = c[0] != 0 ? (int) ((c[1] * 100.0d) / c[0]) : -1;
            long[] f = this.g.f(this.a, Process.myPid());
            this.f.g = f[0];
            this.f.h = f[1];
            this.f.i = f[2];
            this.f.j = a((int) this.f.a, HttpRequest.DEFAULT_MAX_LENGTH, 2621440);
            this.f.k = Math.round((a(100 - i, 70, 50, 30) + a(100 - i2, 60, 40, 20)) / 2.0f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f;
    }

    @Deprecated
    public C9333e f() {
        if (this.a == null) {
            return new C9333e(this);
        }
        if (this.h == null) {
            this.h = new C9333e(this);
            if (this.f == null) {
                e();
            }
            if (this.d == null) {
                b();
            }
            if (this.c == null) {
                c();
            }
            this.h.b = Math.round((((this.f.j * 0.9f) + (this.d.f * 1.5f)) + (this.c.e * 0.6f)) / 3.0f);
            this.h.d = Math.round((this.f.k + this.d.g) / 2.0f);
        } else {
            if (this.f == null) {
                e();
            }
            if (this.d == null) {
                b();
            }
            if (this.c == null) {
                c();
            }
            this.h.d = Math.round(((this.f.k * 0.8f) + (this.d.g * 1.2f)) / 2.0f);
        }
        return this.h;
    }

    private k4() {
    }
}
