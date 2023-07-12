package tb;

import android.os.Handler;
import android.util.LruCache;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnAfterCancelDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnBeforeDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnValidateExposeDataListener;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: tb.im */
/* loaded from: classes11.dex */
public class C9266im<ExposeKey, ExposeData> extends AbstractExposure<ExposeKey, ExposeData> {
    private final OnBeforeDataExposeListener<ExposeKey, ExposeData> e;
    private final OnValidateExposeDataListener<ExposeKey, ExposeData> f;
    private final OnDataExposeListener<ExposeKey, ExposeData> g;
    private final OnAfterCancelDataExposeListener<ExposeKey, ExposeData> h;
    private final long i;
    private final Handler j;
    private final int k;
    private final LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> l;

    /* compiled from: Taobao */
    /* renamed from: tb.im$a */
    /* loaded from: classes11.dex */
    public static class C9267a<ExposeKey, ExposeData> implements IExposure.Builder<ExposeKey, ExposeData> {
        private OnBeforeDataExposeListener<ExposeKey, ExposeData> a;
        private OnValidateExposeDataListener<ExposeKey, ExposeData> b;
        private OnDataExposeListener<ExposeKey, ExposeData> c;
        private OnAfterCancelDataExposeListener<ExposeKey, ExposeData> d;
        private long e;
        private Handler f;
        private int g;
        private LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> h;

        @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure.Builder
        /* renamed from: a */
        public C9266im<ExposeKey, ExposeData> build() {
            return new C9266im<>(this.b, this.a, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public C9267a<ExposeKey, ExposeData> b(LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> lruCache) {
            this.h = lruCache;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> c(long j) {
            this.e = j;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> d(Handler handler) {
            this.f = handler;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> e(OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener) {
            this.d = onAfterCancelDataExposeListener;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> f(OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener) {
            this.a = onBeforeDataExposeListener;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> g(OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener) {
            this.c = onDataExposeListener;
            return this;
        }

        public C9267a<ExposeKey, ExposeData> h(OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener) {
            this.b = onValidateExposeDataListener;
            return this;
        }
    }

    public C9266im(OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener, OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener, OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener, OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener, long j, Handler handler, int i, LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> lruCache) {
        this.e = onBeforeDataExposeListener;
        this.f = onValidateExposeDataListener;
        this.g = onDataExposeListener;
        this.h = onAfterCancelDataExposeListener;
        this.i = j;
        this.j = handler;
        this.k = i;
        this.l = lruCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public int b() {
        int i = this.k;
        return i > 0 ? i : super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> d() {
        LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> lruCache = this.l;
        return lruCache != null ? lruCache : super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public Handler e() {
        Handler handler = this.j;
        return handler != null ? handler : super.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public long f() {
        long j = this.i;
        return j > 0 ? j : super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public void i(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener = this.h;
        if (onAfterCancelDataExposeListener != null) {
            onAfterCancelDataExposeListener.onAfterCancelDataExpose(exposekey, exposedata, str);
        } else {
            super.i(exposekey, exposedata, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public boolean j(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener = this.e;
        if (onBeforeDataExposeListener != null) {
            return onBeforeDataExposeListener.onBeforeExposeData(exposekey, exposedata, str);
        }
        return super.j(exposekey, exposedata, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    protected void m(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener = this.g;
        if (onDataExposeListener != null) {
            onDataExposeListener.onDataExpose(exposekey, exposedata, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    protected boolean p(ExposeKey exposekey, ExposeData exposedata, String str, Map<ExposeKey, ExposeData> map) {
        OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener = this.f;
        if (onValidateExposeDataListener != null) {
            return onValidateExposeDataListener.onValidateExposeData(exposekey, exposedata, str, map);
        }
        return false;
    }
}
