package com.taobao.slide.control;

import android.text.TextUtils;
import com.taobao.slide.compare.ICompare;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.da1;
import tb.jn1;
import tb.nl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UnitParse {
    private static final Pattern d;
    private static final Map<String, OPERATOR> e = new HashMap();
    public String a;
    private String b;
    private OPERATOR c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    enum OPERATOR {
        EQUALS("="),
        GREATER_EQUALS(jn1.GE),
        LESS_EQUALS(jn1.LE),
        GREATER(jn1.G),
        LESS(jn1.L),
        NOT_EQUALS(jn1.NOT_EQUAL2),
        FUZZY("~="),
        NOT_FUZZY("!~"),
        IN("⊂"),
        NOT_IN("⊄");
        
        private String symbol;

        OPERATOR(String str) {
            this.symbol = str;
        }

        public String getSymbol() {
            return this.symbol;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OPERATOR.values().length];
            a = iArr;
            try {
                iArr[OPERATOR.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OPERATOR.NOT_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OPERATOR.GREATER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OPERATOR.GREATER_EQUALS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OPERATOR.LESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[OPERATOR.LESS_EQUALS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[OPERATOR.FUZZY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[OPERATOR.NOT_FUZZY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[OPERATOR.IN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[OPERATOR.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        OPERATOR[] values;
        ArrayList arrayList = new ArrayList();
        for (OPERATOR operator : OPERATOR.values()) {
            e.put(operator.getSymbol(), operator);
            arrayList.add(operator.getSymbol());
        }
        d = Pattern.compile(String.format("^\\s*(\\w+)\\s*(%s)\\s*(.+)\\s*$", nl.c(arrayList)));
    }

    private UnitParse(String str) {
        if (!"ANY".equals(str) && !"NONE".equals(str)) {
            Matcher matcher = d.matcher(str);
            if (matcher.find()) {
                this.a = matcher.group(1);
                this.c = e.get(matcher.group(2));
                this.b = matcher.group(3);
                if (this.a.equals("did_hash") && this.c != OPERATOR.EQUALS) {
                    throw new IllegalArgumentException(String.format("invalid hash exp:%s", str));
                }
                return;
            }
            throw new IllegalArgumentException(String.format("fail parse exp:%s", str));
        }
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnitParse a(String str) {
        return new UnitParse(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(da1 da1Var) {
        if (this.a.equals("ANY")) {
            return true;
        }
        if (this.a.equals("NONE") || da1Var == null || da1Var.a() == null) {
            return false;
        }
        ICompare a2 = da1Var.a();
        String c = da1Var.c();
        switch (a.a[this.c.ordinal()]) {
            case 1:
                return a2.equals(c, this.b);
            case 2:
                return a2.equalsNot(c, this.b);
            case 3:
                return a2.greater(c, this.b);
            case 4:
                return a2.greaterEquals(c, this.b);
            case 5:
                return a2.less(c, this.b);
            case 6:
                return a2.lessEquals(c, this.b);
            case 7:
                return a2.fuzzy(c, this.b);
            case 8:
                return a2.fuzzyNot(c, this.b);
            case 9:
                return a2.in(c, this.b);
            case 10:
                return a2.notIn(c, this.b);
            default:
                return false;
        }
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.a;
        OPERATOR operator = this.c;
        objArr[1] = operator == null ? "" : operator.getSymbol();
        objArr[2] = TextUtils.isEmpty(this.b) ? "" : this.b;
        return String.format("%s%s%s", objArr);
    }
}
