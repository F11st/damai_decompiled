package com.amap.api.mapcore.util;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import tb.km1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gr {
    static final /* synthetic */ boolean a = true;
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, km1.OP_MAX_COUNT, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, -9, -9, -9, -9, km1.OP_UNARY_MIN, -9, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private gr() {
    }

    private static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return e;
        }
        if ((i & 32) == 32) {
            return g;
        }
        return c;
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] b2 = b(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = b2[i5 & 63];
            return bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            return new byte[0];
        }
        if (i2 >= 4) {
            byte[] c2 = c(i3);
            byte[] bArr2 = new byte[(i2 * 3) / 4];
            byte[] bArr3 = new byte[4];
            int i5 = 0;
            int i6 = 0;
            while (i < i4) {
                byte b2 = c2[bArr[i] & 255];
                if (b2 < -5) {
                    throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                }
                if (b2 >= -1) {
                    int i7 = i5 + 1;
                    bArr3[i5] = bArr[i];
                    if (i7 > 3) {
                        i6 += b(bArr3, 0, bArr2, i6, i3);
                        if (bArr[i] == 61) {
                            break;
                        }
                        i5 = 0;
                    } else {
                        i5 = i7;
                    }
                }
                i++;
            }
            byte[] bArr4 = new byte[i6];
            System.arraycopy(bArr2, 0, bArr4, 0, i6);
            return bArr4;
        }
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was " + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 >= 0) {
            if (i + i2 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            }
            if ((i3 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        aVar = new a(byteArrayOutputStream, i3 | 1);
                    } catch (IOException e2) {
                        e = e2;
                        aVar = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        aVar = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    aVar = null;
                    gZIPOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = 0;
                    aVar = null;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(aVar);
                    try {
                        gZIPOutputStream.write(bArr, i, i2);
                        gZIPOutputStream.close();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            aVar.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e4) {
                        e = e4;
                        gZIPOutputStream2 = byteArrayOutputStream;
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = gZIPOutputStream2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                aVar.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream2 = gZIPOutputStream;
                        gZIPOutputStream2.close();
                        aVar.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    gZIPOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream2.close();
                    aVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } else {
                boolean z = (i3 & 8) != 0;
                int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                if (z) {
                    i4 += i4 / 76;
                }
                int i5 = i4;
                byte[] bArr2 = new byte[i5];
                int i6 = i2 - 2;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i6) {
                    int i10 = i7;
                    a(bArr, i7 + i, 3, bArr2, i8, i3);
                    int i11 = i9 + 4;
                    if (!z || i11 < 76) {
                        i9 = i11;
                    } else {
                        bArr2[i8 + 4] = 10;
                        i8++;
                        i9 = 0;
                    }
                    i7 = i10 + 3;
                    i8 += 4;
                }
                int i12 = i7;
                if (i12 < i2) {
                    a(bArr, i12 + i, i2 - i12, bArr2, i8, i3);
                    i8 += 4;
                }
                int i13 = i8;
                if (i13 <= i5 - 1) {
                    byte[] bArr3 = new byte[i13];
                    System.arraycopy(bArr2, 0, bArr3, 0, i13);
                    return bArr3;
                }
                return bArr2;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!a) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public a(OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.a = z;
            int i2 = z ? 3 : 4;
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = gr.c(i);
        }

        public void a() throws IOException {
            int i = this.b;
            if (i > 0) {
                if (this.a) {
                    ((FilterOutputStream) this).out.write(gr.b(this.g, this.c, i, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64Util input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(i);
            } else if (this.a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                int i3 = i2 + 1;
                this.b = i3;
                bArr[i2] = (byte) i;
                int i4 = this.d;
                if (i3 >= i4) {
                    ((FilterOutputStream) this).out.write(gr.b(this.g, bArr, i4, this.i));
                    int i5 = this.e + 4;
                    this.e = i5;
                    if (this.f && i5 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte[] bArr2 = this.j;
                int i6 = i & 127;
                if (bArr2[i6] > -5) {
                    byte[] bArr3 = this.c;
                    int i7 = this.b;
                    int i8 = i7 + 1;
                    this.b = i8;
                    bArr3[i7] = (byte) i;
                    if (i8 >= this.d) {
                        ((FilterOutputStream) this).out.write(this.g, 0, gr.b(bArr3, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (bArr2[i6] != -5) {
                    throw new IOException("Invalid character in Base64Util data.");
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] b2 = b(bArr, i, i2, i3);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x005c -> B:73:0x005c). Please submit an issue!!! */
    public static byte[] a(String str, int i) throws IOException {
        byte[] bytes;
        ?? length;
        GZIPInputStream gZIPInputStream;
        Objects.requireNonNull(str, "Input string was null.");
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] c2 = c(bytes, 0, bytes.length, i);
        boolean z = (i & 4) != 0;
        if (c2 != null && (length = c2.length) >= 4 && !z && 35615 == ((c2[0] & 255) | ((c2[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        length = new ByteArrayInputStream(c2);
                        try {
                            gZIPInputStream = new GZIPInputStream(length);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (IOException e2) {
                                    e = e2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    length = length;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        return c2;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            length.close();
                                        } catch (Exception unused4) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    length.close();
                                    throw th;
                                }
                            }
                            c2 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                        } catch (IOException e3) {
                            e = e3;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        length = 0;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        length = 0;
                        gZIPInputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
                }
            } catch (Exception unused5) {
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                length.close();
            } catch (Exception unused7) {
            }
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i >= 0 && (i4 = i + 3) < bArr.length) {
            if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                byte[] c2 = c(i3);
                int i6 = i + 2;
                if (bArr[i6] == 61) {
                    bArr2[i2] = (byte) ((((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18)) >>> 16);
                    return 1;
                } else if (bArr[i4] == 61) {
                    int i7 = ((c2[bArr[i6]] & 255) << 6) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18);
                    bArr2[i2] = (byte) (i7 >>> 16);
                    bArr2[i2 + 1] = (byte) (i7 >>> 8);
                    return 2;
                } else {
                    int i8 = (c2[bArr[i4]] & 255) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i6]] & 255) << 6);
                    bArr2[i2] = (byte) (i8 >> 16);
                    bArr2[i2 + 1] = (byte) (i8 >> 8);
                    bArr2[i5] = (byte) i8;
                    return 3;
                }
            }
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
    }
}
