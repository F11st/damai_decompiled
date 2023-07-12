package com.taobao.pexode.decoder;

import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.pexode.entity.RewindableStream;
import java.io.FileDescriptor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class APngImage implements AnimatedImage {
    private static final int LOOP_COUNT_MISSING = -1;
    private long mNativePtr;

    APngImage(long j) {
        this.mNativePtr = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native APngImage nativeCreateFromBytes(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native APngImage nativeCreateFromFd(FileDescriptor fileDescriptor);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native APngImage nativeCreateFromRewindableStream(RewindableStream rewindableStream, byte[] bArr);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native APngFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int nativeLoadedVersionTest();

    @Override // com.taobao.pexode.animate.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getDuration() {
        return nativeGetDuration();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount == -1) {
            return 1;
        }
        return nativeGetLoopCount;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public APngFrame getFrame(int i) {
        return nativeGetFrame(i);
    }
}
