package okhttp3.internal.http2;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class f implements Closeable {
    private static final Logger g = Logger.getLogger(c.class.getName());
    private final BufferedSink a;
    private final boolean b;
    private final Buffer c;
    private int d;
    private boolean e;
    final b.C0442b f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BufferedSink bufferedSink, boolean z) {
        this.a = bufferedSink;
        this.b = z;
        Buffer buffer = new Buffer();
        this.c = buffer;
        this.f = new b.C0442b(buffer);
        this.d = 16384;
    }

    private void h(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.d, j);
            long j2 = min;
            j -= j2;
            c(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.a.write(this.c, j2);
        }
    }

    private static void i(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public synchronized void a(h hVar) throws IOException {
        if (!this.e) {
            this.d = hVar.f(this.d);
            if (hVar.c() != -1) {
                this.f.e(hVar.c());
            }
            c(0, 0, (byte) 4, (byte) 1);
            this.a.flush();
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    void b(int i, byte b, Buffer buffer, int i2) throws IOException {
        c(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.a.write(buffer, i2);
        }
    }

    public void c(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.b(false, i, i2, b, b2));
        }
        int i3 = this.d;
        if (i2 > i3) {
            throw c.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw c.c("reserved bit set: %s", Integer.valueOf(i));
        }
        i(this.a, i2);
        this.a.writeByte(b & 255);
        this.a.writeByte(b2 & 255);
        this.a.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.e = true;
        this.a.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (!this.e) {
            if (this.b) {
                Logger logger = g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(okhttp3.internal.a.q(">> CONNECTION %s", c.a.hex()));
                }
                this.a.write(c.a.toByteArray());
                this.a.flush();
                return;
            }
            return;
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    public synchronized void d(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.e) {
            if (errorCode.httpCode != -1) {
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.a.writeInt(i);
                this.a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.a.write(bArr);
                }
                this.a.flush();
            } else {
                throw c.c("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.e) {
            b(i, z ? (byte) 1 : (byte) 0, buffer, i2);
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void e(boolean z, int i, List<a> list) throws IOException {
        if (!this.e) {
            this.f.g(list);
            long size = this.c.size();
            int min = (int) Math.min(this.d, size);
            long j = min;
            int i2 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            c(i, min, (byte) 1, b);
            this.a.write(this.c, j);
            if (i2 > 0) {
                h(i, size - j);
            }
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void f(int i, ErrorCode errorCode) throws IOException {
        if (!this.e) {
            if (errorCode.httpCode != -1) {
                c(i, 4, (byte) 3, (byte) 0);
                this.a.writeInt(errorCode.httpCode);
                this.a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.e) {
            this.a.flush();
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void g(h hVar) throws IOException {
        if (!this.e) {
            int i = 0;
            c(0, hVar.j() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (hVar.g(i)) {
                    this.a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.a.writeInt(hVar.b(i));
                }
                i++;
            }
            this.a.flush();
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public int maxDataLength() {
        return this.d;
    }

    public synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (!this.e) {
            c(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.a.writeInt(i);
            this.a.writeInt(i2);
            this.a.flush();
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void pushPromise(int i, int i2, List<a> list) throws IOException {
        if (!this.e) {
            this.f.g(list);
            long size = this.c.size();
            int min = (int) Math.min(this.d - 4, size);
            long j = min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            c(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.a.writeInt(i2 & Integer.MAX_VALUE);
            this.a.write(this.c, j);
            if (i3 > 0) {
                h(i, size - j);
            }
        } else {
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    public synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.e) {
            throw new IOException(IRequestConst.CLOSED);
        }
        if (j != 0 && j <= 2147483647L) {
            c(i, 4, (byte) 8, (byte) 0);
            this.a.writeInt((int) j);
            this.a.flush();
        } else {
            throw c.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }
}
