package com.taobao.pexode.decoder;

import android.graphics.Bitmap;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImageFrame;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class APngFrame implements AnimatedImageFrame {
    private final int mFrameNumber;
    private final long mNativePtr;

    APngFrame(long j, int i) {
        this.mNativePtr = j;
        this.mFrameNumber = i;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetBlendMode();

    private native int nativeGetDisposalMode();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private static AnimatedDrawableFrameInfo.BlendMode transformNativeBlendMode(int i) {
        if (i == 1) {
            return AnimatedDrawableFrameInfo.BlendMode.BLEND_WITH_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.BlendMode.NO_BLEND;
    }

    private static AnimatedDrawableFrameInfo.DisposalMode transformNativeDisposalMode(int i) {
        if (i == 1) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND;
        }
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getDurationMs() {
        return nativeGetDurationMs();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public AnimatedDrawableFrameInfo getFrameInfo() {
        return new AnimatedDrawableFrameInfo(this.mFrameNumber, getXOffset(), getYOffset(), getWidth(), getHeight(), transformNativeBlendMode(nativeGetBlendMode()), transformNativeDisposalMode(nativeGetDisposalMode()));
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getXOffset() {
        return nativeGetXOffset();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getYOffset() {
        return nativeGetYOffset();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }
}
