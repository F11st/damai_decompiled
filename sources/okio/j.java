package okio;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class j implements Source {
    private final BufferedSource a;
    private final Buffer b;
    private m c;
    private int d;
    private boolean e;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BufferedSource bufferedSource) {
        this.a = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.b = buffer;
        m mVar = buffer.head;
        this.c = mVar;
        this.d = mVar != null ? mVar.b : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e = true;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        m mVar;
        m mVar2;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (!this.e) {
                m mVar3 = this.c;
                if (mVar3 == null || (mVar3 == (mVar2 = this.b.head) && this.d == mVar2.b)) {
                    if (i == 0) {
                        return 0L;
                    }
                    if (this.a.request(this.f + 1)) {
                        if (this.c == null && (mVar = this.b.head) != null) {
                            this.c = mVar;
                            this.d = mVar.b;
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
    public o timeout() {
        return this.a.timeout();
    }
}
