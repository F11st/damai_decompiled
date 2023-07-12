package com.amap.api.mapcore.util;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ht extends hv {
    ht() {
    }

    @Override // com.amap.api.mapcore.util.hv
    protected byte[] a(byte[] bArr) {
        return gn.a(gn.a(bArr) + jn1.OR + 1);
    }

    public ht(hv hvVar) {
        super(hvVar);
    }
}
