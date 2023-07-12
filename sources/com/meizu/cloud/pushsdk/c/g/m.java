package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface m extends Closeable {
    long b(b bVar, long j) throws IOException;

    @Override // java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    void close() throws IOException;
}
