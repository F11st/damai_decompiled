package tb;

import java.io.PrintStream;
import java.net.URI;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class hq {
    public static final int TT_ATKEYWORD = -3;
    public static final int TT_DASHMATCH = -18;
    public static final int TT_DIMENSION = -9;
    public static final int TT_EOF = -1;
    public static final int TT_FUNCTION = -16;
    public static final int TT_HASH = -6;
    public static final int TT_IDENT = -2;
    public static final int TT_INCLUDES = -17;
    public static final int TT_NUMBER = -7;
    public static final int TT_PERCENTAGE = -8;
    public static final int TT_S = -14;
    public static final int TT_STRING = -4;
    public static final int TT_URI = -10;
    public int a;
    public String b;
    public float c;
    private String d;
    private int e;
    private int f = -99;
    private int g;
    URI h;

    public hq(URI uri, String str) {
        this.d = str;
        c(false);
    }

    private int d() {
        if (this.e >= this.d.length()) {
            return -1;
        }
        String str = this.d;
        int i = this.e;
        this.e = i + 1;
        return str.charAt(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r1 = r4.f;
        r4.f = d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private char e() {
        /*
            r4 = this;
            int r0 = r4.d()
            r4.f = r0
            r0 = 0
            r1 = 0
        L8:
            r2 = 6
            if (r0 >= r2) goto L38
            int r2 = r4.f
            r3 = 48
            if (r2 < r3) goto L15
            r3 = 57
            if (r2 <= r3) goto L25
        L15:
            r3 = 97
            if (r2 < r3) goto L1d
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 <= r3) goto L25
        L1d:
            r3 = 65
            if (r2 < r3) goto L38
            r3 = 90
            if (r2 > r3) goto L38
        L25:
            int r0 = r0 + 1
            int r1 = r1 * 16
            char r2 = (char) r2
            r3 = 16
            int r2 = java.lang.Character.digit(r2, r3)
            int r1 = r1 + r2
            int r2 = r4.d()
            r4.f = r2
            goto L8
        L38:
            if (r0 != 0) goto L43
            int r1 = r4.f
            int r0 = r4.d()
            r4.f = r0
            goto L4f
        L43:
            int r0 = r4.f
            r2 = 32
            if (r0 > r2) goto L4f
            int r0 = r4.d()
            r4.f = r0
        L4f:
            char r0 = (char) r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.hq.e():char");
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f;
            if (i == 92) {
                sb.append(e());
            } else {
                sb.append((char) i);
                this.f = d();
            }
            if ("~|<>+*()[]{}.,;*:%=!@#".indexOf(this.f) != -1) {
                break;
            }
        } while (this.f > 32);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    private void g(boolean z) {
        int d;
        float f = 0.0f;
        while (true) {
            int i = this.f;
            if (i == 46) {
                z = 1;
            } else {
                f = ((f * 10.0f) + i) - 48.0f;
                z *= 10;
            }
            d = d();
            this.f = d;
            if (d < 48 || d > 57) {
                if (d != 46) {
                    break;
                }
            }
        }
        if (z != 0) {
            f /= z == true ? 1.0f : 0.0f;
        }
        this.c = f;
        if (d == 37) {
            this.a = -8;
            this.f = -99;
            this.b = "%";
        } else if ((d >= 97 && d <= 122) || (d >= 65 && d <= 90)) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append((char) this.f);
                int d2 = d();
                this.f = d2;
                if (d2 < 97 || d2 > 122) {
                    if (d2 < 65 || d2 > 90) {
                        break;
                    }
                }
            }
            this.a = -9;
            this.b = sb.toString();
        } else {
            this.a = -7;
            this.b = "";
        }
    }

    private String h(char c) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.f;
            if (i == c || i == -1 || i == 10 || i == 13) {
                break;
            } else if (i == 92) {
                sb.append(e());
            } else {
                sb.append((char) i);
                this.f = d();
            }
        }
        this.f = -99;
        return sb.toString();
    }

    private void i() {
        while (true) {
            int i = this.f;
            if (i > 32 || i == -1) {
                return;
            }
            if (i == 10) {
                this.g++;
            }
            this.f = d();
        }
    }

    public void a(int i) {
        if (this.a != i) {
            b("Expected: " + ((char) i));
        }
    }

    public void b(String str) {
        PrintStream printStream = System.out;
        printStream.print(str + " line: " + this.g + "; token: ");
        int i = this.a;
        if (i == -4) {
            PrintStream printStream2 = System.out;
            printStream2.print("string '" + this.b + "'");
        } else if (i != -2) {
            switch (i) {
                case -10:
                    PrintStream printStream3 = System.out;
                    printStream3.print("uri '" + this.b + "'");
                    break;
                case -9:
                case -8:
                case -7:
                    PrintStream printStream4 = System.out;
                    printStream4.print("numeric " + this.c + " unit: " + this.b);
                    break;
                default:
                    if (i <= 32) {
                        System.out.print(i);
                        break;
                    } else {
                        System.out.print((char) i);
                        break;
                    }
            }
        } else {
            PrintStream printStream5 = System.out;
            printStream5.print("identifier '" + this.b + "'");
        }
        PrintStream printStream6 = System.out;
        printStream6.println(" url: " + this.h);
    }

    public int c(boolean z) {
        int d;
        this.b = "";
        this.c = 0.0f;
        if (this.f == -99) {
            this.f = d();
        }
        int i = this.f;
        if (i == -1) {
            this.a = -1;
            return -1;
        }
        if (i <= 32) {
            i();
            if (z) {
                this.a = -14;
                return -14;
            }
        }
        int i2 = this.f;
        if (i2 == 34) {
            this.f = d();
            this.b = h(jn1.QUOTE);
            this.a = -4;
        } else if (i2 == 35) {
            StringBuilder sb = new StringBuilder();
            this.f = d();
            while (true) {
                sb.append((char) this.f);
                int d2 = d();
                this.f = d2;
                if (d2 < 48 || d2 > 57) {
                    if (d2 < 97 || d2 > 122) {
                        if (d2 < 65 || d2 > 90) {
                            if (d2 != 45 && d2 != 95) {
                                break;
                            }
                        }
                    }
                }
            }
            this.a = -6;
            this.b = sb.toString();
        } else if (i2 == 39) {
            this.f = d();
            this.b = h('\'');
            this.a = -4;
        } else if (i2 == 64) {
            this.f = d();
            this.b = f();
            this.a = -3;
        } else if (i2 == 124) {
            int d3 = d();
            this.f = d3;
            if (d3 == 61) {
                this.a = -18;
                this.f = -99;
            } else {
                this.a = 126;
            }
        } else if (i2 != 126) {
            switch (i2) {
                case 45:
                    this.f = d();
                    g(false);
                    this.c = -this.c;
                    break;
                case 46:
                    int d4 = d();
                    this.f = d4;
                    if (d4 >= 48 && d4 <= 57) {
                        g(true);
                        break;
                    } else {
                        this.a = 46;
                        break;
                    }
                case 47:
                    int d5 = d();
                    this.f = d5;
                    if (d5 == 42) {
                        this.f = d();
                        while (true) {
                            int i3 = this.f;
                            int d6 = d();
                            this.f = d6;
                            if (d6 == 10) {
                                this.g++;
                            }
                            if (d6 == -1 || (i3 == 42 && d6 == 47)) {
                            }
                        }
                        this.f = -99;
                        return c(z);
                    } else if (d5 != 47) {
                        this.a = 47;
                        break;
                    } else {
                        do {
                            d = d();
                            this.f = d;
                            if (d == 10 || d == 13) {
                                return c(z);
                            }
                        } while (d != -1);
                        return c(z);
                    }
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    g(false);
                    break;
                default:
                    if ("~|<>+*()[]{}.,;*:%=!@#".indexOf((char) i2) != -1) {
                        this.a = this.f;
                        this.f = -99;
                        break;
                    } else {
                        String f = f();
                        this.b = f;
                        if (this.f == 40) {
                            if (f.equals("url")) {
                                this.f = d();
                                i();
                                int i4 = this.f;
                                if (i4 == 34) {
                                    this.f = d();
                                    this.b = h(jn1.QUOTE);
                                    i();
                                    a(41);
                                    this.f = -99;
                                } else if (i4 != 39) {
                                    this.b = h(')');
                                } else {
                                    this.f = d();
                                    this.b = h('\'');
                                    i();
                                    a(41);
                                    this.f = -99;
                                }
                                this.a = -10;
                                break;
                            } else {
                                this.a = -16;
                                this.f = -99;
                                break;
                            }
                        } else {
                            this.a = -2;
                            break;
                        }
                    }
            }
        } else {
            int d7 = d();
            this.f = d7;
            if (d7 == 61) {
                this.a = -17;
                this.f = -99;
            } else {
                this.a = 126;
            }
        }
        return this.a;
    }
}
