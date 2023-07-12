package com.taobao.tcommon.core;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface BytesPool {
    public static final int COMMON_BUFFER_SIZE = 32768;
    public static final int SHORT_BUFFER_SIZE = 8192;

    void clear();

    byte[] offer(int i);

    byte[] offerMaxAvailable();

    void release(byte[] bArr);

    void resize(int i);
}
