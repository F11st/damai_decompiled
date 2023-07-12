package com.loc;

import com.loc.bl;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;
import tb.o83;
import tb.w33;

/* compiled from: Taobao */
/* renamed from: com.loc.h */
/* loaded from: classes10.dex */
public final class C5836h extends o83 {
    private byte[] l;
    private String m;

    public C5836h(byte[] bArr, String str) {
        this.m = "1";
        this.l = (byte[]) bArr.clone();
        this.m = str;
        d(bl.EnumC5800a.SINGLE);
        f(bl.EnumC5802c.HTTP);
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(this.l.length));
        return hashMap;
    }

    @Override // com.loc.bl
    public final String j() {
        String v = v1.v(w33.b);
        byte[] p = v1.p(w33.a);
        byte[] bArr = new byte[p.length + 50];
        System.arraycopy(this.l, 0, bArr, 0, 50);
        System.arraycopy(p, 0, bArr, 50, p.length);
        return String.format(v, "1", this.m, "1", "open", r1.b(bArr));
    }

    @Override // com.loc.bl
    public final boolean p() {
        return false;
    }

    @Override // com.loc.bl
    public final Map<String, String> q() {
        return null;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        return this.l;
    }
}
