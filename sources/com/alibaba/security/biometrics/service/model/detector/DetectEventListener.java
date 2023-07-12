package com.alibaba.security.biometrics.service.model.detector;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface DetectEventListener {
    void onDetectFailed(int i, Bundle bundle);

    ABDetectType onDetectSuccess(ABFaceFrame aBFaceFrame, ABDetectType aBDetectType);

    void onError(int i, Bundle bundle);

    void onFrameDetected(long j, ABDetectFrame aBDetectFrame);

    void onMessage(int i, Bundle bundle);
}
