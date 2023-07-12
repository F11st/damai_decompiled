package com.taobao.monitor.common;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BundleMap implements Serializable {
    private final Map<String, Object> data;

    public BundleMap(Map<String, Object> map) {
        this.data = map;
    }

    public Map<String, Object> getData() {
        return this.data;
    }
}
