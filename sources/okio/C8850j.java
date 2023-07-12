package okio;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: okio.j */
/* loaded from: classes2.dex */
final class C8850j implements Source {
    private final BufferedSource a;
    private final Buffer b;
    private C8855m c;
    private int d;
    private boolean e;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8850j(BufferedSource bufferedSource) {
        this.a = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.b = buffer;
        C8855m c8855m = buffer.head;
        this.c = c8855m;
        this.d = c8855m != null ? c8855m.b : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e = true;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        C8855m c8855m;
        C8855m c8855m2;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (!this.e) {
                C8855m c8855m3 = this.c;
                if (c8855m3 == null || (c8855m3 == (c8855m2 = this.b.head) && this.d == c8855m2.b)) {
                    if (i == 0) {
                        return 0L;
                    }
                    if (this.a.request(this.f + 1)) {
                        if (this.c == null && (c8855m = this.b.head) != null) {
                            this.c = c8855m;
                            this.d = c8855m.b;
                        }
                        long min = Math.min(j, this.b.size - this.f);
                        this.b.copyTo(buffer, this.f, min);
                        this.f += min;
                        return min;
                    }
                    return -1L;
                }
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.Source
    public C8857o timeout() {
        return this.a.timeout();
    }
}
