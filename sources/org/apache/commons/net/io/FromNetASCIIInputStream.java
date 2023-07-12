package org.apache.commons.net.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FromNetASCIIInputStream extends PushbackInputStream {
    static final String _lineSeparator;
    static final byte[] _lineSeparatorBytes;
    static final boolean _noConversionRequired;
    private int __length;

    static {
        String property = System.getProperty("line.separator");
        _lineSeparator = property;
        _noConversionRequired = property.equals(SocketClient.NETASCII_EOL);
        try {
            _lineSeparatorBytes = property.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Broken JVM - cannot find US-ASCII charset!", e);
        }
    }

    public FromNetASCIIInputStream(InputStream inputStream) {
        super(inputStream, _lineSeparatorBytes.length + 1);
        this.__length = 0;
    }

    private int __read() throws IOException {
        int read = super.read();
        if (read == 13) {
            int read2 = super.read();
            if (read2 != 10) {
                if (read2 != -1) {
                    unread(read2);
                }
                return 13;
            }
            unread(_lineSeparatorBytes);
            this.__length--;
            return super.read();
        }
        return read;
    }

    public static final boolean isConversionRequired() {
        return !_noConversionRequired;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (((PushbackInputStream) this).in != null) {
            return (((PushbackInputStream) this).buf.length - ((PushbackInputStream) this).pos) + ((PushbackInputStream) this).in.available();
        }
        throw new IOException("Stream closed");
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (_noConversionRequired) {
            return super.read();
        }
        return __read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (_noConversionRequired) {
            return super.read(bArr, i, i2);
        }
        if (i2 < 1) {
            return 0;
        }
        int available = available();
        if (i2 > available) {
            i2 = available;
        }
        this.__length = i2;
        if (i2 < 1) {
            this.__length = 1;
        }
        int __read = __read();
        if (__read == -1) {
            return -1;
        }
        int i4 = i;
        while (true) {
            i3 = i4 + 1;
            bArr[i4] = (byte) __read;
            int i5 = this.__length - 1;
            this.__length = i5;
            if (i5 <= 0 || (__read = __read()) == -1) {
                break;
            }
            i4 = i3;
        }
        return i3 - i;
    }
}
