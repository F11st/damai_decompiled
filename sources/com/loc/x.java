package com.loc;

import com.loc.bl;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x extends bl {
    private byte[] l;
    private Map<String, String> m;

    public x(byte[] bArr, Map<String, String> map) {
        this.l = bArr;
        this.m = map;
        d(bl.a.SINGLE);
        f(bl.c.HTTPS);
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        return null;
    }

    @Override // com.loc.bl
    public final String j() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.bl
    public final Map<String, String> q() {
        return this.m;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        return this.l;
    }
}
