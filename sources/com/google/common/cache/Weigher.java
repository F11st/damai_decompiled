package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
