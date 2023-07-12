package mtopsdk.mtop.common.listener;

import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopCacheListenerProxy extends MtopBaseListenerProxy implements MtopCallback.MtopCacheListener {
    private static final String TAG = "mtopsdk.MtopCacheListenerProxy";

    public MtopCacheListenerProxy(MtopListener mtopListener) {
        super(mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopCacheListener
    public void onCached(MtopCacheEvent mtopCacheEvent, Object obj) {
        MtopListener mtopListener = this.listener;
        if (mtopListener instanceof MtopCallback.MtopCacheListener) {
            ((MtopCallback.MtopCacheListener) mtopListener).onCached(mtopCacheEvent, obj);
            this.isCached = true;
        }
    }
}
