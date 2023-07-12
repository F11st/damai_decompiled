package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.handler.HandlerMgr;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class MtopProgressListenerImpl extends MtopBaseListener implements MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
    private static final String TAG = "mtopsdk.MtopProgressListenerImpl";

    public MtopProgressListenerImpl(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopProgressListener
    public void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        String seqNo = this.mtopBusiness.getSeqNo();
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, seqNo, "Mtop onDataReceived event received.");
        }
        if (this.mtopBusiness.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, seqNo, "The request of MtopBusiness is cancelled.");
                return;
            }
            return;
        }
        MtopListener mtopListener = this.listener;
        if (mtopListener instanceof IRemoteProcessListener) {
            MtopBusiness mtopBusiness = this.mtopBusiness;
            if (mtopBusiness.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.i(TAG, seqNo, "onReceive: ON_DATA_RECEIVED in self-defined handler.");
                }
                try {
                    ((IRemoteProcessListener) this.listener).onDataReceived(mtopProgressEvent, obj);
                    return;
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, seqNo, "listener onDataReceived callback error in self-defined handler.", th);
                    return;
                }
            }
            HandlerMgr.instance().obtainMessage(1, HandlerMgr.getHandlerMsg(mtopListener, mtopProgressEvent, mtopBusiness)).sendToTarget();
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        String seqNo = this.mtopBusiness.getSeqNo();
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, seqNo, "Mtop onHeader event received.");
        }
        if (this.mtopBusiness.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, seqNo, "The request of MtopBusiness is cancelled.");
                return;
            }
            return;
        }
        MtopListener mtopListener = this.listener;
        if (mtopListener instanceof IRemoteProcessListener) {
            MtopBusiness mtopBusiness = this.mtopBusiness;
            if (mtopBusiness.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.i(TAG, seqNo, "onReceive: ON_HEADER in self-defined handler.");
                }
                try {
                    ((IRemoteProcessListener) this.listener).onHeader(mtopHeaderEvent, obj);
                    return;
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, seqNo, "listener onHeader callback error in self-defined handler.", th);
                    return;
                }
            }
            HandlerMgr.instance().obtainMessage(2, HandlerMgr.getHandlerMsg(mtopListener, mtopHeaderEvent, mtopBusiness)).sendToTarget();
        }
    }
}
