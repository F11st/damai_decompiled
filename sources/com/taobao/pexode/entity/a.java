package com.taobao.pexode.entity;

import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends RewindableStream {
    private byte[] a;
    private int b;
    private int c;
    private int d;
    private final int e;

    public a(byte[] bArr, int i, int i2) {
        super(1);
        this.a = bArr;
        this.b = i;
        this.c = i;
        int i3 = i2 + i;
        this.d = i3 > bArr.length ? bArr.length : i3;
        this.e = i;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.d - this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public byte[] getBuffer() {
        return this.a;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public int getBufferLength() {
        return this.d;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public int getBufferOffset() {
        return this.e;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public FileDescriptor getFD() {
        return null;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.c = this.b;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        int i;
        int i2 = this.b;
        if (i2 < this.d) {
            byte[] bArr = this.a;
            this.b = i2 + 1;
            i = bArr[i2] & 255;
        } else {
            i = -1;
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.b = this.c;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public void rewind() {
        this.b = this.e;
    }

    @Override // com.taobao.pexode.entity.RewindableStream
    public void rewindAndSetBufferSize(int i) {
        rewind();
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) {
        if (j <= 0) {
            return 0L;
        }
        int i = this.b;
        int i2 = this.d;
        if (i2 - i >= j) {
            i2 = (int) (i + j);
        }
        this.b = i2;
        return i2 - i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3 = this.b;
        int i4 = this.d;
        if (i3 >= i4) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i4 - i3 < i2) {
            i2 = i4 - i3;
        }
        System.arraycopy(this.a, i3, bArr, i, i2);
        this.b += i2;
        return i2;
    }
}
