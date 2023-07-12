package tb;

import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pq1 {
    private String a;
    private int b = 0;
    private x7<zo2> c = new x7<>();
    private x7<lj2> d = new x7<>();

    public pq1(String str) {
        this.a = str;
    }

    private final void b(int i) {
        while (this.d.i() > i) {
            a(this.d.f());
        }
    }

    public static zo2 g(String str) {
        try {
            return new pq1(str).f();
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("code " + str, e);
            }
            return new C9850wc(null, 6);
        }
    }

    void a(lj2 lj2Var) {
        String str = lj2Var.a;
        if (jn1.BRACKET_START_STR.equals(str) || jn1.BLOCK_START_STR.equals(lj2Var.a) || jn1.ARRAY_START_STR.equals(lj2Var.a) || "$".equals(lj2Var.a) || jn1.BLOCK_START_STR.equals(lj2Var.a)) {
            return;
        }
        int i = lj2Var.b;
        int max = Math.max(i - 1, 0);
        if (!this.d.d()) {
            max = Math.max(max, this.d.e().b);
        }
        hn1 hn1Var = new hn1(str, 5);
        if (jn1.AND_NOT.equals(str)) {
            if (this.c.i() > i) {
                hn1Var.c = this.c.h(i);
                this.c.a(i, hn1Var);
            }
        } else if (this.c.i() > i) {
            hn1Var.e = this.c.h(i);
            if (this.c.i() > max) {
                hn1Var.d = this.c.h(max);
            } else if (hn1Var.e == null) {
                return;
            }
            this.c.a(max, hn1Var);
        }
    }

    final boolean c() {
        return this.b < this.a.length();
    }

    final boolean d() {
        while (c()) {
            if (this.a.charAt(this.b) != ' ') {
                return true;
            }
            this.b++;
        }
        return false;
    }

    final char e() {
        char charAt = this.a.charAt(this.b);
        while (charAt == ' ') {
            this.b++;
            int length = this.a.length();
            int i = this.b;
            if (length <= i) {
                break;
            }
            charAt = this.a.charAt(i);
        }
        return charAt;
    }

    public final zo2 f() {
        while (d()) {
            l();
        }
        while (!this.d.d()) {
            a(this.d.f());
        }
        if (this.c.i() == 1) {
            return this.c.f();
        }
        return new C9850wc(this.c.c(), 6);
    }

    final void h() {
        zo2 c9850wc;
        int i = this.c.i();
        int i2 = this.d.i();
        int i3 = this.b;
        int i4 = (i3 + (-1) < 0 || !Character.isJavaIdentifierPart(this.a.charAt(i3 - 1))) ? 7 : 0;
        this.d.g(new lj2(jn1.ARRAY_START_STR, this.c.i()));
        this.b++;
        while (d() && l() != ']') {
        }
        if (this.c.i() <= i) {
            while (this.d.i() > i2) {
                this.d.f();
            }
            return;
        }
        while (this.d.i() > i2) {
            lj2 f = this.d.f();
            if (this.c.i() > i) {
                a(f);
            }
        }
        ArrayList arrayList = new ArrayList(4);
        for (int i5 = i; i5 < this.c.i(); i5++) {
            arrayList.add(this.c.b(i5));
        }
        while (this.c.i() > i) {
            this.c.f();
        }
        if (i4 != 7 && this.c.i() != 0) {
            zo2 f2 = this.c.f();
            if (arrayList.size() == 1) {
                c9850wc = (zo2) arrayList.get(0);
            } else {
                c9850wc = new C9850wc(arrayList, 6);
            }
            hn1 hn1Var = new hn1(".", i4);
            hn1Var.d = f2;
            hn1Var.e = c9850wc;
            this.c.g(hn1Var);
            return;
        }
        this.c.g(new C9850wc(arrayList, 7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void i() {
        int i = this.c.i();
        int i2 = this.d.i();
        if (this.a.charAt(this.b) == '{') {
            this.d.g(new lj2(jn1.BLOCK_START_STR, this.c.i()));
            this.b++;
            while (d() && l() != '}') {
            }
        } else {
            this.d.g(new lj2(jn1.BRACKET_START_STR, this.c.i()));
            this.b++;
            while (d() && l() != ')') {
            }
        }
        if (this.c.i() <= i) {
            while (this.d.i() > i2) {
                this.d.f();
            }
            return;
        }
        while (this.d.i() > i2) {
            lj2 f = this.d.f();
            if (this.c.i() > i) {
                a(f);
            }
        }
        ArrayList arrayList = new ArrayList(4);
        for (int i3 = i; i3 < this.c.i(); i3++) {
            arrayList.add(this.c.b(i3));
        }
        while (this.c.i() > i) {
            this.c.f();
        }
        if (arrayList.size() == 1) {
            this.c.g(arrayList.get(0));
            return;
        }
        this.c.g(new C9850wc(arrayList, 6));
    }

    final void j() {
        int i = this.b;
        this.b = i + 1;
        while (c() && Character.isJavaIdentifierPart(this.a.charAt(this.b))) {
            this.b++;
        }
        String substring = this.a.substring(i, this.b);
        if (substring.startsWith("$")) {
            if (substring.length() == 1) {
                return;
            }
            substring = substring.substring(1);
        }
        int i2 = 0;
        if (jn1.KEYWORDS.containsKey(substring) && (this.d.d() || !jn1.f(this.d.e().a))) {
            i2 = 4;
        }
        this.c.g(new zo2(substring, i2));
    }

    void k() {
        hn1 hn1Var = new hn1("?", 5);
        b(0);
        if (this.c.i() > (this.d.i() > 0 ? Math.max(this.d.e().b, 0) : 0)) {
            hn1Var.c = this.c.f();
        }
        int i = this.c.i();
        int i2 = this.d.i();
        this.b++;
        while (d() && l() != ':') {
        }
        while (this.d.i() > i2) {
            a(this.d.f());
        }
        while (this.c.i() > i) {
            hn1Var.d = this.c.f();
        }
        int i3 = this.d.i();
        while (d()) {
            l();
            if (d()) {
                l();
            }
            if (this.d.i() <= i3) {
                break;
            }
        }
        b(i3);
        while (this.c.i() > i) {
            hn1Var.e = this.c.f();
        }
        this.c.g(hn1Var);
    }

    final char l() {
        char e = e();
        if (e == '$') {
            this.b++;
            return e;
        }
        if (Character.isJavaIdentifierStart(e)) {
            j();
        } else if (e == '(' || e == '{') {
            i();
        } else if (e == '[') {
            h();
        } else if (e != '\"' && e != '\'') {
            if ((e == '.' && Character.isDigit(this.a.charAt(this.b + 1))) || Character.isDigit(e)) {
                m();
            } else if (e == '?') {
                k();
            } else if (e != ':' && e != ')' && e != '}' && e != ' ' && e != ']') {
                n();
            } else {
                this.b++;
                return e;
            }
        } else {
            o();
        }
        return e;
    }

    final void m() {
        zo2 zo2Var;
        int i = this.b;
        boolean z = (this.a.charAt(i) == 'e' || this.a.charAt(this.b) == '.') ? false : true;
        this.b++;
        while (c()) {
            char charAt = this.a.charAt(this.b);
            if (!Character.isDigit(charAt) && charAt != '.' && charAt != 'e') {
                break;
            }
            if (charAt == 'e' || charAt == '.') {
                z = false;
            }
            this.b++;
        }
        String substring = this.a.substring(i, this.b);
        if (".".equals(substring)) {
            return;
        }
        if (z) {
            zo2Var = new zo2(substring, 1);
        } else {
            zo2Var = new zo2(substring, 2);
        }
        this.c.g(zo2Var);
    }

    void n() {
        int i = this.b;
        String substring = this.a.substring(this.b, Math.min(i + 3, this.a.length()));
        if (substring.length() >= 3 && !jn1.a.containsKey(substring)) {
            substring = substring.substring(0, 2);
        }
        if (substring.length() >= 2 && !jn1.a.containsKey(substring)) {
            substring = substring.substring(0, 1);
        }
        if (!jn1.a.containsKey(substring)) {
            int min = Math.min(i + 1, this.a.length());
            WXLogUtils.e("weex", new IllegalArgumentException(this.a.substring(0, min) + " illegal code operator" + substring));
            this.b = this.b + substring.length();
            return;
        }
        if (!this.d.d() && this.d.e() != null) {
            if (jn1.a.get(this.d.e().a).intValue() >= jn1.a.get(substring).intValue()) {
                a(this.d.f());
            }
        }
        if (!jn1.j(substring)) {
            this.d.g(new lj2(substring, this.c.i()));
        }
        this.b += substring.length();
    }

    final void o() {
        int i = this.b;
        x7 x7Var = new x7();
        char charAt = this.a.charAt(i);
        x7Var.g(Character.valueOf(charAt));
        StringBuilder sb = new StringBuilder();
        while (true) {
            this.b = i + 1;
            if (this.b >= this.a.length()) {
                break;
            }
            char charAt2 = this.a.charAt(this.b);
            if (charAt2 == charAt) {
                if (this.a.charAt(this.b - 1) != '\\') {
                    x7Var.f();
                    if (x7Var.i() == 0) {
                        this.b++;
                        break;
                    }
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(charAt2);
                }
            } else {
                sb.append(charAt2);
            }
            i = this.b;
        }
        this.c.g(new zo2(sb.toString(), 3));
    }
}
