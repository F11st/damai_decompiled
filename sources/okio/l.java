package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class l implements BufferedSource {
    public final Buffer a = new Buffer();
    public final Source b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Source source) {
        Objects.requireNonNull(source, "source == null");
        this.b = source;
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.a;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Source
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        return this.a.exhausted() && this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.a;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) throws IOException {
        return indexOf(b, 0L, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return h.d(new j(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j >= 0) {
                if (!this.c) {
                    Buffer buffer2 = this.a;
                    if (buffer2.size == 0 && this.b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1L;
                    }
                    return this.a.read(buffer, Math.min(j, this.a.size));
                }
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j = 0;
            while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                long completeSegmentByteCount = this.a.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j += completeSegmentByteCount;
                    sink.write(this.a, completeSegmentByteCount);
                }
            }
            if (this.a.size() > 0) {
                long size = j + this.a.size();
                Buffer buffer = this.a;
                sink.write(buffer, buffer.size());
                return size;
            }
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.a.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readByteArray();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readByteString();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        byte b;
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            b = this.a.getByte(i);
            if ((b < 48 || b > 57) && !(i == 0 && b == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b)));
        }
        return this.a.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.a;
                long j = buffer.size;
                if (j > 0) {
                    int read = buffer.read(bArr, i, (int) j);
                    if (read == -1) {
                        throw new AssertionError();
                    }
                    i += read;
                } else {
                    throw e;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L4a
            okio.Buffer r3 = r6.a
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.Buffer r0 = r6.a
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.l.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.a.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.a.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.a.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.a.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.a.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.a.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.a.writeAll(this.b);
            return this.a.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b = this.a.getByte(0L);
        if ((b & 224) == 192) {
            require(2L);
        } else if ((b & 240) == 224) {
            require(3L);
        } else if ((b & 248) == 240) {
            require(4L);
        }
        return this.a.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j = this.a.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return this.a.readUtf8Line(indexOf);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) throws IOException {
        Buffer buffer;
        if (j >= 0) {
            if (!this.c) {
                do {
                    buffer = this.a;
                    if (buffer.size >= j) {
                        return true;
                    }
                } while (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
                return false;
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.BufferedSource
    public void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(i iVar) throws IOException {
        if (!this.c) {
            do {
                int selectPrefix = this.a.selectPrefix(iVar, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.a.skip(iVar.a[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        while (j > 0) {
            Buffer buffer = this.a;
            if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.size());
            this.a.skip(min);
            j -= min;
        }
    }

    @Override // okio.Source
    public o timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + jn1.BRACKET_END_STR;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) throws IOException {
        return indexOf(b, j, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        while (true) {
            long indexOfElement = this.a.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.a;
            long j2 = buffer.size;
            if (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException {
        if (!this.c) {
            if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!request(1 + j2) || this.a.getByte(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == AbsPerformance.LONG_NIL ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return this.a.readUtf8Line(indexOf);
            }
            if (j2 < AbsPerformance.LONG_NIL && request(j2) && this.a.getByte(j2 - 1) == 13 && request(1 + j2) && this.a.getByte(j2) == 10) {
                return this.a.readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.a;
            buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long indexOf = this.a.indexOf(b, j, j2);
            if (indexOf == -1) {
                Buffer buffer = this.a;
                long j3 = buffer.size;
                if (j3 >= j2 || this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.a.readByteArray(j);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws IOException {
        require(j);
        return this.a.readByteString(j);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws IOException {
        require(j);
        return this.a.readUtf8(j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            l lVar = l.this;
            if (!lVar.c) {
                return (int) Math.min(lVar.a.size, 2147483647L);
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            l.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            l lVar = l.this;
            if (!lVar.c) {
                Buffer buffer = lVar.a;
                if (buffer.size == 0 && lVar.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return l.this.a.readByte() & 255;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        public String toString() {
            return l.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!l.this.c) {
                p.b(bArr.length, i, i2);
                l lVar = l.this;
                Buffer buffer = lVar.a;
                if (buffer.size == 0 && lVar.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return l.this.a.read(bArr, i, i2);
            }
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.a.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.a);
            throw e;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = i2;
        p.b(bArr.length, i, j);
        Buffer buffer = this.a;
        if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(bArr, i, (int) Math.min(j, this.a.size));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        while (true) {
            long indexOf = this.a.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.a;
            long j2 = buffer.size;
            if (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - byteString.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.a;
        if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }
}
