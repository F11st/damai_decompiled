package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.o;
import tb.hs2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable {
    static final Logger e = Logger.getLogger(c.class.getName());
    private final BufferedSource a;
    private final a b;
    private final boolean c;
    final b.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<okhttp3.internal.http2.a> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, h hVar);

        void windowUpdate(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class a implements Source {
        private final BufferedSource a;
        int b;
        byte c;
        int d;
        int e;
        short f;

        a(BufferedSource bufferedSource) {
            this.a = bufferedSource;
        }

        private void a() throws IOException {
            int i = this.d;
            int h = Http2Reader.h(this.a);
            this.e = h;
            this.b = h;
            byte readByte = (byte) (this.a.readByte() & 255);
            this.c = (byte) (this.a.readByte() & 255);
            Logger logger = Http2Reader.e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.b(true, this.d, this.b, readByte, this.c));
            }
            int readInt = this.a.readInt() & Integer.MAX_VALUE;
            this.d = readInt;
            if (readByte != 9) {
                throw c.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw c.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.e;
                if (i == 0) {
                    this.a.skip(this.f);
                    this.f = (short) 0;
                    if ((this.c & 4) != 0) {
                        return -1L;
                    }
                    a();
                } else {
                    long read = this.a.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.e = (int) (this.e - read);
                    return read;
                }
            }
        }

        @Override // okio.Source
        public o timeout() {
            return this.a.timeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.a = bufferedSource;
        this.c = z;
        a aVar = new a(bufferedSource);
        this.b = aVar;
        this.d = new b.a(4096, aVar);
    }

    static int a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw c.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    private void d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw c.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if (!((b & 32) != 0)) {
            short readByte = (b & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
            handler.data(z, i2, this.a, a(i, b, readByte));
            this.a.skip(readByte);
            return;
        }
        throw c.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void e(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw c.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 == 0) {
            int readInt = this.a.readInt();
            int readInt2 = this.a.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 == null) {
                throw c.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i3 > 0) {
                byteString = this.a.readByteString(i3);
            }
            handler.goAway(readInt, fromHttp2, byteString);
            return;
        }
        throw c.d("TYPE_GOAWAY streamId != 0", new Object[0]);
    }

    private List<okhttp3.internal.http2.a> f(int i, short s, byte b, int i2) throws IOException {
        a aVar = this.b;
        aVar.e = i;
        aVar.b = i;
        aVar.f = s;
        aVar.c = b;
        aVar.d = i2;
        this.d.k();
        return this.d.e();
    }

    private void g(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            short readByte = (b & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
            if ((b & 32) != 0) {
                j(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, -1, f(a(i, b, readByte), readByte, b, i2));
            return;
        }
        throw c.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int h(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw c.d("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 == 0) {
            handler.ping((b & 1) != 0, this.a.readInt(), this.a.readInt());
            return;
        }
        throw c.d("TYPE_PING streamId != 0", new Object[0]);
    }

    private void j(Handler handler, int i) throws IOException {
        int readInt = this.a.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void k(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw c.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 != 0) {
            j(handler, i2);
            return;
        }
        throw c.d("TYPE_PRIORITY streamId == 0", new Object[0]);
    }

    private void l(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            short readByte = (b & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
            handler.pushPromise(i2, this.a.readInt() & Integer.MAX_VALUE, f(a(i - 4, b, readByte), readByte, b, i2));
            return;
        }
        throw c.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void m(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw c.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 != 0) {
            int readInt = this.a.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 == null) {
                throw c.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
            handler.rstStream(i2, fromHttp2);
            return;
        }
        throw c.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }

    private void n(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw c.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            }
            throw c.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 != 0) {
            throw c.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            h hVar = new h();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int readShort = this.a.readShort() & hs2.MAX_VALUE;
                int readInt = this.a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            throw c.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        throw c.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw c.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                hVar.i(readShort, readInt);
            }
            handler.settings(false, hVar);
        }
    }

    private void o(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw c.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.a.readInt() & 2147483647L;
        if (readInt == 0) {
            throw c.d("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        handler.windowUpdate(i2, readInt);
    }

    public boolean b(boolean z, Handler handler) throws IOException {
        try {
            this.a.require(9L);
            int h = h(this.a);
            if (h < 0 || h > 16384) {
                throw c.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(h));
            }
            byte readByte = (byte) (this.a.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.a.readByte() & 255);
                int readInt = this.a.readInt() & Integer.MAX_VALUE;
                Logger logger = e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(c.b(true, readInt, h, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        d(handler, h, readByte2, readInt);
                        break;
                    case 1:
                        g(handler, h, readByte2, readInt);
                        break;
                    case 2:
                        k(handler, h, readByte2, readInt);
                        break;
                    case 3:
                        m(handler, h, readByte2, readInt);
                        break;
                    case 4:
                        n(handler, h, readByte2, readInt);
                        break;
                    case 5:
                        l(handler, h, readByte2, readInt);
                        break;
                    case 6:
                        i(handler, h, readByte2, readInt);
                        break;
                    case 7:
                        e(handler, h, readByte2, readInt);
                        break;
                    case 8:
                        o(handler, h, readByte2, readInt);
                        break;
                    default:
                        this.a.skip(h);
                        break;
                }
                return true;
            }
            throw c.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (EOFException unused) {
            return false;
        }
    }

    public void c(Handler handler) throws IOException {
        if (this.c) {
            if (!b(true, handler)) {
                throw c.d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        BufferedSource bufferedSource = this.a;
        ByteString byteString = c.a;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger = e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(okhttp3.internal.a.q("<< CONNECTION %s", readByteString.hex()));
        }
        if (!byteString.equals(readByteString)) {
            throw c.d("Expected a connection header but was %s", readByteString.utf8());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }
}
