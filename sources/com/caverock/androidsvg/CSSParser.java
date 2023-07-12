package com.caverock.androidsvg;

import android.util.Log;
import com.alipay.sdk.m.n.C4250a;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.b90;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CSSParser {
    private MediaType a;
    private Source b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface PseudoClass {
        boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            PseudoClassIdents[] values;
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Source {
        Document,
        RenderOptions
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$a */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C4675a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            b = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                b[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                b[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                b[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            a = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$b */
    /* loaded from: classes10.dex */
    public static class C4676b {
        public final String a;
        final AttribOp b;
        public final String c;

        C4676b(String str, AttribOp attribOp, String str2) {
            this.a = str;
            this.b = attribOp;
            this.c = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$c */
    /* loaded from: classes10.dex */
    public static class C4677c extends SVGParser.C4743g {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: com.caverock.androidsvg.CSSParser$c$a */
        /* loaded from: classes10.dex */
        public static class C4678a {
            public int a;
            public int b;

            C4678a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }
        }

        C4677c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int D(int i) {
            if (i < 48 || i > 57) {
                int i2 = 65;
                if (i < 65 || i > 70) {
                    i2 = 97;
                    if (i < 97 || i > 102) {
                        return -1;
                    }
                }
                return (i - i2) + 10;
            }
            return i - 48;
        }

        private C4678a E() throws CSSParseException {
            C4746b c4746b;
            C4678a c4678a;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (f('(')) {
                A();
                int i2 = 1;
                if (g("odd")) {
                    c4678a = new C4678a(2, 1);
                } else {
                    if (g("even")) {
                        c4678a = new C4678a(2, 0);
                    } else {
                        int i3 = (!f('+') && f('-')) ? -1 : 1;
                        C4746b c = C4746b.c(this.a, this.b, this.c, false);
                        if (c != null) {
                            this.b = c.a();
                        }
                        if (f('n') || f('N')) {
                            if (c == null) {
                                c = new C4746b(1L, this.b);
                            }
                            A();
                            boolean f = f('+');
                            if (!f && (f = f('-'))) {
                                i2 = -1;
                            }
                            if (f) {
                                A();
                                c4746b = C4746b.c(this.a, this.b, this.c, false);
                                if (c4746b != null) {
                                    this.b = c4746b.a();
                                } else {
                                    this.b = i;
                                    return null;
                                }
                            } else {
                                c4746b = null;
                            }
                            int i4 = i2;
                            i2 = i3;
                            i3 = i4;
                        } else {
                            c4746b = c;
                            c = null;
                        }
                        c4678a = new C4678a(c == null ? 0 : i2 * c.d(), c4746b != null ? i3 * c4746b.d() : 0);
                    }
                }
                A();
                if (f(')')) {
                    return c4678a;
                }
                this.b = i;
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String F() {
            if (h()) {
                return null;
            }
            String q = q();
            return q != null ? q : I();
        }

        private List<String> H() throws CSSParseException {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (f('(')) {
                A();
                ArrayList arrayList = null;
                do {
                    String I = I();
                    if (I == null) {
                        this.b = i;
                        return null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(I);
                    A();
                } while (z());
                if (f(')')) {
                    return arrayList;
                }
                this.b = i;
                return null;
            }
            return null;
        }

        private List<C4689n> L() throws CSSParseException {
            List<C4690o> list;
            List<PseudoClass> list2;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (f('(')) {
                A();
                List<C4689n> M = M();
                if (M == null) {
                    this.b = i;
                    return null;
                } else if (!f(')')) {
                    this.b = i;
                    return null;
                } else {
                    Iterator<C4689n> it = M.iterator();
                    while (it.hasNext() && (list = it.next().a) != null) {
                        Iterator<C4690o> it2 = list.iterator();
                        while (it2.hasNext() && (list2 = it2.next().d) != null) {
                            for (PseudoClass pseudoClass : list2) {
                                if (pseudoClass instanceof C4681f) {
                                    return null;
                                }
                            }
                        }
                    }
                    return M;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<C4689n> M() throws CSSParseException {
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            C4689n c4689n = new C4689n(null);
            while (!h() && N(c4689n)) {
                if (z()) {
                    arrayList.add(c4689n);
                    c4689n = new C4689n(null);
                }
            }
            if (!c4689n.f()) {
                arrayList.add(c4689n);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void P(C4689n c4689n, C4690o c4690o) throws CSSParseException {
            PseudoClass c4679d;
            C4679d c4679d2;
            String I = I();
            if (I != null) {
                PseudoClassIdents fromString = PseudoClassIdents.fromString(I);
                switch (C4675a.b[fromString.ordinal()]) {
                    case 1:
                        c4679d = new C4679d(0, 1, true, false, null);
                        c4689n.b();
                        break;
                    case 2:
                        c4679d = new C4679d(0, 1, false, false, null);
                        c4689n.b();
                        break;
                    case 3:
                        c4679d = new C4683h(false, null);
                        c4689n.b();
                        break;
                    case 4:
                        c4679d = new C4679d(0, 1, true, true, c4690o.b);
                        c4689n.b();
                        break;
                    case 5:
                        c4679d = new C4679d(0, 1, false, true, c4690o.b);
                        c4689n.b();
                        break;
                    case 6:
                        c4679d = new C4683h(true, c4690o.b);
                        c4689n.b();
                        break;
                    case 7:
                        c4679d = new C4684i(null);
                        c4689n.b();
                        break;
                    case 8:
                        c4679d = new C4680e(null);
                        c4689n.b();
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        boolean z = fromString == PseudoClassIdents.nth_child || fromString == PseudoClassIdents.nth_of_type;
                        boolean z2 = fromString == PseudoClassIdents.nth_of_type || fromString == PseudoClassIdents.nth_last_of_type;
                        C4678a E = E();
                        if (E != null) {
                            C4679d c4679d3 = new C4679d(E.a, E.b, z, z2, c4690o.b);
                            c4689n.b();
                            c4679d2 = c4679d3;
                            c4679d = c4679d2;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + I);
                        }
                        break;
                    case 13:
                        List<C4689n> L = L();
                        if (L != null) {
                            C4681f c4681f = new C4681f(L);
                            c4689n.b = c4681f.a();
                            c4679d2 = c4681f;
                            c4679d = c4679d2;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + I);
                        }
                    case 14:
                        c4679d = new C4685j(null);
                        c4689n.b();
                        break;
                    case 15:
                        H();
                        c4679d = new C4682g(I);
                        c4689n.b();
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        c4679d = new C4682g(I);
                        c4689n.b();
                        break;
                    default:
                        throw new CSSParseException("Unsupported pseudo class: " + I);
                }
                c4690o.b(c4679d);
                return;
            }
            throw new CSSParseException("Invalid pseudo class");
        }

        private int Q() {
            int i;
            if (h()) {
                return this.b;
            }
            int i2 = this.b;
            int charAt = this.a.charAt(i2);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i = i2;
            } else {
                int a = a();
                while (true) {
                    if ((a < 65 || a > 90) && ((a < 97 || a > 122) && !((a >= 48 && a <= 57) || a == 45 || a == 95))) {
                        break;
                    }
                    a = a();
                }
                i = this.b;
            }
            this.b = i2;
            return i;
        }

        String G() {
            int D;
            if (h()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if (charAt == '\'' || charAt == '\"') {
                StringBuilder sb = new StringBuilder();
                this.b++;
                int intValue = l().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = l().intValue();
                        if (intValue != -1) {
                            if (intValue != 10 && intValue != 13 && intValue != 12) {
                                int D2 = D(intValue);
                                if (D2 != -1) {
                                    for (int i = 1; i <= 5 && (D = D((intValue = l().intValue()))) != -1; i++) {
                                        D2 = (D2 * 16) + D;
                                    }
                                    sb.append((char) D2);
                                }
                            } else {
                                intValue = l().intValue();
                            }
                        }
                    }
                    sb.append((char) intValue);
                    intValue = l().intValue();
                }
                return sb.toString();
            }
            return null;
        }

        String I() {
            int Q = Q();
            int i = this.b;
            if (Q == i) {
                return null;
            }
            String substring = this.a.substring(i, Q);
            this.b = Q;
            return substring;
        }

        String J() {
            char charAt;
            int D;
            StringBuilder sb = new StringBuilder();
            while (!h() && (charAt = this.a.charAt(this.b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl((int) charAt)) {
                this.b++;
                if (charAt == '\\') {
                    if (!h()) {
                        String str = this.a;
                        int i = this.b;
                        this.b = i + 1;
                        charAt = str.charAt(i);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int D2 = D(charAt);
                            if (D2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !h() && (D = D(this.a.charAt(this.b))) != -1; i2++) {
                                    this.b++;
                                    D2 = (D2 * 16) + D;
                                }
                                sb.append((char) D2);
                            }
                        }
                    }
                }
                sb.append(charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String K() {
            if (h()) {
                return null;
            }
            int i = this.b;
            int charAt = this.a.charAt(i);
            int i2 = i;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                if (!k(charAt)) {
                    i2 = this.b + 1;
                }
                charAt = a();
            }
            if (this.b > i) {
                return this.a.substring(i, i2);
            }
            this.b = i;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0133  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean N(com.caverock.androidsvg.CSSParser.C4689n r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                Method dump skipped, instructions count: 310
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.C4677c.N(com.caverock.androidsvg.CSSParser$n):boolean");
        }

        String O() {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (g("url(")) {
                A();
                String G = G();
                if (G == null) {
                    G = J();
                }
                if (G == null) {
                    this.b = i;
                    return null;
                }
                A();
                if (h() || g(jn1.BRACKET_END_STR)) {
                    return G;
                }
                this.b = i;
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$d */
    /* loaded from: classes10.dex */
    public static class C4679d implements PseudoClass {
        private int a;
        private int b;
        private boolean c;
        private boolean d;
        private String e;

        C4679d(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            int i;
            int i2;
            String a = (this.d && this.e == null) ? abstractC4692a0.a() : this.e;
            SVG.SvgContainer svgContainer = abstractC4692a0.b;
            if (svgContainer != null) {
                Iterator<SVG.C4696c0> it = svgContainer.getChildren().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    SVG.AbstractC4692a0 abstractC4692a02 = (SVG.AbstractC4692a0) it.next();
                    if (abstractC4692a02 == abstractC4692a0) {
                        i = i2;
                    }
                    if (a == null || abstractC4692a02.a().equals(a)) {
                        i2++;
                    }
                }
            } else {
                i = 0;
                i2 = 1;
            }
            int i3 = this.c ? i + 1 : i2 - i;
            int i4 = this.a;
            if (i4 == 0) {
                return i3 == this.b;
            }
            int i5 = this.b;
            if ((i3 - i5) % i4 == 0) {
                return Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.a);
            }
            return false;
        }

        public String toString() {
            String str = this.c ? "" : "last-";
            return this.d ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$e */
    /* loaded from: classes10.dex */
    public static class C4680e implements PseudoClass {
        private C4680e() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            return !(abstractC4692a0 instanceof SVG.SvgContainer) || ((SVG.SvgContainer) abstractC4692a0).getChildren().size() == 0;
        }

        public String toString() {
            return DXRecyclerLayout.LOAD_MORE_EMPTY;
        }

        /* synthetic */ C4680e(C4675a c4675a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$f */
    /* loaded from: classes10.dex */
    public static class C4681f implements PseudoClass {
        private List<C4689n> a;

        C4681f(List<C4689n> list) {
            this.a = list;
        }

        int a() {
            int i = Integer.MIN_VALUE;
            for (C4689n c4689n : this.a) {
                int i2 = c4689n.b;
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            for (C4689n c4689n : this.a) {
                if (CSSParser.l(c4687l, c4689n, abstractC4692a0)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return "not(" + this.a + jn1.BRACKET_END_STR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$g */
    /* loaded from: classes10.dex */
    public static class C4682g implements PseudoClass {
        private String a;

        C4682g(String str) {
            this.a = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            return false;
        }

        public String toString() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$h */
    /* loaded from: classes10.dex */
    public static class C4683h implements PseudoClass {
        private boolean a;
        private String b;

        public C4683h(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            int i;
            String a = (this.a && this.b == null) ? abstractC4692a0.a() : this.b;
            SVG.SvgContainer svgContainer = abstractC4692a0.b;
            if (svgContainer != null) {
                Iterator<SVG.C4696c0> it = svgContainer.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.AbstractC4692a0 abstractC4692a02 = (SVG.AbstractC4692a0) it.next();
                    if (a == null || abstractC4692a02.a().equals(a)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public String toString() {
            return this.a ? String.format("only-of-type <%s>", this.b) : String.format("only-child", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$i */
    /* loaded from: classes10.dex */
    public static class C4684i implements PseudoClass {
        private C4684i() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            return abstractC4692a0.b == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ C4684i(C4675a c4675a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$j */
    /* loaded from: classes10.dex */
    public static class C4685j implements PseudoClass {
        private C4685j() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(C4687l c4687l, SVG.AbstractC4692a0 abstractC4692a0) {
            return c4687l != null && abstractC4692a0 == c4687l.a;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ C4685j(C4675a c4675a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$k */
    /* loaded from: classes10.dex */
    public static class C4686k {
        C4689n a;
        SVG.Style b;
        Source c;

        C4686k(C4689n c4689n, SVG.Style style, Source source) {
            this.a = null;
            this.b = null;
            this.a = c4689n;
            this.b = style;
            this.c = source;
        }

        public String toString() {
            return String.valueOf(this.a) + " {...} (src=" + this.c + jn1.BRACKET_END_STR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$l */
    /* loaded from: classes10.dex */
    public static class C4687l {
        SVG.AbstractC4692a0 a;

        public String toString() {
            SVG.AbstractC4692a0 abstractC4692a0 = this.a;
            return abstractC4692a0 != null ? String.format("<%s id=\"%s\">", abstractC4692a0.a(), this.a.c) : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$m */
    /* loaded from: classes10.dex */
    public static class C4688m {
        private List<C4686k> a = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(C4686k c4686k) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).a.b > c4686k.a.b) {
                    this.a.add(i, c4686k);
                    return;
                }
            }
            this.a.add(c4686k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(C4688m c4688m) {
            if (c4688m.a == null) {
                return;
            }
            if (this.a == null) {
                this.a = new ArrayList(c4688m.a.size());
            }
            for (C4686k c4686k : c4688m.a) {
                a(c4686k);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<C4686k> c() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d() {
            List<C4686k> list = this.a;
            return list == null || list.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(Source source) {
            List<C4686k> list = this.a;
            if (list == null) {
                return;
            }
            Iterator<C4686k> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().c == source) {
                    it.remove();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            List<C4686k> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (C4686k c4686k : this.a) {
                sb.append(c4686k.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$o */
    /* loaded from: classes10.dex */
    public static class C4690o {
        Combinator a;
        String b;
        List<C4676b> c = null;
        List<PseudoClass> d = null;

        C4690o(Combinator combinator, String str) {
            this.a = null;
            this.b = null;
            this.a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.b = str;
        }

        void a(String str, AttribOp attribOp, String str2) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(new C4676b(str, attribOp, str2));
        }

        void b(PseudoClass pseudoClass) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.a;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.b;
            if (str == null) {
                str = jn1.MUL;
            }
            sb.append(str);
            List<C4676b> list = this.c;
            if (list != null) {
                for (C4676b c4676b : list) {
                    sb.append(jn1.ARRAY_START);
                    sb.append(c4676b.a);
                    int i = C4675a.a[c4676b.b.ordinal()];
                    if (i == 1) {
                        sb.append(C4250a.h);
                        sb.append(c4676b.c);
                    } else if (i == 2) {
                        sb.append("~=");
                        sb.append(c4676b.c);
                    } else if (i == 3) {
                        sb.append("|=");
                        sb.append(c4676b.c);
                    }
                    sb.append(jn1.ARRAY_END);
                }
            }
            List<PseudoClass> list2 = this.d;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(jn1.CONDITION_IF_MIDDLE);
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    private static int a(List<SVG.SvgContainer> list, int i, SVG.AbstractC4692a0 abstractC4692a0) {
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        SVG.SvgContainer svgContainer = list.get(i);
        SVG.SvgContainer svgContainer2 = abstractC4692a0.b;
        if (svgContainer != svgContainer2) {
            return -1;
        }
        for (SVG.C4696c0 c4696c0 : svgContainer2.getChildren()) {
            if (c4696c0 == abstractC4692a0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str, MediaType mediaType) {
        C4677c c4677c = new C4677c(str);
        c4677c.A();
        return c(h(c4677c), mediaType);
    }

    private static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all) {
                return true;
            }
            if (mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private void e(C4688m c4688m, C4677c c4677c) throws CSSParseException {
        String I = c4677c.I();
        c4677c.A();
        if (I != null) {
            if (!this.c && I.equals(SVGParser.XML_STYLESHEET_ATTR_MEDIA)) {
                List<MediaType> h = h(c4677c);
                if (c4677c.f('{')) {
                    c4677c.A();
                    if (c(h, this.a)) {
                        this.c = true;
                        c4688m.b(j(c4677c));
                        this.c = false;
                    } else {
                        j(c4677c);
                    }
                    if (!c4677c.h() && !c4677c.f('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (!this.c && I.equals("import")) {
                String O = c4677c.O();
                if (O == null) {
                    O = c4677c.G();
                }
                if (O != null) {
                    c4677c.A();
                    h(c4677c);
                    if (!c4677c.h() && !c4677c.f(b90.TokenSEM)) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                    SVG.g();
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            } else {
                p("Ignoring @%s rule", I);
                o(c4677c);
            }
            c4677c.A();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    public static List<String> f(String str) {
        C4677c c4677c = new C4677c(str);
        ArrayList arrayList = null;
        while (!c4677c.h()) {
            String r = c4677c.r();
            if (r != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r);
                c4677c.A();
            }
        }
        return arrayList;
    }

    private SVG.Style g(C4677c c4677c) throws CSSParseException {
        SVG.Style style = new SVG.Style();
        do {
            String I = c4677c.I();
            c4677c.A();
            if (c4677c.f(jn1.CONDITION_IF_MIDDLE)) {
                c4677c.A();
                String K = c4677c.K();
                if (K != null) {
                    c4677c.A();
                    if (c4677c.f('!')) {
                        c4677c.A();
                        if ("important".equalsIgnoreCase(c4677c.F())) {
                            style.important = true;
                        }
                        c4677c.A();
                    }
                    c4677c.f(b90.TokenSEM);
                    SVGParser.S0(style, I, K);
                    c4677c.A();
                    if (c4677c.h()) {
                        break;
                    }
                } else {
                    throw new CSSParseException("Expected property value");
                }
            } else {
                throw new CSSParseException("Expected ':'");
            }
        } while (!c4677c.f('}'));
        return style;
    }

    private static List<MediaType> h(C4677c c4677c) {
        String w;
        ArrayList arrayList = new ArrayList();
        while (!c4677c.h() && (w = c4677c.w()) != null) {
            try {
                arrayList.add(MediaType.valueOf(w));
            } catch (IllegalArgumentException unused) {
            }
            if (!c4677c.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(C4688m c4688m, C4677c c4677c) throws CSSParseException {
        List<C4689n> M = c4677c.M();
        if (M == null || M.isEmpty()) {
            return false;
        }
        if (c4677c.f('{')) {
            c4677c.A();
            SVG.Style g = g(c4677c);
            c4677c.A();
            for (C4689n c4689n : M) {
                c4688m.a(new C4686k(c4689n, g, this.b));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    private C4688m j(C4677c c4677c) {
        C4688m c4688m = new C4688m();
        while (!c4677c.h()) {
            try {
                if (!c4677c.g("<!--") && !c4677c.g("-->")) {
                    if (c4677c.f('@')) {
                        e(c4688m, c4677c);
                    } else if (!i(c4688m, c4677c)) {
                        break;
                    }
                }
            } catch (CSSParseException e) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e.getMessage());
            }
        }
        return c4688m;
    }

    private static boolean k(C4687l c4687l, C4689n c4689n, int i, List<SVG.SvgContainer> list, int i2, SVG.AbstractC4692a0 abstractC4692a0) {
        C4690o e = c4689n.e(i);
        if (n(c4687l, e, list, i2, abstractC4692a0)) {
            Combinator combinator = e.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 >= 0) {
                    if (m(c4687l, c4689n, i - 1, list, i2)) {
                        return true;
                    }
                    i2--;
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return m(c4687l, c4689n, i - 1, list, i2);
            } else {
                int a = a(list, i2, abstractC4692a0);
                if (a <= 0) {
                    return false;
                }
                return k(c4687l, c4689n, i - 1, list, i2, (SVG.AbstractC4692a0) abstractC4692a0.b.getChildren().get(a - 1));
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(C4687l c4687l, C4689n c4689n, SVG.AbstractC4692a0 abstractC4692a0) {
        if (c4689n.g() == 1) {
            return n(c4687l, c4689n.e(0), null, -1, abstractC4692a0);
        }
        ArrayList arrayList = new ArrayList();
        for (SVG.SvgContainer svgContainer = abstractC4692a0.b; svgContainer != null; svgContainer = ((SVG.C4696c0) svgContainer).b) {
            arrayList.add(0, svgContainer);
        }
        return k(c4687l, c4689n, c4689n.g() - 1, arrayList, arrayList.size() - 1, abstractC4692a0);
    }

    private static boolean m(C4687l c4687l, C4689n c4689n, int i, List<SVG.SvgContainer> list, int i2) {
        C4690o e = c4689n.e(i);
        SVG.AbstractC4692a0 abstractC4692a0 = (SVG.AbstractC4692a0) list.get(i2);
        if (n(c4687l, e, list, i2, abstractC4692a0)) {
            Combinator combinator = e.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 > 0) {
                    i2--;
                    if (m(c4687l, c4689n, i - 1, list, i2)) {
                        return true;
                    }
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return m(c4687l, c4689n, i - 1, list, i2 - 1);
            } else {
                int a = a(list, i2, abstractC4692a0);
                if (a <= 0) {
                    return false;
                }
                return k(c4687l, c4689n, i - 1, list, i2, (SVG.AbstractC4692a0) abstractC4692a0.b.getChildren().get(a - 1));
            }
        }
        return false;
    }

    private static boolean n(C4687l c4687l, C4690o c4690o, List<SVG.SvgContainer> list, int i, SVG.AbstractC4692a0 abstractC4692a0) {
        List<String> list2;
        String str = c4690o.b;
        if (str == null || str.equals(abstractC4692a0.a().toLowerCase(Locale.US))) {
            List<C4676b> list3 = c4690o.c;
            if (list3 != null) {
                int size = list3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C4676b c4676b = c4690o.c.get(i2);
                    String str2 = c4676b.a;
                    str2.hashCode();
                    if (!str2.equals("id")) {
                        if (!str2.equals("class") || (list2 = abstractC4692a0.g) == null || !list2.contains(c4676b.c)) {
                            return false;
                        }
                    } else if (!c4676b.c.equals(abstractC4692a0.c)) {
                        return false;
                    }
                }
            }
            List<PseudoClass> list4 = c4690o.d;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (!c4690o.d.get(i3).matches(c4687l, abstractC4692a0)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void o(C4677c c4677c) {
        int i = 0;
        while (!c4677c.h()) {
            int intValue = c4677c.l().intValue();
            if (intValue == 59 && i == 0) {
                return;
            }
            if (intValue == 123) {
                i++;
            } else if (intValue == 125 && i > 0 && i - 1 == 0) {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4688m d(String str) {
        C4677c c4677c = new C4677c(str);
        c4677c.A();
        return j(c4677c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(MediaType mediaType, Source source) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = mediaType;
        this.b = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.CSSParser$n */
    /* loaded from: classes10.dex */
    public static class C4689n {
        List<C4690o> a;
        int b;

        private C4689n() {
            this.a = null;
            this.b = 0;
        }

        void a(C4690o c4690o) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(c4690o);
        }

        void b() {
            this.b += 1000;
        }

        void c() {
            this.b++;
        }

        void d() {
            this.b += 1000000;
        }

        C4690o e(int i) {
            return this.a.get(i);
        }

        boolean f() {
            List<C4690o> list = this.a;
            return list == null || list.isEmpty();
        }

        int g() {
            List<C4690o> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (C4690o c4690o : this.a) {
                sb.append(c4690o);
                sb.append(' ');
            }
            sb.append(jn1.ARRAY_START);
            sb.append(this.b);
            sb.append(jn1.ARRAY_END);
            return sb.toString();
        }

        /* synthetic */ C4689n(C4675a c4675a) {
            this();
        }
    }
}
