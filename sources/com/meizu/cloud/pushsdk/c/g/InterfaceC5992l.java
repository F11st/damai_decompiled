package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.l */
/* loaded from: classes10.dex */
public interface InterfaceC5992l extends Closeable, Flushable {
    void a(C5982b c5982b, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    void close() throws IOException;

    void flush() throws IOException;
}
