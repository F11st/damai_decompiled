package com.alibaba.security.biometrics.service;

import android.content.Context;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.state.ABStateMachine;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.model.TrackLog;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsService {
    private static final String TAG = "ALBiometricsService";
    private ALBiometricsParams mALBiometricsParams;
    private boolean mIsCollectAlgoStartLog;
    private Context mContext = null;
    private ABStateMachine mABStateMachine = null;
    private ALBiometricsServiceEventListener mABEventListener = null;
    private boolean bRunning = false;

    public ALBiometricsService(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        init(context, aLBiometricsParams, aLBiometricsServiceEventListener);
    }

    private String algoStartParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.mALBiometricsParams.mBiometricsType) ? "colorful" : "action");
        return C3811h.a((Object) hashMap);
    }

    private void init(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.mContext = context;
        this.mABEventListener = aLBiometricsServiceEventListener;
        this.mALBiometricsParams = aLBiometricsParams;
        this.mABStateMachine = new ABStateMachine(this);
    }

    public void collectLog(TrackLog trackLog) {
        ALBiometricsServiceEventListener aLBiometricsServiceEventListener = this.mABEventListener;
        if (aLBiometricsServiceEventListener != null) {
            aLBiometricsServiceEventListener.onLogTrack(trackLog);
        }
    }

    public ALBiometricsServiceEventListener getABEventListener() {
        return this.mABEventListener;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ALBiometricsParams getParams() {
        return this.mALBiometricsParams;
    }

    public void process(byte[] bArr, int i, int i2, int i3) {
        if (this.bRunning) {
            this.mABStateMachine.processFrame(bArr, i, i2, i3);
        }
    }

    public void release() {
        if (this.bRunning) {
            stop();
        }
        ABStateMachine aBStateMachine = this.mABStateMachine;
        if (aBStateMachine != null) {
            aBStateMachine.release();
        }
        ABLogRecorder.releaseI();
    }

    public void resetBioTimeOut(int i) {
        this.mABStateMachine.resetBioTimeOut(i);
    }

    public void restart() {
        if (this.bRunning) {
            return;
        }
        if (!this.mIsCollectAlgoStartLog) {
            collectLog(TrackLog.createBioMonitorAlgoStartLog(algoStartParams()));
            this.mIsCollectAlgoStartLog = true;
        }
        this.mABStateMachine.restartDetect();
        this.bRunning = true;
    }

    public ALBiometricsService setParams(ALBiometricsParams aLBiometricsParams) {
        this.mALBiometricsParams = aLBiometricsParams;
        return this;
    }

    public void start() {
        if (this.bRunning) {
            return;
        }
        ABLogRecorder.i().setOnLogRecordListener(this.mABEventListener);
        if (!this.mIsCollectAlgoStartLog) {
            collectLog(TrackLog.createBioMonitorAlgoStartLog(algoStartParams()));
            this.mIsCollectAlgoStartLog = true;
        }
        this.mABStateMachine.startDetect();
        this.bRunning = true;
    }

    public void stop() {
        if (this.bRunning) {
            this.bRunning = false;
            this.mABStateMachine.stopDetect();
        }
    }
}
