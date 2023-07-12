package okio;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class g implements Source {
    private final BufferedSource a;
    private final Inflater b;
    private int c;
    private boolean d;

    public g(Source source, Inflater inflater) {
        this(h.d(source), inflater);
    }

    private void c() throws IOException {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.skip(remaining);
    }

    public final boolean a() throws IOException {
        if (this.b.needsInput()) {
            c();
            if (this.b.getRemaining() == 0) {
                if (this.a.exhausted()) {
                    return true;
                }
                m mVar = this.a.buffer().head;
                int i = mVar.c;
                int i2 = mVar.b;
                int i3 = i - i2;
                this.c = i3;
                this.b.setInput(mVar.a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        m writableSegment;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.d) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean a = a();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.b.inflate(writableSegment.a, writableSegment.c, (int) Math.min(j, 8192 - writableSegment.c));
                    if (inflate > 0) {
                        writableSegment.c += inflate;
                        long j2 = inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.b.finished() || this.b.needsDictionary()) {
                        break;
                    } else if (a) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            c();
            if (writableSegment.b == writableSegment.c) {
                buffer.head = writableSegment.b();
                n.a(writableSegment);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.Source
    public o timeout() {
        return this.a.timeout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.a = bufferedSource;
            this.b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
