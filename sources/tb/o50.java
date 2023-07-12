package tb;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import tb.im;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class o50<ExposeKey, ExposeData> implements IExposureCenter<ExposeKey, ExposeData, AbstractExposure.a<ExposeData>> {
    private final Handler a;
    private final LruCache<ExposeKey, AbstractExposure.a<ExposeData>> b;

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
    public LruCache<ExposeKey, AbstractExposure.a<ExposeData>> globalCache() {
        return this.b;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public Handler globalHandler() {
        return this.a;
    }

    public o50(Handler handler, LruCache<ExposeKey, AbstractExposure.a<ExposeData>> lruCache) {
        this.a = handler;
        this.b = lruCache;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter
    @NonNull
    public IExposure<ExposeKey, ExposeData> buildExposure(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle, long j) {
        im.a aVar = new im.a();
        if (j > 0) {
            aVar.c(j);
        }
        aVar.f(exposureLifecycle).h(exposureLifecycle).d(this.a).b(this.b).g(exposureLifecycle).e(exposureLifecycle);
        return aVar.build();
    }
}
