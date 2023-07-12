package com.heytap.msp.push.encrypt;

import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.codec.binary.StringUtils;
import tb.km1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a extends b {
    private static final int m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;
    static final byte[] a = {13, 10};
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, km1.OP_MAX_COUNT, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, a);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            byte[] r1 = com.heytap.msp.push.encrypt.a.r
            r4.u = r1
            r1 = 0
            if (r6 == 0) goto L48
            boolean r2 = r4.l(r6)
            if (r2 != 0) goto L28
            if (r5 <= 0) goto L48
            int r5 = r6.length
            int r5 = r5 + r3
            r4.x = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.v = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4c
        L28:
            java.lang.String r5 = org.apache.commons.codec.binary.StringUtils.newStringUtf8(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L48:
            r4.x = r3
            r4.v = r1
        L4c:
            int r5 = r4.x
            int r5 = r5 + (-1)
            r4.w = r5
            if (r7 == 0) goto L57
            byte[] r5 = com.heytap.msp.push.encrypt.a.q
            goto L59
        L57:
            byte[] r5 = com.heytap.msp.push.encrypt.a.p
        L59:
            r4.t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.msp.push.encrypt.a.<init>(int, byte[], boolean):void");
    }

    public a(boolean z) {
        this(76, a, z);
    }

    public static boolean a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return b(StringUtils.getBytesUtf8(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "encodeInteger called with null parameter");
        return a(b(bigInteger), false);
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, a, z2);
        long m2 = aVar.m(bArr);
        if (m2 <= i) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m2 + ") than the specified maximum size of " + i);
    }

    public static boolean b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!a(bArr[i]) && !b.c(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
    }

    static byte[] b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 == 0 || (bigInteger.bitLength() / 8) + 1 != bitLength / 8) {
            int length = byteArray.length;
            if (bigInteger.bitLength() % 8 == 0) {
                length--;
            } else {
                i = 0;
            }
            int i2 = bitLength / 8;
            int i3 = i2 - length;
            byte[] bArr = new byte[i2];
            System.arraycopy(byteArray, i, bArr, i3, length);
            return bArr;
        }
        return byteArray;
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    @Override // com.heytap.msp.push.encrypt.b
    void a(byte[] bArr, int i, int i2) {
        if (this.j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                a(this.x);
                int i4 = (this.l + 1) % 3;
                this.l = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (this.y << 8) + i6;
                this.y = i7;
                if (i4 == 0) {
                    byte[] bArr2 = this.h;
                    int i8 = this.i;
                    int i9 = i8 + 1;
                    this.i = i9;
                    byte[] bArr3 = this.t;
                    bArr2[i8] = bArr3[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    this.i = i10;
                    bArr2[i9] = bArr3[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    this.i = i11;
                    bArr2[i10] = bArr3[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    this.i = i12;
                    bArr2[i11] = bArr3[i7 & 63];
                    int i13 = this.k + 4;
                    this.k = i13;
                    int i14 = this.g;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr4 = this.v;
                        System.arraycopy(bArr4, 0, bArr2, i12, bArr4.length);
                        this.i += this.v.length;
                        this.k = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        this.j = true;
        if (this.l == 0 && this.g == 0) {
            return;
        }
        a(this.x);
        int i15 = this.i;
        int i16 = this.l;
        if (i16 == 1) {
            byte[] bArr5 = this.h;
            int i17 = i15 + 1;
            this.i = i17;
            byte[] bArr6 = this.t;
            int i18 = this.y;
            bArr5[i15] = bArr6[(i18 >> 2) & 63];
            int i19 = i17 + 1;
            this.i = i19;
            bArr5[i17] = bArr6[(i18 << 4) & 63];
            if (bArr6 == p) {
                int i20 = i19 + 1;
                this.i = i20;
                bArr5[i19] = 61;
                this.i = i20 + 1;
                bArr5[i20] = 61;
            }
        } else if (i16 == 2) {
            byte[] bArr7 = this.h;
            int i21 = i15 + 1;
            this.i = i21;
            byte[] bArr8 = this.t;
            int i22 = this.y;
            bArr7[i15] = bArr8[(i22 >> 10) & 63];
            int i23 = i21 + 1;
            this.i = i23;
            bArr7[i21] = bArr8[(i22 >> 4) & 63];
            int i24 = i23 + 1;
            this.i = i24;
            bArr7[i23] = bArr8[(i22 << 2) & 63];
            if (bArr8 == p) {
                this.i = i24 + 1;
                bArr7[i24] = 61;
            }
        }
        int i25 = this.k;
        int i26 = this.i;
        int i27 = i25 + (i26 - i15);
        this.k = i27;
        if (this.g <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr9 = this.v;
        System.arraycopy(bArr9, 0, this.h, i26, bArr9.length);
        this.i += this.v.length;
    }

    public boolean a() {
        return this.t == q;
    }

    @Override // com.heytap.msp.push.encrypt.b
    void b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.j) {
            return;
        }
        if (i2 < 0) {
            this.j = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            a(this.w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (this.l + 1) % 4;
                    this.l = i5;
                    int i6 = (this.y << 6) + b;
                    this.y = i6;
                    if (i5 == 0) {
                        byte[] bArr3 = this.h;
                        int i7 = this.i;
                        int i8 = i7 + 1;
                        this.i = i8;
                        bArr3[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        this.i = i9;
                        bArr3[i8] = (byte) ((i6 >> 8) & 255);
                        this.i = i9 + 1;
                        bArr3[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.j || this.l == 0) {
            return;
        }
        a(this.w);
        int i10 = this.l;
        if (i10 == 2) {
            int i11 = this.y >> 4;
            this.y = i11;
            byte[] bArr4 = this.h;
            int i12 = this.i;
            this.i = i12 + 1;
            bArr4[i12] = (byte) (i11 & 255);
        } else if (i10 != 3) {
        } else {
            int i13 = this.y >> 2;
            this.y = i13;
            byte[] bArr5 = this.h;
            int i14 = this.i;
            int i15 = i14 + 1;
            this.i = i15;
            bArr5[i14] = (byte) ((i13 >> 8) & 255);
            this.i = i15 + 1;
            bArr5[i15] = (byte) (i13 & 255);
        }
    }

    @Override // com.heytap.msp.push.encrypt.b
    protected boolean b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
