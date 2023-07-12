package com.meizu.cloud.pushsdk.c.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.g */
/* loaded from: classes10.dex */
public final class C5987g {
    private static final Logger a = Logger.getLogger(C5987g.class.getName());

    private C5987g() {
    }

    public static InterfaceC5983c a(InterfaceC5992l interfaceC5992l) {
        if (interfaceC5992l != null) {
            return new C5988h(interfaceC5992l);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static InterfaceC5984d a(InterfaceC5993m interfaceC5993m) {
        if (interfaceC5993m != null) {
            return new C5989i(interfaceC5993m);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static InterfaceC5992l a(OutputStream outputStream) {
        return a(outputStream, new C5994n());
    }

    private static InterfaceC5992l a(final OutputStream outputStream, final C5994n c5994n) {
        if (outputStream != null) {
            if (c5994n != null) {
                return new InterfaceC5992l() { // from class: com.meizu.cloud.pushsdk.c.g.g.1
                    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l
                    public void a(C5982b c5982b, long j) throws IOException {
                        C5995o.a(c5982b.b, 0L, j);
                        while (j > 0) {
                            C5994n.this.a();
                            C5990j c5990j = c5982b.a;
                            int min = (int) Math.min(j, c5990j.c - c5990j.b);
                            outputStream.write(c5990j.a, c5990j.b, min);
                            int i = c5990j.b + min;
                            c5990j.b = i;
                            long j2 = min;
                            j -= j2;
                            c5982b.b -= j2;
                            if (i == c5990j.c) {
                                c5982b.a = c5990j.a();
                                C5991k.a(c5990j);
                            }
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    public String toString() {
                        return "sink(" + outputStream + jn1.BRACKET_END_STR;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static InterfaceC5993m a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static InterfaceC5993m a(InputStream inputStream) {
        return a(inputStream, new C5994n());
    }

    private static InterfaceC5993m a(final InputStream inputStream, final C5994n c5994n) {
        if (inputStream != null) {
            if (c5994n != null) {
                return new InterfaceC5993m() { // from class: com.meizu.cloud.pushsdk.c.g.g.2
                    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
                    public long b(C5982b c5982b, long j) throws IOException {
                        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j);
                        } else if (i == 0) {
                            return 0L;
                        } else {
                            C5994n.this.a();
                            C5990j c = c5982b.c(1);
                            int read = inputStream.read(c.a, c.c, (int) Math.min(j, 2048 - c.c));
                            if (read == -1) {
                                return -1L;
                            }
                            c.c += read;
                            long j2 = read;
                            c5982b.b += j2;
                            return j2;
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5993m, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + jn1.BRACKET_END_STR;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }
}
