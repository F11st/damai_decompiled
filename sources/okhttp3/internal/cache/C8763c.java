package okhttp3.internal.cache;

import java.io.IOException;
import okio.AbstractC8839c;
import okio.Buffer;
import okio.Sink;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.cache.c */
/* loaded from: classes2.dex */
class C8763c extends AbstractC8839c {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8763c(Sink sink) {
        super(sink);
    }

    @Override // okio.AbstractC8839c, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.a = true;
            onException(e);
        }
    }

    @Override // okio.AbstractC8839c, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.a = true;
            onException(e);
        }
    }

    protected void onException(IOException iOException) {
        throw null;
    }

    @Override // okio.AbstractC8839c, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.a = true;
            onException(e);
        }
    }
}
