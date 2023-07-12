package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.o;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class b {
    final boolean a;
    final Random b;
    final BufferedSink c;
    final Buffer d;
    boolean e;
    final Buffer f = new Buffer();
    final a g = new a();
    boolean h;
    private final byte[] i;
    private final Buffer.c j;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    final class a implements Sink {
        int a;
        long b;
        boolean c;
        boolean d;

        a() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.d) {
                b bVar = b.this;
                bVar.d(this.a, bVar.f.size(), this.c, true);
                this.d = true;
                b.this.h = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!this.d) {
                b bVar = b.this;
                bVar.d(this.a, bVar.f.size(), this.c, false);
                this.c = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink
        public o timeout() {
            return b.this.c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.d) {
                b.this.f.write(buffer, j);
                boolean z = this.c && this.b != -1 && b.this.f.size() > this.b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                long completeSegmentByteCount = b.this.f.completeSegmentByteCount();
                if (completeSegmentByteCount <= 0 || z) {
                    return;
                }
                b.this.d(this.a, completeSegmentByteCount, this.c, false);
                this.c = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(boolean z, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.a = z;
        this.c = bufferedSink;
        this.d = bufferedSink.buffer();
        this.b = random;
        this.i = z ? new byte[4] : null;
        this.j = z ? new Buffer.c() : null;
    }

    private void c(int i, ByteString byteString) throws IOException {
        if (!this.e) {
            int size = byteString.size();
            if (size <= 125) {
                this.d.writeByte(i | 128);
                if (this.a) {
                    this.d.writeByte(size | 128);
                    this.b.nextBytes(this.i);
                    this.d.write(this.i);
                    if (size > 0) {
                        long size2 = this.d.size();
                        this.d.write(byteString);
                        this.d.readAndWriteUnsafe(this.j);
                        this.j.b(size2);
                        okhttp3.internal.ws.a.b(this.j, this.i);
                        this.j.close();
                    }
                } else {
                    this.d.writeByte(size);
                    this.d.write(byteString);
                }
                this.c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sink a(int i, long j) {
        if (!this.h) {
            this.h = true;
            a aVar = this.g;
            aVar.a = i;
            aVar.b = j;
            aVar.c = true;
            aVar.d = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                okhttp3.internal.ws.a.c(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            c(8, byteString2);
        } finally {
            this.e = true;
        }
    }

    void d(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.e) {
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.d.writeByte(i);
            int i2 = this.a ? 128 : 0;
            if (j <= 125) {
                this.d.writeByte(((int) j) | i2);
            } else if (j <= 65535) {
                this.d.writeByte(i2 | 126);
                this.d.writeShort((int) j);
            } else {
                this.d.writeByte(i2 | 127);
                this.d.writeLong(j);
            }
            if (this.a) {
                this.b.nextBytes(this.i);
                this.d.write(this.i);
                if (j > 0) {
                    long size = this.d.size();
                    this.d.write(this.f, j);
                    this.d.readAndWriteUnsafe(this.j);
                    this.j.b(size);
                    okhttp3.internal.ws.a.b(this.j, this.i);
                    this.j.close();
                }
            } else {
                this.d.write(this.f, j);
            }
            this.c.emit();
            return;
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ByteString byteString) throws IOException {
        c(9, byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ByteString byteString) throws IOException {
        c(10, byteString);
    }
}
