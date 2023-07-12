package cn.damai.common.cache.memory;

import androidx.collection.LruCache;
import cn.damai.common.cache.common.CachePolicy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class LruCachePolicy<K, V> implements CachePolicy<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private LruCache<K, V> b;

    public LruCachePolicy() {
        int maxCacheSize = maxCacheSize();
        this.a = maxCacheSize;
        if (maxCacheSize > 0) {
            this.b = new LruCache<K, V>(maxCacheSize) { // from class: cn.damai.common.cache.memory.LruCachePolicy.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.collection.LruCache
                protected void entryRemoved(boolean z, K k, V v, V v2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1704462287")) {
                        ipChange.ipc$dispatch("1704462287", new Object[]{this, Boolean.valueOf(z), k, v, v2});
                    } else {
                        LruCachePolicy.this.a(z, k, v, v2);
                    }
                }

                @Override // androidx.collection.LruCache
                protected int sizeOf(K k, V v) {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "155990714") ? ((Integer) ipChange.ipc$dispatch("155990714", new Object[]{this, k, v})).intValue() : LruCachePolicy.this.computeValueSize(v);
                }
            };
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public abstract void a(boolean z, K k, V v, V v2);

    @Override // cn.damai.common.cache.common.CachePolicy
    public V cacheValue(K k, V v) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1719640881") ? (V) ipChange.ipc$dispatch("-1719640881", new Object[]{this, k, v}) : this.b.put(k, v);
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264222365")) {
            ipChange.ipc$dispatch("-1264222365", new Object[]{this});
        } else {
            this.b.evictAll();
        }
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int currentCacheSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-175671869") ? ((Integer) ipChange.ipc$dispatch("-175671869", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int evictionCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1325308269") ? ((Integer) ipChange.ipc$dispatch("-1325308269", new Object[]{this})).intValue() : this.b.evictionCount();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int getHitCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1867063441") ? ((Integer) ipChange.ipc$dispatch("1867063441", new Object[]{this})).intValue() : this.b.hitCount();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public int getMissCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1820677584") ? ((Integer) ipChange.ipc$dispatch("1820677584", new Object[]{this})).intValue() : this.b.missCount();
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public V getValue(K k) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2085204951") ? (V) ipChange.ipc$dispatch("2085204951", new Object[]{this, k}) : this.b.get(k);
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public boolean shouldTrim() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1922082409") ? ((Boolean) ipChange.ipc$dispatch("1922082409", new Object[]{this})).booleanValue() : currentCacheSize() > this.a;
    }

    @Override // cn.damai.common.cache.common.CachePolicy
    public void trim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541690536")) {
            ipChange.ipc$dispatch("-1541690536", new Object[]{this});
        } else {
            this.b.trimToSize(this.a);
        }
    }
}
