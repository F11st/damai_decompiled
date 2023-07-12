package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jv extends ie {
    Map<String, String> f;
    String g;
    String h;
    byte[] i;
    byte[] j;
    boolean k;
    String l;
    Map<String, String> m;
    boolean n;
    private String o;

    public jv(Context context, gm gmVar) {
        super(context, gmVar);
        this.f = null;
        this.o = "";
        this.g = "";
        this.h = "";
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = false;
    }

    public final void a() {
        this.k = true;
    }

    public final void a(String str) {
        this.l = str;
    }

    public final void a(Map<String, String> map) {
        this.m = map;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final void b(Map<String, String> map) {
        this.f = map;
    }

    public final void b(byte[] bArr) {
        this.i = bArr;
    }

    public final void c(String str) {
        this.h = str;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final byte[] e() {
        return this.i;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final byte[] f() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ii
    public final String getIPDNSName() {
        return this.o;
    }

    @Override // com.amap.api.mapcore.util.gj, com.amap.api.mapcore.util.ii
    public final String getIPV6URL() {
        return this.h;
    }

    @Override // com.amap.api.mapcore.util.ie, com.amap.api.mapcore.util.ii
    public final Map<String, String> getParams() {
        return this.m;
    }

    @Override // com.amap.api.mapcore.util.ii
    public final Map<String, String> getRequestHead() {
        return this.f;
    }

    @Override // com.amap.api.mapcore.util.ii
    public final String getURL() {
        return this.g;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final boolean h() {
        return this.k;
    }

    @Override // com.amap.api.mapcore.util.ie
    public final String j() {
        return this.l;
    }

    @Override // com.amap.api.mapcore.util.ie
    protected final boolean k() {
        return this.n;
    }

    public final void l() {
        this.n = true;
    }
}
