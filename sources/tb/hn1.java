package tb;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class hn1 extends zo2 {
    public zo2 c;
    public zo2 d;
    public zo2 e;

    public hn1(String str, int i) {
        super(str, i);
    }

    @Override // tb.zo2
    public Object a(Object obj) {
        String b = b();
        b.hashCode();
        char c = 65535;
        switch (b.hashCode()) {
            case 33:
                if (b.equals(jn1.AND_NOT)) {
                    c = 0;
                    break;
                }
                break;
            case 37:
                if (b.equals("%")) {
                    c = 1;
                    break;
                }
                break;
            case 42:
                if (b.equals(jn1.MUL)) {
                    c = 2;
                    break;
                }
                break;
            case 43:
                if (b.equals(jn1.PLUS)) {
                    c = 3;
                    break;
                }
                break;
            case 45:
                if (b.equals("-")) {
                    c = 4;
                    break;
                }
                break;
            case 46:
                if (b.equals(".")) {
                    c = 5;
                    break;
                }
                break;
            case 47:
                if (b.equals("/")) {
                    c = 6;
                    break;
                }
                break;
            case 60:
                if (b.equals(jn1.L)) {
                    c = 7;
                    break;
                }
                break;
            case 62:
                if (b.equals(jn1.G)) {
                    c = '\b';
                    break;
                }
                break;
            case 63:
                if (b.equals("?")) {
                    c = '\t';
                    break;
                }
                break;
            case 91:
                if (b.equals(jn1.ARRAY_START_STR)) {
                    c = '\n';
                    break;
                }
                break;
            case 1084:
                if (b.equals(jn1.NOT_EQUAL2)) {
                    c = 11;
                    break;
                }
                break;
            case INoCaptchaComponent.SG_NC_VERI_WUA_INCORRECT_DATA_FILE /* 1216 */:
                if (b.equals(jn1.AND)) {
                    c = '\f';
                    break;
                }
                break;
            case 1921:
                if (b.equals(jn1.LE)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1952:
                if (b.equals(jn1.EQUAL2)) {
                    c = 14;
                    break;
                }
                break;
            case 1983:
                if (b.equals(jn1.GE)) {
                    c = 15;
                    break;
                }
                break;
            case 3968:
                if (b.equals(jn1.OR)) {
                    c = 16;
                    break;
                }
                break;
            case 33665:
                if (b.equals(jn1.NOT_EQUAL)) {
                    c = 17;
                    break;
                }
                break;
            case 60573:
                if (b.equals(jn1.EQUAL)) {
                    c = 18;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Boolean.valueOf(!jn1.r(this.c, obj));
            case 1:
                return jn1.l(this.d, this.e, obj);
            case 2:
                return jn1.m(this.d, this.e, obj);
            case 3:
                return jn1.n(this.d, this.e, obj);
            case 4:
                return jn1.p(this.d, this.e, obj);
            case 5:
            case '\n':
                return jn1.c(this.d, this.e, obj);
            case 6:
                return jn1.b(this.d, this.e, obj);
            case 7:
                return Boolean.valueOf(jn1.q(this.d, obj) < jn1.q(this.e, obj));
            case '\b':
                return Boolean.valueOf(jn1.q(this.d, obj) > jn1.q(this.e, obj));
            case '\t':
                return jn1.a(this.c, this.d, this.e, obj);
            case 11:
            case 17:
                return Boolean.valueOf(!jn1.h(this.d, this.e, obj));
            case '\f':
                if (jn1.r(this.d, obj) && jn1.r(this.e, obj)) {
                    r2 = true;
                }
                return Boolean.valueOf(r2);
            case '\r':
                return Boolean.valueOf(jn1.q(this.d, obj) <= jn1.q(this.e, obj));
            case 14:
            case 18:
                return Boolean.valueOf(jn1.h(this.d, this.e, obj));
            case 15:
                return Boolean.valueOf(jn1.q(this.d, obj) >= jn1.q(this.e, obj));
            case 16:
                return Boolean.valueOf((jn1.r(this.d, obj) || jn1.r(this.e, obj)) ? true : true);
            default:
                throw new IllegalArgumentException(b + " operator is not supported");
        }
    }

    @Override // tb.zo2
    public String toString() {
        if (jn1.AND_NOT.equals(b())) {
            return "{!" + this.c + "}";
        } else if (this.c == null) {
            return jn1.BLOCK_START_STR + this.d + b() + this.e + "}";
        } else {
            return jn1.BLOCK_START_STR + this.c + b() + this.d + ":" + this.e + "}";
        }
    }
}
