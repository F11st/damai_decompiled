package android.taobao.windvane.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 2230704826523879449L;
    private Object lock;
    private long maxSize;

    public FixedSizeLinkedHashMap() {
        this.maxSize = 10L;
        this.lock = new Object();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        V v;
        synchronized (this.lock) {
            v = (V) super.get(obj);
        }
        return v;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        V v2;
        synchronized (this.lock) {
            v2 = (V) super.put(k, v);
        }
        return v2;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return ((long) size()) > this.maxSize;
    }

    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    public FixedSizeLinkedHashMap(long j) {
        this.maxSize = 10L;
        this.lock = new Object();
        this.maxSize = j;
    }
}
