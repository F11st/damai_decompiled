package tb;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import tb.C9266im;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class o50<ExposeKey, ExposeData> implements IExposureCenter<ExposeKey, ExposeData, AbstractExposure.C6406a<ExposeData>> {
    private final Handler a;
    private final LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> b;

    public o50() {
        this(new Handler(Looper.getMainLooper()), new LruCache(8));
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public IExposure<ExposeKey, ExposeData> buildExposure(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle) {
        return buildExposure(exposureLifecycle, 0L);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> globalCache() {
        return this.b;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public Handler globalHandler() {
        return this.a;
    }

    public o50(Handler handler, LruCache<ExposeKey, AbstractExposure.C6406a<ExposeData>> lruCache) {
        this.a = handler;
        this.b = lruCache;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public IExposure<ExposeKey, ExposeData> buildExposure(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle, long j) {
        C9266im.C9267a c9267a = new C9266im.C9267a();
        if (j > 0) {
            c9267a.c(j);
        }
        c9267a.f(exposureLifecycle).h(exposureLifecycle).d(this.a).b(this.b).g(exposureLifecycle).e(exposureLifecycle);
        return c9267a.build();
    }
}
