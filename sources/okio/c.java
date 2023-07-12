package okio;

import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class c implements Sink {
    private final Sink delegate;

    public c(Sink sink) {
        if (sink != null) {
            this.delegate = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public o timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + this.delegate.toString() + jn1.BRACKET_END_STR;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        this.delegate.write(buffer, j);
    }
}
