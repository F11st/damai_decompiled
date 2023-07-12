package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3818l;
import com.alibaba.security.common.e.InterfaceC3826a;
import com.alibaba.security.common.e.InterfaceC3828c;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class X264CameraVideoRecorder extends BaseCameraVideoRecorder {
    private InterfaceC3826a mCameraVideoReorder;

    public X264CameraVideoRecorder(Context context) {
        super(context);
        try {
            this.mCameraVideoReorder = (InterfaceC3826a) Class.forName("com.alibaba.security.videorecorder.CameraVideoRecorderManager").newInstance();
        } catch (Exception unused) {
            if (C3818l.d(context)) {
                C3800a.c("CameraVideoRecorder", "no camera video recorder ability");
            }
        }
    }

    private boolean isSupportBioRecorder() {
        return this.mCameraVideoReorder != null;
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected boolean canNewStream() {
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected boolean doInit(int i, int i2, int i3, int i4, String str) {
        if (isSupportBioRecorder()) {
            try {
                this.mCameraVideoReorder.init(i, i2, i3, i4, str);
                this.mCameraVideoReorder.setOnH264EncoderListener(new InterfaceC3828c() { // from class: com.alibaba.security.biometrics.service.video.X264CameraVideoRecorder.1
                    @Override // com.alibaba.security.common.e.InterfaceC3828c
                    public void h264(byte[] bArr, int i5) {
                        X264CameraVideoRecorder.this.saveVideo(bArr, i5);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected void doRecord(byte[] bArr, int i, int i2) {
        this.mCameraVideoReorder.record(bArr);
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected void doRelease(boolean z) {
        this.mCameraVideoReorder.release(null, z);
    }
}
