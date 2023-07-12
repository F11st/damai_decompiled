package com.alibaba.pictures.bricks.util.htmlparser;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.vz0;
import tb.w8;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C0151a Companion = new C0151a(null);
    private int a;
    @Nullable
    private Reader b;
    private int c;
    private int d;
    private char[] e;
    private int f;
    private char[] g;
    @Nullable
    private ParserCallback j;
    private char h = 65535;
    private char i = 65535;
    @NotNull
    private final Stack<vz0> k = new Stack<>();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.htmlparser.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0151a {
        private C0151a() {
        }

        public /* synthetic */ C0151a(k50 k50Var) {
            this();
        }
    }

    private final boolean a(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484837796")) {
            return ((Boolean) ipChange.ipc$dispatch("-1484837796", new Object[]{this, Integer.valueOf(i), str})).booleanValue();
        }
        int length = str.length();
        while (true) {
            int i2 = length - 1;
            if (length == 0 || i >= str.length()) {
                break;
            }
            char[] cArr = this.g;
            if (cArr == null) {
                b41.A("buf");
                cArr = null;
            }
            if (cArr[i] != str.charAt(i)) {
                return false;
            }
            i++;
            length = i2;
        }
        return true;
    }

    private final int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693630704")) {
            return ((Integer) ipChange.ipc$dispatch("-693630704", new Object[]{this})).intValue();
        }
        int i = this.f;
        if (i != 10) {
            char[] cArr = null;
            switch (i) {
                case 1:
                    char[] cArr2 = this.g;
                    if (cArr2 == null) {
                        b41.A("buf");
                    } else {
                        cArr = cArr2;
                    }
                    char c = cArr[0];
                    if (c != 'a') {
                        if (c != 'b') {
                            if (c != 'i') {
                                if (c != 'p') {
                                    if (c != 'q') {
                                        if (c != 's') {
                                            if (c != 'u') {
                                                wt2 wt2Var = wt2.INSTANCE;
                                                break;
                                            } else {
                                                return 6;
                                            }
                                        } else {
                                            return 21;
                                        }
                                    } else {
                                        return 24;
                                    }
                                } else {
                                    return 54;
                                }
                            } else {
                                return 3;
                            }
                        } else {
                            return 11;
                        }
                    } else {
                        return 14;
                    }
                case 2:
                    char[] cArr3 = this.g;
                    if (cArr3 == null) {
                        b41.A("buf");
                        cArr3 = null;
                    }
                    char c2 = cArr3[0];
                    if (c2 == 'b') {
                        char[] cArr4 = this.g;
                        if (cArr4 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr4;
                        }
                        if (cArr[1] == 'r') {
                            return 16;
                        }
                    } else if (c2 == 'e') {
                        char[] cArr5 = this.g;
                        if (cArr5 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr5;
                        }
                        if (cArr[1] == 'r') {
                            return 9;
                        }
                    } else if (c2 == 'l') {
                        char[] cArr6 = this.g;
                        if (cArr6 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr6;
                        }
                        if (cArr[1] == 'i') {
                            return 57;
                        }
                    } else if (c2 == 'o') {
                        char[] cArr7 = this.g;
                        if (cArr7 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr7;
                        }
                        if (cArr[1] == 'l') {
                            return 56;
                        }
                    } else if (c2 == 't') {
                        char[] cArr8 = this.g;
                        if (cArr8 == null) {
                            b41.A("buf");
                            cArr8 = null;
                        }
                        if (cArr8[1] == 'd') {
                            return 88;
                        }
                        char[] cArr9 = this.g;
                        if (cArr9 == null) {
                            b41.A("buf");
                            cArr9 = null;
                        }
                        if (cArr9[1] == 'h') {
                            return 87;
                        }
                        char[] cArr10 = this.g;
                        if (cArr10 == null) {
                            b41.A("buf");
                            cArr10 = null;
                        }
                        if (cArr10[1] == 'r') {
                            return 86;
                        }
                        char[] cArr11 = this.g;
                        if (cArr11 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr11;
                        }
                        if (cArr[1] == 't') {
                            return 2;
                        }
                    } else if (c2 != 'u') {
                        return -1;
                    } else {
                        char[] cArr12 = this.g;
                        if (cArr12 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr12;
                        }
                        if (cArr[1] == 'l') {
                            return 55;
                        }
                    }
                    wt2 wt2Var2 = wt2.INSTANCE;
                    break;
                case 3:
                    char[] cArr13 = this.g;
                    if (cArr13 == null) {
                        b41.A("buf");
                        cArr13 = null;
                    }
                    char c3 = cArr13[0];
                    if (c3 == 'b') {
                        char[] cArr14 = this.g;
                        if (cArr14 == null) {
                            b41.A("buf");
                            cArr14 = null;
                        }
                        if (cArr14[1] == 'i') {
                            char[] cArr15 = this.g;
                            if (cArr15 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr15;
                            }
                            if (cArr[2] == 'g') {
                                return 7;
                            }
                        }
                    } else if (c3 == 'd') {
                        char[] cArr16 = this.g;
                        if (cArr16 == null) {
                            b41.A("buf");
                            cArr16 = null;
                        }
                        if (cArr16[1] == 'e') {
                            char[] cArr17 = this.g;
                            if (cArr17 == null) {
                                b41.A("buf");
                                cArr17 = null;
                            }
                            if (cArr17[2] == 'l') {
                                return 20;
                            }
                        }
                        char[] cArr18 = this.g;
                        if (cArr18 == null) {
                            b41.A("buf");
                            cArr18 = null;
                        }
                        if (cArr18[1] == 'f') {
                            char[] cArr19 = this.g;
                            if (cArr19 == null) {
                                b41.A("buf");
                                cArr19 = null;
                            }
                            if (cArr19[2] == 'n') {
                                return 5;
                            }
                        }
                        char[] cArr20 = this.g;
                        if (cArr20 == null) {
                            b41.A("buf");
                            cArr20 = null;
                        }
                        if (cArr20[1] == 'i') {
                            char[] cArr21 = this.g;
                            if (cArr21 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr21;
                            }
                            if (cArr[2] == 'v') {
                                return 53;
                            }
                        }
                    } else if (c3 == 'i') {
                        char[] cArr22 = this.g;
                        if (cArr22 == null) {
                            b41.A("buf");
                            cArr22 = null;
                        }
                        if (cArr22[1] == 'm') {
                            char[] cArr23 = this.g;
                            if (cArr23 == null) {
                                b41.A("buf");
                                cArr23 = null;
                            }
                            if (cArr23[2] == 'g') {
                                return 15;
                            }
                        }
                        char[] cArr24 = this.g;
                        if (cArr24 == null) {
                            b41.A("buf");
                            cArr24 = null;
                        }
                        if (cArr24[1] == 'n') {
                            char[] cArr25 = this.g;
                            if (cArr25 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr25;
                            }
                            if (cArr[2] == 's') {
                                return 19;
                            }
                        }
                    } else if (c3 == 'k') {
                        char[] cArr26 = this.g;
                        if (cArr26 == null) {
                            b41.A("buf");
                            cArr26 = null;
                        }
                        if (cArr26[1] == 'b') {
                            char[] cArr27 = this.g;
                            if (cArr27 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr27;
                            }
                            if (cArr[2] == 'd') {
                                return 12;
                            }
                        }
                    } else if (c3 == 'p') {
                        char[] cArr28 = this.g;
                        if (cArr28 == null) {
                            b41.A("buf");
                            cArr28 = null;
                        }
                        if (cArr28[1] == 'r') {
                            char[] cArr29 = this.g;
                            if (cArr29 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr29;
                            }
                            if (cArr[2] == 'e') {
                                return 70;
                            }
                        }
                    } else if (c3 != 's') {
                        return -1;
                    } else {
                        char[] cArr30 = this.g;
                        if (cArr30 == null) {
                            b41.A("buf");
                            cArr30 = null;
                        }
                        if (cArr30[1] == 'u') {
                            char[] cArr31 = this.g;
                            if (cArr31 == null) {
                                b41.A("buf");
                                cArr31 = null;
                            }
                            if (cArr31[2] == 'b') {
                                return 17;
                            }
                            char[] cArr32 = this.g;
                            if (cArr32 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr32;
                            }
                            if (cArr[2] == 'p') {
                                return 18;
                            }
                        }
                    }
                    wt2 wt2Var3 = wt2.INSTANCE;
                    break;
                case 4:
                    char[] cArr33 = this.g;
                    if (cArr33 == null) {
                        b41.A("buf");
                        cArr33 = null;
                    }
                    char c4 = cArr33[0];
                    if (c4 == 'c') {
                        char[] cArr34 = this.g;
                        if (cArr34 == null) {
                            b41.A("buf");
                            cArr34 = null;
                        }
                        if (cArr34[1] == 'i') {
                            char[] cArr35 = this.g;
                            if (cArr35 == null) {
                                b41.A("buf");
                                cArr35 = null;
                            }
                            if (cArr35[2] == 't') {
                                char[] cArr36 = this.g;
                                if (cArr36 == null) {
                                    b41.A("buf");
                                    cArr36 = null;
                                }
                                if (cArr36[3] == 'e') {
                                    return 4;
                                }
                            }
                        }
                        char[] cArr37 = this.g;
                        if (cArr37 == null) {
                            b41.A("buf");
                            cArr37 = null;
                        }
                        if (cArr37[1] == 'o') {
                            char[] cArr38 = this.g;
                            if (cArr38 == null) {
                                b41.A("buf");
                                cArr38 = null;
                            }
                            if (cArr38[2] == 'd') {
                                char[] cArr39 = this.g;
                                if (cArr39 == null) {
                                    b41.A("buf");
                                } else {
                                    cArr = cArr39;
                                }
                                if (cArr[3] == 'e') {
                                    return 25;
                                }
                            }
                        }
                    } else if (c4 == 'f') {
                        char[] cArr40 = this.g;
                        if (cArr40 == null) {
                            b41.A("buf");
                            cArr40 = null;
                        }
                        if (cArr40[1] == 'o') {
                            char[] cArr41 = this.g;
                            if (cArr41 == null) {
                                b41.A("buf");
                                cArr41 = null;
                            }
                            if (cArr41[2] == 'n') {
                                char[] cArr42 = this.g;
                                if (cArr42 == null) {
                                    b41.A("buf");
                                } else {
                                    cArr = cArr42;
                                }
                                if (cArr[3] == 't') {
                                    return 1;
                                }
                            }
                        }
                    } else if (c4 == 's') {
                        char[] cArr43 = this.g;
                        if (cArr43 == null) {
                            b41.A("buf");
                            cArr43 = null;
                        }
                        if (cArr43[1] == 'p') {
                            char[] cArr44 = this.g;
                            if (cArr44 == null) {
                                b41.A("buf");
                                cArr44 = null;
                            }
                            if (cArr44[2] == 'a') {
                                char[] cArr45 = this.g;
                                if (cArr45 == null) {
                                    b41.A("buf");
                                } else {
                                    cArr = cArr45;
                                }
                                if (cArr[3] == 'n') {
                                    return 23;
                                }
                            }
                        }
                    } else if (c4 != 'm') {
                        return -1;
                    } else {
                        char[] cArr46 = this.g;
                        if (cArr46 == null) {
                            b41.A("buf");
                            cArr46 = null;
                        }
                        if (cArr46[1] == 'a') {
                            char[] cArr47 = this.g;
                            if (cArr47 == null) {
                                b41.A("buf");
                                cArr47 = null;
                            }
                            if (cArr47[2] == 'r') {
                                char[] cArr48 = this.g;
                                if (cArr48 == null) {
                                    b41.A("buf");
                                } else {
                                    cArr = cArr48;
                                }
                                if (cArr[3] == 'k') {
                                    return 13;
                                }
                            }
                        }
                    }
                    wt2 wt2Var4 = wt2.INSTANCE;
                    break;
                case 5:
                    if (a(2, "dio")) {
                        char[] cArr49 = this.g;
                        if (cArr49 == null) {
                            b41.A("buf");
                            cArr49 = null;
                        }
                        if (cArr49[0] == 'a') {
                            char[] cArr50 = this.g;
                            if (cArr50 == null) {
                                b41.A("buf");
                                cArr50 = null;
                            }
                            if (cArr50[1] == 'u') {
                                return 92;
                            }
                        }
                        char[] cArr51 = this.g;
                        if (cArr51 == null) {
                            b41.A("buf");
                            cArr51 = null;
                        }
                        if (cArr51[0] == 'v') {
                            char[] cArr52 = this.g;
                            if (cArr52 == null) {
                                b41.A("buf");
                            } else {
                                cArr = cArr52;
                            }
                            if (cArr[1] == 'e') {
                                return 91;
                            }
                        }
                    } else {
                        char[] cArr53 = this.g;
                        if (cArr53 == null) {
                            b41.A("buf");
                        } else {
                            cArr = cArr53;
                        }
                        char c5 = cArr[0];
                        if (c5 == 's') {
                            if (a(1, "mall")) {
                                return 8;
                            }
                        } else if (c5 != 't') {
                            return -1;
                        } else {
                            if (a(1, "able")) {
                                return 81;
                            }
                            if (a(1, "body")) {
                                return 85;
                            }
                            if (a(1, "head")) {
                                return 83;
                            }
                            if (a(1, "foot")) {
                                return 84;
                            }
                        }
                    }
                    wt2 wt2Var5 = wt2.INSTANCE;
                    break;
                case 6:
                    if (a(0, "str")) {
                        char[] cArr54 = this.g;
                        if (cArr54 == null) {
                            b41.A("buf");
                            cArr54 = null;
                        }
                        if (cArr54[3] == 'o') {
                            char[] cArr55 = this.g;
                            if (cArr55 == null) {
                                b41.A("buf");
                                cArr55 = null;
                            }
                            if (cArr55[4] == 'n') {
                                char[] cArr56 = this.g;
                                if (cArr56 == null) {
                                    b41.A("buf");
                                    cArr56 = null;
                                }
                                if (cArr56[5] == 'g') {
                                    return 10;
                                }
                            }
                        }
                        char[] cArr57 = this.g;
                        if (cArr57 == null) {
                            b41.A("buf");
                            cArr57 = null;
                        }
                        if (cArr57[3] == 'i') {
                            char[] cArr58 = this.g;
                            if (cArr58 == null) {
                                b41.A("buf");
                                cArr58 = null;
                            }
                            if (cArr58[4] == 'k') {
                                char[] cArr59 = this.g;
                                if (cArr59 == null) {
                                    b41.A("buf");
                                } else {
                                    cArr = cArr59;
                                }
                                if (cArr[5] == 'e') {
                                    return 22;
                                }
                            }
                        }
                    } else {
                        char[] cArr60 = this.g;
                        if (cArr60 == null) {
                            b41.A("buf");
                            cArr60 = null;
                        }
                        if (cArr60[4] == 'e') {
                            char[] cArr61 = this.g;
                            if (cArr61 == null) {
                                b41.A("buf");
                                cArr61 = null;
                            }
                            if (cArr61[5] == 'f') {
                                char[] cArr62 = this.g;
                                if (cArr62 == null) {
                                    b41.A("buf");
                                    cArr62 = null;
                                }
                                if (cArr62[0] == 'h') {
                                    char[] cArr63 = this.g;
                                    if (cArr63 == null) {
                                        b41.A("buf");
                                        cArr63 = null;
                                    }
                                    if (cArr63[1] == 'e') {
                                        char[] cArr64 = this.g;
                                        if (cArr64 == null) {
                                            b41.A("buf");
                                            cArr64 = null;
                                        }
                                        if (cArr64[2] == 'a') {
                                            char[] cArr65 = this.g;
                                            if (cArr65 == null) {
                                                b41.A("buf");
                                                cArr65 = null;
                                            }
                                            if (cArr65[3] == 'd') {
                                                return 50;
                                            }
                                        }
                                    }
                                }
                                char[] cArr66 = this.g;
                                if (cArr66 == null) {
                                    b41.A("buf");
                                    cArr66 = null;
                                }
                                if (cArr66[0] == 'f') {
                                    char[] cArr67 = this.g;
                                    if (cArr67 == null) {
                                        b41.A("buf");
                                        cArr67 = null;
                                    }
                                    if (cArr67[1] == 'o') {
                                        char[] cArr68 = this.g;
                                        if (cArr68 == null) {
                                            b41.A("buf");
                                            cArr68 = null;
                                        }
                                        if (cArr68[2] == 'o') {
                                            char[] cArr69 = this.g;
                                            if (cArr69 == null) {
                                                b41.A("buf");
                                            } else {
                                                cArr = cArr69;
                                            }
                                            if (cArr[3] == 't') {
                                                return 51;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    wt2 wt2Var6 = wt2.INSTANCE;
                    break;
                case 7:
                    if (!a(0, "caption")) {
                        wt2 wt2Var7 = wt2.INSTANCE;
                        break;
                    } else {
                        return 82;
                    }
                default:
                    return -1;
            }
        } else if (a(0, "blockquote")) {
            return 71;
        } else {
            wt2 wt2Var8 = wt2.INSTANCE;
        }
        return -1;
    }

    private final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084868335")) {
            ipChange.ipc$dispatch("-1084868335", new Object[]{this});
            return;
        }
        while (!this.k.isEmpty()) {
            vz0 pop = this.k.pop();
            ParserCallback parserCallback = this.j;
            b41.f(parserCallback);
            parserCallback.endElement(pop.d(), pop.b());
        }
        this.h = (char) 65535;
        ParserCallback parserCallback2 = this.j;
        b41.f(parserCallback2);
        parserCallback2.endDocument();
    }

    private final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048752132")) {
            ipChange.ipc$dispatch("-1048752132", new Object[]{this});
            return;
        }
        ParserCallback parserCallback = this.j;
        if (parserCallback == null) {
            return;
        }
        b41.f(parserCallback);
        char[] cArr = this.e;
        if (cArr == null) {
            b41.A("srcBuf");
            cArr = null;
        }
        parserCallback.startDocument(cArr.length);
        n();
        while (true) {
            char c = this.h;
            if (c == 65535) {
                return;
            }
            if (c == 65535) {
                c();
            } else if (c == '<') {
                n();
                char c2 = this.h;
                if (c2 == '/') {
                    h();
                } else if (c2 == '!') {
                    n();
                    if (this.h == '-') {
                        if (n() == '-') {
                            f();
                        } else if (this.h != '>') {
                            q();
                        }
                    } else {
                        q();
                    }
                } else if (c2 == '?') {
                    q();
                } else {
                    i();
                }
            } else if (c == '>') {
                n();
                j();
            } else {
                char c3 = this.i;
                if (c3 != 65535 && c3 != '>') {
                    n();
                } else {
                    j();
                }
            }
        }
    }

    private final void e() {
        char[] cArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831561525")) {
            ipChange.ipc$dispatch("-831561525", new Object[]{this});
            return;
        }
        this.f = 0;
        do {
            char[] cArr2 = this.g;
            cArr = null;
            if (cArr2 == null) {
                b41.A("buf");
                cArr2 = null;
            }
            int i = this.f;
            this.f = i + 1;
            cArr2[i] = this.h;
            n();
            char c = this.h;
            if (c == 65535 || c == '>') {
                break;
            }
        } while (this.f < 256);
        char[] cArr3 = this.g;
        if (cArr3 == null) {
            b41.A("buf");
        } else {
            cArr = cArr3;
        }
        int i2 = this.f;
        if (cArr[i2 - 1] == '/') {
            this.f = i2 - 1;
        }
        if (this.h != '>') {
            q();
        }
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564971409")) {
            ipChange.ipc$dispatch("-1564971409", new Object[]{this});
            return;
        }
        while (this.h != 65535) {
            n();
            n();
            if (this.h == '-' && this.i == '-') {
                n();
                if (this.h == '>') {
                    return;
                }
            }
        }
    }

    private final void h() {
        char[] cArr;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401861501")) {
            ipChange.ipc$dispatch("1401861501", new Object[]{this});
            return;
        }
        this.f = 0;
        while (true) {
            cArr = null;
            if (this.h == 65535) {
                break;
            }
            char o = o();
            this.h = o;
            if (o == '>' || this.f >= 16) {
                break;
            }
            char[] cArr2 = this.g;
            if (cArr2 == null) {
                b41.A("buf");
            } else {
                cArr = cArr2;
            }
            int i2 = this.f;
            this.f = i2 + 1;
            cArr[i2] = this.h;
        }
        char[] cArr3 = this.g;
        if (cArr3 == null) {
            b41.A("buf");
        } else {
            cArr = cArr3;
        }
        String str = new String(cArr, 0, this.f);
        int b = b();
        this.f = 0;
        if (b == 70 && (i = this.a) > 0) {
            this.a = i - 1;
        }
        k(b, str);
        ParserCallback parserCallback = this.j;
        b41.f(parserCallback);
        parserCallback.endElement(b, str);
    }

    private final void i() {
        vz0.b bVar;
        char[] cArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932134396")) {
            ipChange.ipc$dispatch("-932134396", new Object[]{this});
        } else if ((b41.k(this.h, 97) < 0 || b41.k(this.h, 122) > 0) && (b41.k(this.h, 65) < 0 || b41.k(this.h, 90) > 0)) {
        } else {
            this.f = 0;
            while (true) {
                if (b41.k(this.h, 65) >= 0 && b41.k(this.h, 90) <= 0) {
                    this.h = (char) (((char) (this.h + 'a')) - YKUpsConvert.CHAR_A);
                }
                char[] cArr2 = this.g;
                bVar = null;
                cArr = null;
                if (cArr2 == null) {
                    b41.A("buf");
                    cArr2 = null;
                }
                int i = this.f;
                this.f = i + 1;
                cArr2[i] = this.h;
                n();
                char c = this.h;
                if (c == 65535 || this.f >= 16) {
                    break;
                } else if (b41.k(c, 97) < 0 || b41.k(this.h, 122) > 0) {
                    if (b41.k(this.h, 65) < 0 || b41.k(this.h, 90) > 0) {
                        if (b41.k(this.h, 48) < 0 || b41.k(this.h, 57) > 0) {
                            break;
                        }
                    }
                }
            }
            char[] cArr3 = this.g;
            if (cArr3 == null) {
                b41.A("buf");
                cArr3 = null;
            }
            String str = new String(cArr3, 0, this.f);
            int b = b();
            this.f = 0;
            if (this.h == '/') {
                n();
            }
            char c2 = this.h;
            if (c2 != '>') {
                if (c2 == ' ' || c2 == '\n' || c2 == '\r') {
                    o();
                }
                if (this.h == '/') {
                    n();
                }
                if (this.h != '>') {
                    e();
                }
            }
            if (this.j != null) {
                if (b == 70) {
                    this.a++;
                }
                if (this.f >= 5) {
                    w8 w8Var = w8.INSTANCE;
                    char[] cArr4 = this.g;
                    if (cArr4 == null) {
                        b41.A("buf");
                    } else {
                        cArr = cArr4;
                    }
                    bVar = w8Var.m(b, cArr, this.f);
                }
                vz0 vz0Var = new vz0(b, str, bVar);
                l(vz0Var);
                ParserCallback parserCallback = this.j;
                b41.f(parserCallback);
                parserCallback.startElement(vz0Var);
            }
        }
    }

    private final void j() {
        ParserCallback parserCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574544369")) {
            ipChange.ipc$dispatch("-1574544369", new Object[]{this});
            return;
        }
        this.f = 0;
        while (true) {
            char c = this.h;
            if (c == 65535 || c == '<' || c == '>') {
                break;
            }
            if (this.a > 0 && this.f > 0) {
                m(c);
            } else {
                if (c == '&') {
                    n();
                    char c2 = this.h;
                    if (c2 != 65535 && c2 == 'n') {
                        n();
                        char c3 = this.h;
                        if (c3 != 65535 && c3 == 'b') {
                            n();
                            char c4 = this.h;
                            if (c4 != 65535 && c4 == 's') {
                                n();
                                char c5 = this.h;
                                if (c5 != 65535 && c5 == 'p') {
                                    n();
                                    char c6 = this.h;
                                    if (c6 != 65535 && c6 == ';') {
                                        m(32);
                                        n();
                                    } else {
                                        m(38);
                                        m(110);
                                        m(98);
                                        m(115);
                                        m(112);
                                    }
                                } else {
                                    m(38);
                                    m(110);
                                    m(98);
                                    m(115);
                                }
                            } else {
                                m(38);
                                m(110);
                                m(98);
                            }
                        } else {
                            m(38);
                            m(110);
                        }
                    } else if (c2 != 65535 && c2 == 'a') {
                        n();
                        char c7 = this.h;
                        if (c7 != 65535 && c7 == 'm') {
                            n();
                            char c8 = this.h;
                            if (c8 != 65535 && c8 == 'p') {
                                n();
                                char c9 = this.h;
                                if (c9 != 65535 && c9 == ';') {
                                    m(38);
                                    n();
                                } else {
                                    m(38);
                                    m(97);
                                    m(109);
                                    m(112);
                                }
                            } else {
                                m(38);
                                m(97);
                                m(109);
                            }
                        } else if (c7 != 65535 && c7 == 'p') {
                            n();
                            char c10 = this.h;
                            if (c10 != 65535 && c10 == 'o') {
                                n();
                                char c11 = this.h;
                                if (c11 != 65535 && c11 == 's') {
                                    n();
                                    char c12 = this.h;
                                    if (c12 != 65535 && c12 == ';') {
                                        m(39);
                                        n();
                                    } else {
                                        m(38);
                                        m(97);
                                        m(112);
                                        m(111);
                                        m(115);
                                    }
                                } else {
                                    m(38);
                                    m(97);
                                    m(112);
                                    m(111);
                                }
                            } else {
                                m(38);
                                m(97);
                                m(112);
                            }
                        } else {
                            m(38);
                            m(97);
                        }
                    } else if (c2 != 65535 && c2 == 'g') {
                        n();
                        char c13 = this.h;
                        if (c13 != 65535 && c13 == 't') {
                            n();
                            char c14 = this.h;
                            if (c14 != 65535 && c14 == ';') {
                                m(62);
                                n();
                            } else {
                                m(38);
                                m(103);
                                m(116);
                            }
                        } else {
                            m(38);
                            m(103);
                        }
                    } else if (c2 != 65535 && c2 == 'l') {
                        n();
                        char c15 = this.h;
                        if (c15 != 65535 && c15 == 't') {
                            n();
                            char c16 = this.h;
                            if (c16 != 65535 && c16 == ';') {
                                m(60);
                                n();
                            } else {
                                m(38);
                                m(108);
                                m(116);
                            }
                        } else {
                            m(38);
                            m(108);
                        }
                    } else if (c2 != 65535 && c2 == 'q') {
                        n();
                        char c17 = this.h;
                        if (c17 != 65535 && c17 == 'u') {
                            n();
                            char c18 = this.h;
                            if (c18 != 65535 && c18 == 'o') {
                                n();
                                char c19 = this.h;
                                if (c19 != 65535 && c19 == 't') {
                                    n();
                                    char c20 = this.h;
                                    if (c20 != 65535 && c20 == ';') {
                                        m(34);
                                        n();
                                    } else {
                                        m(38);
                                        m(113);
                                        m(117);
                                        m(111);
                                        m(116);
                                    }
                                } else {
                                    m(38);
                                    m(113);
                                    m(117);
                                    m(111);
                                }
                            } else {
                                m(38);
                                m(113);
                                m(117);
                            }
                        } else {
                            m(38);
                            m(113);
                        }
                    } else {
                        m(38);
                    }
                }
                char c21 = this.h;
                if (c21 != ' ' && c21 != '\n') {
                    m(c21);
                } else if (this.f != 0) {
                    char[] cArr = this.g;
                    if (cArr == null) {
                        b41.A("buf");
                        cArr = null;
                    }
                    if (cArr[this.f - 1] != ' ') {
                        this.h = ' ';
                        m(32);
                    }
                }
            }
            n();
        }
        if (this.f <= 0 || (parserCallback = this.j) == null) {
            return;
        }
        b41.f(parserCallback);
        char[] cArr2 = this.g;
        if (cArr2 == null) {
            b41.A("buf");
            cArr2 = null;
        }
        parserCallback.characters(cArr2, 0, this.f);
    }

    private final void k(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542818223")) {
            ipChange.ipc$dispatch("-542818223", new Object[]{this, Integer.valueOf(i), str});
        } else if (i != 15 && i != 16 && i != 72 && !this.k.isEmpty() && this.k.peek() != null) {
            vz0 peek = this.k.peek();
            b41.h(peek, "stack.peek()");
            vz0 vz0Var = peek;
            if (i == vz0Var.d() && b41.d(str, vz0Var.b())) {
                this.k.pop();
                return;
            }
            int size = this.k.size() - 1;
            while (size > 0 && (i != this.k.get(size).d() || !b41.d(str, this.k.get(size).b()))) {
                size--;
            }
            if (size > 0) {
                for (int size2 = this.k.size() - 1; size2 != size - 1; size2--) {
                    this.k.pop();
                }
            }
        }
    }

    private final void l(vz0 vz0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643591483")) {
            ipChange.ipc$dispatch("-1643591483", new Object[]{this, vz0Var});
        } else if (vz0Var.d() == 15 || vz0Var.d() == 16 || vz0Var.d() == 72) {
        } else {
            if (!this.k.isEmpty() && this.k.peek() != null && this.k.peek().a() != null) {
                vz0.b a = this.k.peek().a();
                b41.f(a);
                if (vz0Var.a() == null) {
                    vz0Var.e(a);
                } else {
                    vz0.b a2 = vz0Var.a();
                    b41.f(a2);
                    if (a2.b() == 1) {
                        vz0.b a3 = vz0Var.a();
                        b41.f(a3);
                        a3.m(a.b());
                    }
                    vz0.b a4 = vz0Var.a();
                    b41.f(a4);
                    if (a4.i() == -1) {
                        vz0.b a5 = vz0Var.a();
                        b41.f(a5);
                        a5.t(a.i());
                    }
                    vz0.b a6 = vz0Var.a();
                    b41.f(a6);
                    if (a6.a() == -1) {
                        vz0.b a7 = vz0Var.a();
                        b41.f(a7);
                        a7.l(a.a());
                    }
                    vz0.b a8 = vz0Var.a();
                    b41.f(a8);
                    if (a8.j() == 0) {
                        vz0.b a9 = vz0Var.a();
                        b41.f(a9);
                        a9.u(a.j());
                    }
                }
            }
            this.k.push(vz0Var);
        }
    }

    private final void m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765500625")) {
            ipChange.ipc$dispatch("-1765500625", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.f;
        char[] cArr = this.g;
        char[] cArr2 = null;
        if (cArr == null) {
            b41.A("buf");
            cArr = null;
        }
        if (i2 == cArr.length) {
            char[] cArr3 = new char[((this.f * 4) / 3) + 4];
            char[] cArr4 = this.g;
            if (cArr4 == null) {
                b41.A("buf");
                cArr4 = null;
            }
            System.arraycopy(cArr4, 0, cArr3, 0, this.f);
            this.g = cArr3;
        }
        char[] cArr5 = this.g;
        if (cArr5 == null) {
            b41.A("buf");
        } else {
            cArr2 = cArr5;
        }
        int i3 = this.f;
        this.f = i3 + 1;
        cArr2[i3] = (char) i;
    }

    private final char n() {
        char c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454014642")) {
            return ((Character) ipChange.ipc$dispatch("454014642", new Object[]{this})).charValue();
        }
        this.i = this.h;
        char[] cArr = null;
        if (this.c < this.d) {
            char[] cArr2 = this.e;
            if (cArr2 == null) {
                b41.A("srcBuf");
            } else {
                cArr = cArr2;
            }
            int i = this.c;
            this.c = i + 1;
            this.h = cArr[i];
        } else {
            Reader reader = this.b;
            if (reader == null) {
                this.h = (char) 65535;
            } else {
                try {
                    b41.f(reader);
                    char[] cArr3 = this.e;
                    if (cArr3 == null) {
                        b41.A("srcBuf");
                        cArr3 = null;
                    }
                    char[] cArr4 = this.e;
                    if (cArr4 == null) {
                        b41.A("srcBuf");
                        cArr4 = null;
                    }
                    this.d = reader.read(cArr3, 0, cArr4.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    this.h = (char) 65535;
                }
                if (this.d <= 0) {
                    c = 65535;
                } else {
                    char[] cArr5 = this.e;
                    if (cArr5 == null) {
                        b41.A("srcBuf");
                    } else {
                        cArr = cArr5;
                    }
                    c = cArr[0];
                }
                this.h = c;
                this.c = 1;
            }
        }
        char c2 = this.h;
        if (c2 == 65535) {
            c();
        } else if (c2 == '\r') {
            n();
        }
        return this.h;
    }

    private final char o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816600899")) {
            return ((Character) ipChange.ipc$dispatch("-1816600899", new Object[]{this})).charValue();
        }
        while (this.h != 65535) {
            n();
            char c = this.h;
            if (c != '\n' && c != '\r' && c != '\t' && c != ' ') {
                return c;
            }
        }
        return (char) 65535;
    }

    private final void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521038908")) {
            ipChange.ipc$dispatch("1521038908", new Object[]{this});
            return;
        }
        while (true) {
            char c = this.h;
            if (c == 65535 || c == '>') {
                return;
            }
            n();
        }
    }

    public final void g(@Nullable String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376837985")) {
            ipChange.ipc$dispatch("-376837985", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str, "input cant be null");
        char[] charArray = str.toCharArray();
        b41.h(charArray, "this as java.lang.String).toCharArray()");
        this.e = charArray;
        this.c = 0;
        char[] cArr = null;
        if (charArray == null) {
            b41.A("srcBuf");
            charArray = null;
        }
        this.d = charArray.length;
        char[] cArr2 = this.e;
        if (cArr2 == null) {
            b41.A("srcBuf");
        } else {
            cArr = cArr2;
        }
        int length = cArr.length;
        this.k.clear();
        this.g = new char[length];
        d();
    }

    public final void p(@Nullable ParserCallback parserCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-950631070")) {
            ipChange.ipc$dispatch("-950631070", new Object[]{this, parserCallback});
        } else {
            this.j = parserCallback;
        }
    }
}
