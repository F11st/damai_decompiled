package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import com.alibaba.security.biometrics.jni.YuvEngineWrap;
import com.alibaba.security.common.e.a;
import com.alibaba.security.common.e.b;
import com.alibaba.security.common.e.c;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VideoRecorderService implements a {
    private a mCameraVideoRecorder;

    public VideoRecorderService(Context context) {
        this.mCameraVideoRecorder = CameraVideoRecorderFactory.create(context);
    }

    @Override // com.alibaba.security.common.e.a
    public void init(int i, int i2, int i3, int i4, String str) {
        YuvEngineWrap.getInstance().startYuvEngine();
        this.mCameraVideoRecorder.init(i, i2, i3, i4, str);
    }

    @Override // com.alibaba.security.common.e.a
    public void record(byte[] bArr) {
        this.mCameraVideoRecorder.record(bArr);
    }

    @Override // com.alibaba.security.common.e.a
    public void release(b bVar, boolean z) {
        YuvEngineWrap.getInstance().stopYuvEngine();
        this.mCameraVideoRecorder.release(bVar, z);
    }

    @Override // com.alibaba.security.common.e.a
    public void setOnH264EncoderListener(c cVar) {
    }
}
