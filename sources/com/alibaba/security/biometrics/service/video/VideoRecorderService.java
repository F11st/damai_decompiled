package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import com.alibaba.security.biometrics.jni.YuvEngineWrap;
import com.alibaba.security.common.e.InterfaceC3826a;
import com.alibaba.security.common.e.InterfaceC3827b;
import com.alibaba.security.common.e.InterfaceC3828c;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VideoRecorderService implements InterfaceC3826a {
    private InterfaceC3826a mCameraVideoRecorder;

    public VideoRecorderService(Context context) {
        this.mCameraVideoRecorder = CameraVideoRecorderFactory.create(context);
    }

    @Override // com.alibaba.security.common.e.InterfaceC3826a
    public void init(int i, int i2, int i3, int i4, String str) {
        YuvEngineWrap.getInstance().startYuvEngine();
        this.mCameraVideoRecorder.init(i, i2, i3, i4, str);
    }

    @Override // com.alibaba.security.common.e.InterfaceC3826a
    public void record(byte[] bArr) {
        this.mCameraVideoRecorder.record(bArr);
    }

    @Override // com.alibaba.security.common.e.InterfaceC3826a
    public void release(InterfaceC3827b interfaceC3827b, boolean z) {
        YuvEngineWrap.getInstance().stopYuvEngine();
        this.mCameraVideoRecorder.release(interfaceC3827b, z);
    }

    @Override // com.alibaba.security.common.e.InterfaceC3826a
    public void setOnH264EncoderListener(InterfaceC3828c interfaceC3828c) {
    }
}
