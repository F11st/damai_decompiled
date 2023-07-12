package com.amap.api.mapcore.util;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ic extends ii {
    private byte[] d;
    private Map<String, String> e;

    public ic(byte[] bArr, Map<String, String> map) {
        this.d = bArr;
        this.e = map;
    }

    @Override // com.amap.api.mapcore.util.ii
    public byte[] getEntityBytes() {
        return this.d;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return this.e;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
