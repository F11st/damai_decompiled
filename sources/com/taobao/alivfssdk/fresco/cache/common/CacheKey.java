package com.taobao.alivfssdk.fresco.cache.common;

import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface CacheKey {
    boolean containsUri(Uri uri);

    boolean equals(Object obj);

    int hashCode();

    String toString();
}
