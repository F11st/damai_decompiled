package com.taobao.pexode.decoder;

import android.graphics.Bitmap;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImageFrame;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GifFrame implements AnimatedImageFrame {
    private int mFrameNumber;
    private long mNativeContext;

    GifFrame(long j) {
        this.mNativeContext = j;
    }

    private static AnimatedDrawableFrameInfo.DisposalMode fromGifDisposalMethod(int i) {
        if (i == 0) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDisposalMode();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeHasTransparency();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    protected void finalize() {
        nativeFinalize();
    }

    public int getDisposalMode() {
        return nativeGetDisposalMode();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getDurationMs() {
        return nativeGetDurationMs();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public AnimatedDrawableFrameInfo getFrameInfo() {
        return new AnimatedDrawableFrameInfo(this.mFrameNumber, getXOffset(), getYOffset(), getWidth(), getHeight(), AnimatedDrawableFrameInfo.BlendMode.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(getDisposalMode()));
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

    public boolean hasTransparency() {
        return nativeHasTransparency();
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public void setFrameNumber(int i) {
        this.mFrameNumber = i;
    }
}
