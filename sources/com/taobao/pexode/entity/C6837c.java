package com.taobao.pexode.entity;

import com.taobao.pexode.C6827a;
import com.taobao.pexode.Pexode;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import tb.hh0;

/* compiled from: Taobao */
/* renamed from: com.taobao.pexode.entity.c */
/* loaded from: classes11.dex */
public class C6837c extends RewindableStream {
    protected final InputStream a;
    private int b;
    private int c;
    private int d;
    private byte[] e;
    private final boolean f;
    private boolean g;
    protected boolean h;

    public C6837c(InputStream inputStream, int i) {
        this(3, inputStream, i);
    }

    private int a(byte[] bArr, int i, int i2) throws IOException {
        int min = Math.min(i2, this.b - this.c);
        int i3 = this.c + min;
        byte[] bArr2 = this.e;
        if (bArr2 == null || i3 > bArr2.length) {
            byte[] g = C6827a.f().g(Math.min(i3 + min, this.b));
            byte[] bArr3 = this.e;
            if (bArr3 != null) {
                System.arraycopy(bArr3, 0, g, 0, this.c);
                C6827a.f().h(this.e);
            }
            this.e = g;
        }
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int i6 = this.d;
            int read = this.a.read(this.e, i6, min - i5);
            if (read >= 0) {
                if (read > 0) {
                    int i7 = this.c + read;
                    this.c = i7;
                    this.d = i7;
                    System.arraycopy(this.e, i6, bArr, i + i5, read);
                }
                i5 += read;
                i4 = i5;
                if (i5 == min) {
                    break;
                }
            } else {
                this.g = true;
                hh0.a(Pexode.TAG, "bufferAndWriteTo() read stream end -1 now", new Object[0]);
                break;
            }
        }
        return i4;
    }

    private int b(byte[] bArr, int i, int i2) throws IOException {
        int read = this.a.read(bArr, i, i2);
        if (read < 0) {
            this.g = true;
            return -1;
        }
        if (read > 0) {
            this.d += read;
            C6827a.f().h(this.e);
            this.e = null;
        }
        return read;
    }

    private int d(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.c - this.d);
        System.arraycopy(this.e, this.d, bArr, i, min);
        this.d += min;
        return min;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i) {
        this.b = i;
        if (this.f) {
            this.a.mark(i);
        }
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public byte[] getBuffer() {
        return this.e;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public int getBufferLength() {
        int i = this.c;
        return i > 0 ? i : this.b;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public int getBufferOffset() {
        return 0;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public FileDescriptor getFD() {
        return null;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int b;
        int a;
        if (bArr != null && i >= 0 && i2 > 0) {
            int i4 = -1;
            if (this.g) {
                return -1;
            }
            if (this.f) {
                i3 = i2;
            } else {
                if (this.d < this.c) {
                    i4 = d(bArr, i, i2);
                    i3 = i2 - i4;
                } else {
                    i3 = i2;
                }
                if (i3 > 0 && this.c < this.b && (a = a(bArr, (i + i2) - i3, i3)) >= 0) {
                    i3 -= a;
                    i4 = i4 < 0 ? a : i4 + a;
                }
            }
            return (this.g || i3 <= 0 || (b = b(bArr, (i + i2) - i3, i3)) < 0) ? i4 : i4 < 0 ? b : i4 + b;
        }
        throw new IOException("read parameters illegal");
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public void rewind() throws IOException {
        if (this.f) {
            this.a.reset();
        } else if (this.d > this.c) {
            throw new IOException("cannot rewind cause input stream offset too far");
        }
        this.d = 0;
        this.g = false;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public void rewindAndSetBufferSize(int i) throws IOException {
        rewind();
        e(i);
    }

    public C6837c(int i, InputStream inputStream, int i2) {
        super(i);
        this.a = inputStream;
        this.f = inputStream.markSupported();
        e(i2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) > 0) {
            return bArr[0];
        }
        return -1;
    }
}
