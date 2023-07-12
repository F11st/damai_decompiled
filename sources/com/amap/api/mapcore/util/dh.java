package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dh extends fu<String, a> {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
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
    public a b(String str) throws ft {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", gc.f(this.f));
        hashMap.put("output", "bin");
        String a2 = gf.a();
        String a3 = gf.a(this.f, a2, gn.c(hashMap));
        hashMap.put("ts", a2);
        hashMap.put("scode", a3);
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
    public a b(byte[] bArr) throws ft {
        a aVar = new a();
        aVar.a = bArr;
        return aVar;
    }
}
