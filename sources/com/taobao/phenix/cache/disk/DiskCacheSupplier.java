package com.taobao.phenix.cache.disk;

import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DiskCacheSupplier {
    DiskCache get(int i);

    Collection<DiskCache> getAll();
}
