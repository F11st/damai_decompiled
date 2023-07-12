package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dh extends fu<String, C4515a> {

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.dh$a */
    /* loaded from: classes10.dex */
    public static class C4515a {
        public byte[] a;
        public int b = -1;
    }

    public dh(Context context, String str) {
        super(context, str);
        this.g = "/map/styles";
    }

    @Override // com.amap.api.mapcore.util.fu
    protected String a() {
        return null;
    }

    public void a(String str) {
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fu
    /* renamed from: c */
    public C4515a b(String str) throws ft {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", C4554gc.f(this.f));
        hashMap.put("output", "bin");
        String a = gf.a();
        String a2 = gf.a(this.f, a, gn.c(hashMap));
        hashMap.put("ts", a);
        hashMap.put("scode", a2);
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return this.g;
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fu
    /* renamed from: a */
    public C4515a b(byte[] bArr) throws ft {
        C4515a c4515a = new C4515a();
        c4515a.a = bArr;
        return c4515a;
    }
}
