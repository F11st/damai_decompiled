package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c extends okio.c {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Sink sink) {
        super(sink);
    }

    @Override // okio.c, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // okio.c, okio.Sink, java.io.Flushable
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

    @Override // okio.c, okio.Sink
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
