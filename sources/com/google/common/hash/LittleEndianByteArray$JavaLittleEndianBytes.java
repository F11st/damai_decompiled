package com.google.common.hash;

import com.google.common.primitives.Longs;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum LittleEndianByteArray$JavaLittleEndianBytes implements LittleEndianByteArray$LittleEndianBytes {
    INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes.1
        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i) {
            return Longs.d(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$LittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            long j2 = 255;
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i + i2] = (byte) ((j & j2) >> (i2 * 8));
                j2 <<= 8;
            }
        }
    }
}
