package com.taobao.accs.utl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MessageStreamReader extends ByteArrayInputStream {
    public MessageStreamReader(byte[] bArr) {
        super(bArr);
    }

    public byte[] readAll() throws IOException {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }

    public String readAllString() throws IOException {
        return new String(readAll(), "utf-8");
    }

    public int readByte() {
        return read() & 255;
    }

    public int readInt() {
        return (readShort() << 16) | readShort();
    }

    public long readLong() {
        return (readInt() << 32) | readInt();
    }

    public int readShort() {
        return (readByte() << 8) | readByte();
    }

    public String readString(int i) throws IOException {
        byte[] bArr = new byte[i];
        int read = read(bArr);
        if (read == i) {
            return new String(bArr, "utf-8");
        }
        throw new IOException("read len not match. ask for " + i + " but read for " + read);
    }
}
