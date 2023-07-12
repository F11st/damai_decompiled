package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import android.os.Build;
import com.alibaba.security.common.e.a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CameraVideoRecorderFactory {
    public static final a create(Context context) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new MediaCodeApi15CameraVideoRecorder(context);
        }
        return new X264CameraVideoRecorder(context);
    }
}
