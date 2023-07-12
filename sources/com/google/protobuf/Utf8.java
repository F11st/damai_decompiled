package com.google.protobuf;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.arch.v3.data.Constants;
import java.nio.ByteBuffer;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Utf8 {
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    private static final AbstractC5391a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.Utf8$a */
    /* loaded from: classes10.dex */
    static abstract class AbstractC5391a {
        AbstractC5391a() {
        }

        private static int f(ByteBuffer byteBuffer, int i, int i2) {
            int j = i + Utf8.j(byteBuffer, i, i2);
            while (j < i2) {
                int i3 = j + 1;
                byte b = byteBuffer.get(j);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        i3++;
                    } else if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.n(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (byteBuffer.get(i4) <= -65) {
                                i3 = i5 + 1;
                                if (byteBuffer.get(i5) > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 1) {
                        return Utf8.n(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i6 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || byteBuffer.get(i6) > -65))) {
                            return -1;
                        }
                        j = i6 + 1;
                    }
                }
                j = i3;
            }
            return 0;
        }

        abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        final boolean b(ByteBuffer byteBuffer, int i, int i2) {
            return d(0, byteBuffer, i, i2) == 0;
        }

        final boolean c(byte[] bArr, int i, int i2) {
            return e(0, bArr, i, i2) == 0;
        }

        final int d(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return e(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return h(i, byteBuffer, i2, i3);
            } else {
                return g(i, byteBuffer, i2, i3);
            }
        }

        abstract int e(int i, byte[] bArr, int i2, int i3);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r8.get(r9) > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008a, code lost:
            if (r8.get(r9) > (-65)) goto L51;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int g(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L8d
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1d
                r7 = -62
                if (r0 < r7) goto L1c
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1c
            L1a:
                r9 = r7
                goto L8d
            L1c:
                return r2
            L1d:
                r4 = -16
                if (r0 >= r4) goto L4e
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L37
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L34
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L34:
                r5 = r9
                r9 = r7
                r7 = r5
            L37:
                if (r7 > r3) goto L4d
                r4 = -96
                if (r0 != r1) goto L3f
                if (r7 < r4) goto L4d
            L3f:
                r1 = -19
                if (r0 != r1) goto L45
                if (r7 >= r4) goto L4d
            L45:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4d:
                return r2
            L4e:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L62:
                r9 = r7
                goto L67
            L64:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L67:
                if (r4 != 0) goto L77
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L76
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r4)
                return r7
            L76:
                r9 = r7
            L77:
                if (r1 > r3) goto L8c
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L8c
                if (r4 > r3) goto L8c
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L8c:
                return r2
            L8d:
                int r7 = f(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.AbstractC5391a.g(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int h(int i, ByteBuffer byteBuffer, int i2, int i3);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.Utf8$b */
    /* loaded from: classes10.dex */
    static final class C5392b extends AbstractC5391a {
        C5392b() {
        }

        private static int i(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return j(bArr, i, i2);
        }

        private static int j(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.o(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (bArr[i4] <= -65) {
                                i3 = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 1) {
                        return Utf8.o(bArr, i3, i2);
                    } else {
                        int i6 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                            i = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.AbstractC5391a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5392b.a(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x007e, code lost:
            if (r8[r9] > (-65)) goto L51;
         */
        @Override // com.google.protobuf.Utf8.AbstractC5391a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int e(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L81
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1b
                r7 = -62
                if (r0 < r7) goto L1a
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1a
            L18:
                r9 = r7
                goto L81
            L1a:
                return r2
            L1b:
                r4 = -16
                if (r0 >= r4) goto L48
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L33
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L30
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L30:
                r5 = r9
                r9 = r7
                r7 = r5
            L33:
                if (r7 > r3) goto L47
                r4 = -96
                if (r0 != r1) goto L3b
                if (r7 < r4) goto L47
            L3b:
                r1 = -19
                if (r0 != r1) goto L41
                if (r7 >= r4) goto L47
            L41:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L47:
                return r2
            L48:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L5a:
                r9 = r7
                goto L5f
            L5c:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L5f:
                if (r4 != 0) goto L6d
                int r7 = r9 + 1
                r4 = r8[r9]
                if (r7 < r10) goto L6c
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r4)
                return r7
            L6c:
                r9 = r7
            L6d:
                if (r1 > r3) goto L80
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L80
                if (r4 > r3) goto L80
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L80:
                return r2
            L81:
                int r7 = i(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5392b.e(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.AbstractC5391a
        int h(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return g(i, byteBuffer, i2, i3);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.Utf8$c */
    /* loaded from: classes10.dex */
    static final class C5393c extends AbstractC5391a {
        C5393c() {
        }

        static boolean i() {
            return C5418n.k() && C5418n.l();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int j(long r8, int r10) {
            /*
                int r0 = l(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.C5418n.f(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.C5418n.f(r8)
                if (r8 <= r4) goto L37
                goto L39
            L37:
                r8 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r10 >= r6) goto L46
                int r8 = n(r8, r1, r10)
                return r8
            L46:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.C5418n.f(r8)
                if (r8 > r4) goto L63
                r9 = -96
                if (r1 != r0) goto L56
                if (r8 < r9) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r8 >= r9) goto L63
            L5c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.C5418n.f(r6)
                if (r8 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r10 >= r0) goto L6c
                int r8 = n(r8, r1, r10)
                return r8
            L6c:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.C5418n.f(r8)
                if (r8 > r4) goto L8e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.C5418n.f(r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.C5418n.f(r8)
                if (r8 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5393c.j(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int k(byte[] r8, long r9, int r11) {
            /*
                int r0 = m(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.C5418n.g(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C5418n.g(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = o(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C5418n.g(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.C5418n.g(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = o(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.C5418n.g(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.C5418n.g(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.C5418n.g(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5393c.k(byte[], long, int):int");
        }

        private static int l(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (C5418n.f(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (C5418n.h(j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        private static int m(byte[] bArr, long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (C5418n.g(bArr, j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (C5418n.i(bArr, j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        private static int n(long j, int i, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.m(i, C5418n.f(j), C5418n.f(j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.l(i, C5418n.f(j));
            }
            return Utf8.k(i);
        }

        private static int o(byte[] bArr, int i, long j, int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return Utf8.m(i, C5418n.g(bArr, j), C5418n.g(bArr, j + 1));
                    }
                    throw new AssertionError();
                }
                return Utf8.l(i, C5418n.g(bArr, j));
            }
            return Utf8.k(i);
        }

        @Override // com.google.protobuf.Utf8.AbstractC5391a
        int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            char c;
            long j;
            long e;
            long j2;
            long j3;
            int i3;
            char charAt;
            long e2 = C5418n.e() + i;
            long j4 = i2 + e2;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                c = 128;
                j = 1;
                if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                C5418n.m(bArr, e2, (byte) charAt);
                i4++;
                e2 = 1 + e2;
            }
            if (i4 == length) {
                e = C5418n.e();
            } else {
                while (i4 < length) {
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 >= c || e2 >= j4) {
                        if (charAt2 < 2048 && e2 <= j4 - 2) {
                            long j5 = e2 + j;
                            C5418n.m(bArr, e2, (byte) ((charAt2 >>> 6) | 960));
                            C5418n.m(bArr, j5, (byte) ((charAt2 & jn1.CONDITION_IF) | 128));
                            j2 = j5 + j;
                            j3 = j;
                        } else if ((charAt2 >= 55296 && 57343 >= charAt2) || e2 > j4 - 3) {
                            if (e2 <= j4 - 4) {
                                int i5 = i4 + 1;
                                if (i5 != length) {
                                    char charAt3 = charSequence.charAt(i5);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        long j6 = e2 + 1;
                                        C5418n.m(bArr, e2, (byte) ((codePoint >>> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN));
                                        long j7 = j6 + 1;
                                        C5418n.m(bArr, j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j8 = j7 + 1;
                                        C5418n.m(bArr, j7, (byte) (((codePoint >>> 6) & 63) | 128));
                                        j3 = 1;
                                        j2 = j8 + 1;
                                        C5418n.m(bArr, j8, (byte) ((codePoint & 63) | 128));
                                        i4 = i5;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                throw new UnpairedSurrogateException(i4 - 1, length);
                            } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                throw new UnpairedSurrogateException(i4, length);
                            } else {
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + e2);
                            }
                        } else {
                            long j9 = e2 + j;
                            C5418n.m(bArr, e2, (byte) ((charAt2 >>> '\f') | GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH));
                            long j10 = j9 + j;
                            C5418n.m(bArr, j9, (byte) (((charAt2 >>> 6) & 63) | 128));
                            C5418n.m(bArr, j10, (byte) ((charAt2 & jn1.CONDITION_IF) | 128));
                            j2 = j10 + 1;
                            j3 = 1;
                        }
                        i4++;
                        c = 128;
                        long j11 = j3;
                        e2 = j2;
                        j = j11;
                    } else {
                        long j12 = e2 + j;
                        C5418n.m(bArr, e2, (byte) charAt2);
                        j3 = j;
                        j2 = j12;
                    }
                    i4++;
                    c = 128;
                    long j112 = j3;
                    e2 = j2;
                    j = j112;
                }
                e = C5418n.e();
            }
            return (int) (e2 - e);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
            if (com.google.protobuf.C5418n.g(r13, r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
            if (com.google.protobuf.C5418n.g(r13, r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.AbstractC5391a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int e(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 214
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5393c.e(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
            if (com.google.protobuf.C5418n.f(r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
            if (com.google.protobuf.C5418n.f(r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.AbstractC5391a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int h(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.C5393c.h(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        a = C5393c.i() ? new C5393c() : new C5392b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.a(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += i(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + Constants.RequestStrategy.LOCAL_FIRST));
    }

    private static int i(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i2 - 7;
        int i4 = i;
        while (i4 < i3 && (byteBuffer.getLong(i4) & (-9187201950435737472L)) == 0) {
            i4 += 8;
        }
        return i4 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return m(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
                }
                throw new AssertionError();
            }
            return l(i, byteBuffer.get(i2));
        }
        return k(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return m(b, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return l(b, bArr[i]);
        }
        return k(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(ByteBuffer byteBuffer) {
        return a.b(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean q(byte[] bArr, int i, int i2) {
        return a.c(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return a.d(i, byteBuffer, i2, i3);
    }

    public static int s(int i, byte[] bArr, int i2, int i3) {
        return a.e(i, bArr, i2, i3);
    }
}
