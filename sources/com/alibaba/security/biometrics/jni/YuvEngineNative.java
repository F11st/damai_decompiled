package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class YuvEngineNative {
    public static final native void I420ClockWiseRotate90(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void I420ToNv21(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void I420ToYv12(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void Nv12ClockWiseRotate90(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv12ToNv21(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void Nv21ClockWiseRotate180(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ClockWiseRotate270(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ClockWiseRotate90(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ToI420(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void Nv21ToNv12(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void Nv21ToYV12(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void YV12ToNv21(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static final native void Yv12ClockWiseRotate90(long j, byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Yv12ToI420(long j, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void cutCommonYuv(long j, int i, int i2, int i3, byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7);

    public static native void getSpecYuvBuffer(long j, int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5);

    public static native long startYuvEngine();

    public static native void stopYuvEngine(long j);

    public static native void yuvAddWaterMark(long j, int i, int i2, int i3, byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7);
}
