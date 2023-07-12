package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
class go extends ii {
    private String e;
    private Map<String, String> d = new HashMap();
    private Map<String, String> f = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Map<String, String> map) {
        this.d.clear();
        this.d.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Map<String, String> map) {
        this.f.clear();
        this.f.putAll(map);
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        return this.f;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.e = str;
    }
}
