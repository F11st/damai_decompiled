package com.alibaba.pictures.bricks.util.blur;

import androidx.collection.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class LruCachePolicy<K, V> implements CachePolicy<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private LruCache<K, V> b;

    public LruCachePolicy() {
        int maxCacheSize = maxCacheSize();
        this.a = maxCacheSize;
        if (maxCacheSize > 0) {
            this.b = new LruCache<K, V>(maxCacheSize) { // from class: com.alibaba.pictures.bricks.util.blur.LruCachePolicy.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.collection.LruCache
                protected void entryRemoved(boolean z, K k, V v, V v2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-593568880")) {
                        ipChange.ipc$dispatch("-593568880", new Object[]{this, Boolean.valueOf(z), k, v, v2});
                    } else {
                        LruCachePolicy.this.a(z, k, v, v2);
                    }
                }

                @Override // androidx.collection.LruCache
                protected int sizeOf(K k, V v) {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "1574508505") ? ((Integer) ipChange.ipc$dispatch("1574508505", new Object[]{this, k, v})).intValue() : LruCachePolicy.this.computeValueSize(v);
                }
            };
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public abstract void a(boolean z, K k, V v, V v2);

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public V cacheValue(K k, V v) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1004710576") ? (V) ipChange.ipc$dispatch("-1004710576", new Object[]{this, k, v}) : this.b.put(k, v);
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648731428")) {
            ipChange.ipc$dispatch("648731428", new Object[]{this});
        } else {
            this.b.evictAll();
        }
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public int currentCacheSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1897457506") ? ((Integer) ipChange.ipc$dispatch("1897457506", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public int evictionCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1762881876") ? ((Integer) ipChange.ipc$dispatch("1762881876", new Object[]{this})).intValue() : this.b.evictionCount();
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public int getHitCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1110501266") ? ((Integer) ipChange.ipc$dispatch("1110501266", new Object[]{this})).intValue() : this.b.hitCount();
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public int getMissCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-157913361") ? ((Integer) ipChange.ipc$dispatch("-157913361", new Object[]{this})).intValue() : this.b.missCount();
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public V getValue(K k) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "606942936") ? (V) ipChange.ipc$dispatch("606942936", new Object[]{this, k}) : this.b.get(k);
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public boolean shouldTrim() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "235109192") ? ((Boolean) ipChange.ipc$dispatch("235109192", new Object[]{this})).booleanValue() : currentCacheSize() > this.a;
    }

    @Override // com.alibaba.pictures.bricks.util.blur.CachePolicy
    public void trim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341435017")) {
            ipChange.ipc$dispatch("-1341435017", new Object[]{this});
        } else {
            this.b.trimToSize(this.a);
        }
    }
}
