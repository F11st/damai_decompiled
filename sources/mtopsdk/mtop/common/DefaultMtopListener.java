package mtopsdk.mtop.common;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultMtopListener extends DefaultMtopCallback implements MtopCallback.MtopCacheListener {
    private static final String TAG = "mtopsdk.DefaultMtopListener";

    @Override // mtopsdk.mtop.common.MtopCallback.MtopCacheListener
    public void onCached(MtopCacheEvent mtopCacheEvent, Object obj) {
        if (mtopCacheEvent == null || mtopCacheEvent.getMtopResponse() == null || !TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        String str = mtopCacheEvent.seqNo;
        TBSdkLog.d(TAG, str, "[onCached]" + mtopCacheEvent.getMtopResponse().toString());
    }
}
