package com.taobao.phenix.cache.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.taobao.phenix.bitmap.BitmapPool;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import tb.ef;
import tb.hh0;
import tb.mz0;
import tb.xt2;

/* compiled from: Taobao */
@TargetApi(19)
/* loaded from: classes11.dex */
public class a extends mz0<String, ef> implements BitmapPool {
    public static final int CEILING_SIZE_MAX_MULTIPLE = 6;
    public static final String TAG = "ImageCachePool";
    public static final String TAG_POOL = "BitmapPool";
    public static final String TAG_RECYCLE = "ImageRecycle";
    private NavigableMap<Integer, List<String>> n;
    private final Object o;
    private int p;
    private int q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.phenix.cache.memory.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class C0322a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(int i, float f) {
        super(i, f);
        this.o = new Object();
        this.n = new TreeMap();
        xt2.a(TAG, "init with maxSize=%K, hotPercent=%.1f%%", Integer.valueOf(i), Float.valueOf(f * 100.0f));
    }

    private int x(Bitmap.Config config) {
        if (config != null) {
            int i = C0322a.a[config.ordinal()];
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2 && i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    private int z(ef efVar) {
        Bitmap bitmap;
        if (!(efVar instanceof StaticCachedImage) || (bitmap = ((StaticCachedImage) efVar).i) == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            return 0;
        }
        return efVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.mz0
    /* renamed from: A */
    public void l(boolean z, String str, ef efVar, boolean z2) {
        List list;
        if (z2) {
            efVar.j();
        } else {
            efVar.i(z);
        }
        synchronized (this.o) {
            if (!z) {
                int z3 = z(efVar);
                if (z3 > 0 && (list = (List) this.n.get(Integer.valueOf(z3))) != null) {
                    if (list.remove(str)) {
                        this.p -= z3;
                        this.s--;
                        xt2.a(TAG_POOL, "remove from bitmap pool when not pre-evicted(cache removed=%b), image=%s", Boolean.valueOf(z2), efVar);
                    }
                    if (list.isEmpty()) {
                        this.n.remove(Integer.valueOf(z3));
                    }
                }
            }
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public int available() {
        return this.p;
    }

    @Override // tb.mz0, com.taobao.phenix.cache.LruCache, com.taobao.phenix.bitmap.BitmapPool
    public final synchronized void clear() {
        super.clear();
        synchronized (this.o) {
            this.p = 0;
            this.s = 0;
            this.n.clear();
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public Bitmap getFromPool(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        int intValue;
        String str;
        ef efVar;
        Bitmap bitmap2;
        int x = i * i2 * x(config);
        synchronized (this.o) {
            bitmap = null;
            if (x > 0) {
                Map.Entry<Integer, List<String>> ceilingEntry = this.n.ceilingEntry(Integer.valueOf(x));
                if (ceilingEntry != null) {
                    intValue = ceilingEntry.getKey().intValue();
                    if (intValue <= x * 6) {
                        List<String> value = ceilingEntry.getValue();
                        if (value.isEmpty()) {
                            str = null;
                        } else {
                            str = value.remove(0);
                            this.p -= intValue;
                            this.s--;
                        }
                        if (value.isEmpty()) {
                            this.n.remove(Integer.valueOf(intValue));
                        }
                    } else {
                        str = null;
                    }
                }
            }
            str = null;
            intValue = 0;
        }
        if (str != null) {
            efVar = o(str, false);
            if ((efVar instanceof StaticCachedImage) && (bitmap2 = ((StaticCachedImage) efVar).i) != null && bitmap2.isMutable() && !bitmap2.isRecycled()) {
                try {
                    bitmap2.reconfigure(i, i2, config);
                    bitmap2.setHasAlpha(true);
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                } catch (Throwable th) {
                    xt2.c(TAG_POOL, "reconfigure error, bitmap=%s, throwable=%s", bitmap2, th);
                }
            }
        } else {
            efVar = null;
        }
        if (bitmap != null) {
            this.q++;
            xt2.a(TAG_POOL, "get from bitmap pool, width=%d, height=%d, config=%s, redundant=%.1f, image=%s", Integer.valueOf(i), Integer.valueOf(i2), config, Float.valueOf(intValue / x), efVar);
        } else {
            this.r++;
        }
        v();
        return bitmap;
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public void maxPoolSize(int i) {
        u(i);
        xt2.a(TAG_POOL, "set preEvictedMaxSize(maxPoolSize=%K) in ImageCacheAndPool", Integer.valueOf(i));
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public boolean putIntoPool(ef efVar) {
        boolean add;
        if (!d(efVar.b())) {
            xt2.a(TAG_POOL, "cannot put into bitmap pool(cache removed), image=%s", efVar);
            return false;
        }
        int z = z(efVar);
        if (z > 0) {
            synchronized (this.o) {
                List list = (List) this.n.get(Integer.valueOf(z));
                if (list == null) {
                    list = new LinkedList();
                    this.n.put(Integer.valueOf(z), list);
                }
                this.p += z;
                this.s++;
                xt2.a(TAG_POOL, "put into bitmap pool, size=%d, image=%s", Integer.valueOf(z), efVar);
                add = list.add(efVar.b());
            }
            return add;
        }
        return false;
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public void trimPool(int i) {
        trimTo(i);
    }

    protected void v() {
        if (hh0.g(3)) {
            int i = this.q;
            xt2.a(TAG_POOL, "%K/%K, rate:%.1f%%, hits:%d, misses:%d, count:%d", Integer.valueOf(this.p), Integer.valueOf(h()), Float.valueOf((i * 100.0f) / (i + this.r)), Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s));
        }
    }

    @Override // tb.mz0, com.taobao.phenix.cache.LruCache
    /* renamed from: w */
    public final ef get(String str) {
        ef efVar = (ef) super.get(str);
        a(TAG);
        return efVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.mz0
    /* renamed from: y */
    public int e(ef efVar) {
        if (efVar == null) {
            return 0;
        }
        return efVar.c();
    }
}
