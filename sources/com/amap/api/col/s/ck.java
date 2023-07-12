package com.amap.api.col.s;

import com.amap.api.col.s.df;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ck extends br {
    private byte[] a;
    private String b;

    public ck(byte[] bArr, String str) {
        this.b = "1";
        this.a = (byte[]) bArr.clone();
        this.b = str;
        a(df.EnumC4423a.SINGLE);
        a(df.EnumC4425c.HTTP);
    }

    @Override // com.amap.api.col.s.df
    public final boolean b_() {
        return false;
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final byte[] g() {
        return this.a;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String c = bw.c(cf.b);
        byte[] a = bw.a(cf.a);
        byte[] bArr = new byte[a.length + 50];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a, 0, bArr, 50, a.length);
        return String.format(c, "1", this.b, "1", "open", bs.a(bArr));
    }
}
