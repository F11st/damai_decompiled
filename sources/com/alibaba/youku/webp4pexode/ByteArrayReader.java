package com.alibaba.youku.webp4pexode;

import androidx.core.view.MotionEventCompat;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ByteArrayReader {
    private final byte[] data;
    private final int offset;
    private int position;
    private final int size;

    ByteArrayReader(byte[] bArr, int i, int i2) {
        this.position = 0;
        this.data = bArr;
        this.offset = i;
        this.size = i2;
        this.position = i;
    }

    public int getByte() throws IOException {
        int i = this.position;
        if (i >= this.offset + this.size) {
            return -1;
        }
        byte[] bArr = this.data;
        this.position = i + 1;
        return bArr[i];
    }

    public int getUInt16() throws IOException {
        return ((getByte() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (getByte() & 255);
    }

    public short getUInt8() throws IOException {
        return (short) (getByte() & 255);
    }

    public int read(byte[] bArr, int i) throws IOException {
        int min = Math.min((this.offset + this.size) - this.position, i);
        if (min == 0) {
            return -1;
        }
        System.arraycopy(this.data, this.position, bArr, 0, min);
        return min;
    }

    public long skip(long j) throws IOException {
        int min = (int) Math.min((this.offset + this.size) - this.position, j);
        this.position += min;
        return min;
    }
}
