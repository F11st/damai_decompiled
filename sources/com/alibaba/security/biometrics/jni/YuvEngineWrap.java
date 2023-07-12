package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class YuvEngineWrap {
    private static Object lockobj = new Object();
    private static YuvEngineWrap mInstance;
    private long cPtr = 0;

    private YuvEngineWrap() {
    }

    public static YuvEngineWrap getInstance() {
        synchronized (lockobj) {
            if (mInstance == null) {
                mInstance = new YuvEngineWrap();
            }
        }
        return mInstance;
    }

    public void I420ClockWiseRotate90(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.I420ClockWiseRotate90(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void I420ToNv21(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.I420ToNv21(j, bArr, bArr2, i, i2);
        }
    }

    public void I420ToYv12(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.I420ToYv12(j, bArr, bArr2, i, i2);
        }
    }

    public void Nv12ClockWiseRotate90(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv12ClockWiseRotate90(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void Nv12ToNv21(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv12ToNv21(j, bArr, bArr2, i, i2);
        }
    }

    public void Nv21ClockWiseRotate180(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ClockWiseRotate180(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ClockWiseRotate270(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ClockWiseRotate270(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ClockWiseRotate90(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ClockWiseRotate90(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ToI420(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ToI420(j, bArr, bArr2, i, i2);
        }
    }

    public void Nv21ToNv12(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ToNv12(j, bArr, bArr2, i, i2);
        }
    }

    public void Nv21ToYv12(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Nv21ToYV12(j, bArr, bArr2, i, i2);
        }
    }

    public void Yv12ClockWiseRotate90(byte[] bArr, int i, int i2, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Yv12ClockWiseRotate90(j, bArr, i, i2, bArr2, iArr, iArr2);
        }
    }

    public void Yv12ToI420(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.Yv12ToI420(j, bArr, bArr2, i, i2);
        }
    }

    public void Yv12ToNv21(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.YV12ToNv21(j, bArr, bArr2, i, i2);
        }
    }

    public void cutCommonYuv(int i, int i2, int i3, byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.cutCommonYuv(j, i, i2, i3, bArr, i4, i5, bArr2, i6, i7);
        }
    }

    public void getSpecYuvBuffer(int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.getSpecYuvBuffer(j, i, bArr, bArr2, i2, i3, i4, i5);
        }
    }

    public void startYuvEngine() {
        this.cPtr = YuvEngineNative.startYuvEngine();
    }

    public void stopYuvEngine() {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.stopYuvEngine(j);
        }
        mInstance = null;
    }

    public void yuvAddWaterMark(int i, int i2, int i3, byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7) {
        long j = this.cPtr;
        if (j != 0) {
            YuvEngineNative.yuvAddWaterMark(j, i, i2, i3, bArr, i4, i5, bArr2, i6, i7);
        }
    }
}
