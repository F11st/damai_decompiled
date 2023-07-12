package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.f */
/* loaded from: classes10.dex */
public abstract class AbstractC5986f implements InterfaceC5992l {
    private final InterfaceC5992l a;

    public AbstractC5986f(InterfaceC5992l interfaceC5992l) {
        if (interfaceC5992l == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = interfaceC5992l;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l
    public void a(C5982b c5982b, long j) throws IOException {
        this.a.a(c5982b, j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + this.a.toString() + jn1.BRACKET_END_STR;
    }
}
