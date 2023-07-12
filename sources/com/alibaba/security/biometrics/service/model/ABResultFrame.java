package com.alibaba.security.biometrics.service.model;

import android.graphics.RectF;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.DetectInfo;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABResultFrame extends ABFaceFrame {
    protected int faceDetected;
    protected int imageAngle;
    protected byte[] imageData;
    protected int imageHeight;
    protected int imageWidth;
    protected float iso;

    public ABResultFrame(byte[] bArr, int i, int i2, int i3, int i4, float f) {
        this.imageData = bArr;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.imageAngle = i3;
        this.faceDetected = i4;
        this.iso = f;
        DetectInfo detectInfo = new DetectInfo();
        this.detectInfo = detectInfo;
        detectInfo.setFaceQuality(-1.0f);
        this.detectInfo.setStaticQuality(-1.0f);
        this.detectInfo.setBrightness(-1.0f);
        this.detectInfo.setGaussianBlur(-1.0f);
        this.detectInfo.setMotionBlur(-1.0f);
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int facesDetected() {
        return this.faceDetected;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public RectF getFacePos() {
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getFaceQuality() {
        return -1.0f;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageAngle() {
        return this.imageAngle;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public byte[] getImageData() {
        return this.imageData;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getIso() {
        return this.iso;
    }

    public String toString() {
        return "ResultFaceFrame{imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageAngle=" + this.imageAngle + ", faceDetected=" + this.faceDetected + ", detectInfo=" + this.detectInfo + '}';
    }
}
