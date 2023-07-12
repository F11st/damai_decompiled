package com.alibaba.security.biometrics.service.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface OnVideoCodeCallback {
    void outMediaFormat(int i, MediaFormat mediaFormat);

    void outputVideoFrame(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);
}
