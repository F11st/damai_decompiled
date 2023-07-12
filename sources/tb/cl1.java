package tb;

import android.annotation.SuppressLint;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cl1 implements DiskCacheSupplier {
    private final int[] a = {17};
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, DiskCache> b = new HashMap();

    private synchronized DiskCache a(int i) {
        DiskCache diskCache;
        diskCache = this.b.get(Integer.valueOf(i));
        if (diskCache == null) {
            diskCache = new bl1(i);
            this.b.put(Integer.valueOf(i), diskCache);
        }
        return diskCache;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCacheSupplier
    public synchronized DiskCache get(int i) {
        for (int i2 : this.a) {
            if (i2 == i) {
                return a(i);
            }
        }
        return null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCacheSupplier
    public synchronized Collection<DiskCache> getAll() {
        for (int i : this.a) {
            a(i);
        }
        return this.b.values();
    }
}
