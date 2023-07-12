package com.alibaba.youku.webp4pexode;

import com.taobao.pexode.animate.AnimatedImage;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WebpImage implements AnimatedImage {
    private static final int LOOP_COUNT_MISSING = -1;
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    private long mNativePtr;
    private int mWidth;

    WebpImage(long j, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        if (j != 0) {
            this.mWidth = i;
            this.mHeigth = i2;
            this.mFrameCount = i3;
            this.mDurationMs = i4;
            this.mFrameDurations = iArr;
            this.mLoopCount = i5;
            fixFrameDurations(iArr);
            this.mBackgroundColor = i6;
            this.mNativePtr = j;
            return;
        }
        throw new RuntimeException("internal error: native WebpImage is 0");
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 20) {
                iArr[i] = 100;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i);

    private native int nativeGetSizeInBytes();

    @Override // com.taobao.pexode.animate.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getDuration() {
        return this.mDurationMs;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getFrameCount() {
        return this.mFrameCount;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getHeight() {
        return this.mHeigth;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getLoopCount() {
        return this.mLoopCount;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public WebpFrame getFrame(int i) {
        return nativeGetFrame(i);
    }
}
