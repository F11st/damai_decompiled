package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FromNetASCIIOutputStream extends FilterOutputStream {
    private boolean __lastWasCR;

    public FromNetASCIIOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.__lastWasCR = false;
    }

    private void __write(int i) throws IOException {
        if (i == 10) {
            if (this.__lastWasCR) {
                ((FilterOutputStream) this).out.write(FromNetASCIIInputStream._lineSeparatorBytes);
                this.__lastWasCR = false;
                return;
            }
            this.__lastWasCR = false;
            ((FilterOutputStream) this).out.write(10);
        } else if (i != 13) {
            if (this.__lastWasCR) {
                ((FilterOutputStream) this).out.write(13);
                this.__lastWasCR = false;
            }
            ((FilterOutputStream) this).out.write(i);
        } else {
            this.__lastWasCR = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            super.close();
            return;
        }
        if (this.__lastWasCR) {
            ((FilterOutputStream) this).out.write(13);
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            ((FilterOutputStream) this).out.write(i);
        } else {
            __write(i);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            int i4 = i + 1;
            __write(bArr[i]);
            i = i4;
            i2 = i3;
        }
    }
}
