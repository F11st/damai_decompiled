package com.taobao.pexode.decoder;

import com.taobao.pexode.animate.AnimatedImage;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GifImage implements AnimatedImage {
    private static final int LOOP_COUNT_FOREVER = 0;
    private static final int LOOP_COUNT_INFINITE = 0;
    private static final int LOOP_COUNT_MISSING = -1;
    private long mNativeContext;

    GifImage(long j) {
        this.mNativeContext = j;
    }

    public static GifImage create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native GifImage nativeCreateFromFileDescriptor(FileDescriptor fileDescriptor);

    private static native GifImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

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
        if (nativeGetLoopCount != -1) {
            if (nativeGetLoopCount != 0) {
                return nativeGetLoopCount + 1;
            }
            return 0;
        }
        return 1;
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    public static GifImage create(byte[] bArr, int i, int i2) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        allocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(allocateDirect);
    }

    @Override // com.taobao.pexode.animate.AnimatedImage
    public GifFrame getFrame(int i) {
        GifFrame nativeGetFrame = nativeGetFrame(i);
        nativeGetFrame.setFrameNumber(i);
        return nativeGetFrame;
    }

    public static GifImage create(FileDescriptor fileDescriptor) {
        return nativeCreateFromFileDescriptor(fileDescriptor);
    }

    public static GifImage create(long j, int i) {
        return nativeCreateFromNativeMemory(j, i);
    }
}
