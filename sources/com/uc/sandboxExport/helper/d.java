package com.uc.sandboxExport.helper;

import android.os.StrictMode;
import java.io.Closeable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class d implements Closeable {
    private final StrictMode.ThreadPolicy a;
    private final StrictMode.VmPolicy b;

    private d(StrictMode.ThreadPolicy threadPolicy) {
        this.a = threadPolicy;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return new d(StrictMode.allowThreadDiskReads(), (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private d(StrictMode.ThreadPolicy threadPolicy, byte b) {
        this(threadPolicy);
    }
}
