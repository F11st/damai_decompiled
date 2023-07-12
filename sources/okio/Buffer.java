package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.cu2;
import tb.jn1;
import tb.m8;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    m head;
    long size;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Buffer.this.writeByte((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class c implements Closeable {
        public Buffer a;
        public boolean b;
        private m c;
        public byte[] e;
        public long d = -1;
        public int f = -1;
        public int g = -1;

        public final int a() {
            long j = this.d;
            if (j != this.a.size) {
                if (j == -1) {
                    return b(0L);
                }
                return b(j + (this.g - this.f));
            }
            throw new IllegalStateException();
        }

        public final int b(long j) {
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i >= 0) {
                Buffer buffer = this.a;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (i != 0 && j != j2) {
                        long j3 = 0;
                        m mVar = buffer.head;
                        m mVar2 = this.c;
                        if (mVar2 != null) {
                            long j4 = this.d - (this.f - mVar2.b);
                            if (j4 > j) {
                                j2 = j4;
                                mVar2 = mVar;
                                mVar = mVar2;
                            } else {
                                j3 = j4;
                            }
                        } else {
                            mVar2 = mVar;
                        }
                        if (j2 - j > j - j3) {
                            while (true) {
                                int i2 = mVar2.c;
                                int i3 = mVar2.b;
                                if (j < (i2 - i3) + j3) {
                                    break;
                                }
                                j3 += i2 - i3;
                                mVar2 = mVar2.f;
                            }
                        } else {
                            while (j2 > j) {
                                mVar = mVar.g;
                                j2 -= mVar.c - mVar.b;
                            }
                            mVar2 = mVar;
                            j3 = j2;
                        }
                        if (this.b && mVar2.d) {
                            m f = mVar2.f();
                            Buffer buffer2 = this.a;
                            if (buffer2.head == mVar2) {
                                buffer2.head = f;
                            }
                            mVar2 = mVar2.c(f);
                            mVar2.g.b();
                        }
                        this.c = mVar2;
                        this.d = j;
                        this.e = mVar2.a;
                        int i4 = mVar2.b + ((int) (j - j3));
                        this.f = i4;
                        int i5 = mVar2.c;
                        this.g = i5;
                        return i5 - i4;
                    }
                    this.c = null;
                    this.d = j;
                    this.e = null;
                    this.f = -1;
                    this.g = -1;
                    return -1;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.a.size)));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a != null) {
                this.a = null;
                this.c = null;
                this.d = -1L;
                this.e = null;
                this.f = -1;
                this.g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            m mVar = this.head;
            if (mVar != null) {
                byte[] bArr = mVar.a;
                int i = mVar.b;
                messageDigest.update(bArr, i, mVar.c - i);
                m mVar2 = this.head;
                while (true) {
                    mVar2 = mVar2.f;
                    if (mVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = mVar2.a;
                    int i2 = mVar2.b;
                    messageDigest.update(bArr2, i2, mVar2.c - i2);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            m mVar = this.head;
            if (mVar != null) {
                byte[] bArr = mVar.a;
                int i = mVar.b;
                mac.update(bArr, i, mVar.c - i);
                m mVar2 = this.head;
                while (true) {
                    mVar2 = mVar2.f;
                    if (mVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = mVar2.a;
                    int i2 = mVar2.b;
                    mac.update(bArr2, i2, mVar2.c - i2);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        m mVar = this.head.g;
        int i = mVar.c;
        return (i >= 8192 || !mVar.e) ? j : j - (i - mVar.b);
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.size;
            if (j != buffer.size) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            m mVar = this.head;
            m mVar2 = buffer.head;
            int i = mVar.b;
            int i2 = mVar2.b;
            while (j2 < this.size) {
                long min = Math.min(mVar.c - i, mVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (mVar.a[i] != mVar2.a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == mVar.c) {
                    mVar = mVar.f;
                    i = mVar.b;
                }
                if (i2 == mVar2.c) {
                    mVar2 = mVar2.f;
                    i2 = mVar2.b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        p.b(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j > j) {
            m mVar = this.head;
            while (true) {
                int i2 = mVar.c;
                int i3 = mVar.b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return mVar.a[i3 + ((int) j)];
                }
                j -= j3;
                mVar = mVar.f;
            }
        } else {
            long j4 = j - j2;
            m mVar2 = this.head;
            do {
                mVar2 = mVar2.g;
                int i4 = mVar2.c;
                i = mVar2.b;
                j4 += i4 - i;
            } while (j4 < 0);
            return mVar2.a[i + ((int) j4)];
        }
    }

    public int hashCode() {
        m mVar = this.head;
        if (mVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = mVar.c;
            for (int i3 = mVar.b; i3 < i2; i3++) {
                i = (i * 31) + mVar.a[i3];
            }
            mVar = mVar.f;
        } while (mVar != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new b();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(MessageDigestAlgorithms.MD5);
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new a();
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return h.d(new j(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final c readAndWriteUnsafe() {
        return readAndWriteUnsafe(new c());
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j != 0) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            int i3 = i + 1;
            byte b2 = mVar.a[i];
            this.size = j - 1;
            if (i3 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        r1 = new okio.Buffer().writeDecimalLong(r3).writeByte((int) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r8 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r17.size -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
        if (r8 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc4
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L14:
            okio.m r10 = r0.head
            byte[] r11 = r10.a
            int r12 = r10.b
            int r13 = r10.c
        L1c:
            if (r12 >= r13) goto L9d
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6a
            r14 = 57
            if (r15 > r14) goto L6a
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3d
            if (r16 != 0) goto L36
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L36
            goto L3d
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L74
        L3d:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong(r3)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r8 != 0) goto L4f
            r1.readByte()
        L4f:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6a:
            r1 = 45
            if (r15 != r1) goto L7e
            if (r7 != 0) goto L7e
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L74:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L1c
        L7e:
            if (r7 == 0) goto L82
            r9 = 1
            goto L9d
        L82:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9d:
            if (r12 != r13) goto La9
            okio.m r1 = r10.b()
            r0.head = r1
            okio.n.a(r10)
            goto Lab
        La9:
            r10.b = r12
        Lab:
            if (r9 != 0) goto Lb9
            okio.m r1 = r0.head
            if (r1 != 0) goto Lb2
            goto Lb9
        Lb2:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L14
        Lb9:
            long r1 = r0.size
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.size = r1
            if (r8 == 0) goto Lc2
            goto Lc3
        Lc2:
            long r3 = -r3
        Lc3:
            return r3
        Lc4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, AbsPerformance.LONG_NIL, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[EDGE_INSN: B:42:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.m r6 = r15.head
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.m r7 = r6.b()
            r15.head = r7
            okio.n.a(r6)
            goto L9f
        L9d:
            r6.b = r8
        L9f:
            if (r1 != 0) goto La5
            okio.m r6 = r15.head
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j >= 4) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.size = j - 4;
            if (i8 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return p.c(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j >= 8) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (bArr[i3] & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = j2 | ((bArr[i] & 255) << 56) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
            this.size = j - 8;
            if (i10 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i10;
            }
            return j3;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return p.d(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j >= 2) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.size = j - 2;
            if (i4 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return p.e(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final c readUnsafe() {
        return readUnsafe(new c());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, p.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size != 0) {
            byte b2 = getByte(0L);
            if ((b2 & cu2.MAX_POWER_OF_TWO) == 0) {
                i = b2 & m8.DEL;
                i2 = 1;
                i3 = 0;
            } else if ((b2 & 224) == 192) {
                i = b2 & 31;
                i2 = 2;
                i3 = 128;
            } else if ((b2 & 240) == 224) {
                i = b2 & 15;
                i2 = 3;
                i3 = 2048;
            } else if ((b2 & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            } else {
                i = b2 & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (this.size >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = i4;
                    byte b3 = getByte(j2);
                    if ((b3 & 192) != 128) {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                    i = (i << 6) | (b3 & 63);
                }
                skip(j);
                return i > 1114111 ? REPLACEMENT_CHARACTER : ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b2) + jn1.BRACKET_END_STR);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j = this.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return readUtf8Line(indexOf);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        m mVar = this.head;
        arrayList.add(Integer.valueOf(mVar.c - mVar.b));
        m mVar2 = this.head;
        while (true) {
            mVar2 = mVar2.f;
            if (mVar2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(mVar2.c - mVar2.b));
        }
    }

    @Override // okio.BufferedSource
    public int select(i iVar) {
        int selectPrefix = selectPrefix(iVar, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(iVar.a[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r19 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int selectPrefix(okio.i r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 162
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.selectPrefix(okio.i, boolean):int");
    }

    public final ByteString sha1() {
        return digest(MessageDigestAlgorithms.SHA_1);
    }

    public final ByteString sha256() {
        return digest(MessageDigestAlgorithms.SHA_256);
    }

    public final ByteString sha512() {
        return digest(MessageDigestAlgorithms.SHA_512);
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        m mVar;
        while (j > 0) {
            if (this.head != null) {
                int min = (int) Math.min(j, mVar.c - mVar.b);
                long j2 = min;
                this.size -= j2;
                j -= j2;
                m mVar2 = this.head;
                int i = mVar2.b + min;
                mVar2.b = i;
                if (i == mVar2.c) {
                    this.head = mVar2.b();
                    n.a(mVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // okio.Sink
    public o timeout() {
        return o.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m writableSegment(int i) {
        if (i >= 1 && i <= 8192) {
            m mVar = this.head;
            if (mVar == null) {
                m b2 = n.b();
                this.head = b2;
                b2.g = b2;
                b2.f = b2;
                return b2;
            }
            m mVar2 = mVar.g;
            return (mVar2.c + i > 8192 || !mVar2.e) ? mVar2.c(n.b()) : mVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        m d = this.head.d();
        buffer.head = d;
        d.g = d;
        d.f = d;
        m mVar = this.head;
        while (true) {
            mVar = mVar.f;
            if (mVar != this.head) {
                buffer.head.g.c(mVar.d());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        int i;
        if (outputStream != null) {
            p.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            m mVar = this.head;
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
                outputStream.write(mVar.a, (int) (mVar.b + j), min);
                j2 -= min;
                mVar = mVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            m mVar = this.head;
            if (mVar == null) {
                return -1L;
            }
            long j3 = this.size;
            if (j3 - j < j) {
                while (j3 > j) {
                    mVar = mVar.g;
                    j3 -= mVar.c - mVar.b;
                }
            } else {
                while (true) {
                    long j4 = (mVar.c - mVar.b) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    mVar = mVar.f;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = mVar.a;
                    i = (int) ((mVar.b + j) - j3);
                    int i3 = mVar.c;
                    while (i < i3) {
                        byte b4 = bArr[i];
                        if (b4 == b2 || b4 == b3) {
                            i2 = mVar.b;
                            return (i - i2) + j3;
                        }
                        i++;
                    }
                    j3 += mVar.c - mVar.b;
                    mVar = mVar.f;
                    j = j3;
                }
                return -1L;
            }
            byte[] internalArray = byteString.internalArray();
            while (j3 < this.size) {
                byte[] bArr2 = mVar.a;
                i = (int) ((mVar.b + j) - j3);
                int i4 = mVar.c;
                while (i < i4) {
                    byte b5 = bArr2[i];
                    for (byte b6 : internalArray) {
                        if (b5 == b6) {
                            i2 = mVar.b;
                            return (i - i2) + j3;
                        }
                    }
                    i++;
                }
                j3 += mVar.c - mVar.b;
                mVar = mVar.f;
                j = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        p.b(bArr.length, i, i2);
        m mVar = this.head;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(i2, mVar.c - mVar.b);
        System.arraycopy(mVar.a, mVar.b, bArr, i, min);
        int i3 = mVar.b + min;
        mVar.b = i3;
        this.size -= min;
        if (i3 == mVar.c) {
            this.head = mVar.b();
            n.a(mVar);
        }
        return min;
    }

    public final c readAndWriteUnsafe(c cVar) {
        if (cVar.a == null) {
            cVar.a = this;
            cVar.b = true;
            return cVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public final c readUnsafe(c cVar) {
        if (cVar.a == null) {
            cVar.a = this;
            cVar.b = false;
            return cVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = AbsPerformance.LONG_NIL;
            if (j != AbsPerformance.LONG_NIL) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32L, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        m writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        writableSegment.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        m writableSegment = writableSegment(i2);
        byte[] bArr = writableSegment.a;
        int i3 = writableSegment.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment.c += i2;
        this.size += i2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        m writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.a;
        int i = writableSegment.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.c += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        m writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.c = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(p.c(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        m writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.a;
        int i = writableSegment.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        writableSegment.c = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(p.d(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        m writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.c = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) p.e((short) i));
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            p.b(this.size, 0L, j);
            m mVar = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, mVar.c - mVar.b);
                outputStream.write(mVar.a, mVar.b, min);
                int i = mVar.b + min;
                mVar.b = i;
                long j2 = min;
                this.size -= j2;
                j -= j2;
                if (i == mVar.c) {
                    m b2 = mVar.b();
                    this.head = b2;
                    n.a(mVar);
                    mVar = b2;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j, long j2) {
        m mVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.size;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (mVar = this.head) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    mVar = mVar.g;
                    j4 -= mVar.c - mVar.b;
                }
            } else {
                while (true) {
                    long j6 = (mVar.c - mVar.b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    mVar = mVar.f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = mVar.a;
                int min = (int) Math.min(mVar.c, (mVar.b + j5) - j4);
                for (int i = (int) ((mVar.b + j7) - j4); i < min; i++) {
                    if (bArr[i] == b2) {
                        return (i - mVar.b) + j4;
                    }
                }
                j4 += mVar.c - mVar.b;
                mVar = mVar.f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        p.b(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        p.b(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                m mVar = this.head;
                int i = mVar.b;
                if (i + j > mVar.c) {
                    return new String(readByteArray(j), charset);
                }
                String str = new String(mVar.a, i, (int) j, charset);
                int i2 = (int) (mVar.b + j);
                mVar.b = i2;
                this.size -= j;
                if (i2 == mVar.c) {
                    this.head = mVar.b();
                    n.a(mVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, p.UTF_8);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            m writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.a, writableSegment.c, (int) Math.min(j, 8192 - writableSegment.c));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.c += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1L);
        return readUtf82;
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(p.UTF_8)) {
                            return writeUtf8(str, i, i2);
                        }
                        byte[] bytes = str.substring(i, i2).getBytes(charset);
                        return write(bytes, 0, bytes.length);
                    }
                    throw new IllegalArgumentException("charset == null");
                }
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        m writableSegment = writableSegment(1);
                        byte[] bArr = writableSegment.a;
                        int i3 = writableSegment.c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = writableSegment.c;
                        int i6 = (i3 + i4) - i5;
                        writableSegment.c = i5 + i6;
                        this.size += i6;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & jn1.CONDITION_IF) | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i8 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                                writeByte(((i8 >> 12) & 63) | 128);
                                writeByte(((i8 >> 6) & 63) | 128);
                                writeByte((i8 & 63) | 128);
                                i += 2;
                            } else {
                                writeByte(63);
                                i = i7;
                            }
                        } else {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | 128);
                            writeByte((charAt & jn1.CONDITION_IF) | 128);
                        }
                        i++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    private boolean rangeEquals(m mVar, int i, ByteString byteString, int i2, int i3) {
        int i4 = mVar.c;
        byte[] bArr = mVar.a;
        while (i2 < i3) {
            if (i == i4) {
                mVar = mVar.f;
                byte[] bArr2 = mVar.a;
                bArr = bArr2;
                i = mVar.b;
                i4 = mVar.c;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            p.b(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                m writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.c);
                System.arraycopy(bArr, i, writableSegment.a, writableSegment.c, min);
                i += min;
                writableSegment.c += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            p.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            m mVar = this.head;
            while (true) {
                int i = mVar.c;
                int i2 = mVar.b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                mVar = mVar.f;
            }
            while (j2 > 0) {
                m d = mVar.d();
                int i3 = (int) (d.b + j);
                d.b = i3;
                d.c = Math.min(i3 + ((int) j2), d.c);
                m mVar2 = buffer.head;
                if (mVar2 == null) {
                    d.g = d;
                    d.f = d;
                    buffer.head = d;
                } else {
                    mVar2.g.c(d);
                }
                j2 -= d.c - d.b;
                mVar = mVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        m mVar = this.head;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), mVar.c - mVar.b);
        byteBuffer.put(mVar.a, mVar.b, min);
        int i = mVar.b + min;
        mVar.b = i;
        this.size -= min;
        if (i == mVar.c) {
            this.head = mVar.b();
            n.a(mVar);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                m writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.c);
                byteBuffer.get(writableSegment.a, writableSegment.c, min);
                i -= min;
                writableSegment.c += min;
            }
            this.size += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                m mVar = this.head;
                long j3 = -1;
                if (mVar == null) {
                    return -1L;
                }
                long j4 = this.size;
                if (j4 - j < j) {
                    while (j4 > j) {
                        mVar = mVar.g;
                        j4 -= mVar.c - mVar.b;
                    }
                } else {
                    while (true) {
                        long j5 = (mVar.c - mVar.b) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        mVar = mVar.f;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b2 = byteString.getByte(0);
                int size = byteString.size();
                long j6 = 1 + (this.size - size);
                long j7 = j;
                m mVar2 = mVar;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = mVar2.a;
                    int min = (int) Math.min(mVar2.c, (mVar2.b + j6) - j8);
                    int i = (int) ((mVar2.b + j7) - j8);
                    while (i < min) {
                        if (bArr2[i] == b2) {
                            bArr = bArr2;
                            if (rangeEquals(mVar2, i + 1, byteString, 1, size)) {
                                return (i - mVar2.b) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i++;
                        bArr2 = bArr;
                    }
                    j8 += mVar2.c - mVar2.b;
                    mVar2 = mVar2.f;
                    j7 = j8;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j >= 0) {
                long j2 = this.size;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                buffer.write(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            p.b(buffer.size, 0L, j);
            while (j > 0) {
                m mVar = buffer.head;
                if (j < mVar.c - mVar.b) {
                    m mVar2 = this.head;
                    m mVar3 = mVar2 != null ? mVar2.g : null;
                    if (mVar3 != null && mVar3.e) {
                        if ((mVar3.c + j) - (mVar3.d ? 0 : mVar3.b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            mVar.g(mVar3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = mVar.e((int) j);
                }
                m mVar4 = buffer.head;
                long j2 = mVar4.c - mVar4.b;
                buffer.head = mVar4.b();
                m mVar5 = this.head;
                if (mVar5 == null) {
                    this.head = mVar4;
                    mVar4.g = mVar4;
                    mVar4.f = mVar4;
                } else {
                    mVar5.g.c(mVar4).a();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
