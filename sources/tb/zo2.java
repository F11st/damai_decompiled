package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zo2 {
    public static final int TYPE_ARRAY = 7;
    public static final int TYPE_BLOCK = 6;
    public static final int TYPE_DOUBLE = 2;
    public static final int TYPE_IDENTIFIER = 0;
    public static final int TYPE_INT = 1;
    public static final int TYPE_KEYWORD = 4;
    public static final int TYPE_OPERATOR = 5;
    public static final int TYPE_STRING = 3;
    private String a;
    private int b;

    public zo2(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public Object a(Object obj) {
        int i = this.b;
        if (i == 0) {
            return jn1.d(obj, this.a);
        }
        if (i == 3) {
            return this.a;
        }
        if (i == 1) {
            try {
                return Integer.valueOf(Integer.parseInt(this.a));
            } catch (Exception unused) {
                return 0;
            }
        } else if (i == 2) {
            try {
                return Double.valueOf(Double.parseDouble(this.a));
            } catch (Exception unused2) {
                return 0;
            }
        } else if (i == 4) {
            return jn1.KEYWORDS.get(this.a);
        } else {
            throw new IllegalArgumentException("unhandled token type " + this.b);
        }
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        return jn1.BLOCK_START_STR + this.a + "," + this.b + '}';
    }
}
