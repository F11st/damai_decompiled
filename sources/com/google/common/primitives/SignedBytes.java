package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int b = SignedBytes.b(bArr[i], bArr2[i]);
                if (b != 0) {
                    return b;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j) {
        byte b = (byte) j;
        du1.h(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int b(byte b, byte b2) {
        return b - b2;
    }
}
