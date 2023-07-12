package tb;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.cache.LruCache;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class be1 implements Builder<LruCache<String, ef>> {
    private boolean a;
    private LruCache<String, ef> b;
    private Context c;
    private Integer d;
    private Float e;
    private ComponentCallbacks2 f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements ComponentCallbacks2 {
        final /* synthetic */ LruCache a;

        a(LruCache lruCache) {
            this.a = lruCache;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            xt2.a(com.taobao.phenix.cache.memory.a.TAG, "ComponentCallbacks2 onTrimMemory, level=%d", Integer.valueOf(i));
            if (i >= 60) {
                this.a.clear();
                xt2.i(com.taobao.phenix.cache.memory.a.TAG, "clear all at TRIM_MEMORY_MODERATE", new Object[0]);
            } else if (i >= 40) {
                int size = this.a.size() / 2;
                this.a.trimTo(size);
                xt2.i(com.taobao.phenix.cache.memory.a.TAG, "trim to size=%d at TRIM_MEMORY_BACKGROUND", Integer.valueOf(size));
            }
        }
    }

    private static int b(Context context) {
        int i;
        long maxMemory = Runtime.getRuntime().maxMemory();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long min = Math.min(maxMemory, activityManager != null ? activityManager.getMemoryClass() * 1048576 : 0L);
        if (min < 33554432) {
            i = 6291456;
        } else {
            i = min < 67108864 ? 10485760 : (int) (min / 5);
        }
        return Math.min(36700160, i);
    }

    private LruCache<String, ef> d(LruCache<String, ef> lruCache) {
        if (Build.VERSION.SDK_INT >= 14) {
            a aVar = new a(lruCache);
            this.f = aVar;
            this.c.registerComponentCallbacks(aVar);
        }
        return lruCache;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: a */
    public synchronized LruCache<String, ef> build() {
        if (this.a) {
            return this.b;
        }
        Context applicationContext = ur1.o().applicationContext();
        this.c = applicationContext;
        cu1.d(applicationContext, "Phenix.with(Context) hasn't been called before MemCacheBuilder building");
        this.a = true;
        LruCache<String, ef> lruCache = this.b;
        if (lruCache != null) {
            int maxSize = lruCache.maxSize();
            float hotPercent = this.b.hotPercent();
            Integer num = this.d;
            int intValue = num != null ? num.intValue() : maxSize;
            Float f = this.e;
            float floatValue = f != null ? f.floatValue() : hotPercent;
            if (maxSize != intValue || Math.abs(hotPercent - floatValue) >= 1.0E-4d) {
                this.b.resize(intValue, floatValue);
            }
            return d(this.b);
        }
        if (this.d == null) {
            this.d = Integer.valueOf(b(this.c));
        }
        if (this.e == null) {
            this.e = Float.valueOf(0.2f);
        }
        com.taobao.phenix.cache.memory.a aVar = new com.taobao.phenix.cache.memory.a(this.d.intValue(), this.e.floatValue());
        this.b = aVar;
        return d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LruCache<String, ef> c() {
        return this.b;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: e */
    public be1 with(LruCache<String, ef> lruCache) {
        cu1.e(!this.a, "MemCacheBuilder has been built, not allow with() now");
        cu1.c(lruCache);
        this.b = lruCache;
        return this;
    }

    protected void finalize() {
        try {
            super.finalize();
            ComponentCallbacks2 componentCallbacks2 = this.f;
            if (componentCallbacks2 != null) {
                this.c.unregisterComponentCallbacks(componentCallbacks2);
            }
        } catch (Throwable unused) {
            if (this.f != null) {
                this.c.unregisterComponentCallbacks(this.f);
            }
        }
    }
}
