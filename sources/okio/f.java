package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class f implements Source {
    private final BufferedSource b;
    private final Inflater c;
    private final g d;
    private int a = 0;
    private final CRC32 e = new CRC32();

    public f(Source source) {
        if (source != null) {
            Inflater inflater = new Inflater(true);
            this.c = inflater;
            BufferedSource d = h.d(source);
            this.b = d;
            this.d = new g(d, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private void c() throws IOException {
        this.b.require(10L);
        byte b = this.b.buffer().getByte(3L);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            f(this.b.buffer(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((b >> 2) & 1) == 1) {
            this.b.require(2L);
            if (z) {
                f(this.b.buffer(), 0L, 2L);
            }
            long readShortLe = this.b.buffer().readShortLe();
            this.b.require(readShortLe);
            if (z) {
                f(this.b.buffer(), 0L, readShortLe);
            }
            this.b.skip(readShortLe);
        }
        if (((b >> 3) & 1) == 1) {
            long indexOf = this.b.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z) {
                    f(this.b.buffer(), 0L, indexOf + 1);
                }
                this.b.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long indexOf2 = this.b.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z) {
                    f(this.b.buffer(), 0L, indexOf2 + 1);
                }
                this.b.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.b.readShortLe(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void e() throws IOException {
        a("CRC", this.b.readIntLe(), (int) this.e.getValue());
        a("ISIZE", this.b.readIntLe(), (int) this.c.getBytesWritten());
    }

    private void f(Buffer buffer, long j, long j2) {
        int i;
        m mVar = buffer.head;
        while (true) {
            int i2 = mVar.c;
            int i3 = mVar.b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            mVar = mVar.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(mVar.c - i, j2);
            this.e.update(mVar.a, (int) (mVar.b + j), min);
            j2 -= min;
            mVar = mVar.f;
            j = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0L;
        } else {
            if (this.a == 0) {
                c();
                this.a = 1;
            }
            if (this.a == 1) {
                long j2 = buffer.size;
                long read = this.d.read(buffer, j);
                if (read != -1) {
                    f(buffer, j2, read);
                    return read;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                e();
                this.a = 3;
                if (!this.b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.Source
    public o timeout() {
        return this.b.timeout();
    }
}
