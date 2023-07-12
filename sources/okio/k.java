package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class k implements BufferedSink {
    public final Buffer a = new Buffer();
    public final Sink b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Sink sink) {
        Objects.requireNonNull(sink, "sink == null");
        this.b = sink;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this.a;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            Buffer buffer = this.a;
            long j = buffer.size;
            if (j > 0) {
                this.b.write(buffer, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            p.f(th);
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (!this.c) {
            long size = this.a.size();
            if (size > 0) {
                this.b.write(this.a, size);
            }
            return this;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (!this.c) {
            long completeSegmentByteCount = this.a.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.b.write(this.a, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.c) {
            Buffer buffer = this.a;
            long j = buffer.size;
            if (j > 0) {
                this.b.write(buffer, j);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new a();
    }

    @Override // okio.Sink
    public o timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + jn1.BRACKET_END_STR;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (!this.c) {
            this.a.write(buffer, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) throws IOException {
        if (!this.c) {
            this.a.writeByte(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long j) throws IOException {
        if (!this.c) {
            this.a.writeDecimalLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (!this.c) {
            this.a.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) throws IOException {
        if (!this.c) {
            this.a.writeInt(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int i) throws IOException {
        if (!this.c) {
            this.a.writeIntLe(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long j) throws IOException {
        if (!this.c) {
            this.a.writeLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long j) throws IOException {
        if (!this.c) {
            this.a.writeLongLe(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!this.c) {
            this.a.writeShort(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int i) throws IOException {
        if (!this.c) {
            this.a.writeShortLe(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (!this.c) {
            this.a.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (!this.c) {
            this.a.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i) throws IOException {
        if (!this.c) {
            this.a.writeUtf8CodePoint(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            k.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            k kVar = k.this;
            if (kVar.c) {
                return;
            }
            kVar.flush();
        }

        public String toString() {
            return k.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            k kVar = k.this;
            if (!kVar.c) {
                kVar.a.writeByte((int) ((byte) i));
                k.this.emitCompleteSegments();
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            k kVar = k.this;
            if (!kVar.c) {
                kVar.a.write(bArr, i, i2);
                k.this.emitCompleteSegments();
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (!this.c) {
            this.a.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, int i, int i2, Charset charset) throws IOException {
        if (!this.c) {
            this.a.writeString(str, i, i2, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.writeUtf8(str, i, i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.write(bArr, i, i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.c) {
            int write = this.a.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this.a, j);
            if (read != -1) {
                j -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
