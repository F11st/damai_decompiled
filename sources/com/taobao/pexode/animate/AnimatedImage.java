package com.taobao.pexode.animate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface AnimatedImage {
    void dispose();

    boolean doesRenderSupportScaling();

    int getDuration();

    AnimatedImageFrame getFrame(int i);

    int getFrameCount();

    int[] getFrameDurations();

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
