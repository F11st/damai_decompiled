package com.taobao.android.dinamicx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.C9192h;
import tb.by2;
import tb.fy;
import tb.zt;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXEngineConfig {
    public static final int DEFAULT_MAX_CACHE_COUNT = 100;
    public static final int DEFAULT_PERIOD_TIME = DXSignalProduce.f * 20;
    public static final int DOWN_GRADE_ONCE = 2;
    public static final int DOWN_GRADE_TO_PRESET = 1;
    public static final String DX_DEFAULT_BIZTYPE = "default_bizType";
    public static final int NOTIFICATION_TYPE_EVERY_ONE = 1;
    public static final int NOTIFICATION_TYPE_ONLY_ONE = 2;
    String a;
    int b;
    long c;
    int d;
    boolean e;
    boolean f;
    int g;
    boolean h;
    long i;
    private String j;
    private int k;
    private zt l;
    private boolean m;
    private C9192h n;
    private boolean o;
    private fy p;
    private boolean q;
    private DXVideoControlConfig<by2> r;
    private boolean s;
    private int t;
    private boolean u;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DownGradeType {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface RemoteTemplateDownloadNotificationType {
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.DXEngineConfig$b */
    /* loaded from: classes12.dex */
    public static final class C6355b {
        private String a;
        private int b;
        private int c;
        private boolean d;
        private long e;
        boolean f;
        private int g;
        private boolean h;
        private long i;
        private String j;
        private int k;
        private C9192h l;
        private zt m;
        private boolean n;
        private IDXElderTextSizeStrategy o;
        private boolean p;
        private DXVideoControlConfig<by2> r;
        private int t;
        private boolean q = true;
        private boolean s = false;
        private boolean u = true;

        public C6355b(String str) {
            this.a = str;
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
            } else {
                this.a = DXEngineConfig.DX_DEFAULT_BIZTYPE;
            }
            this.e = System.currentTimeMillis();
            this.c = 1;
            this.d = false;
            this.g = 100;
            this.h = true;
            this.b = DXEngineConfig.DEFAULT_PERIOD_TIME;
            this.f = false;
            this.i = 100L;
            this.k = -1;
            this.j = "";
            this.t = 1;
        }

        public DXEngineConfig t() {
            return new DXEngineConfig(this.a, this);
        }

        public C6355b u(int i) {
            this.c = i;
            return this;
        }

        public C6355b v(boolean z) {
            this.p = z;
            return this;
        }

        public C6355b w(int i) {
            this.t = i;
            return this;
        }

        public C6355b x(boolean z) {
            this.h = z;
            return this;
        }
    }

    public C9192h a() {
        return this.n;
    }

    public String b() {
        return this.a;
    }

    public zt c() {
        return this.l;
    }

    public fy d() {
        return this.p;
    }

    public long e() {
        return this.c;
    }

    public int f() {
        return this.k;
    }

    public String g() {
        return this.j;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.g;
    }

    public int j() {
        return this.t;
    }

    public long k() {
        return this.i;
    }

    public DXVideoControlConfig<by2> l() {
        return this.r;
    }

    public boolean m() {
        return this.f;
    }

    public boolean n() {
        return this.u;
    }

    public boolean o() {
        return this.q;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.s;
    }

    public boolean r() {
        return this.m;
    }

    public boolean s() {
        return this.h;
    }

    public DXEngineConfig(@NonNull String str) {
        this(str, new C6355b(str));
    }

    private DXEngineConfig(@NonNull String str, C6355b c6355b) {
        this.d = 1;
        this.q = true;
        this.t = 1;
        this.u = true;
        this.a = str;
        this.b = c6355b.b;
        this.c = c6355b.e;
        this.d = c6355b.c;
        this.e = c6355b.d;
        this.g = c6355b.g;
        this.h = c6355b.h;
        this.f = c6355b.f;
        this.i = Math.max(c6355b.i, 100L);
        if (TextUtils.isEmpty(str)) {
            this.a = DX_DEFAULT_BIZTYPE;
        }
        this.k = c6355b.k;
        this.j = c6355b.j;
        this.n = c6355b.l;
        zt unused = c6355b.m;
        this.m = c6355b.n;
        if (c6355b.o != null) {
            this.p = new fy(c6355b.o);
        } else {
            this.p = C6366c.b;
        }
        this.o = c6355b.p;
        this.q = c6355b.q;
        this.r = c6355b.r;
        this.s = c6355b.s;
        this.t = c6355b.t;
        this.u = c6355b.u;
    }
}
