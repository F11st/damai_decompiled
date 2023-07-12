package com.amap.api.mapcore.util;

/* compiled from: Taobao */
@hh(a = "update_item")
/* loaded from: classes10.dex */
public class bn {
    @hi(a = "localPath", b = 6)
    protected String h;
    @hi(a = "mCompleteCode", b = 2)
    protected int j;
    @hi(a = "mState", b = 2)
    public int l;
    @hi(a = "title", b = 6)
    protected String a = null;
    @hi(a = "url", b = 6)
    protected String b = null;
    @hi(a = "mAdcode", b = 6)
    protected String c = null;
    @hi(a = "fileName", b = 6)
    protected String d = null;
    @hi(a = "version", b = 6)
    protected String e = "";
    @hi(a = "lLocalLength", b = 5)
    protected long f = 0;
    @hi(a = "lRemoteLength", b = 5)
    protected long g = 0;
    @hi(a = "isProvince", b = 2)
    protected int i = 0;
    @hi(a = "mCityCode", b = 6)
    protected String k = "";
    @hi(a = "mPinyin", b = 6)
    public String m = "";

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.b;
    }

    public int h() {
        return this.j;
    }

    public String i() {
        return this.m;
    }

    public static String e(String str) {
        return "mAdcode='" + str + "'";
    }

    public static String f(String str) {
        return "mPinyin='" + str + "'";
    }

    public void d(String str) {
        this.k = str;
    }
}
