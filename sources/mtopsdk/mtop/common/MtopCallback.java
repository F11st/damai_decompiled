package mtopsdk.mtop.common;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopCallback {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MtopCacheListener extends MtopListener {
        void onCached(MtopCacheEvent mtopCacheEvent, Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MtopFinishListener extends MtopListener {
        void onFinished(MtopFinishEvent mtopFinishEvent, Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MtopHeaderListener extends MtopListener {
        void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj);
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes11.dex */
    public interface MtopProgressListener extends MtopListener {
        @Deprecated
        void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj);
    }
}
