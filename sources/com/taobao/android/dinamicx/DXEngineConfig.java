package com.taobao.android.dinamicx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
    private tb.h n;
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
    /* loaded from: classes12.dex */
    public static final class b {
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
        private tb.h l;
        private zt m;
        private boolean n;
        private IDXElderTextSizeStrategy o;
        private boolean p;
        private DXVideoControlConfig<by2> r;
        private int t;
        private boolean q = true;
        private boolean s = false;
        private boolean u = true;

        public b(String str) {
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

        public b u(int i) {
            this.c = i;
            return this;
        }

        public b v(boolean z) {
            this.p = z;
            return this;
        }

        public b w(int i) {
            this.t = i;
            return this;
        }

        public b x(boolean z) {
            this.h = z;
            return this;
        }
    }

    public tb.h a() {
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
        this(str, new b(str));
    }

    private DXEngineConfig(@NonNull String str, b bVar) {
        this.d = 1;
        this.q = true;
        this.t = 1;
        this.u = true;
        this.a = str;
        this.b = bVar.b;
        this.c = bVar.e;
        this.d = bVar.c;
        this.e = bVar.d;
        this.g = bVar.g;
        this.h = bVar.h;
        this.f = bVar.f;
        this.i = Math.max(bVar.i, 100L);
        if (TextUtils.isEmpty(str)) {
            this.a = DX_DEFAULT_BIZTYPE;
        }
        this.k = bVar.k;
        this.j = bVar.j;
        this.n = bVar.l;
        zt unused = bVar.m;
        this.m = bVar.n;
        if (bVar.o != null) {
            this.p = new fy(bVar.o);
        } else {
            this.p = c.b;
        }
        this.o = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
    }
}
