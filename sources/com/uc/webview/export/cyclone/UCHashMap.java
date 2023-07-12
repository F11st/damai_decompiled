package com.uc.webview.export.cyclone;

import java.util.HashMap;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCHashMap<K, V> extends HashMap<K, V> {
    public UCHashMap<K, V> set(K k, V v) {
        put(k, v);
        return this;
    }
}
