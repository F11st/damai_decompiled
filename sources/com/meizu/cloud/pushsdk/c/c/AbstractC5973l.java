package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.InterfaceC5984d;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.l */
/* loaded from: classes10.dex */
public abstract class AbstractC5973l implements Closeable {
    public abstract InterfaceC5984d a();

    public final InputStream b() {
        return a().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C5974m.a(a());
    }
}
