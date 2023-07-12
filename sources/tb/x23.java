package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class x23 extends p43 {
    static final byte[] p = {13, 10};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, km1.OP_MAX_COUNT, 47};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] j;
    private final byte[] k;
    private final byte[] l;
    private final int m;
    private final int n;
    private int o;

    public x23() {
        this(0);
    }

    public x23(int i) {
        this(i, p);
    }

    public x23(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x23(int r5, byte[] r6, boolean r7) {
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
            byte[] r1 = tb.x23.s
            r4.k = r1
            r1 = 0
            if (r6 == 0) goto L48
            boolean r2 = r4.k(r6)
            if (r2 != 0) goto L28
            if (r5 <= 0) goto L48
            int r5 = r6.length
            int r5 = r5 + r3
            r4.n = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.l = r5
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
            r4.n = r3
            r4.l = r1
        L4c:
            int r5 = r4.n
            int r5 = r5 + (-1)
            r4.m = r5
            if (r7 == 0) goto L57
            byte[] r5 = tb.x23.r
            goto L59
        L57:
            byte[] r5 = tb.x23.q
        L59:
            r4.j = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.x23.<init>(int, byte[], boolean):void");
    }

    public static byte[] l(String str) {
        return new x23().h(str);
    }

    @Override // tb.p43
    void c(byte[] bArr, int i, int i2) {
        if (this.g) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                b(this.n);
                int i4 = (this.i + 1) % 3;
                this.i = i4;
                int i5 = i + 1;
                int i6 = bArr[i];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (this.o << 8) + i6;
                this.o = i7;
                if (i4 == 0) {
                    byte[] bArr2 = this.d;
                    int i8 = this.e;
                    int i9 = i8 + 1;
                    this.e = i9;
                    byte[] bArr3 = this.j;
                    bArr2[i8] = bArr3[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    this.e = i10;
                    bArr2[i9] = bArr3[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    this.e = i11;
                    bArr2[i10] = bArr3[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    this.e = i12;
                    bArr2[i11] = bArr3[i7 & 63];
                    int i13 = this.h + 4;
                    this.h = i13;
                    int i14 = this.a;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr4 = this.l;
                        System.arraycopy(bArr4, 0, bArr2, i12, bArr4.length);
                        this.e += this.l.length;
                        this.h = 0;
                    }
                }
                i3++;
                i = i5;
            }
            return;
        }
        this.g = true;
        if (this.i == 0 && this.a == 0) {
            return;
        }
        b(this.n);
        int i15 = this.e;
        int i16 = this.i;
        if (i16 == 1) {
            byte[] bArr5 = this.d;
            int i17 = i15 + 1;
            this.e = i17;
            byte[] bArr6 = this.j;
            int i18 = this.o;
            bArr5[i15] = bArr6[(i18 >> 2) & 63];
            int i19 = i17 + 1;
            this.e = i19;
            bArr5[i17] = bArr6[(i18 << 4) & 63];
            if (bArr6 == q) {
                int i20 = i19 + 1;
                this.e = i20;
                bArr5[i19] = 61;
                this.e = i20 + 1;
                bArr5[i20] = 61;
            }
        } else if (i16 == 2) {
            byte[] bArr7 = this.d;
            int i21 = i15 + 1;
            this.e = i21;
            byte[] bArr8 = this.j;
            int i22 = this.o;
            bArr7[i15] = bArr8[(i22 >> 10) & 63];
            int i23 = i21 + 1;
            this.e = i23;
            bArr7[i21] = bArr8[(i22 >> 4) & 63];
            int i24 = i23 + 1;
            this.e = i24;
            bArr7[i23] = bArr8[(i22 << 2) & 63];
            if (bArr8 == q) {
                this.e = i24 + 1;
                bArr7[i24] = 61;
            }
        }
        int i25 = this.h;
        int i26 = this.e;
        int i27 = i25 + (i26 - i15);
        this.h = i27;
        if (this.a <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr9 = this.l;
        System.arraycopy(bArr9, 0, this.d, i26, bArr9.length);
        this.e += this.l.length;
    }

    @Override // tb.p43
    void d(byte[] bArr, int i, int i2) {
        byte b;
        if (this.g) {
            return;
        }
        if (i2 < 0) {
            this.g = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            b(this.m);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.g = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = s;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (this.i + 1) % 4;
                    this.i = i5;
                    int i6 = (this.o << 6) + b;
                    this.o = i6;
                    if (i5 == 0) {
                        byte[] bArr3 = this.d;
                        int i7 = this.e;
                        int i8 = i7 + 1;
                        this.e = i8;
                        bArr3[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        this.e = i9;
                        bArr3[i8] = (byte) ((i6 >> 8) & 255);
                        this.e = i9 + 1;
                        bArr3[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.g || this.i == 0) {
            return;
        }
        b(this.m);
        int i10 = this.i;
        if (i10 == 2) {
            int i11 = this.o >> 4;
            this.o = i11;
            byte[] bArr4 = this.d;
            int i12 = this.e;
            this.e = i12 + 1;
            bArr4[i12] = (byte) (i11 & 255);
        } else if (i10 != 3) {
        } else {
            int i13 = this.o >> 2;
            this.o = i13;
            byte[] bArr5 = this.d;
            int i14 = this.e;
            int i15 = i14 + 1;
            this.e = i15;
            bArr5[i14] = (byte) ((i13 >> 8) & 255);
            this.e = i15 + 1;
            bArr5[i15] = (byte) (i13 & 255);
        }
    }

    @Override // tb.p43
    protected boolean e(byte b) {
        if (b >= 0) {
            byte[] bArr = this.k;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
