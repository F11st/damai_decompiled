package com.alibaba.android.umbrella.performance;

import android.os.SystemClock;
import java.util.Map;
import tb.jt2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
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

    private a(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.e;
        this.d = bVar.f;
        this.e = bVar.g;
        this.h = bVar.c;
        this.g = bVar.d;
        this.f = bVar.h;
        this.j = bVar.i;
        this.i = bVar.j;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
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

        public b(String str) {
            this.b = str;
            this.c = SystemClock.uptimeMillis();
        }

        public b a(String str) {
            this.g = str;
            return this;
        }

        public b b(String str) {
            this.f = str;
            return this;
        }

        public b i(Map<String, String> map) {
            this.i = map;
            return this;
        }

        public a j() {
            return new a(this);
        }

        public b k(String str) {
            this.e = str;
            return this;
        }

        public b l(long j) {
            this.j = j;
            return this;
        }

        public b m(String str) {
            this.h = str;
            return this;
        }

        public b n(int i) {
            this.a = i;
            return this;
        }

        public b o(jt2 jt2Var) {
            this.d = jt2Var;
            return this;
        }

        public b(String str, long j) {
            this.b = str;
            if (j > 0) {
                this.c = j;
            } else {
                this.c = SystemClock.uptimeMillis();
            }
        }
    }
}
