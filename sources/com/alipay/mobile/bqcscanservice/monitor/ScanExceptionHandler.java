package com.alipay.mobile.bqcscanservice.monitor;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ScanExceptionHandler {
    public static final String PREVIEW_RECONNECT_CAMERA = "reconnect_camera";
    public static final String PREVIEW_START_CAMERA = "start_camera";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class TorchException extends Exception {
        public static final int FOCUS_FAILED = 4002;
        public static final int THREAD_FAILED = 4003;
        public static final int TORCH_FAILED = 4001;
        public int errorCode;
        public boolean state;

        public TorchException(boolean z, int i, String str) {
            super(str);
            this.state = z;
            this.errorCode = i;
        }
    }

    public static int getCameraErrorCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2004;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("service")) {
            return 2001;
        }
        if (lowerCase.contains("initial")) {
            return 2002;
        }
        return lowerCase.contains("unknown") ? 2003 : 2004;
    }

    public static int getPreviewErrorCode(String str) {
        if (TextUtils.equals(str, PREVIEW_START_CAMERA)) {
            return 3001;
        }
        return TextUtils.equals(str, PREVIEW_RECONNECT_CAMERA) ? 3002 : 0;
    }
}
