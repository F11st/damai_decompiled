package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class b extends JsonReader {
    private static final ByteString n = ByteString.encodeUtf8("'\\");
    private static final ByteString o = ByteString.encodeUtf8("\"\\");
    private static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString q = ByteString.encodeUtf8("\n\r");
    private static final ByteString r = ByteString.encodeUtf8("*/");
    private final BufferedSource h;
    private final Buffer i;
    private int j = 0;
    private long k;
    private int l;
    @Nullable
    private String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        this.h = bufferedSource;
        this.i = bufferedSource.buffer();
        r(6);
    }

    private boolean A(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        x();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.h.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        x();
        r3 = r6.i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.i.readByte();
        r6.i.readByte();
        J();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.i.readByte();
        r6.i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (I() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw w("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        x();
        J();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int B(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L84
            okio.Buffer r2 = r6.i
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L81
            r2 = 32
            if (r1 == r2) goto L81
            r2 = 13
            if (r1 == r2) goto L81
            r2 = 9
            if (r1 != r2) goto L25
            goto L81
        L25:
            okio.Buffer r2 = r6.i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.x()
            okio.Buffer r3 = r6.i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.i
            r1.readByte()
            okio.Buffer r1 = r6.i
            r1.readByte()
            r6.J()
            goto L1
        L5c:
            okio.Buffer r1 = r6.i
            r1.readByte()
            okio.Buffer r1 = r6.i
            r1.readByte()
            boolean r1 = r6.I()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.w(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L80
            r6.x()
            r6.J()
            goto L1
        L80:
            return r1
        L81:
            r1 = r3
            goto L2
        L84:
            if (r7 != 0) goto L88
            r7 = -1
            return r7
        L88:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.B(boolean):int");
    }

    private String C(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.i.getByte(indexOfElement) != 92) {
                    if (sb == null) {
                        String readUtf8 = this.i.readUtf8(indexOfElement);
                        this.i.readByte();
                        return readUtf8;
                    }
                    sb.append(this.i.readUtf8(indexOfElement));
                    this.i.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.i.readUtf8(indexOfElement));
                this.i.readByte();
                sb.append(G());
            } else {
                throw w("Unterminated string");
            }
        }
    }

    private String D() throws IOException {
        long indexOfElement = this.h.indexOfElement(p);
        return indexOfElement != -1 ? this.i.readUtf8(indexOfElement) : this.i.readUtf8();
    }

    private int E() throws IOException {
        int i;
        String str;
        String str2;
        byte b = this.i.getByte(0L);
        if (b == 116 || b == 84) {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (b == 102 || b == 70) {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.h.request(i3)) {
                return 0;
            }
            byte b2 = this.i.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.h.request(length + 1) && A(this.i.getByte(length))) {
            return 0;
        }
        this.i.skip(length);
        this.j = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (A(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009d, code lost:
        r16.k = r8;
        r16.i.skip(r5);
        r16.j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a9, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ad, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b0, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b3, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b5, code lost:
        r16.l = r5;
        r16.j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bb, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bc, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int F() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.F():int");
    }

    private char G() throws IOException {
        int i;
        int i2;
        if (this.h.request(1L)) {
            byte readByte = this.i.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte != 98) {
                if (readByte != 102) {
                    if (readByte != 110) {
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.e) {
                                        return (char) readByte;
                                    }
                                    throw w("Invalid escape sequence: \\" + ((char) readByte));
                                } else if (this.h.request(4L)) {
                                    char c = 0;
                                    for (int i3 = 0; i3 < 4; i3++) {
                                        byte b = this.i.getByte(i3);
                                        char c2 = (char) (c << 4);
                                        if (b < 48 || b > 57) {
                                            if (b >= 97 && b <= 102) {
                                                i = b - 97;
                                            } else if (b < 65 || b > 70) {
                                                throw w("\\u" + this.i.readUtf8(4L));
                                            } else {
                                                i = b - 65;
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = b - 48;
                                        }
                                        c = (char) (c2 + i2);
                                    }
                                    this.i.skip(4L);
                                    return c;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
                            }
                            return '\t';
                        }
                        return CharUtils.CR;
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        throw w("Unterminated escape sequence");
    }

    private void H(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.i.getByte(indexOfElement) == 92) {
                    this.i.skip(indexOfElement + 1);
                    G();
                } else {
                    this.i.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw w("Unterminated string");
            }
        }
    }

    private boolean I() throws IOException {
        BufferedSource bufferedSource = this.h;
        ByteString byteString = r;
        long indexOf = bufferedSource.indexOf(byteString);
        boolean z = indexOf != -1;
        Buffer buffer = this.i;
        buffer.skip(z ? indexOf + byteString.size() : buffer.size());
        return z;
    }

    private void J() throws IOException {
        long indexOfElement = this.h.indexOfElement(q);
        Buffer buffer = this.i;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private void K() throws IOException {
        long indexOfElement = this.h.indexOfElement(p);
        Buffer buffer = this.i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    private void x() throws IOException {
        if (!this.e) {
            throw w("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int y() throws IOException {
        int[] iArr = this.b;
        int i = this.a;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int B = B(true);
            this.i.readByte();
            if (B != 44) {
                if (B != 59) {
                    if (B == 93) {
                        this.j = 4;
                        return 4;
                    }
                    throw w("Unterminated array");
                }
                x();
            }
        } else if (i2 == 3 || i2 == 5) {
            iArr[i - 1] = 4;
            if (i2 == 5) {
                int B2 = B(true);
                this.i.readByte();
                if (B2 != 44) {
                    if (B2 != 59) {
                        if (B2 == 125) {
                            this.j = 2;
                            return 2;
                        }
                        throw w("Unterminated object");
                    }
                    x();
                }
            }
            int B3 = B(true);
            if (B3 == 34) {
                this.i.readByte();
                this.j = 13;
                return 13;
            } else if (B3 == 39) {
                this.i.readByte();
                x();
                this.j = 12;
                return 12;
            } else if (B3 != 125) {
                x();
                if (A((char) B3)) {
                    this.j = 14;
                    return 14;
                }
                throw w("Expected name");
            } else if (i2 != 5) {
                this.i.readByte();
                this.j = 2;
                return 2;
            } else {
                throw w("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int B4 = B(true);
            this.i.readByte();
            if (B4 != 58) {
                if (B4 == 61) {
                    x();
                    if (this.h.request(1L) && this.i.getByte(0L) == 62) {
                        this.i.readByte();
                    }
                } else {
                    throw w("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            iArr[i - 1] = 7;
        } else if (i2 == 7) {
            if (B(false) == -1) {
                this.j = 18;
                return 18;
            }
            x();
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int B5 = B(true);
        if (B5 == 34) {
            this.i.readByte();
            this.j = 9;
            return 9;
        } else if (B5 == 39) {
            x();
            this.i.readByte();
            this.j = 8;
            return 8;
        } else {
            if (B5 != 44 && B5 != 59) {
                if (B5 == 91) {
                    this.i.readByte();
                    this.j = 3;
                    return 3;
                } else if (B5 != 93) {
                    if (B5 != 123) {
                        int E = E();
                        if (E != 0) {
                            return E;
                        }
                        int F = F();
                        if (F != 0) {
                            return F;
                        }
                        if (A(this.i.getByte(0L))) {
                            x();
                            this.j = 10;
                            return 10;
                        }
                        throw w("Expected value");
                    }
                    this.i.readByte();
                    this.j = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.i.readByte();
                    this.j = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                throw w("Unexpected value");
            }
            x();
            this.j = 7;
            return 7;
        }
    }

    private int z(String str, JsonReader.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.j = 0;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 3) {
            r(1);
            this.d[this.a - 1] = 0;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + q() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j = 0;
        this.b[0] = 8;
        this.a = 1;
        this.i.clear();
        this.h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 1) {
            r(3);
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void f() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 4) {
            int i2 = this.a - 1;
            this.a = i2;
            int[] iArr = this.d;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void g() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 2) {
            int i2 = this.a - 1;
            this.a = i2;
            this.c[i2] = null;
            int[] iArr = this.d;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean j() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean k() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 5) {
            this.j = 0;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.j = 0;
            int[] iArr2 = this.d;
            int i3 = this.a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + q() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double l() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 16) {
            this.j = 0;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.k;
        }
        if (i == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (i == 9) {
            this.m = C(o);
        } else if (i == 8) {
            this.m = C(n);
        } else if (i == 10) {
            this.m = D();
        } else if (i != 11) {
            throw new JsonDataException("Expected a double but was " + q() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            if (!this.e && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.m = null;
            this.j = 0;
            int[] iArr2 = this.d;
            int i3 = this.a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int m() throws IOException {
        String C;
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 16) {
            long j = this.k;
            int i2 = (int) j;
            if (j == i2) {
                this.j = 0;
                int[] iArr = this.d;
                int i3 = this.a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.k + " at path " + getPath());
        }
        if (i == 17) {
            this.m = this.i.readUtf8(this.l);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                C = C(o);
            } else {
                C = C(n);
            }
            this.m = C;
            try {
                int parseInt = Integer.parseInt(C);
                this.j = 0;
                int[] iArr2 = this.d;
                int i4 = this.a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new JsonDataException("Expected an int but was " + q() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            int i5 = (int) parseDouble;
            if (i5 == parseDouble) {
                this.m = null;
                this.j = 0;
                int[] iArr3 = this.d;
                int i6 = this.a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String n() throws IOException {
        String str;
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 14) {
            str = D();
        } else if (i == 13) {
            str = C(o);
        } else if (i == 12) {
            str = C(n);
        } else if (i == 15) {
            str = this.m;
        } else {
            throw new JsonDataException("Expected a name but was " + q() + " at path " + getPath());
        }
        this.j = 0;
        this.c[this.a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String o() throws IOException {
        String readUtf8;
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i == 10) {
            readUtf8 = D();
        } else if (i == 9) {
            readUtf8 = C(o);
        } else if (i == 8) {
            readUtf8 = C(n);
        } else if (i == 11) {
            readUtf8 = this.m;
            this.m = null;
        } else if (i == 16) {
            readUtf8 = Long.toString(this.k);
        } else if (i == 17) {
            readUtf8 = this.i.readUtf8(this.l);
        } else {
            throw new JsonDataException("Expected a string but was " + q() + " at path " + getPath());
        }
        this.j = 0;
        int[] iArr = this.d;
        int i2 = this.a - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token q() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int s(JsonReader.a aVar) throws IOException {
        int i = this.j;
        if (i == 0) {
            i = y();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return z(this.m, aVar);
        }
        int select = this.h.select(aVar.b);
        if (select != -1) {
            this.j = 0;
            this.c[this.a - 1] = aVar.a[select];
            return select;
        }
        String str = this.c[this.a - 1];
        String n2 = n();
        int z = z(n2, aVar);
        if (z == -1) {
            this.j = 15;
            this.m = n2;
            this.c[this.a - 1] = str;
        }
        return z;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void t() throws IOException {
        if (!this.f) {
            int i = this.j;
            if (i == 0) {
                i = y();
            }
            if (i == 14) {
                K();
            } else if (i == 13) {
                H(o);
            } else if (i == 12) {
                H(n);
            } else if (i != 15) {
                throw new JsonDataException("Expected a name but was " + q() + " at path " + getPath());
            }
            this.j = 0;
            this.c[this.a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + q() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.h + jn1.BRACKET_END_STR;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void u() throws IOException {
        if (!this.f) {
            int i = 0;
            do {
                int i2 = this.j;
                if (i2 == 0) {
                    i2 = y();
                }
                if (i2 == 3) {
                    r(1);
                } else if (i2 == 1) {
                    r(3);
                } else {
                    if (i2 == 4) {
                        i--;
                        if (i >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                        }
                    } else if (i2 == 14 || i2 == 10) {
                        K();
                    } else if (i2 == 9 || i2 == 13) {
                        H(o);
                    } else if (i2 == 8 || i2 == 12) {
                        H(n);
                    } else if (i2 == 17) {
                        this.i.skip(this.l);
                    } else if (i2 == 18) {
                        throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                    }
                    this.j = 0;
                }
                i++;
                this.j = 0;
            } while (i != 0);
            int[] iArr = this.d;
            int i3 = this.a;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.c[i3 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + q() + " at " + getPath());
    }
}
