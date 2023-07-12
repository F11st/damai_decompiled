package com.alibaba.android.umbrella.performance;

import android.os.SystemClock;
import java.util.Map;
import tb.jt2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.umbrella.performance.a */
/* loaded from: classes15.dex */
public class C3271a {
    public static final int ADD_ABTEST = 6;
    public static final int ADD_ARGS = 2;
    public static final int ADD_PROCESS_POINT = 3;
    public static final int ADD_SUB_PROCESS_POINT = 4;
    public static final int COMMIT = 5;
    public static final int REGISTER_PAGE_POINT = 1;
    public static final int SET_CHILD_BIZ = 7;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public jt2 g;
    public long h;
    public long i;
    public Map<String, String> j;

    private C3271a(C3273b c3273b) {
        this.a = c3273b.a;
        this.b = c3273b.b;
        this.c = c3273b.e;
        this.d = c3273b.f;
        this.e = c3273b.g;
        this.h = c3273b.c;
        this.g = c3273b.d;
        this.f = c3273b.h;
        this.j = c3273b.i;
        this.i = c3273b.j;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.umbrella.performance.a$b */
    /* loaded from: classes15.dex */
    public static class C3273b {
        private int a;
        private String b;
        private long c;
        public jt2 d;
        public String e;
        public String f;
        public String g;
        private String h;
        private Map<String, String> i;
        private long j;

        public C3273b(String str) {
            this.b = str;
            this.c = SystemClock.uptimeMillis();
        }

        public C3273b a(String str) {
            this.g = str;
            return this;
        }

        public C3273b b(String str) {
            this.f = str;
            return this;
        }

        public C3273b i(Map<String, String> map) {
            this.i = map;
            return this;
        }

        public C3271a j() {
            return new C3271a(this);
        }

        public C3273b k(String str) {
            this.e = str;
            return this;
        }

        public C3273b l(long j) {
            this.j = j;
            return this;
        }

        public C3273b m(String str) {
            this.h = str;
            return this;
        }

        public C3273b n(int i) {
            this.a = i;
            return this;
        }

        public C3273b o(jt2 jt2Var) {
            this.d = jt2Var;
            return this;
        }

        public C3273b(String str, long j) {
            this.b = str;
            if (j > 0) {
                this.c = j;
            } else {
                this.c = SystemClock.uptimeMillis();
            }
        }
    }
}
