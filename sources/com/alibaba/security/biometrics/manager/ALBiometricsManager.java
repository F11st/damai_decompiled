package com.alibaba.security.biometrics.manager;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.activity.ALBiometricsActivity;
import com.alibaba.security.biometrics.c.b.C3750a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.model.TrackLog;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsManager {
    private static final String TAG = "ALBiometricsManager";
    private ALBiometricsConfig alBiometricsConfig;
    private final Context mContext;
    private ALBiometricsEventListener mEventListener;
    private ALBiometricsParams mParams = new ALBiometricsParams();
    private Bundle mParamsBundle = new Bundle();

    public ALBiometricsManager(Context context) {
        this.mContext = context;
    }

    private void collectLog(TrackLog trackLog) {
        getEventListener().onLogTrack(trackLog);
    }

    public ALBiometricsConfig getAlBiometricsConfig() {
        if (this.alBiometricsConfig == null) {
            this.alBiometricsConfig = new ALBiometricsConfig.Builder().build();
        }
        return this.alBiometricsConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ALBiometricsEventListener getEventListener() {
        return this.mEventListener;
    }

    public ALBiometricsParams getParams() {
        return this.mParams;
    }

    public Bundle getParamsBundle() {
        return this.mParamsBundle;
    }

    public void open(Context context) {
        C3750a.b().a(getEventListener());
        ALBiometricsActivity.a(context, this);
    }

    public void setAlBiometricsConfig(ALBiometricsConfig aLBiometricsConfig) {
        this.alBiometricsConfig = aLBiometricsConfig;
    }

    public void setEventListener(ALBiometricsEventListener aLBiometricsEventListener) {
        this.mEventListener = aLBiometricsEventListener;
    }

    public ALBiometricsManager setParams(Bundle bundle, ALBiometricsParams aLBiometricsParams) {
        this.mParams = aLBiometricsParams;
        this.mParamsBundle = bundle;
        return this;
    }
}
