package okio;

import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class d implements Source {
    private final Source delegate;

    public d(Source source) {
        if (source != null) {
            this.delegate = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        return this.delegate.read(buffer, j);
    }

    @Override // okio.Source
    public o timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + this.delegate.toString() + jn1.BRACKET_END_STR;
    }
}
