package com.alibaba.youku.webp4pexode;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImageFrame;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WebpFrame implements AnimatedImageFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 20;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;
    int ih;
    int iw;
    int ix;
    int iy;
    private final int mFrameNumber = 1;
    @Keep
    private final long mNativePtr;

    WebpFrame(long j, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.mNativePtr = j;
        this.ix = i;
        this.iy = i2;
        this.iw = i3;
        this.ih = i4;
        this.delay = i5;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z2;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 20) {
            this.delay = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private AnimatedDrawableFrameInfo.BlendMode transformNativeBlendMode() {
        if (this.blendPreviousFrame) {
            return AnimatedDrawableFrameInfo.BlendMode.BLEND_WITH_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.BlendMode.NO_BLEND;
    }

    private AnimatedDrawableFrameInfo.DisposalMode transformNativeDisposalMode() {
        if (this.disposeBackgroundColor) {
            return AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND;
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
        return this.delay;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public AnimatedDrawableFrameInfo getFrameInfo() {
        return new AnimatedDrawableFrameInfo(1, getXOffset(), getYOffset(), getWidth(), getHeight(), transformNativeBlendMode(), transformNativeDisposalMode());
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getHeight() {
        return this.ih;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getWidth() {
        return this.iw;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getXOffset() {
        return this.ix;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public int getYOffset() {
        return this.iy;
    }

    @Override // com.taobao.pexode.animate.AnimatedImageFrame
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }
}
