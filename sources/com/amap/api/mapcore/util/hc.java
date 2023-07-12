package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hc extends gj {
    private byte[] d;
    private String e;

    public hc(byte[] bArr, String str) {
        this.e = "1";
        this.d = (byte[]) bArr.clone();
        this.e = str;
    }

    private String a() {
        byte[] a = gn.a(gy.b);
        byte[] bArr = new byte[a.length + 50];
        System.arraycopy(this.d, 0, bArr, 0, 50);
        System.arraycopy(a, 0, bArr, 50, a.length);
        return gk.a(bArr);
    }

    @Override // com.amap.api.mapcore.util.ii
    public byte[] getEntityBytes() {
        return this.d;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(this.d.length));
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return String.format(gn.c(gy.c), "1", this.e, "1", "open", a());
    }
}
