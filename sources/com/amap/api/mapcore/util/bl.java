package com.amap.api.mapcore.util;

/* compiled from: Taobao */
@hh(a = "update_item_download_info")
/* loaded from: classes10.dex */
class bl {
    @hi(a = "mAdcode", b = 6)
    private String a;
    @hi(a = "fileLength", b = 5)
    private long b;
    @hi(a = "splitter", b = 2)
    private int c;
    @hi(a = "startPos", b = 5)
    private long d;
    @hi(a = "endPos", b = 5)
    private long e;

    public bl() {
        this.a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public bl(String str, long j, int i, long j2, long j3) {
        this.a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }
}
