package tb;

import android.annotation.SuppressLint;
import android.app.Application;
import com.taobao.alivfsadapter.AVFSAdapterManager;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class y4 implements DiskCacheSupplier {
    private static final int[] b;
    private static final String[] c = {"top1", "top2", "top3", "top4", "top5"};
    private static final int d;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, DiskCache> a = new HashMap();

    static {
        int[] iArr = {17, 34, 51, 68, 85};
        b = iArr;
        d = iArr.length;
    }

    private synchronized DiskCache a(int i, int i2) {
        x4 x4Var;
        x4Var = (x4) this.a.get(Integer.valueOf(i));
        if (x4Var == null) {
            x4Var = new x4(i, c[i2]);
            this.a.put(Integer.valueOf(i), x4Var);
        }
        return x4Var;
    }

    public void b() {
        try {
            if (AVFSAdapterManager.g().i()) {
                return;
            }
            AVFSAdapterManager.g().c((Application) ur1.o().applicationContext());
        } catch (Throwable th) {
            xt2.c("DiskCache", "alivfs inited error=%s", th);
        }
    }

    @Override // com.taobao.phenix.cache.disk.DiskCacheSupplier
    /* renamed from: c */
    public synchronized x4 get(int i) {
        for (int i2 = 0; i2 < d; i2++) {
            if (b[i2] == i) {
                return (x4) a(i, i2);
            }
        }
        return null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCacheSupplier
    public synchronized Collection<DiskCache> getAll() {
        for (int i = 0; i < d; i++) {
            a(b[i], i);
        }
        return this.a.values();
    }
}
