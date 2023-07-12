package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class c implements g {
    private String a;
    private int b;
    private int c;
    private int d;
    private String e;
    private Map<String, List<String>> f = new HashMap();

    public c(HttpURLConnection httpURLConnection, String str, int i, int i2, int i3, String str2) {
        Map<String, List<String>> headerFields;
        this.a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f.putAll(headerFields);
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.a + jn1.ARRAY_END + "\nresponseSize = " + this.b + "\nrequestSize = " + this.c + "\nresultCode = " + this.d + "\nerrorMsg = " + this.e;
    }
}
