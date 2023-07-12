package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class f implements l {
    private final l a;

    public f(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        this.a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + this.a.toString() + jn1.BRACKET_END_STR;
    }
}
