package com.alipay.camera.util;

import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraFocusParamConfig {
    public static int DEFAULT_INTERVAL = 5000;
    private static int e = 5000;
    private String a;
    private String b;
    private String c;
    private long d;

    public CameraFocusParamConfig() {
        if (FocusWhiteList.inWhiteList()) {
            this.b = "continuous-picture";
        } else {
            this.b = "auto";
        }
    }

    public static void updateThresholdSwitchToAutoDuration(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e = Integer.parseInt(str);
        } catch (Throwable unused) {
        }
    }

    public void confirmInitFocusMode(String str) {
        if (TextUtils.equals(str, this.b)) {
            return;
        }
        this.b = str;
        this.c = null;
        this.d = 0L;
    }

    public boolean getInitFocusAuto() {
        return TextUtils.equals(this.a, "auto") && TextUtils.equals(this.b, "auto");
    }

    public String getInitFocusMode() {
        return this.b;
    }

    public String getMode() {
        return this.a;
    }

    public long getSecondDuration() {
        return this.d;
    }

    public String getSecondFocusMode() {
        return this.c;
    }

    public void postValidFocusMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        updateFocusMode(str);
    }

    public void setSecondDelayDuration(long j) {
        this.d = j;
    }

    public void setSecondFocusMode(String str) {
        this.c = str;
    }

    public void updateFocusMode(String str) {
        this.a = str;
        if ("debug".equalsIgnoreCase(str)) {
            this.b = "auto";
            this.c = null;
            this.d = 0L;
        } else if ("auto".equalsIgnoreCase(str)) {
            this.b = "auto";
            this.c = null;
            this.d = 0L;
        } else if (BQCCameraParam.FOCUS_TYPE_C_PICTURE.equalsIgnoreCase(str)) {
            this.b = "continuous-picture";
            this.c = null;
            this.d = 0L;
        } else if (BQCCameraParam.FOCUS_TYPE_C_VIDEO.equalsIgnoreCase(str)) {
            this.b = "continuous-video";
            this.c = null;
            this.d = 0L;
        } else if (BQCCameraParam.FOCUS_TYPE_WX.equalsIgnoreCase(str)) {
            this.b = "continuous-picture";
            this.c = "auto";
            this.d = e;
        } else if (BQCCameraParam.FOCUS_TYPE_MACRO.equalsIgnoreCase(str)) {
            this.b = BQCCameraParam.FOCUS_TYPE_MACRO;
            this.c = null;
            this.d = 0L;
        } else if (BQCCameraParam.FOCUS_TYPE_EDOF.equalsIgnoreCase(str)) {
            this.b = BQCCameraParam.FOCUS_TYPE_EDOF;
            this.c = null;
            this.d = 0L;
        }
    }
}
