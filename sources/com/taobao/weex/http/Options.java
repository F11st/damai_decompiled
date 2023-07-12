package com.taobao.weex.http;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class Options {
    private String a;
    private String b;
    private Map<String, String> c;
    private String d;
    private Type e;
    private int f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum Type {
        json,
        text,
        jsonp
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private String a;
        private String b;
        private Map<String, String> c = new HashMap();
        private String d;
        private Type e;
        private int f;

        public Options a() {
            return new Options(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public b b(String str, String str2) {
            this.c.put(str, str2);
            return this;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }

        public b d(String str) {
            this.a = str;
            return this;
        }

        public b e(int i) {
            this.f = i;
            return this;
        }

        public b f(String str) {
            Type type = Type.json;
            if (type.name().equals(str)) {
                this.e = type;
            } else {
                Type type2 = Type.jsonp;
                if (type2.name().equals(str)) {
                    this.e = type2;
                } else {
                    this.e = Type.text;
                }
            }
            return this;
        }

        public b g(String str) {
            this.b = str;
            return this;
        }
    }

    public String a() {
        return this.d;
    }

    public Map<String, String> b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.f;
    }

    public Type e() {
        return this.e;
    }

    public String f() {
        return this.b;
    }

    private Options(String str, String str2, Map<String, String> map, String str3, Type type, int i) {
        this.e = Type.text;
        this.f = 3000;
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = str3;
        this.e = type;
        this.f = i == 0 ? 3000 : i;
    }
}
