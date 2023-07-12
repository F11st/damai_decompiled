package mtopsdk.mtop.common;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultMtopCallback implements MtopCallback.MtopFinishListener, MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
    private static final String TAG = "mtopsdk.DefaultMtopCallback";

    @Override // mtopsdk.mtop.common.MtopCallback.MtopProgressListener
    public void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        if (mtopProgressEvent == null || !TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        String str = mtopProgressEvent.seqNo;
        TBSdkLog.d(TAG, str, "[onDataReceived]" + mtopProgressEvent.toString());
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        if (mtopFinishEvent == null || mtopFinishEvent.getMtopResponse() == null || !TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        String str = mtopFinishEvent.seqNo;
        TBSdkLog.d(TAG, str, "[onFinished]" + mtopFinishEvent.getMtopResponse().toString());
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        if (mtopHeaderEvent == null || !TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        String str = mtopHeaderEvent.seqNo;
        TBSdkLog.d(TAG, str, "[onHeader]" + mtopHeaderEvent.toString());
    }
}
