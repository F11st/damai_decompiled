package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.handler.HandlerMgr;
import com.taobao.tao.remotebusiness.handler.HandlerParam;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class MtopCacheListenerImpl extends MtopBaseListener implements MtopCallback.MtopCacheListener {
    private static final String TAG = "mtopsdk.MtopCacheListenerImpl";

    public MtopCacheListenerImpl(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopCacheListener
    public void onCached(MtopCacheEvent mtopCacheEvent, Object obj) {
        MtopStatistics.RbStatisticData rbStatisticData;
        Class<?> cls;
        String seqNo = this.mtopBusiness.getSeqNo();
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, seqNo, "Mtop onCached event received. apiKey=" + this.mtopBusiness.request.getKey());
        }
        if (this.mtopBusiness.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, seqNo, "The request of MtopBusiness is cancelled.");
            }
        } else if (this.listener == null) {
            TBSdkLog.e(TAG, seqNo, "The listener of MtopBusiness is null.");
        } else if (mtopCacheEvent == null) {
            TBSdkLog.e(TAG, seqNo, "MtopCacheEvent is null.");
        } else {
            MtopResponse mtopResponse = mtopCacheEvent.getMtopResponse();
            if (mtopResponse == null) {
                TBSdkLog.e(TAG, seqNo, "The MtopResponse of MtopCacheEvent is null.");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            BaseOutDo mtopResponseToOutputDO = (!mtopResponse.isApiSuccess() || (cls = this.mtopBusiness.clazz) == null) ? null : MtopConvert.mtopResponseToOutputDO(mtopResponse, cls);
            long currentTimeMillis3 = System.currentTimeMillis();
            this.mtopBusiness.onBgFinishTime = currentTimeMillis3;
            MtopStatistics mtopStat = mtopResponse.getMtopStat();
            if (mtopStat != null) {
                rbStatisticData = mtopStat.getRbStatData();
                long j = currentTimeMillis3 - currentTimeMillis2;
                rbStatisticData.jsonParseTime = j;
                rbStatisticData.jsonTime = j;
                rbStatisticData.isCache = 1;
                MtopBusiness mtopBusiness = this.mtopBusiness;
                rbStatisticData.mtopReqTime = currentTimeMillis - mtopBusiness.sendStartTime;
                long j2 = mtopBusiness.onBgFinishTime - mtopBusiness.reqStartTime;
                rbStatisticData.rbReqTime = j2;
                rbStatisticData.totalTime = j2;
            } else {
                rbStatisticData = null;
            }
            HandlerParam handlerMsg = HandlerMgr.getHandlerMsg(this.listener, mtopCacheEvent, this.mtopBusiness);
            handlerMsg.pojo = mtopResponseToOutputDO;
            handlerMsg.mtopResponse = mtopResponse;
            MtopBusiness mtopBusiness2 = this.mtopBusiness;
            mtopBusiness2.isCached = true;
            if (mtopBusiness2.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.i(TAG, seqNo, "onReceive: ON_CACHED in self-defined handler.");
                }
                if (mtopStat != null) {
                    if (rbStatisticData != null && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d(TAG, seqNo, rbStatisticData.toString());
                    }
                    mtopStat.commitStatData(true);
                }
                try {
                    if (handlerMsg.listener instanceof IRemoteCacheListener) {
                        TBSdkLog.i(TAG, seqNo, "listener onCached callback");
                        ((IRemoteCacheListener) handlerMsg.listener).onCached(mtopCacheEvent, handlerMsg.pojo, obj);
                        return;
                    }
                    TBSdkLog.i(TAG, seqNo, "listener onCached transfer to onSuccess callback");
                    ((IRemoteListener) handlerMsg.listener).onSuccess(handlerMsg.mtopBusiness.getRequestType(), handlerMsg.mtopResponse, handlerMsg.pojo, obj);
                    return;
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, seqNo, "listener onCached callback error in self-defined handler.", th);
                    return;
                }
            }
            HandlerMgr.instance().obtainMessage(4, handlerMsg).sendToTarget();
        }
    }
}
