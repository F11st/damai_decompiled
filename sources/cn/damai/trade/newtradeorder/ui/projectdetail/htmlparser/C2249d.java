package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.C2247c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.Stack;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.d */
/* loaded from: classes16.dex */
public class C2249d {
    private static transient /* synthetic */ IpChange $ipChange;
    private Reader b;
    private int c;
    private int d;
    private char[] e;
    private int f;
    private char[] g;
    private ParserCallback j;
    private int a = 0;
    private char h = 65535;
    private char i = 65535;
    private Stack<C2247c> k = new Stack<>();

    private boolean a(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007891872")) {
            return ((Boolean) ipChange.ipc$dispatch("-2007891872", new Object[]{this, Integer.valueOf(i), str})).booleanValue();
        }
        int length = str.length();
        while (true) {
            int i2 = length - 1;
            if (length == 0 || i >= str.length()) {
                break;
            } else if (this.g[i] != str.charAt(i)) {
                return false;
            } else {
                i++;
                length = i2;
            }
        }
        return true;
    }

    private int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237444236")) {
            return ((Integer) ipChange.ipc$dispatch("237444236", new Object[]{this})).intValue();
        }
        int i = this.f;
        if (i != 10) {
            switch (i) {
                case 1:
                    char c = this.g[0];
                    if (c == 'a') {
                        return 14;
                    }
                    if (c == 'b') {
                        return 11;
                    }
                    if (c == 'i') {
                        return 3;
                    }
                    if (c == 's') {
                        return 21;
                    }
                    if (c == 'u') {
                        return 6;
                    }
                    if (c == 'p') {
                        return 54;
                    }
                    if (c == 'q') {
                        return 24;
                    }
                    break;
                case 2:
                    char[] cArr = this.g;
                    char c2 = cArr[0];
                    if (c2 != 'b') {
                        if (c2 != 'e') {
                            if (c2 != 'h') {
                                if (c2 != 'l') {
                                    if (c2 != 'o') {
                                        if (c2 != 't') {
                                            if (c2 == 'u' && cArr[1] == 'l') {
                                                return 55;
                                            }
                                        } else if (cArr[1] == 'd') {
                                            return 88;
                                        } else {
                                            if (cArr[1] == 'h') {
                                                return 87;
                                            }
                                            if (cArr[1] == 'r') {
                                                return 86;
                                            }
                                            if (cArr[1] == 't') {
                                                return 2;
                                            }
                                        }
                                    } else if (cArr[1] == 'l') {
                                        return 56;
                                    }
                                } else if (cArr[1] == 'i') {
                                    return 57;
                                }
                            } else if ('1' <= cArr[1] && cArr[1] <= '6') {
                                return (cArr[1] - '1') + 61;
                            } else {
                                if (cArr[1] == 'r') {
                                    return 72;
                                }
                            }
                        } else if (cArr[1] == 'r') {
                            return 9;
                        }
                    } else if (cArr[1] == 'r') {
                        return 16;
                    }
                    break;
                case 3:
                    char[] cArr2 = this.g;
                    char c3 = cArr2[0];
                    if (c3 != 'b') {
                        if (c3 != 'd') {
                            if (c3 != 'i') {
                                if (c3 != 'k') {
                                    if (c3 != 'p') {
                                        if (c3 == 's' && cArr2[1] == 'u') {
                                            if (cArr2[2] == 'b') {
                                                return 17;
                                            }
                                            if (cArr2[2] == 'p') {
                                                return 18;
                                            }
                                        }
                                    } else if (cArr2[1] == 'r' && cArr2[2] == 'e') {
                                        return 70;
                                    }
                                } else if (cArr2[1] == 'b' && cArr2[2] == 'd') {
                                    return 12;
                                }
                            } else if (cArr2[1] == 'm' && cArr2[2] == 'g') {
                                return 15;
                            } else {
                                if (cArr2[1] == 'n' && cArr2[2] == 's') {
                                    return 19;
                                }
                            }
                        } else if (cArr2[1] == 'e' && cArr2[2] == 'l') {
                            return 20;
                        } else {
                            if (cArr2[1] == 'f' && cArr2[2] == 'n') {
                                return 5;
                            }
                            if (cArr2[1] == 'i' && cArr2[2] == 'v') {
                                return 53;
                            }
                        }
                    } else if (cArr2[1] == 'i' && cArr2[2] == 'g') {
                        return 7;
                    }
                    break;
                case 4:
                    char[] cArr3 = this.g;
                    char c4 = cArr3[0];
                    if (c4 != 'c') {
                        if (c4 != 'f') {
                            if (c4 != 'm') {
                                if (c4 == 's' && cArr3[1] == 'p' && cArr3[2] == 'a' && cArr3[3] == 'n') {
                                    return 23;
                                }
                            } else if (cArr3[1] == 'a' && cArr3[2] == 'r' && cArr3[3] == 'k') {
                                return 13;
                            }
                        } else if (cArr3[1] == 'o' && cArr3[2] == 'n' && cArr3[3] == 't') {
                            return 1;
                        }
                    } else if (cArr3[1] == 'i' && cArr3[2] == 't' && cArr3[3] == 'e') {
                        return 4;
                    } else {
                        if (cArr3[1] == 'o' && cArr3[2] == 'd' && cArr3[3] == 'e') {
                            return 25;
                        }
                    }
                    break;
                case 5:
                    if (a(2, "dio")) {
                        char[] cArr4 = this.g;
                        if (cArr4[0] == 'a' && cArr4[1] == 'u') {
                            return 92;
                        }
                        if (cArr4[0] == 'v' && cArr4[1] == 'e') {
                            return 91;
                        }
                    } else {
                        char c5 = this.g[0];
                        if (c5 != 's') {
                            if (c5 != 't') {
                                return -1;
                            }
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
                        } else if (a(1, "mall")) {
                            return 8;
                        }
                    }
                    break;
                case 6:
                    if (a(0, "str")) {
                        char[] cArr5 = this.g;
                        if (cArr5[3] == 'o' && cArr5[4] == 'n' && cArr5[5] == 'g') {
                            return 10;
                        }
                        if (cArr5[3] == 'i' && cArr5[4] == 'k' && cArr5[5] == 'e') {
                            return 22;
                        }
                    } else {
                        char[] cArr6 = this.g;
                        if (cArr6[4] == 'e' && cArr6[5] == 'f') {
                            if (cArr6[0] == 'h' && cArr6[1] == 'e' && cArr6[2] == 'a' && cArr6[3] == 'd') {
                                return 50;
                            }
                            if (cArr6[0] == 'f' && cArr6[1] == 'o' && cArr6[2] == 'o' && cArr6[3] == 't') {
                                return 51;
                            }
                        }
                    }
                    break;
                case 7:
                    if (a(0, "caption")) {
                        return 82;
                    }
                    break;
                default:
                    return -1;
            }
        } else if (a(0, "blockquote")) {
            return 71;
        }
        return -1;
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153793395")) {
            ipChange.ipc$dispatch("-153793395", new Object[]{this});
            return;
        }
        while (!this.k.isEmpty()) {
            C2247c pop = this.k.pop();
            this.j.endElement(pop.a, pop.b);
        }
        this.h = (char) 65535;
        this.j.endDocument();
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293142784")) {
            ipChange.ipc$dispatch("-293142784", new Object[]{this});
            return;
        }
        ParserCallback parserCallback = this.j;
        if (parserCallback == null) {
            return;
        }
        parserCallback.startDocument(this.e.length);
        n();
        while (true) {
            char c = this.h;
            if (c == 65535) {
                return;
            }
            if (c == '<') {
                n();
                char c2 = this.h;
                if (c2 == '!') {
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
                } else if (c2 == '/') {
                    h();
                } else if (c2 != '?') {
                    i();
                } else {
                    q();
                }
            } else if (c == '>') {
                n();
                j();
            } else if (c != 65535) {
                char c3 = this.i;
                if (c3 != 65535 && c3 != '>') {
                    n();
                } else {
                    j();
                }
            } else {
                c();
            }
        }
    }

    private void e() {
        char c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247337521")) {
            ipChange.ipc$dispatch("-247337521", new Object[]{this});
            return;
        }
        this.f = 0;
        do {
            char[] cArr = this.g;
            int i = this.f;
            this.f = i + 1;
            cArr[i] = this.h;
            n();
            c = this.h;
            if (c == 65535 || c == '>') {
                break;
            }
        } while (this.f < 384);
        char[] cArr2 = this.g;
        int i2 = this.f;
        if (cArr2[i2 - 1] == '/') {
            this.f = i2 - 1;
        }
        if (c != '>') {
            q();
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155151637")) {
            ipChange.ipc$dispatch("-155151637", new Object[]{this});
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

    private void h() {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200413569")) {
            ipChange.ipc$dispatch("200413569", new Object[]{this});
            return;
        }
        this.f = 0;
        while (this.h != 65535) {
            char o = o();
            this.h = o;
            if (o == '>' || (i2 = this.f) >= 16) {
                break;
            }
            char[] cArr = this.g;
            this.f = i2 + 1;
            cArr[i2] = o;
        }
        String str = new String(this.g, 0, this.f);
        int b = b();
        this.f = 0;
        if (b == 70 && (i = this.a) > 0) {
            this.a = i - 1;
        }
        k(b, str);
        this.j.endElement(b, str);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177394424")) {
            ipChange.ipc$dispatch("-177394424", new Object[]{this});
            return;
        }
        char c = this.h;
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            return;
        }
        this.f = 0;
        while (true) {
            char c2 = this.h;
            if (c2 >= 'A' && c2 <= 'Z') {
                this.h = (char) ((c2 + 'a') - 65);
            }
            char[] cArr = this.g;
            int i = this.f;
            this.f = i + 1;
            cArr[i] = this.h;
            n();
            char c3 = this.h;
            if (c3 == 65535 || this.f >= 16) {
                break;
            } else if (c3 < 'a' || c3 > 'z') {
                if (c3 < 'A' || c3 > 'Z') {
                    if (c3 < '0' || c3 > '9') {
                        break;
                    }
                }
            }
        }
        String str = new String(this.g, 0, this.f);
        int b = b();
        this.f = 0;
        if (this.h == '/') {
            n();
        }
        char c4 = this.h;
        if (c4 != '>') {
            if (c4 == ' ' || c4 == '\n' || c4 == '\r') {
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
            int i2 = this.f;
            C2247c c2247c = new C2247c(b, str, i2 >= 5 ? C2245a.m(b, this.g, i2) : null);
            l(c2247c);
            this.j.startElement(c2247c);
        }
    }

    private void j() {
        ParserCallback parserCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990320365")) {
            ipChange.ipc$dispatch("-990320365", new Object[]{this});
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
                } else {
                    int i = this.f;
                    if (i != 0 && this.g[i - 1] != ' ') {
                        this.h = ' ';
                        m(32);
                    }
                }
            }
            n();
        }
        int i2 = this.f;
        if (i2 <= 0 || (parserCallback = this.j) == null) {
            return;
        }
        parserCallback.characters(this.g, 0, i2);
    }

    private void k(int i, String str) {
        C2247c peek;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421143603")) {
            ipChange.ipc$dispatch("-421143603", new Object[]{this, Integer.valueOf(i), str});
        } else if (i != 15 && i != 16 && i != 72 && !this.k.isEmpty() && (peek = this.k.peek()) != null) {
            if (i == peek.a && str.equals(peek.b)) {
                this.k.pop();
                return;
            }
            int size = this.k.size() - 1;
            while (size > 0 && (i != this.k.get(size).a || !str.equals(this.k.get(size).b))) {
                size--;
            }
            if (size > 0) {
                for (int size2 = this.k.size() - 1; size2 != size - 1; size2--) {
                    this.k.pop();
                }
            }
        }
    }

    private void l(C2247c c2247c) {
        C2247c.C2248a c2248a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987059433")) {
            ipChange.ipc$dispatch("987059433", new Object[]{this, c2247c});
            return;
        }
        int i = c2247c.a;
        if (i == 15 || i == 16 || i == 72) {
            return;
        }
        if (!this.k.isEmpty() && (c2248a = this.k.peek().d) != null) {
            C2247c.C2248a c2248a2 = c2247c.d;
            if (c2248a2 == null) {
                c2247c.d = c2248a;
            } else {
                if (c2248a2.c == 1) {
                    c2248a2.c = c2248a.c;
                }
                if (c2248a2.e == -1) {
                    c2248a2.e = c2248a.e;
                }
                if (c2248a2.g == -1) {
                    c2248a2.g = c2248a.g;
                }
                if (c2248a2.f == 0) {
                    c2248a2.f = c2248a.f;
                }
            }
        }
        this.k.push(c2247c);
    }

    private void m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181276621")) {
            ipChange.ipc$dispatch("-1181276621", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.f;
        char[] cArr = this.g;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[((i2 * 4) / 3) + 4];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.g = cArr2;
        }
        char[] cArr3 = this.g;
        int i3 = this.f;
        this.f = i3 + 1;
        cArr3[i3] = (char) i;
    }

    private char n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448220462")) {
            return ((Character) ipChange.ipc$dispatch("1448220462", new Object[]{this})).charValue();
        }
        this.i = this.h;
        int i = this.c;
        if (i < this.d) {
            char[] cArr = this.e;
            this.c = i + 1;
            this.h = cArr[i];
        } else {
            Reader reader = this.b;
            if (reader == null) {
                this.h = (char) 65535;
            } else {
                try {
                    char[] cArr2 = this.e;
                    this.d = reader.read(cArr2, 0, cArr2.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    this.h = (char) 65535;
                }
                if (this.d <= 0) {
                    this.h = (char) 65535;
                } else {
                    this.h = this.e[0];
                }
                this.c = 1;
            }
        }
        char c = this.h;
        if (c == '\r') {
            n();
        } else if (c == 65535) {
            c();
        }
        return this.h;
    }

    private char o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276918465")) {
            return ((Character) ipChange.ipc$dispatch("1276918465", new Object[]{this})).charValue();
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

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779722568")) {
            ipChange.ipc$dispatch("-1779722568", new Object[]{this});
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

    public void g(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539466213")) {
            ipChange.ipc$dispatch("-539466213", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str, "input cant be null");
        char[] charArray = str.toCharArray();
        this.e = charArray;
        this.c = 0;
        this.d = charArray.length;
        int length = charArray.length;
        this.k.clear();
        this.g = new char[length];
        d();
    }

    public void p(ParserCallback parserCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338562402")) {
            ipChange.ipc$dispatch("-1338562402", new Object[]{this, parserCallback});
        } else {
            this.j = parserCallback;
        }
    }
}
