package okio;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(Buffer buffer, long j) throws IOException;

    C8857o timeout();
}
