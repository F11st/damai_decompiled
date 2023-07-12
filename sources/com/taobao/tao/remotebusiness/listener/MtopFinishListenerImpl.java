package com.taobao.tao.remotebusiness.listener;

import android.os.Looper;
import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.handler.HandlerMgr;
import com.taobao.tao.remotebusiness.handler.HandlerParam;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class MtopFinishListenerImpl extends MtopBaseListener implements MtopCallback.MtopFinishListener {
    private static final String TAG = "mtopsdk.MtopFinishListenerImpl";

    public MtopFinishListenerImpl(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        long j;
        HandlerParam handlerParam;
        String str;
        String str2;
        Class<?> cls;
        String seqNo = this.mtopBusiness.getSeqNo();
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, seqNo, "Mtop onFinished event received.");
        }
        if (this.mtopBusiness.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, seqNo, "The request of MtopBusiness is canceled.");
            }
        } else if (this.listener == null) {
            TBSdkLog.e(TAG, seqNo, "The listener of MtopBusiness is null.");
        } else if (mtopFinishEvent == null) {
            TBSdkLog.e(TAG, seqNo, "MtopFinishEvent is null.");
        } else {
            MtopResponse mtopResponse = mtopFinishEvent.getMtopResponse();
            if (mtopResponse == null) {
                TBSdkLog.e(TAG, seqNo, "The MtopResponse of MtopFinishEvent is null.");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            MtopListener mtopListener = this.listener;
            if (mtopListener instanceof IRemoteParserListener) {
                try {
                    ((IRemoteParserListener) mtopListener).parseResponse(mtopResponse);
                } catch (Exception e) {
                    TBSdkLog.e(TAG, seqNo, "listener parseResponse callback error.", e);
                }
            }
            HandlerParam handlerMsg = HandlerMgr.getHandlerMsg(this.listener, mtopFinishEvent, this.mtopBusiness);
            handlerMsg.mtopResponse = mtopResponse;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!mtopResponse.isApiSuccess() || (cls = this.mtopBusiness.clazz) == null) {
                j = currentTimeMillis2;
            } else {
                handlerMsg.pojo = MtopConvert.mtopResponseToOutputDO(mtopResponse, cls);
                j = System.currentTimeMillis();
            }
            this.mtopBusiness.onBgFinishTime = j;
            MtopStatistics mtopStat = mtopResponse.getMtopStat();
            MtopStatistics.RbStatisticData rbStatisticData = null;
            if (mtopStat != null) {
                rbStatisticData = mtopStat.getRbStatData();
                MtopBusiness mtopBusiness = this.mtopBusiness;
                long j2 = mtopBusiness.sendStartTime;
                handlerParam = handlerMsg;
                long j3 = mtopBusiness.reqStartTime;
                str = seqNo;
                rbStatisticData.beforeReqTime = j2 - j3;
                rbStatisticData.mtopReqTime = currentTimeMillis - j2;
                long j4 = mtopBusiness.onBgFinishTime;
                rbStatisticData.afterReqTime = j4 - currentTimeMillis;
                rbStatisticData.parseTime = currentTimeMillis2 - currentTimeMillis;
                long j5 = j - currentTimeMillis2;
                rbStatisticData.jsonParseTime = j5;
                rbStatisticData.jsonTime = j5;
                long j6 = j4 - j3;
                rbStatisticData.rbReqTime = j6;
                rbStatisticData.totalTime = j6;
                long currentTimeMillis3 = mtopStat.currentTimeMillis();
                mtopStat = mtopStat;
                rbStatisticData.mtopDispatchTime = currentTimeMillis3 - mtopStat.startCallbackTime;
            } else {
                handlerParam = handlerMsg;
                str = seqNo;
            }
            if (this.mtopBusiness.mtopProp.handler != null) {
                TBSdkLog.LogEnable logEnable2 = TBSdkLog.LogEnable.InfoEnable;
                if (TBSdkLog.isLogEnable(logEnable2)) {
                    str2 = str;
                    TBSdkLog.i(TAG, str2, "onReceive: ON_FINISHED in self-defined handler.");
                } else {
                    str2 = str;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                if (mtopStat != null) {
                    mtopStat.rspCbStart = System.currentTimeMillis();
                }
                HandlerParam handlerParam2 = handlerParam;
                handlerParam2.mtopBusiness.doFinish(handlerParam2.mtopResponse, handlerParam2.pojo);
                if (mtopStat != null) {
                    mtopStat.rspCbEnd = System.currentTimeMillis();
                    mtopStat.commitFullTrace();
                }
                if (TBSdkLog.isLogEnable(logEnable2)) {
                    long length = handlerParam2.mtopResponse.getBytedata() != null ? handlerParam2.mtopResponse.getBytedata().length : 0L;
                    StringBuilder sb = new StringBuilder(128);
                    sb.append("onReceive: ON_FINISHED in self-defined handler.");
                    sb.append("doFinishTime=");
                    sb.append(System.currentTimeMillis() - currentTimeMillis4);
                    sb.append(", dataSize=");
                    sb.append(length);
                    sb.append("; ");
                    if (rbStatisticData != null) {
                        sb.append(rbStatisticData.toString());
                    }
                    TBSdkLog.i(TAG, str2, sb.toString());
                }
                if (mtopStat != null) {
                    mtopStat.isMain = this.mtopBusiness.mtopProp.handler.getLooper().equals(Looper.getMainLooper());
                    mtopStat.commitStatData(true);
                    return;
                }
                return;
            }
            HandlerParam handlerParam3 = handlerParam;
            if (mtopStat != null) {
                mtopStat.rspCbDispatch = System.currentTimeMillis();
            }
            HandlerMgr.instance().obtainMessage(3, handlerParam3).sendToTarget();
        }
    }
}
